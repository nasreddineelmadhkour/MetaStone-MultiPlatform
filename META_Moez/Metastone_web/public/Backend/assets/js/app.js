/*
Template: nairobi - Responsive Bootstrap 5 Admin Dashboard Template
Author: iqonic.design
Design and Developed by: iqonic.design
NOTE: This file contains the styling for responsive Template.
*/

/*----------------------------------------------
Index Of Script
------------------------------------------------

------- Plugin Init --------

:: Tooltip
:: Popover
:: NoUiSlider
:: CopyToClipboard
:: Vanila Datepicker
:: SliderTab
:: Data Tables
:: Active Class for Pricing Table

------ Functions --------

:: Loader Init
:: Resize Plugins
:: Sidebar Toggle
:: Back To Top

------- Listners ---------

:: DOMContentLoaded
:: Window Resize
------------------------------------------------
Index Of Script
----------------------------------------------*/
"use strict";
/*---------------------------------------------------------------------
              Popover
-----------------------------------------------------------------------*/

var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'))
var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
  return new bootstrap.Popover(popoverTriggerEl)
})

/*---------------------------------------------------------------------
                Tooltip
-----------------------------------------------------------------------*/

var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="tooltip"]'))
var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
  return new bootstrap.Tooltip(tooltipTriggerEl)
})

var tooltipTriggerList = [].slice.call(document.querySelectorAll('[data-sidebar-toggle="tooltip"]'))
var tooltipList = tooltipTriggerList.map(function (tooltipTriggerEl) {
  return new bootstrap.Tooltip(tooltipTriggerEl)
})



/*---------------------------------------------------------------------
Progress Bar
-----------------------------------------------------------------------*/
const progressBarInit = (elem) => {
  const currentValue = elem.getAttribute('aria-valuenow')
  elem.style.width = '0%'
  elem.style.transition = 'width 2s'
  new Waypoint( {
    element: elem,
    handler: function() { 
      setTimeout(() => {
        elem.style.width = currentValue + '%'
      }, 100);
    },
    offset: 'bottom-in-view',
  })
}

const customProgressBar = document.querySelectorAll('[data-toggle="progress-bar"]')
Array.from(customProgressBar, (elem) => {
  progressBarInit(elem)
})

/*---------------------------------------------------------------------
                 noUiSlider
-----------------------------------------------------------------------*/

const rangeSlider = document.querySelectorAll('.range-slider');

Array.from(rangeSlider, (elem) => {
  noUiSlider.create(elem, {
    start: [20, 80],
    connect: true,
    range: {
        'min': 0,
        'max': 100
    }
  })
})

const slider = document.querySelectorAll('.slider');

Array.from(slider, (elem) => {
  noUiSlider.create(elem, {
    start: 50,
    connect: [true, false],
    range: {
        'min': 0,
        'max': 100
    }
  })
})

/*---------------------------------------------------------------------
              Copy To Clipboard
-----------------------------------------------------------------------*/
const copy = document.querySelectorAll('[data-toggle="copy"]')
Array.from(copy, (elem) => {
  elem.addEventListener('click', (e) => {
    const target = elem.getAttribute("data-copy-target");
    let value = elem.getAttribute("data-copy-value");
    const container = document.querySelector(target);
    if (container !== undefined && container !== null) {
      if (container.value !== undefined && container.value !== null) {
        value = container.value;
      } else {
        value = container.innerHTML;
      }
    }
    if (value !== null) {
      const elem = document.createElement("input");
      document.querySelector("body").appendChild(elem);
      elem.value = value;
      elem.select();
      document.execCommand("copy");
      elem.remove();
    }
  })
});

/*---------------------------------------------------------------------
              Vanila Datepicker
-----------------------------------------------------------------------*/
const datepickers = document.querySelectorAll('.vanila-datepicker')
Array.from(datepickers, (elem) => {
  new Datepicker(elem)
})
const daterangePickers = document.querySelectorAll('.vanila-daterangepicker')
Array.from(daterangePickers, (elem) => {
  new DateRangePicker(elem)
})

