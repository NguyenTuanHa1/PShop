<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<!-- Mirrored from winsfolio.net/html/patte/ by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 22 May 2024 16:31:22 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>patte - Home 1</title>
    <link rel="icon" href="/assets/img/heading-img.png">
    <!-- CSS only -->
    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/assets/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="/assets/css/slick.css">
    <link rel="stylesheet" href="/assets/css/slick-theme.css">
    <!-- fancybox -->
    <link rel="stylesheet" href="/assets/css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="/assets/css/fontawesome.min.css">
    <!-- style -->
    <link rel="stylesheet" href="/assets/css/style.css">
    <!-- responsive -->
    <link rel="stylesheet" href="/assets/css/responsive.css">
    <!-- color -->
    <link rel="stylesheet" href="/assets/css/color.css">
    <!-- jQuery -->
    <script src="/assets/js/jquery-3.6.0.min.js"></script>
    <script src="/assets/js/preloader.js"></script>
</head>
<body>
<!-- loader -->
<div class="preloader">
    <div class="container">
        <div class="dot dot-1"></div>
        <div class="dot dot-2"></div>
        <div class="dot dot-3"></div>
    </div>
</div>
<!-- loader end -->
<!-- header -->
<%--import header--%>
<%@include file="header.jsp" %>
<!-- header end -->
<section class="hero-section" style="background-color: #fff8e5; background-image:url(assets/img/background.png)">
    <div class="container">
        <div class="row hero-one-slider owl-carousel owl-theme">
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-5">
                        <div class="hero-text">
                            <h1>Take a Good Care of Pets</h1>
                            <h3>We are your local dog home boarding service giving you complete</h3>
                            <a href="/contact" class="button">Get Appointment</a>
                        </div>
                    </div>
                    <div class="col-lg-7">
                        <div class="hero-img">
                            <img src="/assets/img/hero-img-1.png" alt="img">
                            <img src="/assets/img/hero-shaps.png" alt="hero-shaps" class="img-1">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-5">
                        <div class="hero-text">
                            <h1>Healthy Pets, Happy People</h1>
                            <h3>We are your local dog home boarding service giving you complete</h3>
                            <a href="/contact" class="button">Get Appointment</a>
                        </div>
                    </div>
                    <div class="col-lg-7">
                        <div class="hero-img">
                            <img src="/assets/img/slide-3.png" alt="img">
                            <img src="/assets/img/hero-shaps.png" alt="hero-shaps" class="img-1">
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-12">
                <div class="row">
                    <div class="col-lg-5">
                        <div class="hero-text">
                            <h1>Take a Good Care of Pets</h1>
                            <h3>We are your local dog home boarding service giving you complete</h3>
                            <a href="/contact" class="button">Get Appointment</a>
                        </div>
                    </div>
                    <div class="col-lg-7">
                        <div class="hero-img">
                            <img src="/assets/img/slide-2.png" alt="img">
                            <img src="/assets/img/hero-shaps.png" alt="hero-shaps" class="img-1">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <img src="/assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-2">
    <img src="/assets/img/dabal-foot-1.png" alt="hero-shaps" class="img-3">
    <img src="/assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-4">
</section>
<section class="gap no-bottom">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="we-provide">
                    <div class="we-provide-img">
                        <img src="/assets/img/we-provide-1.jpg" alt="we-provide-1">
                        <svg width="326" height="326" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#fedc4f"/>
                        </svg>

                    </div>
                    <a href="#"><h5>Find a Dog Sitter</h5></a>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et.</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="we-provide">
                    <div class="we-provide-img">
                        <img src="/assets/img/we-provide-2.jpg" alt="we-provide-1">
                        <svg width="326" height="326" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#fb5e3c"/>
                        </svg>
                    </div>
                    <a href="#"><h5>Become a Dog Sitter</h5></a>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et.</p>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="we-provide mb-0">
                    <div class="we-provide-img">
                        <img src="/assets/img/we-provide-3.jpg" alt="we-provide-1">
                        <svg width="326" height="326" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#fedc4f"/>
                        </svg>
                    </div>
                    <a href="#"><h5> Start a franchise</h5></a>
                    <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et.</p>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="gap no-bottom">
    <div class="container">
        <div class="row">
            <div class="col-lg-6">
                <div class="welcome-to">
                    <h2>Welcome to The Pet Care Company</h2>
                    <p>Lorem ipsum dolor sit amet,consectetur adipiscing elit do eiusmod tempor incididunt ut labore et.Lorem ipsumsit amet, consectetur adipiscing elit, sed do eiusmod teincididunt ut laamet,consectetur adipiscing elibore et.</p>
                    <div class="row mt-lg-5">
                        <div class="col-md-6">
                            <div class="pet-grooming">
                                <i><img src="/assets/img/welcome-to-1.png" alt="icon"></i>
                                <svg width="138" height="138" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#940c69"/>
                                </svg>
                                <a href="#"><h4>Pet Grooming</h4></a>
                                <p>Lorem ipsum dolor sit amet ur adipiscing elit, sed do eiu incididunt ut labore et.</p>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="pet-grooming mb-0">
                                <i><img src="/assets/img/welcome-to-2.png" alt="icon"></i>
                                <svg width="138" height="138" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                                    <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#940c69"/>
                                </svg>
                                <a href="#"><h4>Dog Walking</h4></a>
                                <p>Lorem ipsum dolor sit amet ur adipiscing elit, sed do eiu incididunt ut labore et.</p>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="dog-walker two d-block">
                    <img src="/assets/img/puppies.png" class="puppies" alt="puppies">
                    <img src="/assets/img/dog-walker-1.png" class="w-100" alt="dog walker">
                    <img src="/assets/img/line.png" class="line" alt="line">
                    <img src="/assets/img/dabal-foot.png" class="dabal-foot" alt="dabal-foot">
                    <img src="/assets/img/haddi.png" class="haddi" alt="haddi">
                </div>
            </div>
        </div>
    </div>
