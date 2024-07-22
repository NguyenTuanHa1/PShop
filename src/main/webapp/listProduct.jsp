<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zxx">

<!-- Mirrored from winsfolio.net/html/patte/our-products.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 22 May 2024 16:32:39 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patte - Our Products</title>
    <link rel="icon" href="assets/img/heading-img.png">
    <!-- CSS only -->
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="assets/css/slick.css">
    <!-- nice-select -->
    <link rel="stylesheet" href="assets/css/nice-select.css">
    <link rel="stylesheet" href="assets/css/slick-theme.css">
    <!-- fancybox -->
    <link rel="stylesheet" href="assets/css/jquery.fancybox.min.css">
    <link rel="stylesheet" href="assets/css/fontawesome.min.css">
    <!-- style -->
    <link rel="stylesheet" href="assets/css/style.css">
    <!-- responsive -->
    <link rel="stylesheet" href="assets/css/responsive.css">
    <!-- color -->
    <link rel="stylesheet" href="assets/css/color.css">
    <!-- jQuery -->
    <script src="assets/js/jquery-3.6.0.min.js"></script>
    <script src="assets/js/preloader.js"></script>
    <style>
        .active {
            background-color: #fa441d;
            color: white;
        }
        .disabled {
            pointer-events: none;
            cursor: not-allowed;
            background-color: #e9ecef !important;
            color: #6c757d;
        }
        #pagination-bar {
            margin-top: 20px;
            margin-bottom: 20px;
            display: flex;
            justify-content: center;
        }
    </style>
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
<%@include file="header.jsp" %>

<section class="banner" style="background-color: #fff8e5; background-image:url(assets/img/banner.png)">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6">
                <div class="banner-text">
                    <h2>Our Products</h2>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="index-2.html">Home</a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">shop</li>
                        <li class="breadcrumb-item active" aria-current="page">Our Products</li>
                    </ol>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="banner-img">
                    <div class="banner-img-1">
                        <svg width="260" height="260" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#fa441d"></path>
                        </svg>
                        <img src="assets/img/banner-img-1.jpg" alt="banner">
                    </div>
                    <div class="banner-img-2">
                        <svg width="320" height="320" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#fa441d"></path>
                        </svg>
                        <img src="assets/img/banner-img-2.jpg" alt="banner">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <img src="assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-2">
    <img src="assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-4">