/*---------------------------------------------------------------------
              CounterUp 2
-----------------------------------------------------------------------*/
if (window.counterUp !== undefined) {
  const counterUp = window.counterUp["default"];
  const counterUp2 = document.querySelectorAll( '.counter' )
  Array.from(counterUp2, (el) => {
    const waypoint = new Waypoint({
      element: el,
      handler: function () {
        counterUp(el, {
          duration: 1000,
          delay: 10,
        });
        this.destroy();
      },
      offset: "bottom-in-view",
    });
  })
}

// Smooth Scollbar
let Scrollbar
if (jQuery(".data-scrollbar").length) {
  Scrollbar = window.Scrollbar
  Scrollbar.init(document.querySelector('.data-scrollbar'), {
    continuousScrolling: false,
  })
}

/*---------------------------------------------------------------------
  Active Class for Pricing Table
-----------------------------------------------------------------------*/
jQuery("#my-table tr th").on('click',function () {
  jQuery('#my-table tr th').children().removeClass('active');
  jQuery(this).children().addClass('active');
  jQuery("#my-table td").each(function () {
    if (jQuery(this).hasClass('active')) {
      jQuery(this).removeClass('active')
    }
  });
  var col = jQuery(this).index();
  jQuery("#my-table tr td:nth-child(" + parseInt(col + 1) + ")").addClass('active');
});


/*---------------------------------------------------------------------
              Resize Plugins
-----------------------------------------------------------------------*/

const resizePlugins = () => {
  // sidebar-mini
  const tabs = document.querySelectorAll('.nav')
  const sidebarResponsive = document.querySelector('.sidebar-default')
  if (window.innerWidth < 991) {
    Array.from(tabs, (elem) => {
      if (!elem.classList.contains('flex-column') && elem.classList.contains('nav-tabs') && elem.classList.contains('nav-pills')) {
        elem.classList.add('flex-column', 'on-resize');
      }
    })
    if(sidebarResponsive !== null) {
      if (!sidebarResponsive.classList.contains('sidebar-mini')) {
        sidebarResponsive.classList.add('sidebar-mini','on-resize')
      }
    }
  } else {
    Array.from(tabs, (elem) => {
      if (elem.classList.contains('on-resize')) {
        elem.classList.remove('flex-column', 'on-resize');
      }
    })
    if(sidebarResponsive !== null) {
      if (sidebarResponsive.classList.contains('sidebar-mini') && sidebarResponsive.classList.contains('on-resize')) {
        sidebarResponsive.classList.remove('sidebar-mini','on-resize')
      }
    }
  }
}


/*---------------------------------------------------------------------
              LoaderInit
-----------------------------------------------------------------------*/

const loaderInit = () => {
  const loader = document.querySelector('.loader')
  setTimeout(() => {
    loader.classList.add('animate__animated', 'animate__fadeOut')
    setTimeout(() => {
      loader.classList.add('d-none')
    }, 500)
  }, 500)
}

/*---------------------------------------------------------------------
              Sidebar Toggle
-----------------------------------------------------------------------*/
const sidebarToggle = (elem) => {
  elem.addEventListener('click', (e) => {
    const sidebar = document.querySelector('.sidebar')
    if (sidebar.classList.contains('sidebar-mini')) {
      sidebar.classList.remove('sidebar-mini')
    } else {
      sidebar.classList.add('sidebar-mini')
    }
  })
}

const sidebarToggleBtn = document.querySelectorAll('[data-toggle="sidebar"]')
const sidebar = document.querySelector('.sidebar-default')
if (sidebar !== null) {
  const sidebarActiveItem = sidebar.querySelectorAll('.active')
  Array.from(sidebarActiveItem, (elem) => {
    if (!elem.closest('ul').classList.contains('iq-main-menu')) {
      const childMenu = elem.closest('ul')
      childMenu.classList.add('show')
      const parentMenu = childMenu.closest('li').querySelector('.nav-link')
      parentMenu.classList.add('collapsed')
      parentMenu.setAttribute('aria-expanded', true)
    }
  })
}
Array.from(sidebarToggleBtn, (sidebarBtn) => {
  sidebarToggle(sidebarBtn)
})

