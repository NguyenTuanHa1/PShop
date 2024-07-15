<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Dashboard</title>
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
    <style>
        /*body {*/
        /*    font-family: Arial, sans-serif;*/
        /*    background-color: #f8f9fa;*/
        /*}*/

        /*.hero-section {*/
        /*    padding: 50px 0;*/
        /*}*/

        /*.card {*/
        /*    border: none;*/
        /*}*/

        /*.card-body {*/
        /*    background-color: #fff8e5;*/
        /*}*/

        /*.card-title {*/
        /*    color: #333;*/
        /*}*/

        /*.card-text {*/
        /*    color: #666;*/
        /*}*/

        /*footer {*/
        /*    background-color: #343a40;*/
        /*    color: #fff;*/
        /*    padding: 30px 0;*/
        /*}*/

        /*.footer .widget-title h3 {*/
        /*    color: #fff;*/
        /*}*/

        /*.footer .widget-title .boder {*/
        /*    width: 50px;*/
        /*    height: 3px;*/
        /*    background-color: #fedc4f;*/
        /*    margin-bottom: 20px;*/
        /*}*/

        /*.footer .working-hours .working-time h6 {*/
        /*    color: #fff;*/
        /*}*/

        /*.footer .phone, .footer .phone a {*/
        /*    color: #fff;*/
        /*}*/

        /*.footer .social-icon li a {*/
        /*    color: #fedc4f;*/
        /*}*/

        /*.footer .social-icon li a:hover {*/
        /*    color: #fff;*/
        /*}*/

        /*.footer .call-us img {*/
        /*    width: 40px;*/
        /*}*/

        /*.footer .border-top {*/
        /*    border-top: 1px solid #666;*/
        /*    padding-top: 15px;*/
        /*    margin-top: 15px;*/
        /*    color: #fff;*/
        /*    text-align: center;*/
        /*}*/

        /*.footer .border-top img {*/
        /*    width: 50px;*/
        /*    margin-top: 10px;*/
        /*}*/

    </style>
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

<!-- header -->
<%@include file="header.jsp" %>
<!-- header end -->

<section class="hero-section text-center" style="background-color: #fff8e5; background-image:url(assets/img/background.png); padding: 50px 0;">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="hero-text">
                    <h1>Admin Dashboard</h1>
                    <h3>Manage your application efficiently</h3>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="gap no-bottom py-5">
    <div class="container">
        <div class="row">
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-3.jpg" class="card-img-top" alt="Bill Management">
                    <div class="card-body text-center">
                        <a href="/dashboard"><h5 class="card-title">Dashboard</h5></a>
                        <p class="card-text">View statistics of your application</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-3.jpg" class="card-img-top" alt="Bill Management">
                    <div class="card-body text-center">
                        <a href="/listBillAdmin"><h5 class="card-title">Bill Management</h5></a>
                        <p class="card-text">Manage bills in your website</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-3.jpg" class="card-img-top" alt="User Management">
                    <div class="card-body text-center">
                        <a href="/listUser"><h5 class="card-title">User Management</h5></a>
                        <p class="card-text">Manage user in your website</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-3.jpg" class="card-img-top" alt="Voucher Management">
                    <div class="card-body text-center">
                        <a href="/listVoucher"><h5 class="card-title">Voucher Management</h5></a>
                        <p class="card-text">Manage vouchers in your application</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-3.jpg" class="card-img-top" alt="Product Management">
                    <div class="card-body text-center">
                        <a href="/listProduct"><h5 class="card-title">Product Management</h5></a>
                        <p class="card-text">Manage products in your application</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-1.jpg" class="card-img-top" alt="Add Product Type">
                    <div class="card-body text-center">
                        <a href="/list-product-type"><h5 class="card-title">Product Type</h5></a>
                        <p class="card-text">Manage product types in your application</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-2.jpg" class="card-img-top" alt="Add Size">
                    <div class="card-body text-center">
                        <a href="/list-size"><h5 class="card-title">Size</h5></a>
                        <p class="card-text">Manage product sizes in your application</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-3.jpg" class="card-img-top" alt="Add Trademark">
                    <div class="card-body text-center">
                        <a href="/list-trademark"><h5 class="card-title">Trademark</h5></a>
                        <p class="card-text">Manage trademarks in your application</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-3.jpg" class="card-img-top" alt="Add Payment">
                    <div class="card-body text-center">
                        <a href="/list-payment"><h5 class="card-title">Payment</h5></a>
                        <p class="card-text">Manage payment methods in your application</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-3.jpg" class="card-img-top" alt="Add Transport">
                    <div class="card-body text-center">
                        <a href="/list-transport"><h5 class="card-title">Transport</h5></a>
                        <p class="card-text">Manage transport methods in your application</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-2.jpg" class="card-img-top" alt="Add Size">
                    <div class="card-body text-center">
                        <a href="/addDiscount"><h5 class="card-title">Discount</h5></a>
                        <p class="card-text">Manage product discounts in your application</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-3.jpg" class="card-img-top" alt="Add Transport">
                    <div class="card-body text-center">
                        <a href="/chatAdmin"><h5 class="card-title">Chat</h5></a>
                        <p class="card-text">Chat with your customers</p>
                    </div>
                </div>
            </div>
            <div class="col-lg-4 col-md-6 mb-4">
                <div class="card shadow-sm">
                    <img src="assets/img/we-provide-3.jpg" class="card-img-top" alt="Add Transport">
                    <div class="card-body text-center">
                        <a href="/listShipper"><h5 class="card-title">Shipper</h5></a>
                        <p class="card-text">Manager shipper in your application</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- footer -->
<%@ include file="footer.jsp" %>

<!-- cart-popup -->
<%@ include file="cartPopup.jsp"%>
<!-- cart-popup end -->
<!-- search-popup -->
<%@ include file="searchPopup.jsp"%>
<!-- search-popup end -->
<!-- progress -->
<div id="progress">
    <span id="progress-value"><i class="fas fa-arrow-up"></i></span>
</div>
<!-- progress end -->

<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>
<script src="assets/js/slick.min.js"></script>
<!-- fancybox -->
<script src="assets/js/jquery.fancybox.min.js"></script>
<script src="assets/js/custom.js"></script>
<!-- fancybox -->
</body>
</html>