</section>
<section class="gap products-section">
    <div class="container">
        <div class="row">
            <div class="col-lg-3">
                <div class="sidebar">
                    <h3>Category</h3>
                    <div class="boder-bar"></div>
                    <ul class="category">

                        <c:forEach items="${listType}" var="type">
                            <li>
                                <a href="/products?typeId=${type.typeProductId}">${type.typeProductName}<span>${type.quantity}</span></a>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
                <div class="sidebar">
                    <h3>Price range</h3>
                    <div class="boder-bar"></div>
                    <div class="wrapper">
                        <fieldset class="filter-price">
                            <div class="price-wrap">
                                <span class="price-title">Price</span>
                                <div class="price-wrap-1">
                                    <input id="one" style="width: 100%;">
                                    <label for="one">₫</label>
                                </div>
                                <div class="price-wrap_line">-</div>
                                <div class="price-wrap-2" style="">
                                    <input id="two" style="width: 100%;">
                                    <label for="two">₫</label>
                                </div>
                            </div>
                            <div class="price-field">
                                <input type="range" min="0" max="2000000" value="0" id="lower">
                                <input type="range" min="0" max="2000000" value="2000000" id="upper">
                            </div>
                            <button class="w-100 button" onclick="filterPrice()">Filter</button>
                        </fieldset>
                    </div>
                </div>
                <div class="sidebar">
                    <h3>Top Products</h3>
                    <div class="boder-bar"></div>
                    <ul class="top-products">
                        <c:forEach items="${listTopProduct}" var="topProduct">
                            <li>
                                <img src="${topProduct.img}" alt="top-products" style="width: 81.8px; height: 101.8px;">
                                <div>
                                    <a href="/detailProduct?id=${topProduct.productId}">${topProduct.productName}</a>
                                    <span><fmt:formatNumber value="${topProduct.priceProduct}" type="number" groupingUsed="true" /> ₫</span>

                                </div>
                            </li>
                        </c:forEach>
                    </ul>
                </div>
            </div>
            <div class="col-lg-9">
                <div class="items-number">
                    <span>Items 1-${listProduct.size()} of ${totalAll}</span>
                    <div class="d-flex align-items-center">
                        <span>Sort By</span>
                        <select name="sort" id="sort" onchange="sortProduct(this)">
                            <option value="default">Sort by Default</option>
                            <option value="priceProduct" data-type="asc">Price: Low to High</option>
                            <option value="priceProduct" data-type="desc">Price: High to Low</option>
                            <option value="productName" data-type="asc">Name: A to Z</option>
                            <option value="productName" data-type="desc">Name: Z to A</option>
                            <option value="createdDate" data-type="asc">Date: Old to New</option>
                            <option value="createdDate" data-type="desc">Date: New to Old</option>
                        </select>
                    </div>
                </div>
                <div class="row">
                    <c:forEach items="${listProduct}" var="product">
                        <div class="col-md-4 col-sm-6">
                            <div class="healthy-product">
                                <div class="healthy-product-img">
                                    <img src="${product.img}" alt="food" style="width: 217px; height: 255px;">
                                    <ul class="star">
                                        <li><i class="fa-solid fa-star"></i></li>
                                        <li><i class="fa-solid fa-star"></i></li>
                                        <li><i class="fa-solid fa-star"></i></li>
                                        <li><i class="fa-solid fa-star"></i></li>
                                        <li><i class="fa-solid fa-star"></i></li>
                                    </ul>
                                    <div class="add-to-cart">
                                        <a href="#" onclick="addToCart(${product.productId})">Add to Cart</a>
                                        <a href="#" class="heart-wishlist">
                                            <i class="fa-regular fa-heart"></i>
                                        </a>
                                    </div>
                                    <c:choose>
                                        <c:when test="${product.priceAfterDiscount != 0}">
                                            <h4>-${product.discountPercentage}%</h4>
                                        </c:when>
                                    </c:choose>
                                </div>
                                <span>${product.productTypeName}</span>
                                <a href="/detailProduct?id=${product.productId}">${product.productName}</a>
                                <c:choose>
                                    <c:when test="${product.priceAfterDiscount != 0}">
                                        <h6>
                                            <del><fmt:formatNumber value="${product.priceProduct}" type="number" groupingUsed="true" /> ₫</del>
                                            <fmt:formatNumber value="${product.priceAfterDiscount}" type="number" groupingUsed="true" /> ₫
                                        </h6>
                                    </c:when>
                                    <c:otherwise>
                                        <h6>
                                            <fmt:formatNumber value="${product.priceProduct}" type="number" groupingUsed="true" /> ₫
                                        </h6>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>
                    </c:forEach>
                </div>
                <ul class="pagination m-auto" id="pagination-bar">
                    <c:choose>
                        <c:when test="${page == 1}">
                            <li class="prev disabled"><a href="#"><i class='fa-solid fa-arrow-left'></i></a></li>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${not empty typeId}">
                                    <li class="prev"><a href="/products?typeId=${typeId}&page=${page - 1}"><i class='fa-solid fa-arrow-left'></i></a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="prev"><a href="/products?page=${page - 1}"><i class='fa-solid fa-arrow-left'></i></a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>

                    <c:forEach begin="1" end="${totalPage}" varStatus="i">
                        <li class="${i.index == page ? 'active' : ''}">
                            <c:choose>
                                <c:when test="${not empty typeId}">
                                    <a href="/products?typeId=${typeId}&page=${i.index}">${i.index}</a>
                                </c:when>
                                <c:otherwise>
                                    <a href="/products?page=${i.index}">${i.index}</a>
                                </c:otherwise>
                            </c:choose>
                        </li>
                    </c:forEach>


                    <c:choose>
                        <c:when test="${page == totalPage}">
                            <li class="next disabled"><a href="#"><i class='fa-solid fa-arrow-right'></i></a></li>
                        </c:when>
                        <c:otherwise>
                            <c:choose>
                                <c:when test="${not empty typeId}">
                                    <li class="next"><a href="/products?typeId=${typeId}&page=${page + 1}"><i class='fa-solid fa-arrow-right'></i></a></li>
                                </c:when>
                                <c:otherwise>
                                    <li class="next"><a href="/products?page=${page + 1}"><i class='fa-solid fa-arrow-right'></i></a></li>
                                </c:otherwise>
                            </c:choose>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </div>
</section>
<%@include file="footer.jsp" %>
<!-- cart-popup -->
<%@include file="cartPopup.jsp" %>

<!-- cart-popup end -->
<!-- search-popup -->
<%@include file="searchPopup.jsp" %>
<!-- search-popup end -->
<!-- progress -->
<div id="progress">
    <span id="progress-value"><i class="fa-solid fa-up-long"></i></span>
</div>
<!-- progress end -->
<!-- Bootstrap Js -->
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>
<script src="assets/js/slick.min.js"></script>
<!-- fancybox -->
<script src="assets/js/jquery.fancybox.min.js"></script>
<script src="assets/js/jquery.nice-select.min.js"></script>
<script src="assets/js/wrapper.js"></script>
<script src="assets/js/custom.js"></script>
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
    const sortProduct = (e) => {
        const sort = e.value;
        const type = e.options[e.selectedIndex].getAttribute('data-type');
        window.location.href = "/products?sort=" + sort + "&typeSort=" + type;
    }

    const filterPrice = () => {
        const lower = document.getElementById('lower').value;
        const upper = document.getElementById('upper').value;
        window.location.href = "/products?lower=" + lower + "&upper=" + upper;
    }

    window.onload = function() {
        // Get from parameter
        const urlParams = new URLSearchParams(window.location.search);
        const lower = urlParams.get('lower');
        const upper = urlParams.get('upper');
        if (lower && upper) {
            document.getElementById('lower').value = lower;
            document.getElementById('upper').value = upper;
            document.getElementById('one').value = lower;
            document.getElementById('two').value = upper;
        }

    }
</script>
</body>