/*------------------------
Back To Top
--------------------------*/
$('#back-to-top').fadeOut();
  $(window).on("scroll", function() {
    if ($(this).scrollTop() > 250) {
      $('#back-to-top').fadeIn(1400);
    } 
    else {
      $('#back-to-top').fadeOut(400);
    }
  });
// scroll body to 0px on click
  $('#top').on('click', function() {
    $('top').tooltip('hide');
    $('body,html').animate({
      scrollTop: 0
    }, 0);
  return false;
});

/*---------------------------------------------------------------------
              DOMContentLoaded
-----------------------------------------------------------------------*/
document.addEventListener('DOMContentLoaded', (event) => {
  resizePlugins()
  loaderInit()
});

/*---------------------------------------------------------------------
              Window Resize
-----------------------------------------------------------------------*/

window.addEventListener('resize', function(event) {
  resizePlugins()
});

/*-------------------------------
| | | | | DropDown
--------------------------------*/

function darken_screen(yesno){
  if( yesno == true ){
    document.querySelector('.screen-darken').classList.add('active');
  }
  else if(yesno == false){
    document.querySelector('.screen-darken').classList.remove('active');
  }
}
	
function close_offcanvas(){
  darken_screen(false);
  document.querySelector('.mobile-offcanvas.show').classList.remove('show');
  document.body.classList.remove('offcanvas-active');
}

function show_offcanvas(offcanvas_id){
  darken_screen(true);
  document.getElementById(offcanvas_id).classList.add('show');
  document.body.classList.add('offcanvas-active');
}

document.addEventListener("DOMContentLoaded", function(){
  
  document.querySelectorAll('[data-trigger]').forEach(function(everyelement){
    let offcanvas_id = everyelement.getAttribute('data-trigger');
    everyelement.addEventListener('click', function (e) {
      e.preventDefault();
          show_offcanvas(offcanvas_id);
    });
  });
  if(document.querySelectorAll('.btn-close')) {
    document.querySelectorAll('.btn-close').forEach(function(everybutton){
      everybutton.addEventListener('click', function (e) { 
            close_offcanvas();
        });
    });
  }
  if(document.querySelector('.screen-darken')) {
    document.querySelector('.screen-darken').addEventListener('click', function(event){
      close_offcanvas();
    });
  }
});
if (document.querySelector('#navbarSideCollapse'))  {
  document.querySelector('#navbarSideCollapse').addEventListener('click', function () {
    document.querySelector('.offcanvas-collapse').classList.toggle('open')
  })
}