</section>
<section class="gap">
    <div class="container">
        <div class="heading">
            <img src="/assets/img/heading-img.png" alt="heading-img">
            <h6>Find Healthy Product By Category</h6>
            <h2>Browse By Categories</h2>
        </div>
        <div class="row slider-categorie owl-carousel owl-theme">
            <div class="col-lg-12 item">
                <div class="food-categorie">
                    <img src="/assets/img/food-categorie-1.png" alt="food-categorie">
                    <a href="/products">Cat Supplies</a>
                </div>
            </div>
            <div class="col-lg-12 item">
                <div class="food-categorie">
                    <img src="/assets/img/food-categorie-2.png" alt="food-categorie">
                    <a href="/products">Dog Supplies</a>
                </div>
            </div>
            <div class="col-lg-12 item">
                <div class="food-categorie">
                    <img src="/assets/img/food-categorie-3.png" alt="food-categorie">
                    <a href="/products">Animal Feed</a>
                </div>
            </div>
            <div class="col-lg-12 item">
                <div class="food-categorie">
                    <img src="/assets/img/food-categorie-4.png" alt="food-categorie">
                    <a href="/products">Accessories</a>
                </div>
            </div>
            <div class="col-lg-12 item">
                <div class="food-categorie">
                    <img src="/assets/img/food-categorie-5.png" alt="food-categorie">
                    <a href="/products">Horse Care</a>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="gap section-healthy-product" style="background-image: url(assets/img/healthy-product.png); background-color: #f5f5f5;">
    <div class="container">
        <div class="heading">
            <img src="/assets/img/heading-img.png" alt="heading-img">
            <h6>Find Healthy Product</h6>
            <h2>Healthy Products</h2>
        </div>
        <div class="row">
