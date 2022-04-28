(function (jQuery) {
  "use strict";

//sparklinechart-1
if(jQuery('#sparklinechart-1').length){
  const options = {
    chart: {
        height: 40,
        type: 'area',
        sparkline: {
            enabled: true
        },
        group: 'sparklines',
  
    },
    dataLabels: {
        enabled: false
    },
    stroke: {
        width: 3,
        curve: 'straight'
    },
    fill: {
        type: 'gradient',
        gradient: {
            shadeIntensity: 0,
            opacityFrom: 0,
            opacityTo: 0,
        }
    }, 
    series: [{
        name: 'series1',
        data: [60, 15, 50, 30, 70]
    }, ],
    colors: ['#07750b'],
  
    xaxis: {
        type: 'datetime',
        categories: ["2018-08-19T00:00:00", "2018-09-19T01:30:00", "2018-10-19T02:30:00", "2018-11-19T01:30:00", "2018-12-19T01:30:00"],
    },
    tooltip: {
      enabled: false,
        x: {
            format: 'dd/MM/yy HH:mm'
        },
    }
  };
  const chart = new ApexCharts(
      document.querySelector("#sparklinechart-1"),
      options
  );
  chart.render();
}

//sparklinechart-2
if(jQuery('#sparklinechart-2').length){
  const options = {
    chart: {
        height: 40,
        type: 'area',
        sparkline: {
            enabled: true
        },
        group: 'sparklines',
  
    },
    dataLabels: {
        enabled: false
    },
    stroke: {
        width: 3,
        curve: 'straight'
    },
    fill: {
        type: 'gradient',
        gradient: {
            shadeIntensity: 0,
            opacityFrom: 0,
            opacityTo: 0,
        }
    }, 
    series: [{
        name: 'series1',
        data: [60, 15, 50, 30, 70]
    }, ],
    colors: ['#07750b'],
  
    xaxis: {
        type: 'datetime',
        categories: ["2018-08-19T00:00:00", "2018-09-19T01:30:00", "2018-10-19T02:30:00", "2018-11-19T01:30:00", "2018-12-19T01:30:00"],
    },
    tooltip: {
      enabled: false,
        x: {
            format: 'dd/MM/yy HH:mm'
        },
    }
  };
  const chart = new ApexCharts(
      document.querySelector("#sparklinechart-2"),
      options
  );
  chart.render();
}

//sparklinechart-3
if(jQuery('#sparklinechart-3').length){
  const options = {
    chart: {
        height: 40,
        type: 'area',
        sparkline: {
            enabled: true
        },
        group: 'sparklines',
  
    },
    dataLabels: {
        enabled: false
    },
    stroke: {
        width: 3,
        curve: 'straight'
    },
    fill: {
        type: 'gradient',
        gradient: {
            shadeIntensity: 0,
            opacityFrom: 0,
            opacityTo: 0,
        }
    }, 
    series: [{
        name: 'series1',
        data: [60, 15, 50, 30, 70]
    }, ],
    colors: ['#d43418'],
  
    xaxis: {
        type: 'datetime',
        categories: ["2018-08-19T00:00:00", "2018-09-19T01:30:00", "2018-10-19T02:30:00", "2018-11-19T01:30:00", "2018-12-19T01:30:00"],
    },
    tooltip: {
      enabled: false,
        x: {
            format: 'dd/MM/yy HH:mm'
        },
    }
  };
  const chart = new ApexCharts(
      document.querySelector("#sparklinechart-3"),
      options
  );
  chart.render();
}

//sparklinechart-4
if(jQuery('#sparklinechart-4').length){
  const options = {
    chart: {
        height: 40,
        type: 'area',
        sparkline: {
            enabled: true
        },
        group: 'sparklines',
  
    },
    dataLabels: {
        enabled: false
    },
    stroke: {
        width: 3,
        curve: 'straight'
    },
    fill: {
        type: 'gradient',
        gradient: {
            shadeIntensity: 0,
            opacityFrom: 0,
            opacityTo: 0,
        }
    }, 
    series: [{
        name: 'series1',
        data: [60, 15, 50, 30, 70]
    }, ],
    colors: ['#07750b'],
  
    xaxis: {
        type: 'datetime',
        categories: ["2018-08-19T00:00:00", "2018-09-19T01:30:00", "2018-10-19T02:30:00", "2018-11-19T01:30:00", "2018-12-19T01:30:00"],
    },
    tooltip: {
      enabled: false,
        x: {
            format: 'dd/MM/yy HH:mm'
        },
    }
  };
  const chart = new ApexCharts(
      document.querySelector("#sparklinechart-4"),
      options
  );
  chart.render();
}

//sparklinechart-5
if(jQuery('#sparklinechart-5').length){
  const options = {
    chart: {
        height: 40,
        type: 'area',
        sparkline: {
            enabled: true
        },
        group: 'sparklines',
  
    },
    dataLabels: {
        enabled: false
    },
    stroke: {
        width: 3,
        curve: 'straight'
    },
    fill: {
        type: 'gradient',
        gradient: {
            shadeIntensity: 0,
            opacityFrom: 0,
            opacityTo: 0,
        }
    }, 
    series: [{
        name: 'series1',
        data: [60, 15, 50, 30, 70]
    }, ],
    colors: ['#d43418'],
  
    xaxis: {
        type: 'datetime',
        categories: ["2018-08-19T00:00:00", "2018-09-19T01:30:00", "2018-10-19T02:30:00", "2018-11-19T01:30:00", "2018-12-19T01:30:00"],
    },
    tooltip: {
      enabled: false,
        x: {
            format: 'dd/MM/yy HH:mm'
        },
    }
  };
  const chart = new ApexCharts(
      document.querySelector("#sparklinechart-5"),
      options
  );
  chart.render();
}

})(jQuery)