/*---------------------------------------------------------------------
    Fieldset
-----------------------------------------------------------------------*/

        $(document).ready(function() {
          var e, t, a, n, o = 1,
              r = $("fieldset").length;
      
          function i(e) {
              var t = parseFloat(100 / r) * e;
              t = t.toFixed(), $(".progress-bar").css("width", t + "%")
          }
          i(o), $(".next").click(function() {
              e = $(this).parent(), t = $(this).parent().next(), $("#top-tab-list li").eq($("fieldset").index(t)).addClass("active"), $("#top-tab-list li").eq($("fieldset").index(e)).addClass("done"), t.show(), e.animate({
                  opacity: 0
              }, {
                  step: function(a) {
                      n = 1 - a, e.css({
                          display: "none",
                          position: "relative"
                      }), t.css({
                          opacity: n
                      })
                  },
                  duration: 500
              }), i(++o)
          }), $(".previous").click(function() {
              e = $(this).parent(), a = $(this).parent().prev(), $("#top-tab-list li").eq($("fieldset").index(e)).removeClass("active"), $("#top-tab-list li").eq($("fieldset").index(a)).removeClass("done"), a.show(), e.animate({
                  opacity: 0
              }, {
                  step: function(t) {
                      n = 1 - t, e.css({
                          display: "none",
                          position: "relative"
                      }), a.css({
                          opacity: n
                      })
                  },
                  duration: 500
              }), i(--o)
          }), $(".submit").click(function() {
              return !1
          })
      }), $(document).ready(function() {
          var e = $("div.setup-panel div a"),
              t = $(".setup-content"),
              a = $(".nextBtn");
          t.hide(), e.click(function(a) {
              a.preventDefault();
              var n = $($(this).attr("href")),
                  o = $(this);
              o.hasClass("disabled") || (e.addClass("active"), o.parent().addClass("active"), t.hide(), n.show(), n.find("input:eq(0)").focus())
          }), a.click(function() {
              var e = $(this).closest(".setup-content"),
                  t = e.attr("id"),
                  a = $('div.setup-panel div a[href="#' + t + '"]').parent().next().children("a"),
                  n = e.find("input[type='text'],input[type='email'],input[type='password'],input[type='url'],textarea"),
                  o = !0;
              $(".form-group").removeClass("has-error");
              for (var r = 0; r < n.length; r++) n[r].validity.valid || (o = !1, $(n[r]).closest(".form-group").addClass("has-error"));
              o && a.removeAttr("disabled").trigger("click")
          }), $("div.setup-panel div a.active").trigger("click")
      }), $(document).ready(function() {
          var e, t, a, n, o = 1,
              r = $("fieldset").length;
      
          function i(e) {
              var t = parseFloat(100 / r) * e;
              t = t.toFixed(), $(".progress-bar").css("width", t + "%")
          }
          i(o), $(".next").click(function() {
              e = $(this).parent(), t = $(this).parent().next(), $("#top-tabbar-vertical li").eq($("fieldset").index(t)).addClass("active"), t.show(), e.animate({
                  opacity: 0
              }, {
                  step: function(a) {
                      n = 1 - a, e.css({
                          display: "none",
                          position: "relative"
                      }), t.css({
                          opacity: n
                      })
                  },
                  duration: 500
              }), i(++o)
          }), $(".previous").click(function() {
              e = $(this).parent(), a = $(this).parent().prev(), $("#top-tabbar-vertical li").eq($("fieldset").index(e)).removeClass("active"), a.show(), e.animate({
                  opacity: 0
              }, {
                  step: function(t) {
                      n = 1 - t, e.css({
                          display: "none",
                          position: "relative"
                      }), a.css({
                          opacity: n
                      })
                  },
                  duration: 500
              }), i(--o)
          }), $(".submit").click(function() {
              return !1
          })
      }), $(document).ready(function() {
          $(".file-upload").on("change", function() {
              ! function(e) {
                  if (e.files && e.files[0]) {
                      var t = new FileReader;
                      t.onload = function(e) {
                          $(".profile-pic").attr("src", e.target.result)
                      }, t.readAsDataURL(e.files[0])
                  }
              }(this)
          }), $(".upload-button").on("click", function() {
              $(".file-upload").click()
          })
      }), $(function() {
          function e(e) {
              return e / 100 * 360
          }
          $(".progress-round").each(function() {
              var t = $(this).attr("data-value"),
                  a = $(this).find(".progress-left .progress-bar"),
                  n = $(this).find(".progress-right .progress-bar");
              t > 0 && (t <= 50 ? n.css("transform", "rotate(" + e(t) + "deg)") : (n.css("transform", "rotate(180deg)"), a.css("transform", "rotate(" + e(t - 50) + "deg)")))
          })
      });

/*---------------------------------------------------------------------
Form Validation
-----------------------------------------------------------------------*/

// Example starter JavaScript for disabling form submissions if there are invalid fields
window.addEventListener('load', function() {
    // Fetch all the forms we want to apply custom Bootstrap validation styles to
    var forms = document.getElementsByClassName('needs-validation');
    // Loop over them and prevent submission
    var validation = Array.prototype.filter.call(forms, function(form) {
      form.addEventListener('submit', function(event) {
          if (form.checkValidity() === false) {
              event.preventDefault();
              event.stopPropagation();
          }
          form.classList.add('was-validated');
        }, false);
      });
}, false);