<%--            <c:forEach var="product" items="${listP}" varStatus="loop">--%>
<%--                <c:if test="${loop.index < 5}">--%>
<%--                    <div class="col-lg-3 col-md-4 col-sm-6">--%>
<%--                        <div class="healthy-product">--%>
<%--                            <div class="healthy-product-img">--%>
<%--                                <img src="${product.img}" alt="food">--%>
<%--                                <div class="add-to-cart">--%>
<%--                                    <a href="#" onclick="addToCart(${product.id})" class="button">Add to Cart</a>--%>
<%--                                    <a href="#" class="heart-wishlist">--%>
<%--                                        <i class="fa-regular fa-heart"></i>--%>
<%--                                    </a>--%>
<%--                                </div>--%>
<%--                            </div>--%>
<%--                            <span>${product.category}</span>--%>
<%--                            <a href="/products">Procan Adult Dog Food</a>--%>
<%--                            <h6>$32.00</h6>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </c:if>--%>
<%--                <c:if test="${loop.index == 5}">--%>
<%--                <div class="col-lg-9">--%>
<%--                    <div class="deal-of-the-week">--%>
<%--                        <div class="healthy-product-img">--%>
<%--                            <h6>Deal of the Week</h6>--%>
<%--                            <img src="/assets/img/food-6.png" alt="food">--%>
<%--                            <ul class="star">--%>
<%--                                <li><i class="fa-solid fa-star"></i></li>--%>
<%--                                <li><i class="fa-solid fa-star"></i></li>--%>
<%--                                <li><i class="fa-solid fa-star"></i></li>--%>
<%--                                <li><i class="fa-solid fa-star"></i></li>--%>
<%--                                <li><i class="fa-solid fa-star"></i></li>--%>
<%--                            </ul>--%>
<%--                        </div>--%>
<%--                        <div class="healthy-product">--%>
<%--                            <span>Animal Feed</span>--%>
<%--                            <a href="/products">Healthy Dog Food Roaster Chicken</a>--%>
<%--                            <h6><del>$32.00</del>$22.00</h6>--%>
<%--                            <h5>up to 14% off</h5>--%>
<%--                            <div class="add-to-cart">--%>
<%--                                <a href="#" class="button">Add to Cart</a>--%>
<%--                                <a href="#" class="heart-wishlist">--%>
<%--                                    <i class="fa-regular fa-heart"></i>--%>
<%--                                </a>--%>
<%--                            </div>--%>
<%--                            <div id="countdown">--%>
<%--                                <ul>--%>
<%--                                    <li><span id="days"></span>days</li>--%>
<%--                                    <li><span id="hours"></span>Hour</li>--%>
<%--                                    <li><span id="minutes"></span>Min</li>--%>
<%--                                    <li class="mb-0"><span id="seconds"></span>Sec</li>--%>
<%--                                </ul>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--                </c:if>--%>
<%--            </c:forEach>--%>

        </div>
    </div>
</section>
<section class="gap">
    <div class="container">
        <div class="row">
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="count-text">
                    <img alt="img" src="/assets/img/fun-facts-1.png">
                    <div>
                        <div class="d-flex justify-content-center">
                            <h2 class="count" data-number="100" ></h2>
                            <span>+</span>
                        </div>
                        <h3 class="text">Client Served</h3>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="count-text">
                    <img alt="img" src="/assets/img/fun-facts-2.png">
                    <div>
                        <div class="d-flex justify-content-center">
                            <h2 class="count" data-number="99" ></h2>
                            <span>%</span>
                        </div>
                        <h3 class="text">Client Served</h3>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="count-text mb-sm-0">
                    <img alt="img" src="/assets/img/fun-facts-3.png">
                    <div>
                        <div class="d-flex justify-content-center">
                            <h2 class="count" data-number="2" ></h2>
                            <span>k</span>
                        </div>
                        <h3 class="text">Client Served</h3>
                    </div>
                </div>
            </div>
            <div class="col-lg-3 col-md-4 col-sm-6">
                <div class="count-text mb-0">
                    <img alt="img" src="/assets/img/fun-facts-4.png">
                    <div>
                        <div class="d-flex justify-content-center">
                            <h2 class="count" data-number="400" ></h2>
                            <span>+</span>
                        </div>
                        <h3 class="text">Client Served</h3>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<section>
    <div class="container">
        <div class="heading">
            <img src="/assets/img/heading-img.png" alt="heading-img">
            <h6>Meet Our Experts</h6>
            <h2>Best Working Team</h2>
        </div>
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="team-working">
                    <img src="/assets/img/team-1.jpg" alt="team">
                    <svg width="188" height="188" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#000"/>
                    </svg>
                    <span>Veterinary Assistant</span>
                    <a href="/team-details"><h4>Gorjona Hiller</h4></a>
                    <ul class="social-icon">
                        <li><a href="#"><i class="fa-brands fa-facebook-f"></i></a></li>
                        <li><a href="#"><i class="fa-brands fa-twitter"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="team-working">
                    <img src="/assets/img/team-2.jpg" alt="team">
                    <svg width="188" height="188" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#000"/>
                    </svg>
                    <span>Veterinary Assistant</span>
                    <a href="/team-details"><h4>Willimes Domson</h4></a>
                    <ul class="social-icon">
                        <li><a href="#"><i class="fa-brands fa-facebook-f"></i></a></li>
                        <li><a href="#"><i class="fa-brands fa-twitter"></i></a></li>
                    </ul>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="team-working mb-0">
                    <img src="/assets/img/team-3.jpg" alt="team">
                    <svg width="188" height="188" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#000"/>
                    </svg>
                    <span>Veterinary Assistant</span>
                    <a href="/team-details"><h4>Thomas Walkar</h4></a>
                    <ul class="social-icon">
                        <li><a href="#"><i class="fa-brands fa-facebook-f"></i></a></li>
                        <li><a href="#"><i class="fa-brands fa-twitter"></i></a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</section>
