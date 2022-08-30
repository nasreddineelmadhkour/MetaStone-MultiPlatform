(function (jQuery) {
    "use strict";
if (jQuery('.d-slider1').length > 0) {
    const options = {
        centeredSlides: false,
        loop: false,
        slidesPerView: 1,
        autoplay:true,
        // spaceBetween: 32,
        pagination: {
            el: '.swiper-pagination'
        },
        navigation: {
            nextEl: '#d-slider-next',
            prevEl: '#d-slider-prev'
        },  

        // And if we need scrollbar
        scrollbar: {
            el: '.swiper-scrollbar'  
        }
    } 
    let swiper = new Swiper('.d-slider1',options);

    document.addEventListener('ChangeMode', (e) => {
    if (e.detail.rtl === 'rtl' || e.detail.rtl === 'ltr') {
        swiper.destroy(true, true)
        setTimeout(() => {
            swiper = new Swiper('.d-slider1',options);
        }, 500);
    }
    })
}

if (jQuery('.d-slider2').length > 0) {
    const options = {
        centeredSlides: false,
        loop: false,
        slidesPerView: 3,
        autoplay:false,
        spaceBetween: 32,
        breakpoints: {
          320: { slidesPerView: 1 },
          550: { slidesPerView: 2 },
          991: { slidesPerView: 2 },
          1200: { slidesPerView: 3 },
          1400: { slidesPerView: 3 },
          1500: { slidesPerView: 3 },
          1920: { slidesPerView: 3 },
          2040: { slidesPerView: 4 },
          2440: { slidesPerView: 4 }
      },
        pagination: {
            el: '.swiper-pagination'
        },
        // And if we need scrollbar
        scrollbar: {
            el: '.swiper-scrollbar'  
        }
    } 
    new Swiper('.d-slider2',options);
}
if (jQuery('.d-slider5').length > 0) {
    const options = {
        centeredSlides: false,
        loop: false,
        slidesPerView: 1,
        autoplay:false,
        spaceBetween: 32,
    
        pagination: {
            el: '.swiper-pagination'
        },
        // And if we need scrollbar
        scrollbar: {
            el: '.swiper-scrollbar'  
        }
    } 
    new Swiper('.d-slider5',options);
}
if(jQuery('.banner-slider').length > 0) {
    const options = {
        centeredSlides: false,
        loop: false,
        slidesPerView: 1,
        autoplay:false,
        pagination: {
            el: '#banner-swiper-pagination'
        },
        navigation: {
            nextEl: '#banner-slider-next',
            prevEl: '#banner-slider-prev'
        },
    }
    new Swiper('.banner-slider', options)
}

if ($('.d-slider3').length > 0) {
    const options = {
        centeredSlides: false,
        loop: false,
        slidesPerView: 3,
        autoplay:false,
        spaceBetween: 32,
        breakpoints: {
          320: { slidesPerView: 1 },
          550: { slidesPerView: 2 },
          991: { slidesPerView: 2 },
          1400: { slidesPerView: 3 },
          1500: { slidesPerView: 3 },
          1920: { slidesPerView: 3 },
          2040: { slidesPerView: 4 },
          2440: { slidesPerView: 4 }
      },
        pagination: {
            el: '.swiper-pagination'
        },
        // And if we need scrollbar
        scrollbar: {
            el: '.swiper-scrollbar'  
        }
    } 
    let swiper = new Swiper('.d-slider3',options);
  
    document.addEventListener('ChangeMode', (e) => {
      if (e.detail.rtl === 'rtl' || e.detail.rtl === 'ltr') {
        swiper.destroy(true, true)
        setTimeout(() => {
            swiper = new Swiper('.d-slider3',options);
        }, 500);
      }
    })
}


})(jQuery)