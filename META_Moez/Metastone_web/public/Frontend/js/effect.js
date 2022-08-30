class Transferer {
    constructor() {
        this.contentImgWrapper = document.getElementById("contentImg");
        this.contentImg = document.querySelector("img");

        this.styleImgWrapper = document.getElementById("styleImg");
        this.styleImg = this.styleImgWrapper.querySelector("img");

        this.styledCanvasWrapper = document.getElementById("styledCanvas");
        this.styledCanvas = this.styledCanvasWrapper.querySelector("canvas");

        this.generateArtButton = document.getElementById("generateArtButton");

        this.uploadButton = document.getElementById("upload");
        this.fileInput = document.getElementById("input");

        this.downloadButton = document.getElementById("download");

        this.neuralNet = new NeuralNet();
        this.init();
    }

    async init() {
        this.setLoading(true);
        this.generateArtButton.addEventListener("click", this.updateStyle.bind(this));
        this.downloadButton.addEventListener("click", this.download.bind(this));
        this.uploadButton.addEventListener("click", () => this.fileInput.click());
        this.fileInput.addEventListener("change", this.upload.bind(this));
        window.addEventListener("resize", this.resize.bind(this));

        await new Promise((res) => {
            this.contentImg.onload = res;
            if (this.contentImg.complete && this.contentImg.naturalHeight !== 0) res();
        });
        this.resize();

        await this.neuralNet.init();
        await this.applyStyle();
    }

    async updateStyle() {
        this.setLoading(true);
        await new Promise((res) => {
            setTimeout(res, 1000);
        });
        this.styleImg.src =
            "https://source.unsplash.com/random/256x256/?art&" + Math.random();

        await new Promise((res) => {
            this.styleImg.onload = res;
            if (this.styleImg.complete && this.styleImg.naturalHeight !== 0) res();
        });
        this.applyStyle();
    }

    async applyStyle() {
        this.setLoading(true);
        try {
            const styledData = await this.neuralNet.applyStyle(
                this.contentImg,
                this.styleImg
            );
            tf.browser.toPixels(styledData, this.styledCanvas);
            this.setLoading(false);
        } catch (e) {
            console.log(e);
            this.generateArtButton.innerText = "Error: try to reload";
        }
    }

    async upload(e) {
        if (e.target.files[0]) {
            this.contentImg.src = window.URL.createObjectURL(e.target.files[0]);
            await new Promise((res) => {
                this.contentImg.onload = res;
                if (this.contentImg.complete && this.contentImg.naturalHeight !== 0) res();
            });
            this.resize();
            this.applyStyle();
        }
    }

    download() {
        var a = document.createElement("a");
        a.href = this.styledCanvas
            .toDataURL("image/png")
            .replace("image/png", "image/octet-stream");
        a.download = "styled.png";
        document.body.appendChild(a);
        a.click();
    }

    setLoading(loading) {
        if (loading) document.body.classList.add("loading");
        else document.body.classList.remove("loading");

        this.generateArtButton.disabled = loading;
    }

    resize() {
        const imgWidth = this.contentImg.naturalWidth;
        const imgHeight = this.contentImg.naturalHeight;

        for (const elm of [this.contentImg, this.styledCanvas]) {
            const containerRect = elm.parentElement.getBoundingClientRect();

            const { width, height } = this.contain(
                { width: imgWidth, height: imgHeight },
                containerRect
            );
            elm.style.top = (containerRect.height - height) / 2 + "px";
            elm.style.left = (containerRect.width - width) / 2 + "px";
            elm.style.width = width + "px";
            elm.style.height = height + "px";
            const icon = elm.parentElement.querySelector(".material-icons");
            if (icon) {
                icon.style.bottom = (containerRect.height - height) / 2 + 10 + "px";
                icon.style.right = (containerRect.width - width) / 2 + 10 + "px";
            }
        }

        this.styleImgWrapper.style.width = "100%";
        this.styleImgWrapper.style.height = "100%";
        const { width, height } = this.styleImgWrapper.getBoundingClientRect();
        if (width > height) this.styleImgWrapper.style.width = height + "px";
        else {
            this.styleImgWrapper.style.height = width + "px";
        }
        this.generateArtButton.style.width = this.styleImgWrapper.style.width;
    }

    contain(imgRect, containerRect) {
        const imageRatio = imgRect.width / imgRect.height;

        if (imageRatio >= containerRect.width / containerRect.height)
            return {
                width: containerRect.width,
                height: containerRect.width / imageRatio
            };
        else
            return {
                width: containerRect.height * imageRatio,
                height: containerRect.height
            };
    }
}

class NeuralNet {
    constructor() {}

    async init() {
        this.transferModel = await tflite.loadTFLiteModel(
            "https://tfhub.dev/google/lite-model/magenta/arbitrary-image-stylization-v1-256/fp16/transfer/1"
        );
        this.bottleneckModel = await tflite.loadTFLiteModel(
            "https://tfhub.dev/google/lite-model/magenta/arbitrary-image-stylization-v1-256/fp16/prediction/1"
        );
    }

    async applyStyle(contentImg, styleImg) {
        const contentImgData = tf.browser
            .fromPixels(contentImg, 3)
            .resizeBilinear([384, 384])
            .expandDims(0)
            .div(255);
        const styleImgData = tf.browser
            .fromPixels(styleImg, 3)
            .resizeBilinear([256, 256])
            .expandDims(0)
            .div(255);

        const bottleneck = await this.createStyleBottleneck(styleImgData);
        let styledImageData = this.transferModel.predict([
            contentImgData,
            bottleneck
        ]);

        if (styledImageData.shape.length > 3)
            styledImageData = tf.squeeze(styledImageData);

        return styledImageData.resizeBilinear([contentImg.height, contentImg.width]);
    }

    async createStyleBottleneck(styleImg) {
        const bottleneckTensor = this.bottleneckModel.predict(styleImg);
        const bottleneckData = bottleneckTensor.dataSync();
        const bottleneckClone = new Float32Array(100);
        for (var i = 0; i < bottleneckClone.length; i++) {
            bottleneckClone[i] = bottleneckData[i];
        }
        bottleneckTensor.dispose();
        return tf.tensor(bottleneckClone, [1, 1, 1, 100]);
    }
}

const transferer = new Transferer();
