<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="zxx">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Information</title>
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
    <style>
        .avatar-preview img {
            cursor: pointer;
            width: 180px;
            height: 180px;
            margin-top: 60px;
        }
        .container-user-info {
            background-color: #f0f0f0;
            padding: 40px 60px;
            border-radius: 10px;
        }
        .form-group {
            margin-top: 20px;
        }
    </style>
    <script>
        $(document).ready(function() {
            $('#avatar').click(function() {
                $('#avatarInput').click();
            });

            $('#avatarInput').change(function(event) {
                var reader = new FileReader();
                reader.onload = function(e) {
                    $('#avatar').attr('src', e.target.result);
                }
                reader.readAsDataURL(event.target.files[0]);
            });
        });
    </script>
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
                    <h1>User Information</h1>
                    <h3>Here are the details of the user.</h3>
                </div>
            </div>
        </div>
    </div>
    <img src="assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-2">
    <img src="assets/img/dabal-foot-1.png" alt="hero-shaps" class="img-3">
    <img src="assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-4">
</section>

<section class="gap">
    <div class="container container-user-info">
        <form action="/editInfoUser" method="post" enctype="multipart/form-data">
            <div class="row">
                <div class="col-lg-6">
                    <h2>User Details</h2>
                    <div class="form-group mt-5">
                        <label for="name">Name</label>
                        <input type="text" id="name" name="name" value="${userInfo.name}" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="userDOB">Date of Birth</label>
                        <input type="date" id="userDOB" name="userDOB" value="${userInfo.userDOB}" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="email">Email</label>
                        <input type="email" id="email" name="email" value="${userInfo.email}" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="phoneNumber">Phone</label>
                        <input type="text" id="phoneNumber" name="phoneNumber" value="${userInfo.phoneNumber}" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="gender">Gender</label>
                        <select id="gender" name="gender" class="form-control">
                            <option value="true" ${userInfo.gender ? 'selected' : ''}>Male</option>
                            <option value="false" ${!userInfo.gender ? 'selected' : ''}>Female</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label for="address">Address</label>
                        <input type="text" id="address" name="address" value="${userInfo.address}" class="form-control">
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <textarea id="description" name="description" class="form-control">${userInfo.description}</textarea>
                    </div>
                    <button type="submit" class="btn btn-primary float-end mt-4">Save</button>
                </div>
                <div class="col-lg-6 mt-5">
                    <div class="avatar-preview">
                        <img id="avatar" src="${userInfo.avatar}" alt="User Avatar" class="img-fluid rounded-circle border border-secondary">
                        <input type="file" id="avatarInput" name="avatarFile" accept="image/*" style="display: none;">
                    </div>
                </div>
            </div>
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
