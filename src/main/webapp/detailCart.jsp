<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zxx">

<!-- Mirrored from winsfolio.net/html/patte/shop-cart.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 22 May 2024 16:32:42 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patte - shop cart</title>
    <link rel="icon" href="assets/img/heading-img.png">
    <!-- CSS only -->
    <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="assets/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="assets/css/slick.css">
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
</head>
<body>
<!-- loader -->
<%--<div class="preloader">--%>
<%--    <div class="container">--%>
<%--        <div class="dot dot-1"></div>--%>
<%--        <div class="dot dot-2"></div>--%>
<%--        <div class="dot dot-3"></div>--%>
<%--    </div>--%>
<%--</div>--%>
<!-- loader end -->
<%@include file="header.jsp" %>



<section class="banner" style="background-color: #fff8e5; background-image:url(assets/img/banner.png)">
    <div class="container">
        <div class="row align-items-center">
            <div class="col-lg-6">
                <div class="banner-text">
                    <h2>shop cart</h2>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="index-2.html">Home</a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">shop cart</li>
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
<section class="gap">
    <div class="container">
        <div class="row">
            <form action="/processCheckOut" class="woocommerce-cart-form" method="POST">
                <div style="overflow-x:auto;overflow-y: hidden;">
                    <table class="shop_table table-responsive">
                        <thead>
                        <tr>
                            <th></th>
                            <th class="product-name">Product</th>
                            <th class="product-price">Price</th>
                            <th class="product-quantity">Quantity</th>
                            <th class="product-subtotal">Total</th>
                        </tr>
                        </thead>
                        <tbody>
                            <c:if test="${!empty cart}">
                                <c:forEach items="${cart}" var="cart">
                                    <tr class="cart_item">
                                        <td class="product-remove">
                                            <a href="JavaScript:void(0)" onclick="removeItem(${cart.product.productId})" class="remove" title="Remove this item">
                                                <i class="fa-solid fa-circle-xmark"></i>
                                            </a>
                                        </td>
                                        <td class="product-name">
                                            <img src="${cart.product.img}" alt="${cart.product.productName}">
                                            <a href="product-detail.jsp?productId=${cart.product.productId}">${cart.product.productName}</a>
                                        </td>
                                        <td class="product-price">
                                            <c:choose>
                                                <c:when test="${cart.product.priceAfterDiscount != 0}">
                                                    <span class="woocommerce-Price-amount">
                                                        <bdi>
                                                            <span class="woocommerce-Price-currencySymbol"></span><fmt:formatNumber value="${cart.product.priceAfterDiscount}" type="number" groupingUsed="true" /> ₫
                                                        </bdi>
                                                        <del><fmt:formatNumber value="${cart.product.priceProduct}" type="number" groupingUsed="true" /> ₫</del>
                                                    </span>
                                                </c:when>
                                                <c:otherwise>
                                                    <span class="woocommerce-Price-amount">
                                                        <bdi>
                                                            <span class="woocommerce-Price-currencySymbol"></span><fmt:formatNumber value="${cart.product.priceProduct}" type="number" groupingUsed="true" /> ₫
                                                        </bdi>
                                                    </span>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                        <td class="product-quantity">
                                            <div class="quantity">
                                                <input onchange="changeQuantity(${cart.product.productId})" id="quantity-${cart.product.productId}" type="number" class="input-text qty text" step="1" min="1" max="${cart.product.quantity}" name="quantity" value="${cart.quantity}" title="Qty" size="4" pattern="[0-9]*" inputmode="numeric">
                                            </div>
                                        </td>
                                        <td class="product-subtotal">
                                            <span class="woocommerce-Price-amount">
                                                <bdi>
                                                    <span class="woocommerce-Price-currencySymbol"></span>
                                                    <c:choose>
                                                        <c:when test="${cart.product.priceAfterDiscount != 0}">
                                                            <fmt:formatNumber value="${cart.product.priceAfterDiscount * cart.quantity}" type="number" groupingUsed="true" /> ₫
                                                        </c:when>
                                                        <c:otherwise>
                                                            <fmt:formatNumber value="${cart.product.priceProduct * cart.quantity}" type="number" groupingUsed="true" /> ₫
                                                        </c:otherwise>
                                                    </c:choose>
                                                    ₫
                                                </bdi>
                                            </span>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:if>
                            <c:if test="${empty cart}">
                                <tr>
                                    <td colspan="5" class="text-center">
                                        <h3>Your cart is empty</h3>
                                        <a href="/products" class="button">Continue shopping</a>
                                    </td>
                                </tr>
                            </c:if>

                        </tbody>
                    </table>
                </div>
                <div class="row mt-lg-5">
                    <div class="col-lg-5">
                        <div class="coupon-area">
                            <h3>Voucher</h3>
                            <p>Enter a voucher code below to apply it</p>
                            <div class="coupon">
                                <input type="text" name="voucherCode" class="input-text" placeholder="Voucher code">
                                <button type="button" class="button" onclick="applyVoucher()">Apply voucher
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-7">
                        <div class="cart_totals">
                            <h4>Payment Total</h4>
                            <table class="shop_table_responsive">
                                <tbody>
                                <tr class="cart-subtotal">
                                    <th>Subtotal:</th>
                                    <td>
                                            <span class="woocommerce-Price-amount">
                                            <bdi>
                                                <span class="woocommerce-Price-currencySymbol"></span><fmt:formatNumber value="${totalPrice}" type="number" groupingUsed="true" /> ₫
                                            </bdi>
                                            </span>
                                    </td>
                                </tr>
<%--                                <tr class="Shipping">--%>
<%--                                    <th>Shipping:</th>--%>
<%--                                    <td>--%>
<%--                                            <span class="woocommerce-Price-amount amount">--%>
<%--                                                free--%>
<%--                                            </span>--%>
<%--                                    </td>--%>
<%--                                </tr>--%>
                                <tr class="Discount">
                                    <th>Discount:</th>
                                    <td>
                                            <span class="woocommerce-Price-amount amount" id="discount-value">
                                                0
                                            </span> ₫
                                    </td>
                                </tr>
                                <tr class="Total">
                                    <th>Total:</th>
                                    <td>
                                            <span class="woocommerce-Price-amount">
                                            <bdi>
                                                <input hidden name="totalPrice" id="totalPrice" value="${totalPrice}">
                                                <span id="total-price"><fmt:formatNumber value="${totalPrice}" type="number" groupingUsed="true" /></span> ₫
                                            </bdi>
                                            </span>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                        <div class="wc-proceed-to-checkout">
                            <button type="submit" class="button">Thanh toán</button>
                        </div>
                    </div>
                </div>
            </form>
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
<script src="assets/js/custom.js"></script>
<script>
    function changeQuantity(productId) {
        $.ajax({
            url: "/changeQuantityCart",
            type: "get",
            data: {
                productId: productId,
                quantity: $("#quantity-" + productId).val()
            },
            success: function (response) {
                location.reload();
            }
        });
    }

    function applyVoucher() {
        $.ajax({
            url: "/applyVoucher",
            type: "get",
            data: {
                voucherCode: $("input[name='voucherCode']").val()
            },
            success: function (response) {
                // Convert to json
                var data = JSON.parse(response);
                console.log(data);
                if (data.status) {
                    $("#total-price").text(data.total);
                    $("#discount-value").text("-" + data.discountValue);
                } else {
                    alert(data.message);
                }
            }
        });
    }
</script>
</body>
