<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Discount</title>
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
<%@include file="header.jsp" %>

<section class="hero-section" style="background-color: #fff8e5; background-image:url(assets/img/background.png)">
    <div class="container">
        <div class="row">
            <div class="col-lg-12">
                <div class="hero-text">
                    <h1>Add New Discount</h1>
                    <h3>Fill in the details below to add a new discount.</h3>
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
        <form action="/addDiscount" method="post">
            <div class="row">
                <div class="col-lg-6">
                    <h2>Discount Details</h2>
                    <c:if test="${not empty errorMessage}">
                        <div class="alert alert-danger mt-3">${errorMessage}</div>
                    </c:if>
                    <c:if test="${not empty successMessage}">
                        <div class="alert alert-success mt-3">${successMessage}</div>
                    </c:if>
                    <div class="form-group">
                        <label for="discountPercentage">Discount Percentage</label>
                        <input type="number" id="discountPercentage" name="discountPercentage" class="form-control" min="0" max="100" step="0.01" required>
                    </div>
                    <div class="form-group">
                        <label for="startDate">Start Date</label>
                        <input type="date" id="startDate" name="startDate" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="endDate">End Date</label>
                        <input type="date" id="endDate" name="endDate" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="status">Status</label>
                        <select id="status" name="status" class="form-control">
                            <option value="1">Active</option>
                            <option value="0">Inactive</option>
                        </select>
                    </div>
                    <button type="submit" class="btn btn-primary">Add Discount</button>
                </div>
            </div>
        </form>
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
