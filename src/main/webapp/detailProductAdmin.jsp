<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Product Details</title>
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
                    <h1>Product Details</h1>
                    <h3>View details of the product</h3>
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
        <h2>Product Details</h2>
        <table class="table table-bordered">
            <tbody>
            <tr>
                <th>Product Name</th>
                <td>${product.productName}</td>
            </tr>
            <tr>
                <th>Main Image</th>
                <td><img src="${product.img}" alt="${product.productName}" style="width: 100px; height: 100px;"></td>
            </tr>
            <tr>
                <th>Image 1</th>
                <td><img src="${product.img1}" alt="${product.productName}" style="width: 100px; height: 100px;"></td>
            </tr>
            <tr>
                <th>Image 2</th>
                <td><img src="${product.img2}" alt="${product.productName}" style="width: 100px; height: 100px;"></td>
            </tr>
            <tr>
                <th>Image 3</th>
                <td><img src="${product.img3}" alt="${product.productName}" style="width: 100px; height: 100px;"></td>
            </tr>
            <tr>
                <th>Price</th>
                <td><fmt:formatNumber value="${product.priceProduct}" type="currency" /></td>
            </tr>
            <tr>
                <th>Type</th>
                <td>${product.productTypeName}</td>
            </tr>
            <tr>
                <th>Size</th>
                <td>${product.sizeName}</td>
            </tr>
            <tr>
                <th>Trademark</th>
                <td>${product.trademarkName}</td>
            </tr>
            <tr>
                <th>Quantity</th>
                <td>${product.quantity}</td>
            </tr>
            <tr>
                <th>Description</th>
                <td>${product.describeProduct}</td>
            </tr>
            <tr>
                <th>Status</th>
                <td>${product.status ? 'Active' : 'Inactive'}</td>
            </tr>
            <tr>
                <th>Created Date</th>
                <td>${product.createDate}</td>
            </tr>
            <tr>
                <th>Updated Date</th>
                <td>${product.updateDate}</td>
            </tr>
            </tbody>
        </table>
    </div>
</section>

<section class="gap">
    <div class="container">
        <h2>Reviews</h2>
        <table class="table table-bordered">
            <thead>
            <tr>
                <th>User Name</th>
                <th>Star Quantity</th>
                <th>Content</th>
                <th>Created Date</th>
                <th>Updated Date</th>
                <th></th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listReview}" var="review">
                <tr>
                    <td>${review.name}</td>
                    <td>${review.starQuantity}</td>
                    <td>${review.content}</td>
                    <td>${review.createdDate}</td>
                    <td>${review.updatedDate}</td>
                    <td>
                        <a href="/deleteReview?reviewID=${review.reviewId}&productID=${product.productId}" class="btn btn-danger">Delete</a>
                    </td>
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
