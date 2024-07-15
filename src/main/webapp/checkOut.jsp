<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zxx">

<!-- Mirrored from winsfolio.net/html/patte/cart-checkout.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 22 May 2024 16:32:42 GMT -->
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Patte - Cart Checkout</title>
    <link rel="icon" href="/assets/img/heading-img.png">
    <!-- CSS only -->
    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/owl.carousel.min.css">
    <link rel="stylesheet" href="/assets/css/owl.theme.default.min.css">
    <link rel="stylesheet" href="/assets/css/slick.css">
    <link rel="stylesheet" href="/assets/css/slick-theme.css">
    <!-- nice-select -->
    <link rel="stylesheet" href="/assets/css/nice-select.css">
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
    <style>

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
                    <h2>Cart Checkout</h2>
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item">
                            <a href="index-2.html">Home</a>
                        </li>
                        <li class="breadcrumb-item active" aria-current="page">Cart Checkout</li>
                    </ol>
                </div>
            </div>
            <div class="col-lg-6">
                <div class="banner-img">
                    <div class="banner-img-1">
                        <svg width="260" height="260" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#fa441d"></path>
                        </svg>
                        <img src="/assets/img/banner-img-1.jpg" alt="banner">
                    </div>
                    <div class="banner-img-2">
                        <svg width="320" height="320" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                            <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#fa441d"></path>
                        </svg>
                        <img src="/assets/img/banner-img-2.jpg" alt="banner">
                    </div>
                </div>
            </div>
        </div>
    </div>
    <img src="/assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-2">
    <img src="/assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-4">
</section>
<section class="gap">
    <div class="container">
        <form class="checkout-meta donate-page" action="/addBill" method="post">
            <div class="row">
                <div class="col-lg-8">
                    <h3>Thông tin thanh toán</h3>
                    <p>Bạn có thể rút gọn quá trình điền thông tin bằng cách vào trang thông tin của bạn, <br>sau đó cập nhật các thông tin như: <b>Email</b>, <b>Địa chỉ</b>, <b>Số điện thoại</b></p>
                    <div class="col-lg-12">
                        <input type="text" class="input-text " value="${sessionScope.user.name}" name="userName" placeholder="Họ và Tên người nhận">
                        <input type="email" class="input-text " name="email" placeholder="Email" value="${sessionScope.user.email}">
<%--                        <input type="text" class="input-text " name="billing_company"  placeholder="Company name">--%>

                        <div class="row">
                            <div class="col-lg-6">
                                <select name="city" class="nice-select Advice city">
                                    <option>Tỉnh thành phố</option>
                                    <c:forEach items="${provinces}" var="province">
                                        <option value="${province.name}" data-name="${province.idProvince}">${province.name}</option>
                                    </c:forEach>
                                </select>
                            </div>
                            <div class="col-lg-6">
                                <select name="district" class="nice-select Advice state province" id="district-list">
                                    <option>District</option>
                                </select>
                            </div>
                            <div class="col-lg-6">
                                <input type="text" name="voucherCode" placeholder="Voucher Code" value="${voucherCode}" onfocusout="applyVoucher()">
                            </div>
                            <div class="col-lg-6">
                                <input type="tel" class="input-text " name="phone"  placeholder="Phone" value="${sessionScope.user.phoneNumber}">
                            </div>
                        </div>
                        <input type="text" name="address" placeholder="Address" value="${sessionScope.user.address}">
                        <select name="transportId" class="nice-select Advice country_to_state" onchange="changeTransport()">
                            <c:forEach items="${listTransport}" var="transport">
                                <option value="${transport.transportId}" data-price="${transport.priceTransPort}">${transport.transportName}</option>
                            </c:forEach>
                        </select>

                    </div>
                </div>
                <div class="col-lg-4">
                    <div class="woocommerce-additional-fields">
                        <h3>Order Note</h3>
                        <textarea name="order_comments" class="input-text " placeholder="Order Note"></textarea>
                    </div>
                </div>
            </div>
            <div class="row mt-lg-5">
                <div class="col-lg-6">
                    <div class="cart_totals cart-Total">
                        <h4>Cart Total</h4>
                        <table class="shop_table_responsive">
                            <tbody>
                            <tr class="cart-subtotal">
                                <th>Subtotal:</th>
                                <td>
                                            <span class="woocommerce-Price-amount">
                                            <bdi id="totalPriceOriginal">
                                                <fmt:formatNumber value="${totalPrice}" type="number" groupingUsed="true" />
                                            </bdi> ₫
                                            </span>
                                </td>
                            </tr>
                            <tr class="Shipping">
                                <th>Shipping:</th>
                                <td>
                                            <span id="ship_fee" class="woocommerce-Price-amount amount">
                                                free
                                            </span> ₫
                                </td>
                            </tr>
                            <tr class="Discount">
                                <th>Discount:</th>
                                <td>
                                            -<span class="woocommerce-Price-amount amount" id="discount-value">
                                                0
                                            </span> ₫
                                </td>
                            </tr>
                            <tr class="Total">
                                <th>Total:</th>
                                <td>
                                            <span class="woocommerce-Price-amount">
                                            <bdi>
                                                <span id="total-price"><fmt:formatNumber value="${totalPrice}" type="number" groupingUsed="true" /></span> ₫
                                            </bdi>
                                            </span>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-lg-6">
                    <div class="checkout-side">
                        <h3>Hình thức thanh toán</h3>
                        <ul>
                            <c:forEach items="${listPayment}" var="payment" varStatus="status">
                                <li>
                                    <input type="radio" id="payment-${payment.paymentId}" name="paymentId" value="${payment.paymentId}" <c:if test="${status.first}">checked</c:if>>
                                    <label for="payment-${payment.paymentId}">
                                            ${payment.paymentName}
                                    </label>
                                </li>
                            </c:forEach>
                        </ul>

                        <button type="submit" class="button">Đặt hàng</button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</section>
