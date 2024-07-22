<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add Product</title>
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
    <script src="https://cdn.ckeditor.com/4.20.2/standard/ckeditor.js"></script>


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
                    <h1>Add New Product</h1>
                    <h3>Fill in the details to add a new product.</h3>
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
        <form action="addProduct" method="post" enctype="multipart/form-data">
            <div class="row">
                <div class="col-lg-6">
                    <h2>Product Details</h2>
                    <c:if test="${not empty errorMessage}">
                        <div class="alert alert-danger mt-3">${errorMessage}</div>
                    </c:if>
                    <c:if test="${not empty successMessage}">
                        <div class="alert alert-success mt-3">${successMessage}</div>
                    </c:if>
                    <div class="form-group">
                        <label for="productName">Product Name</label>
                        <input type="text" id="productName" name="productName" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="priceProduct">Price</label>
                        <input type="number" id="priceProduct" name="priceProduct" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="productTypeId">Type</label>
                        <select id="productTypeId" name="productTypeId" class="form-control">
                            <c:forEach var="type" items="${listProductType}">
                                <option value="${type.typeProductId}">${type.typeProductName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="sizeId">Size</label>
                        <select id="sizeId" name="sizeId" class="form-control">
                            <c:forEach var="size" items="${listSize}">
                                <option value="${size.sizeId}">${size.sizeName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="trademarkId">Trademark</label>
                        <select id="trademarkId" name="trademarkId" class="form-control">
                            <c:forEach var="trademark" items="${listTrademark}">
                                <option value="${trademark.trademarkId}">${trademark.trademarkName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="quantity">Quantity</label>
                        <input type="number" id="quantity" name="quantity" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="discountId">Trademark</label>
                        <select id="discountId" name="discountId" class="form-control">
                            <c:forEach var="discount" items="${listDiscount}">
                                <option value="${discount.discountId}">Giảm ${discount.discountPercentage}%</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="editor">Description</label>
                        <textarea id="editor" name="describeProduct" class="form-control"></textarea>
                    </div>
                </div>
                <div class="col-lg-6">
                    <h2>Product Images</h2>
                    <div class="form-group">
                        <label for="img">Main Image</label>
                        <input type="file" id="img" name="img" class="form-control" required>
                    </div>
                    <div class="form-group">
                        <label for="img1">Additional Image 1</label>
                        <input type="file" id="img1" name="img1" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="img2">Additional Image 2</label>
                        <input type="file" id="img2" name="img2" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="img3">Additional Image 3</label>
                        <input type="file" id="img3" name="img3" class="form-control">
                    </div>
                    <button type="submit" class="btn btn-primary">Add Product</button>
                </div>
            </div>
        </form>
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
<script>
    CKEDITOR.replace('editor', {
        filebrowserUploadUrl: '/uploadImage',
        filebrowserUploadMethod: 'form'
    });
</script>
</body>
</html>
