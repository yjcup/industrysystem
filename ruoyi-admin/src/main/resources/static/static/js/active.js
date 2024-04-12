(function (a) {
    var f = a(window);
    f.on("scroll", function () {
        var v = f.scrollTop();
        if (v < 300) {
            a(".sticky").removeClass("is-sticky")
        } else {
            a(".sticky").addClass("is-sticky")
        }
    });

    function l() {
        a(".dropdown").on("show.bs.dropdown", function (v) {
            a(this).find(".dropdown-menu").first().stop(true, true).slideDown(500)
        });
        a(".dropdown").on("hide.bs.dropdown", function (v) {
            a(this).find(".dropdown-menu").first().stop(true, true).slideUp(500)
        })
    }

    l();
    a(".mini-cart-wrap button").on("click", function (v) {
        v.stopPropagation();
        v.preventDefault();
        a(".cart-list").slideToggle()
    });
    jQuery("#mobile-menu").meanmenu({meanMenuContainer: ".mobile-menu", meanScreenWidth: "991"});
    a('[data-toggle="tooltip"]').tooltip();
    a(".hero-slider-active").slick({
        autoplay: true,
        infinite: true,
        fade: true,
        dots: false,
        arrows: true,
        prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
        nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
        responsive: [{breakpoint: 768, settings: {arrows: false,}}]
    });
    a(".blog-slider").slick({
        autoplay: true,
        infinite: true,
        fade: false,
        dots: false,
        arrows: false,
        slidesToShow: 2,
        responsive: [{breakpoint: 768, settings: {slidesToShow: 1,}},]
    });
    var i = a(".brand-active");
    i.slick({
        infinite: true,
        arrows: false,
        autoplay: true,
        speed: 1000,
        pauseOnFocus: false,
        pauseOnHover: false,
        slidesToShow: 6,
        prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
        nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
        responsive: [{breakpoint: 992, settings: {slidesToShow: 4,}}, {
            breakpoint: 768,
            settings: {slidesToShow: 3, arrows: false,}
        }, {breakpoint: 575, settings: {slidesToShow: 2, arrows: false,}}, {
            breakpoint: 479,
            settings: {slidesToShow: 1, arrows: false,}
        },]
    });
    var i = a(".product-carousel-active");
    i.slick({
        infinite: true,
        arrows: true,
        autoplay: true,
        speed: 1000,
        pauseOnFocus: false,
        pauseOnHover: false,
        slidesToShow: 5,
        prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
        nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
        responsive: [{breakpoint: 1200, settings: {slidesToShow: 4,}}, {
            breakpoint: 992,
            settings: {slidesToShow: 3, arrows: false,}
        }, {breakpoint: 768, settings: {slidesToShow: 2, arrows: false,}}, {
            breakpoint: 479,
            settings: {slidesToShow: 1, arrows: false,}
        },]
    });
    a(".product-carousel-active-2").each(function () {
        var w = a(this);
        var v = w.attr("data-row") ? parseInt(w.attr("data-row"), 10) : 1;
        w.slick({
            infinite: true,
            arrows: false,
            dots: false,
            slidesToShow: 2,
            slidesToScroll: 1,
            rows: v,
            prevArrow: '<button class="slick-prev"><i class="fa fa-angle-left"></i></button>',
            nextArrow: '<button class="slick-next"><i class="fa fa-angle-right"></i></button>',
            responsive: [{breakpoint: 992, settings: {slidesToShow: 1, arrows: false,}}, {
                breakpoint: 480,
                settings: {slidesToShow: 1, arrows: false,}
            },]
        })
    });
    a(".product-carousel-active-3").each(function () {
        var w = a(this);
        var v = w.attr("data-row") ? parseInt(w.attr("data-row"), 10) : 1;
        w.slick({
            infinite: true,
            arrows: false,
            dots: false,
            rows: v,
            prevArrow: '<button class="slick-prev"><i class="fa fa-angle-left"></i></button>',
            nextArrow: '<button class="slick-next"><i class="fa fa-angle-right"></i></button>',
            responsive: [{breakpoint: 992, settings: {slidesToShow: 2, arrows: false,}}, {
                breakpoint: 768,
                settings: {slidesToShow: 1, arrows: false,}
            },]
        })
    });
    var k = a(".deal-carousel-active");
    k.slick({
        infinite: true,
        arrows: true,
        autoplay: false,
        speed: 1000,
        centerMode: true,
        centerPadding: 0,
        pauseOnFocus: false,
        pauseOnHover: false,
        slidesToShow: 3,
        prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
        nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
        responsive: [{
            breakpoint: 992,
            settings: {slidesToShow: 2, arrows: false, centerMode: false,}
        }, {breakpoint: 576, settings: {slidesToShow: 1, arrows: false,}},]
    });
    var u = a(".related-product-active");
    u.slick({
        infinite: true,
        arrows: true,
        autoplay: false,
        speed: 1000,
        slidesToShow: 4,
        prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
        nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
        responsive: [{
            breakpoint: 992,
            settings: {slidesToShow: 2, arrows: false, centerMode: false,}
        }, {breakpoint: 576, settings: {slidesToShow: 1, arrows: false,}},]
    });
    a(".product-large-slider").slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        fade: true,
        arrows: true,
        asNavFor: ".pro-nav",
        prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
        nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
    });
    a(".pro-nav").slick({
        slidesToShow: 3,
        slidesToScroll: 1,
        asNavFor: ".product-large-slider",
        centerMode: true,
        arrows: true,
        centerPadding: 0,
        focusOnSelect: true,
        prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
        nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>'
    });
    a(".product-box-slider").slick({
        autoplay: false,
        infinite: true,
        fade: false,
        dots: false,
        arrows: true,
        prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
        nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>',
        slidesToShow: 4,
        responsive: [{breakpoint: 992, settings: {slidesToShow: 3,}}, {
            breakpoint: 768,
            settings: {slidesToShow: 2,}
        }, {breakpoint: 480, settings: {slidesToShow: 1,}},]
    });
    a(".product-large-slider2").slick({
        slidesToShow: 1,
        slidesToScroll: 1,
        fade: true,
        arrows: false,
        asNavFor: ".pro-nav2"
    });
    a(".pro-nav2").slick({
        autoplay: true,
        slidesToShow: 4,
        slidesToScroll: 1,
        asNavFor: ".product-large-slider2",
        centerMode: true,
        arrows: false,
        vertical: true,
        centerPadding: 0,
        focusOnSelect: true,
        verticalSwiping: true
    });
    a(".testimonial-carousel-active").slick({
        autoplay: false,
        infinite: true,
        fade: false,
        dots: true,
        arrows: false,
        slidesToShow: 1
    });
    var m = a(".blog-gallery-slider");
    m.slick({
        arrows: true,
        autoplay: true,
        autoplaySpeed: 5000,
        pauseOnFocus: false,
        pauseOnHover: false,
        fade: true,
        dots: false,
        infinite: true,
        slidesToShow: 1,
        prevArrow: '<button type="button" class="slick-prev"><i class="fa fa-angle-left"></i></button>',
        nextArrow: '<button type="button" class="slick-next"><i class="fa fa-angle-right"></i></button>'
    });
    a(".sticky__sidebar").stickySidebar({topSpacing: 130, bottomSpacing: -20});
    a("select").niceSelect();
    a(".img-zoom").zoom();
    a(".grid").imagesLoaded(function () {
        a(".grid").masonry({itemSelector: ".col-lg-6", columnWidth: 1})
    });
    a("[data-countdown]").each(function () {
        var v = a(this), w = a(this).data("countdown");
        v.countdown(w, function (x) {
            v.html(x.strftime('<div class="single-countdown"><span class="single-countdown__time">%D</span><span class="single-countdown__text">Days</span></div><div class="single-countdown"><span class="single-countdown__time">%H</span><span class="single-countdown__text">Hrs</span></div><div class="single-countdown"><span class="single-countdown__time">%M</span><span class="single-countdown__text">Min</span></div><div class="single-countdown"><span class="single-countdown__time">%S</span><span class="single-countdown__text">Sec</span></div>'))
        })
    });
    var j = a(".sidebar-category li .children");
    j.slideUp();
    j.parents("li").addClass("has-children");
    a(".sidebar-category").on("click", "li.has-children > a", function (v) {
        if (a(this).parent().hasClass("has-children")) {
            if (a(this).siblings("ul:visible").length > 0) {
                a(this).siblings("ul").slideUp()
            } else {
                a(this).parents("li").siblings("li").find("ul:visible").slideUp();
                a(this).siblings("ul").slideDown()
            }
        }
        if (a(this).attr("href") === "#") {
            v.preventDefault();
            return false
        }
    });
    var t = a(".price-range"), h = a("#amount"), r = t.data("min"), q = t.data("max");
    t.slider({
        range: true, min: r, max: q, values: [r, q], slide: function (v, w) {
            h.val("$" + w.values[0] + " - $" + w.values[1])
        }
    });
    h.val(" $" + t.slider("values", 0) + " - $" + t.slider("values", 1));
    a(".product-view-mode a").on("click", function (v) {
        v.preventDefault();
        var w = a(".shop-product-wrap");
        var x = a(this).data("target");
        a(".product-view-mode a").removeClass("active");
        a(this).addClass("active");
        w.removeClass("grid-view list-view").addClass(x)
    });
    a(".pro-qty").prepend('<span class="dec qtybtn">-</span>');
    a(".pro-qty").append('<span class="inc qtybtn">+</span>');
    a(".qtybtn").on("click", function () {
        var v = a(this);
        var x = v.parent().find("input").val();
        if (v.hasClass("inc")) {
            var w = parseFloat(x) + 1
        } else {
            if (x > 0) {
                var w = parseFloat(x) - 1
            } else {
                w = 0
            }
        }
        v.parent().find("input").val(w)
    });
    a("#create_pwd").on("change", function () {
        a(".account-create").slideToggle("100")
    });
    a("#ship_to_different").on("change", function () {
        a(".ship-to-different").slideToggle("100")
    });
    a('input[name="paymentmethod"]').on("click", function () {
        var v = a(this).attr("value");
        a(".payment-method-details").slideUp();
        a('[data-method="' + v + '"]').slideDown()
    });
    a("#mc-form").ajaxChimp({
        language: "en",
        callback: n,
        url: "https://company.us19.list-manage.com/subscribe/post?u=2f2631cacbe4767192d339ef2&amp;id=24db23e68a"
    });

    function n(v) {
        if (v.result === "success") {
            a(".mailchimp-success").html("" + v.msg).fadeIn(900);
            a(".mailchimp-error").fadeOut(400)
        } else {
            if (v.result === "error") {
                a(".mailchimp-error").html("" + v.msg).fadeIn(900)
            }
        }
    }

    var o = a("#map_content");
    if (o.length > 0) {
        var b = o.data("lat"), c = o.data("lng"), g = o.data("zoom"), e = o.data("maptitle"), d = o.data("mapaddress"),
            s = L.map("map_content").setView([b, c], g);
        L.tileLayer("https://api.tiles.mapbox.com/v4/{id}/{z}/{x}/{y}.png?access_token={accessToken}", {
            attribution: "Map",
            maxZoom: 18,
            id: "mapbox.streets",
            scrollWheelZoom: false,
            accessToken: "pk.eyJ1Ijoic2hha2lsYWhtbWVlZCIsImEiOiJjamk4anF6NDgwMGd5M3BwM2c4eHU5dmIzIn0.yBLGUAB8kV1I1yGGonxzzg"
        }).addTo(s);
        var p = L.marker([b, c]).addTo(s);
        p.bindPopup("<b>" + e + "</b><br>" + d).openPopup();
        s.scrollWheelZoom.disable()
    }
    a(window).on("scroll", function () {
        if (a(this).scrollTop() > 600) {
            a(".scroll-top").removeClass("not-visible")
        } else {
            a(".scroll-top").addClass("not-visible")
        }
    });
    a(".scroll-top").on("click", function (v) {
        a("html,body").animate({scrollTop: 0}, 1000)
    })
}(jQuery));