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
  <title>Bill List</title>
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
<%@include file="header.jsp" %>
<!-- header end -->

<section class="hero-section" style="background-color: #fff8e5; background-image:url(assets/img/background.png)">
  <div class="container">
    <div class="row">
      <div class="col-lg-12">
        <div class="hero-text">
          <h1>User Bills</h1>
          <h3>List of all bills placed by the user.</h3>
        </div>
      </div>
    </div>
  </div>
  <img src="/assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-2">
  <img src="/assets/img/dabal-foot-1.png" alt="hero-shaps" class="img-3">
  <img src="/assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-4">
</section>

<section class="gap">
  <div class="container">
    <h2>Bills</h2>
    <c:if test="${not empty errorMessage}">
      <div class="alert alert-danger mt-3">${errorMessage}</div>
    </c:if>
    <c:if test="${not empty successMessage}">
      <div class="alert alert-success mt-3">${successMessage}</div>
    </c:if>
    <table class="table table-bordered">
      <thead>
      <tr>
        <th>ID</th>
        <th>User Name</th>
        <th>Email</th>
        <th>Phone</th>
        <th>Voucher Code</th>
        <th>Transport</th>
        <th>Payment</th>
        <th>Total Price</th>
        <th>Created Date</th>
        <th>Status</th>
        <th>Actions</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${billList}" var="bill">
        <tr>
          <td>
            <form action="/billDetail" method="post">
                <input type="hidden" name="billId" value="${bill.billId}">
                <button type="submit" class="btn btn-link">${bill.billId}</button>
            </form>
          </td>
          <td>${bill.userName}</td>
          <td>${bill.email}</td>
          <td>${bill.phone}</td>
          <td>${bill.voucherCode}</td>
          <td>${bill.transportName}</td>
          <td>${bill.paymentName}</td>
          <td><fmt:formatNumber value="${bill.totalPrice}" type="number" groupingUsed="true" /></td>
          <td>${bill.createdDate}</td>
          <td>${bill.statusBill}</td>
          <td>
            <c:choose>
                <c:when test="${bill.statusBill == 'Đã xác nhận'}">
                </c:when>
                <c:when test="${bill.statusBill != 'Đã hủy'}">
                  <form action="/approveBill" method="post" style="display:inline;">
                    <input type="hidden" name="billId" value="${bill.billId}">
                    <button type="submit" class="btn btn-success">Xác nhận</button>
                  </form>
                </c:when>
            </c:choose>

            <form action="/editBillAdmin" method="get" style="display:inline;">
              <input type="hidden" name="billId" value="${bill.billId}">
              <button type="submit" class="btn btn-warning">Sửa</button>
            </form>
            <form action="/deleteBillAdmin" method="post" style="display:inline;">
              <input type="hidden" name="billId" value="${bill.billId}">
              <button type="submit" class="btn btn-danger">Xóa</button>
            </form>
          </td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</section>

<%@include file="footer.jsp" %>
<!-- Bootstrap Js -->
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/owl.carousel.min.js"></script>
<script src="/assets/js/slick.min.js"></script>
<!-- fancybox -->
<script src="/assets/js/jquery.fancybox.min.js"></script>
<script src="/assets/js/custom.js"></script>
</body>
</html>