<section class="gap">
    <div class="container">
        <div class="dog-walker">
            <img src="/assets/img/dog-walker.png" alt="dog walker">
            <img src="/assets/img/line.png" class="line" alt="line">
            <img src="/assets/img/dabal-foot.png" class="dabal-foot" alt="dabal-foot">
            <div class="dog-walker-text">
                <h2>Find a dog walker or pet care</h2>
                <p>Place your trust in We Love Pets, an award-winning dog walking and pet care</p>
                <form>
                    <input placeholder="Enter address or postcode..." name="Enter address" type="text">
                    <button class="button">Find Branch</button>
                </form>
            </div>
        </div>
    </div>
</section>
<section class="section-client gap" style="background-image: url(assets/img/client-b.jpg)">
    <div class="container">
        <div class="heading two">
            <h2>What Our Client’s Say</h2>
        </div>
        <div class="client-slider owl-carousel owl-theme">
            <div class="item" >
                <div class="client">
                    <img src="/assets/img/client.png" alt="client">
                    <div class="client-text">
                        <ul class="star">
                            <li><i class="fa-solid fa-star"></i></li>
                            <li><i class="fa-solid fa-star"></i></li>
                            <li><i class="fa-solid fa-star"></i></li>
                            <li><i class="fa-solid fa-star"></i></li>
                            <li><i class="fa-solid fa-star"></i></li>
                        </ul>
                        <p>Excepteur sint occaecat cupidatat nilesm aniu deserunt mollit anim Lorem set dolo liem amet dolor sit amet, consectetur adipiscing il erunti nuliems elit sed incididunt</p>
                        <h4>Qlark Domous</h4>
                        <span>Health Advisor</span>
                        <i class="quote">
                            <img src="/assets/img/quote.png" alt="quote">
                        </i>
                    </div>
                </div>
            </div>
            <div class="item">
                <div class="client">
                    <img src="/assets/img/client.png" alt="client">
                    <div class="client-text">
                        <ul class="star">
                            <li><i class="fa-solid fa-star"></i></li>
                            <li><i class="fa-solid fa-star"></i></li>
                            <li><i class="fa-solid fa-star"></i></li>
                            <li><i class="fa-solid fa-star"></i></li>
                            <li><i class="fa-solid fa-star"></i></li>
                        </ul>
                        <p>Excepteur sint occaecat cupidatat nilesm aniu deserunt mollit anim Lorem set dolo liem amet dolor sit amet, consectetur adipiscing il erunti nuliems elit sed incididunt</p>
                        <h4>Willimes Marko</h4>
                        <span>Health Advisor</span>
                        <i class="quote">
                            <img src="/assets/img/quote.png" alt="quote">
                        </i>
                    </div>
                </div>
            </div>
            <div class="item" >
                <div class="client">
                    <img src="/assets/img/client.png" alt="client">
                    <div class="client-text">
                        <ul class="star">
                            <li><i class="fa-solid fa-star"></i></li>
                            <li><i class="fa-solid fa-star"></i></li>
                            <li><i class="fa-solid fa-star"></i></li>
                            <li><i class="fa-solid fa-star"></i></li>
                            <li><i class="fa-solid fa-star"></i></li>
                        </ul>
                        <p>Excepteur sint occaecat cupidatat nilesm aniu deserunt mollit anim Lorem set dolo liem amet dolor sit amet, consectetur adipiscing il erunti nuliems elit sed incididunt</p>
                        <h4>Qlark Domous</h4>
                        <span>Health Advisor</span>
                        <i class="quote">
                            <img src="/assets/img/quote.png" alt="quote">
                        </i>
                    </div>
                </div>
            </div>
        </div>
        <div class="rated">
            <ul class="star">
                <li><i class="fa-solid fa-star"></i></li>
                <li><i class="fa-solid fa-star"></i></li>
                <li><i class="fa-solid fa-star"></i></li>
                <li><i class="fa-solid fa-star"></i></li>
                <li><i class="fa-solid fa-star"></i></li>
            </ul>
            <h4>Rated 4.5 Out of 5.0</h4>
        </div>
    </div>