<%@ include file="footer.jsp"%>
<!-- cart-popup -->
<%@ include file="cartPopup.jsp"%>
<!-- cart-popup end -->
<!-- search-popup -->
<%@ include file="searchPopup.jsp"%>
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
<script src="/assets/js/jquery.nice-select.min.js"></script>
<!-- fancybox -->
<script src="/assets/js/jquery.fancybox.min.js"></script>
<script src="/assets/js/custom.js"></script>
<script>
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
                if (data.status) {
                    var shipFee = $("#ship_fee").text();
                    shipFee = shipFee === "free" ? 0 : parseInt(shipFee.replace(/\,/g, '').replace(/\./g, ''));
                    var discountValue = parseInt(data.discountValue.replace(/\,/g, '').replace(/\./g, ''));
                    var totalPriceOriginal = parseInt($("#totalPriceOriginal").text().replace(/\,/g, '').replace(/\./g, ''));
                    var totalPrice = totalPriceOriginal + shipFee - discountValue;
                    $("#discount-value").text(data.discountValue);
                    $("#total-price").text(new Intl.NumberFormat().format(totalPrice));

                } else {
                    var shipFee = $("#ship_fee").text();
                    shipFee = shipFee === "free" ? 0 : parseInt(shipFee.replace(/\,/g, '').replace(/\./g, ''));
                    var discountValue = 0;
                    var totalPriceOriginal = parseInt($("#totalPriceOriginal").text().replace(/\,/g, '').replace(/\./g, ''));
                    var totalPrice = totalPriceOriginal + shipFee - discountValue;
                    $("#discount-value").text(discountValue);
                    $("#total-price").text(new Intl.NumberFormat().format(totalPrice));
                    alert(data.message);
                }
            }
        });
    }
    $(document).ready(function () {
        $.ajax({
            url: "/applyVoucher",
            type: "get",
            data: {
                voucherCode: $("input[name='voucherCode']").val()
            },
            success: function (response) {
                // Convert to json
                var data = JSON.parse(response);
                if (data.status) {
                    var shipFee = $("#ship_fee").text();
                    shipFee = shipFee === "free" ? 0 : parseInt(shipFee.replace(/\,/g, '').replace(/\./g, ''));
                    var discountValue = parseInt(data.discountValue.replace(/\,/g, '').replace(/\./g, ''));
                    var totalPriceOriginal = parseInt($("#totalPriceOriginal").text().replace(/\,/g, '').replace(/\./g, ''));
                    var totalPrice = totalPriceOriginal + shipFee - discountValue;
                    $("#discount-value").text(data.discountValue);
                    $("#total-price").text(new Intl.NumberFormat().format(totalPrice));

                } else {
                    var shipFee = $("#ship_fee").text();
                    shipFee = shipFee === "free" ? 0 : parseInt(shipFee.replace(/\,/g, '').replace(/\./g, ''));
                    var discountValue = 0;
                    var totalPriceOriginal = parseInt($("#totalPriceOriginal").text().replace(/\,/g, '').replace(/\./g, ''));
                    var totalPrice = totalPriceOriginal + shipFee - discountValue;
                    $("#discount-value").text(discountValue);
                    $("#total-price").text(new Intl.NumberFormat().format(totalPrice));
                }
            }
        });
        changeTransport();
    });

    // Change value of ship fee
    function changeTransport() {
        var selectElement = document.querySelector('select[name="transportId"]');
        var selectedOption = selectElement.options[selectElement.selectedIndex];
        var transportPrice = selectedOption.getAttribute('data-price');

        if (transportPrice) {
            var totalPriceOriginal = document.getElementById('totalPriceOriginal').innerText;
            var discountValue = document.getElementById('discount-value').innerText;

            totalPriceOriginal = totalPriceOriginal.replace(/\,/g, '').replace(/\./g, '');
            discountValue = discountValue.replace(/\,/g, '').replace(/\./g, '');
            var totalPrice = parseInt(totalPriceOriginal) - parseInt(discountValue) + parseInt(transportPrice);
            document.getElementById('ship_fee').innerText = new Intl.NumberFormat().format(transportPrice);
            document.getElementById('total-price').innerText = new Intl.NumberFormat().format(totalPrice);
        } else {
            document.getElementById('ship_fee').innerText = 'free';
        }
    }

    // Change value of district
    $('.city').change(function () {
        var idProvince = $(this).find(':selected').data('name');
        $.ajax({
            url: "/getDistrict",
            type: "get",
            data: {
                idProvince: idProvince
            },
            success: function (response) {
                var html = '';
                html += response;
                $('#district-list').html(html);
                $('#district-list').niceSelect('update');
                // $('#district-list').css('display', 'block');
            }
        });
    });
</script>
</body>
