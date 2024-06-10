<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Bill</title>
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
                    <h1>Edit Bill</h1>
                    <h3>Edit the details of the bill</h3>
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
        <h2>Edit Bill</h2>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger mt-3">${errorMessage}</div>
        </c:if>
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success mt-3">${successMessage}</div>
        </c:if>
        <form action="/editBillAdmin" method="post">
            <input type="hidden" name="billId" value="${billInfo.billId}">
            <div class="form-group">
                <label for="userName">User Name:</label>
                <input type="text" class="form-control" id="userName" name="userName" value="${billInfo.userName}" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" class="form-control" id="email" name="email" value="${billInfo.email}" required>
            </div>
            <div class="form-group">
                <label for="city">City:</label>
                <input type="text" class="form-control" id="city" name="city" value="${billInfo.city}" required>
            </div>
            <div class="form-group">
                <label for="district">District:</label>
                <input type="text" class="form-control" id="district" name="district" value="${billInfo.district}" required>
            </div>
            <div class="form-group">
                <label for="phone">Phone:</label>
                <input type="text" class="form-control" id="phone" name="phone" value="${billInfo.phone}" required>
            </div>
            <div class="form-group">
                <label for="address">Address:</label>
                <input type="text" class="form-control" id="address" name="address" value="${billInfo.address}" required>
            </div>
            <div class="form-group">
                <label for="note">Note:</label>
                <textarea class="form-control" id="note" name="note">${billInfo.note}</textarea>
            </div>
            <div class="form-group">
                <label for="statusBill">Status:</label>
                <select class="form-control" id="statusBill" name="statusBill">
                    <option value="Chờ xác nhận" ${billInfo.statusBill == 'Chờ xác nhận' ? 'selected' : ''}>Chờ xác nhận</option>
                    <option value="Đang xử lý" ${billInfo.statusBill == 'Đang xử lý' ? 'selected' : ''}>Đang xử lý</option>
                    <option value="Đã xác nhận" ${billInfo.statusBill == 'Đã xác nhận' ? 'selected' : ''}>Đã xác nhận</option>
                    <option value="Đã hủy" ${billInfo.statusBill == 'Đã hủy' ? 'selected' : ''}>Đã hủy</option>
                </select>
            </div>
            <div class="form-group">
                <label for="voucherCode">Voucher Code:</label>
                <input type="text" class="form-control" id="voucherCode" name="voucherCode" value="${billInfo.voucherCode}">
            </div>
            <div class="form-group">
                <label for="vat">VAT:</label>
                <input type="number" step="0.01" class="form-control" id="vat" name="vat" value="${billInfo.vat}" required>
            </div>
            <div class="form-group">
                <label for="transportId">Transport:</label>
                <select class="form-control" id="transportId" name="transportId">
                    <c:forEach items="${transportList}" var="transport">
                        <option value="${transport.transportId}" ${billInfo.transportId == transport.transportId ? 'selected' : ''}>${transport.transportName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="paymentId">Payment:</label>
                <select class="form-control" id="paymentId" name="paymentId">
                    <c:forEach items="${paymentList}" var="payment">
                        <option value="${payment.paymentId}" ${billInfo.paymentId == payment.paymentId ? 'selected' : ''}>${payment.paymentName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="totalPrice">Total Price:</label>
                <input type="number" class="form-control" id="totalPrice" name="totalPrice" value="${billInfo.totalPrice}" required>
            </div>
            <button type="submit" class="btn btn-primary">Update Bill</button>
        </form>
    </div>
</section>

<section class="gap">
    <div class="container">
        <h2>Bill Details</h2>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>Product Name</th>
                <th>Quantity</th>
                <th>Price</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${billDetailList}" var="detail">
                <tr>
                    <td>${detail.product.productName}</td>
                    <td>${detail.quantity}</td>
                    <td><fmt:formatNumber value="${detail.priceBillDetail}" type="number" groupingUsed="true" /></td>
                    <td>
                        <form action="/editBillDetail" method="get" style="display:inline;">
                            <input type="hidden" name="billDetailId" value="${detail.billDetailId}">
                            <button type="submit" class="btn btn-warning">Edit</button>
                        </form>
                        <form action="/deleteBillDetail" method="post" style="display:inline;">
                            <input type="hidden" name="billDetailId" value="${detail.billDetailId}">
                            <button type="submit" class="btn btn-danger">Delete</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <a href="/addBillDetail?billId=${billInfo.billId}" class="btn btn-success">Add Product</a>
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
