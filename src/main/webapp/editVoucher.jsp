<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Voucher</title>
    <link rel="icon" href="assets/img/heading-img.png">
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
<%@include file="header.jsp" %>
<!-- header end -->

<section class="hero-section" style="background-color: #fff8e5; background-image:url(/assets/img/background.png)">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="hero-text">
                    <h1>Edit Voucher</h1>
                    <h3>Edit the details of the voucher</h3>
                </div>
            </div>
        </div>
    </div>
</section>

<section class="gap">
    <div class="container">
        <h2>Edit Voucher</h2>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger mt-3">${errorMessage}</div>
        </c:if>
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success mt-3">${successMessage}</div>
        </c:if>
        <form action="/editVoucher" method="post">
            <input type="hidden" name="voucherID" value="${voucher.voucherId}">
            <div class="form-group">
                <label for="code">Code:</label>
                <input type="text" hidden class="form-control" id="code" name="code" value="${voucher.code}" required>

                <input type="text" disabled class="form-control" value="${voucher.code}" required>
            </div>
            <div class="form-group">
                <label for="value">Value:</label>
                <input type="number" class="form-control" id="value" name="value" value="${voucher.value}" required>
            </div>
            <div class="form-group">
                <label for="typeSale">Type Sale:</label>
                <select class="form-control" id="typeSale" name="typeSale">
                    <option value="0" ${voucher.typeSale == false ? 'selected' : ''}>Fixed Amount</option>
                    <option value="1" ${voucher.typeSale == true ? 'selected' : ''}>Percentage</option>
                </select>
            </div>
            <div class="form-group">
                <label for="status">Status:</label>
                <select class="form-control" id="status" name="status">
                    <option value="1" ${voucher.status == true ? 'selected' : ''}>Active</option>
                    <option value="0" ${voucher.status == false ? 'selected' : ''}>Inactive</option>
                </select>
            </div>
            <div class="form-group">
                <label for="describeVoucher">Description:</label>
                <textarea class="form-control" id="describeVoucher" name="describeVoucher" required>${voucher.describeVoucher}</textarea>
            </div>
            <div class="form-group">
                <label for="maxSale">Max Sale:</label>
                <input type="number" class="form-control" id="maxSale" name="maxSale" value="${voucher.maxSale}" required>
            </div>
            <div class="form-group">
                <label for="startDate">Start Date:</label>
                <input type="date" class="form-control" id="startDate" name="startDate" value="${voucher.startDate}" required>
            </div>
            <div class="form-group">
                <label for="endDate">End Date:</label>
                <input type="date" class="form-control" id="endDate" name="endDate" value="${voucher.endDate}" required>
            </div>
            <button type="submit" class="btn btn-primary">Update Voucher</button>
        </form>
    </div>
</section>

<%@ include file="footer.jsp" %>
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
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>
<script src="assets/js/slick.min.js"></script>
<!-- fancybox -->
<script src="assets/js/jquery.fancybox.min.js"></script>
<script src="assets/js/custom.js"></script>
</body>
</html>
