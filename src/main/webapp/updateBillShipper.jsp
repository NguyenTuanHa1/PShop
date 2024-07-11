<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml" prefix="x" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Update Order Status</title>
    <link rel="icon" href="assets/img/heading-img.png">
    <!-- CSS only -->
    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/fontawesome.min.css">
    <!-- style -->
    <link rel="stylesheet" href="/assets/css/style.css">
    <!-- responsive -->
    <link rel="stylesheet" href="/assets/css/responsive.css">
    <!-- jQuery -->
    <script src="/assets/js/jquery-3.6.0.min.js"></script>
    <script src="/assets/js/custom.js"></script>
</head>
<body>
<!-- header -->
<%@include file="header.jsp" %>
<!-- header end -->

<section class="update-status-section" style="background-color: #f9f9f9; padding: 20px;">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <h2 class="section-title">Cập nhật trạng thái đơn hàng</h2>
                <form action="updateOrderStatus" method="post">
                    <div class="form-group">
                        <label for="orderId">Mã đơn hàng</label>
                        <input type="text" class="form-control" id="orderId" name="orderId" required>
                    </div>
                    <div class="form-group">
                        <label for="status">Trạng thái</label>
                        <select class="form-control" id="status" name="status" required>
                            <option value="Đang xử lý">Đang xử lý</option>
                            <option value="Đang giao hàng">Đang giao hàng</option>
                            <option value="Đã giao hàng">Đã giao hàng</option>
                            <option value="Đã hủy">Đã hủy</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="note">Ghi chú</label>
                        <textarea class="form-control" id="note" name="note" rows="4"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary">Cập nhật</button>
                </form>
            </div>
        </div>
    </div>
</section>

<%@ include file="footer.jsp" %>

<!-- Bootstrap Js -->
<script src="/assets/js/bootstrap.min.js"></script>
</body>
</html>
