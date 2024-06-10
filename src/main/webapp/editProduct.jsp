<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Product</title>
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
                    <h1>Edit Product</h1>
                    <h3>Edit the details of the product</h3>
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
        <h2>Edit Product</h2>
        <c:if test="${not empty errorMessage}">
            <div class="alert alert-danger mt-3">${errorMessage}</div>
        </c:if>
        <c:if test="${not empty successMessage}">
            <div class="alert alert-success mt-3">${successMessage}</div>
        </c:if>
        <form action="/editProduct" method="post" enctype="multipart/form-data">
            <input type="hidden" name="productId" value="${product.productId}">
            <div class="form-group">
                <label for="productName">Product Name:</label>
                <input type="text" class="form-control" id="productName" name="productName" value="${product.productName}" required>
            </div>
            <div class="form-group">
                <label for="img">Main Image:</label>
                <input type="file" class="form-control-file" id="img" name="img">
                <img src="${product.img}" alt="${product.productName}" style="width: 100px; height: 100px;">
            </div>
            <div class="form-group">
                <label for="img1">Image 1:</label>
                <input type="file" class="form-control-file" id="img1" name="img1">
                <img src="${product.img1}" alt="${product.productName}" style="width: 100px; height: 100px;">
            </div>
            <div class="form-group">
                <label for="img2">Image 2:</label>
                <input type="file" class="form-control-file" id="img2" name="img2">
                <img src="${product.img2}" alt="${product.productName}" style="width: 100px; height: 100px;">
            </div>
            <div class="form-group">
                <label for="img3">Image 3:</label>
                <input type="file" class="form-control-file" id="img3" name="img3">
                <img src="${product.img3}" alt="${product.productName}" style="width: 100px; height: 100px;">
            </div>
            <div class="form-group">
                <label for="priceProduct">Price:</label>
                <input type="number" class="form-control" id="priceProduct" name="priceProduct" value="${product.priceProduct}" required>
            </div>
            <div class="form-group">
                <label for="typeProductId">Product Type:</label>
                <select class="form-control" id="typeProductId" name="typeProductId">
                    <c:forEach items="${typeProductList}" var="typeProduct">
                        <option value="${typeProduct.typeProductId}" ${product.typeProductId == typeProduct.typeProductId ? 'selected' : ''}>${typeProduct.typeProductName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="sizeId">Size:</label>
                <select class="form-control" id="sizeId" name="sizeId">
                    <c:forEach items="${sizeList}" var="size">
                        <option value="${size.sizeId}" ${product.sizeId == size.sizeId ? 'selected' : ''}>${size.sizeName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="trademarkId">Trademark:</label>
                <select class="form-control" id="trademarkId" name="trademarkId">
                    <c:forEach items="${trademarkList}" var="trademark">
                        <option value="${trademark.trademarkId}" ${product.trademarkId == trademark.trademarkId ? 'selected' : ''}>${trademark.trademarkName}</option>
                    </c:forEach>
                </select>
            </div>
            <div class="form-group">
                <label for="quantity">Quantity:</label>
                <input type="number" class="form-control" id="quantity" name="quantity" value="${product.quantity}" required>
            </div>
            <div class="form-group">
                <label for="describeProduct">Description:</label>
                <textarea class="form-control" id="describeProduct" name="describeProduct" required>${product.describeProduct}</textarea>
            </div>
            <div class="form-group">
                <label for="status">Status:</label>
                <select class="form-control" id="status" name="status">
                    <option value="true" ${product.status ? 'selected' : ''}>Active</option>
                    <option value="false" ${!product.status ? 'selected' : ''}>Inactive</option>
                </select>
            </div>
            <div class="form-group">
                <label for="discount">Discount:</label>
                <select class="form-control" id="discount" name="discountId">
                    <option value="0">No Discount</option>
                    <c:forEach items="${discountList}" var="discount">
                        <option value="${discount.discountId}" ${discountProduct.discountId == discount.discountId ? 'selected' : ''}>${discount.discountPercentage}</option>
                    </c:forEach>
                </select>
            </div>
            <button type="submit" class="btn btn-primary">Update Product</button>
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