</section>
<section class="gap no-bottom">
    <div class="container">
        <div class="heading">
            <img src="/assets/img/heading-img.png" alt="heading-img">
            <h6>Blog and News</h6>
            <h2>Recent Articles</h2>
        </div>
        <div class="row">
            <div class="col-lg-4 col-md-6">
                <div class="blog-style">
                    <figure>
                        <img src="/assets/img/blog-1.jpg" alt="img">
                    </figure>
                    <a href="#"><h6>Animal Care</h6></a>
                    <div class="blog-style-text">
                        <h5>23<span>May,2023</span></h5>
                        <div>
                            <a href="/blog-detail"><h3>The Best High Fiber Dog Food</h3></a>
                            <p>Lorem ipsum dolor sit amet ur adipiscing elit, sed do eiuincididunut labore et.</p>
                            <div class="d-flex align-items-center">
                                <img src="/assets/img/man.jpg" alt="man">
                                <h4>Willimes Domson</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="blog-style">
                    <figure>
                        <img src="/assets/img/blog-2.jpg" alt="img">
                    </figure>
                    <a href="#"><h6>Animal Care</h6></a>
                    <div class="blog-style-text">
                        <h5>23<span>May,2023</span></h5>
                        <div>
                            <a href="/blog-detail"><h3>The Basic Necessities of Proper Pet Care</h3></a>
                            <p>Lorem ipsum dolor sit amet ur adipiscing elit, sed do eiuincididunut labore et.</p>
                            <div class="d-flex align-items-center">
                                <img src="/assets/img/man.jpg" alt="man">
                                <h4>Willimes Domson</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6">
                <div class="blog-style mb-0">
                    <figure>
                        <img src="/assets/img/blog-3.jpg" alt="img">
                    </figure>
                    <a href="#"><h6>Animal Care</h6></a>
                    <div class="blog-style-text">
                        <h5>23<span>May,2023</span></h5>
                        <div>
                            <a href="/blog-detail"><h3>Pets need care and attention</h3></a>
                            <p>Lorem ipsum dolor sit amet ur adipiscing elit, sed do eiuincididunut labore et.</p>
                            <div class="d-flex align-items-center">
                                <img src="/assets/img/man.jpg" alt="man">
                                <h4>Willimes Domson</h4>
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
        <div class="btn-center">
            <a href="/our-blog" class="button">View All News</a>
        </div>
    </div>
</section>
<div class="gap">
    <div class="container">
        <div class="insta-img">
            <h3><i class="fa-brands fa-instagram"></i>Follow @domain.com</h3>
            <a href="#" class="button">Follow Us</a>
        </div>
        <ul class="image-gallery">
            <li>
                <a href="/assets/img/gallery-1.jpg" data-fancybox="gallery"><figure><img alt="girl" src="/assets/img/gallery-1.jpg"></figure></a>
            </li>
            <li>
                <a href="/assets/img/gallery-2.jpg" data-fancybox="gallery"><figure><img alt="girl" src="/assets/img/gallery-2.jpg"></figure></a>
            </li>
            <li>
                <a href="/assets/img/gallery-3.jpg" data-fancybox="gallery"><figure><img alt="girl" src="/assets/img/gallery-3.jpg"></figure></a>
            </li>
            <li>
                <a href="/assets/img/gallery-4.jpg" data-fancybox="gallery"><figure><img alt="girl" src="/assets/img/gallery-4.jpg"></figure></a>
            </li>
            <li>
                <a href="/assets/img/gallery-5.jpg" data-fancybox="gallery"><figure><img alt="girl" src="/assets/img/gallery-5.jpg"></figure></a>
            </li>
            <li>
                <a href="/assets/img/gallery-6.jpg" data-fancybox="gallery"><figure><img alt="girl" src="/assets/img/gallery-6.jpg"></figure></a>
            </li>
            <li>
                <a href="/assets/img/gallery-7.jpg" data-fancybox="gallery"><figure><img alt="girl" src="/assets/img/gallery-7.jpg"></figure></a>
            </li>
        </ul>
    </div>
</div>
<%@ include file="footer.jsp" %>
<!-- cart-popup -->
<%@ include file="cartPopup.jsp"%>
<!-- cart-popup end -->
<!-- search-popup -->
<%@ include file="searchPopup.jsp"%>
<%@ include file="chatButton.jsp"%>
<!-- search-popup end -->
<!-- progress -->
<div id="progress">
    <span id="progress-value"><i class="fa-solid fa-up-long"></i></span>
</div>
<!-- progress end -->
<!-- Bootstrap Js -->
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/owl.carousel.min.js"></script>
<script src="/assets/js/slick.min.js"></script>
<!-- fancybox -->
<script src="/assets/js/jquery.fancybox.min.js"></script>
<script src="/assets/js/custom.js"></script>
<script>
    function addToCart(id) {
        $.ajax({
            url: "/addItemToCart",
            type: "post",
            data: {
                productId: id,
                quantity: 1
            },
            success: function (data) {
                //Do Something to handle success
                alert("Add to cart successfully");
                // Update cart popup
                location.reload();
            },
        });
    }
</script>
</body>


