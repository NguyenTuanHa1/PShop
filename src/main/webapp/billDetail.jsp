<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bill Details</title>
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

<section class="hero-section" style="background-color: #fff8e5; background-image:url(assets/img/background.png)">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="hero-text">
                    <h1>Bill Details</h1>
                    <h3>Details of the selected bill and its items.</h3>
                </div>
            </div>
        </div>
    </div>
    <img src="assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-2">
    <img src="assets/img/dabal-foot-1.png" alt="hero-shaps" class="img-3">
    <img src="assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-4">
</section>

<section class="gap">
    <div class="container">
        <h2>Bill Details</h2>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger mt-3">${errorMessage}</div>
        </c:if>
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success mt-3">${successMessage}</div>
        </c:if>
        <table class="table table-bordered">
            <tr>
                <th>Bill ID</th>
                <td>${bill.billId}</td>
            </tr>
            <tr>
                <th>User Name</th>
                <td>${bill.userName}</td>
            </tr>
            <tr>
                <th>Email</th>
                <td>${bill.email}</td>
            </tr>
            <tr>
                <th>City</th>
                <td>${bill.city}</td>
            </tr>
            <tr>
                <th>District</th>
                <td>${bill.district}</td>
            </tr>
            <tr>
                <th>Phone</th>
                <td>${bill.phone}</td>
            </tr>
            <tr>
                <th>Address</th>
                <td>${bill.address}</td>
            </tr>
            <tr>
                <th>Note</th>
                <td>${bill.note}</td>
            </tr>
            <tr>
                <th>Status</th>
                <td>${bill.statusBill}</td>
            </tr>
            <tr>
                <th>Voucher Code</th>
                <td>${bill.voucherCode}</td>
            </tr>
            <tr>
                <th>VAT</th>
                <td>${bill.vat}</td>
            </tr>
            <tr>
                <th>Transport ID</th>
                <td>${bill.transportId}</td>
            </tr>
            <tr>
                <th>Payment ID</th>
                <td>${bill.paymentId}</td>
            </tr>
            <tr>
                <th>Employee ID</th>
                <td>${bill.employeeId}</td>
            </tr>
            <tr>
                <th>Total Price</th>
                <td><fmt:formatNumber value="${bill.totalPrice}" type="number" groupingUsed="true" /></td>
            </tr>
            <tr>
                <th>Created Date</th>
                <td>${bill.createdDate}</td>
            </tr>
            <tr>
                <th>Updated Date</th>
                <td>${bill.updatedDate}</td>
            </tr>
        </table>

        <h2>Bill Items</h2>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Product ID</th>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Discount Percentage</th>
                <th>Price After Discount</th>
                <th>Created Date</th>
                <th>Updated Date</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${billDetailList}" var="detail">
                <tr>
                    <td>${detail.product.productId}</td>
                    <td><a href="/detailProduct?id=${detail.product.productId}">${detail.product.productName}</a></td>
                    <td>${detail.quantity}</td>
                    <td><fmt:formatNumber value="${detail.product.priceProduct}" type="number" groupingUsed="true" /></td>
                    <td>${detail.discount.discountPercentage}</td>
                    <td><fmt:formatNumber value="${detail.product.priceAfterDiscount}" type="number" groupingUsed="true" /></td>
                    <td>${detail.createdDate}</td>
                    <td>${detail.updatedDate}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</section>

<%@include file="footer.jsp" %>
<!-- Bootstrap Js -->
<script src="assets/js/bootstrap.min.js"></script>
<script src="assets/js/owl.carousel.min.js"></script>
<script src="assets/js/slick.min.js"></script>
<!-- fancybox -->
<script src="assets/js/jquery.fancybox.min.js"></script>
<script src="assets/js/custom.js"></script>
</body>
</html>
