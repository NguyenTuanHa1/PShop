<%@ page import="entity.Cart" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Product" %>
<%@ page isELIgnored="false" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html lang="zxx">

<!-- Mirrored from winsfolio.net/html/patte/product-details.html by HTTrack Website Copier/3.x [XR&CO'2014], Wed, 22 May 2024 16:32:40 GMT -->
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>patte - product details</title>
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
  <style>
    .star-rating {
      display: flex;
      flex-direction: row-reverse;
      justify-content: center;
    }

    .star-rating input[type="radio"] {
      display: none;
    }

    .star-rating label {
      cursor: pointer;
      width: 30px;
      height: 30px;
      font-size: 2em;
      color: #ddd;
      transition: color 0.3s;
    }

    .star-rating input[type="radio"]:checked ~ label {
      color: #f5b301;
    }

    .star-rating label:hover,
    .star-rating label:hover ~ label {
      color: #f5b301;
    }
  </style>
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
<%@include file="header.jsp" %>

<section class="banner" style="background-color: #fff8e5; background-image:url(assets/img/banner.png)">
  <div class="container">
    <div class="row align-items-center">
      <div class="col-lg-6">
        <div class="banner-text">
          <h2>product details</h2>
          <ol class="breadcrumb">
            <li class="breadcrumb-item">
              <a href="index-2.html">Home</a>
            </li>
            <li class="breadcrumb-item active" aria-current="page">product details</li>
          </ol>
        </div>
      </div>
      <div class="col-lg-6">
        <div class="banner-img">
          <div class="banner-img-1">
            <svg width="260" height="260" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#fa441d"></path>
            </svg>
            <img src="/assets/img/banner-img-1.jpg" alt="banner">
          </div>
          <div class="banner-img-2">
            <svg width="320" height="320" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
              <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#fa441d"></path>
            </svg>
            <img src="/assets/img/banner-img-2.jpg" alt="banner">
          </div>
        </div>
      </div>
    </div>
  </div>
  <img src="/assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-2">
  <img src="/assets/img/hero-shaps-1.png" alt="hero-shaps" class="img-4">
</section>
<section class="gap no-bottom">
  <div class="container">
    <div class="row product-info-section">
      <div class="col-lg-7 p-0">
        <div class="pd-gallery">
          <ul class="pd-imgs">
              <li class="li-pd-imgs nav-active">
                <a href="JavaScript:void(0)">
                  <img alt="Main image" src="${product.img}">
                </a>
              </li>
              <li class="li-pd-imgs nav-active">
                <a href="JavaScript:void(0)">
                  <img alt="First image" src="${product.img1}">
                </a>
              </li>
              <li class="li-pd-imgs nav-active">
                <a href="JavaScript:void(0)">
                  <img alt="Second image" src="${product.img2}">
                </a>
              </li>
              <li class="li-pd-imgs nav-active">
                <a href="JavaScript:void(0)">
                  <img alt="Third image" src="${product.img3}">
                </a>
              </li>
          </ul>
          <div class="pd-main-img">
            <img id="NZoomImg" alt="toys" src="${product.img}" style="width: 416px; height: 367px;">

          </div>
        </div>
      </div>
      <div class="col-lg-5">
        <div class="product-info p-60">
          <div class="d-flex align-items-center">
            <div class="start d-flex align-items-center">
              
              <c:forEach var="i" begin="1" end="5">
                <c:choose>
                  <c:when test="${i <= avgRating}">
                    <i class="fa-solid fa-star" style="color: #f5b301;"></i>
                  </c:when>
                  <c:otherwise>
                    <i class="fa-solid fa-star" style="color: #ddd;"></i>
                  </c:otherwise>
                </c:choose>
              </c:forEach>
            </div>
            <span>${listReview.size()} reviews</span>
          </div>
          <h3>${product.productName}</h3>
          <form class="variations_form">
            <div class="stock">
            <span class="price">
              <c:choose>
                <c:when test="${product.priceAfterDiscount != 0}">
                  <del>
                    <span class="woocommerce-Price-amount">
                    <bdi>
                      <span class="woocommerce-Price-currencySymbol"></span><fmt:formatNumber value="${product.priceProduct}" type="number" groupingUsed="true" /> ₫
                    </bdi>
                    </span>
                  </del>
                  <ins>
                    <span class="woocommerce-Price-amount amount">
                      <bdi>
                      <span class="woocommerce-Price-currencySymbol"></span><fmt:formatNumber value="${product.priceAfterDiscount}" type="number" groupingUsed="true" /> ₫</bdi>
                    </span>
                  </ins>
                </c:when>
                <c:otherwise>
                  <ins>
                    <span class="woocommerce-Price-amount amount">
                      <bdi>
                      <span class="woocommerce-Price-currencySymbol"></span><fmt:formatNumber value="${product.priceProduct}" type="number" groupingUsed="true" /> ₫</bdi>
                    </span>
                  </ins>
                </c:otherwise>
              </c:choose>
            </span>
                <h6><span>Sản phẩm còn lại: ${product.quantity}</span></h6>

            </div>
            <c:choose>
              <c:when test="${product.quantity > 0}">
                <div class="quantity">
                  <input type="number" id="quantity" class="input-text qty text" step="1" min="1" max="${product.quantity}" name="quantity" value="1" title="Qty" size="4" pattern="[0-9]*" inputmode="numeric">
                </div>
                <button type="button" class="button" onclick="addCart(${product.productId})">Add to cart</button>
              </c:when>
              <c:otherwise>
                <button type="button" class="button" disabled>Sản phẩm hết hàng</button>
              </c:otherwise>
            </c:choose>
            <ul class="product_meta">
              <li><span class="theme-bg-clr">Category:</span>
                <ul class="pd-cat">
                  <li><a href="#">${typeProduct.typeProductName}</a></li>
                </ul>
              </li>
<%--              <li><span class="theme-bg-clr">Tags:</span>--%>
<%--                <ul class="pd-tag">--%>
<%--                  <li>--%>
<%--                    <a href="#">Pet</a>--%>
<%--                    ,<a href="#">Pet care</a>--%>
<%--                  </li>--%>
<%--                </ul>--%>
<%--              </li>--%>
            </ul>
          </form>
        </div>
      </div>
    </div>
  </div>
</section>
<section class="gap">
  <div class="container">
    <div class="information">
      <h3>Description</h3>
      <div class="boder-bar"></div>
      <p>${product.describeProduct}</p>
    </div>
    <div class="row mt-5">
      <div class="col-lg-7">
        <div class="information">
          <h3>Related Products</h3>
          <div class="boder-bar"></div>
          <p>Lorem ipsum dolor sit amet,consectetur adipiscing elit do eiusmosed do eiusmod teincididunt ut la amet,consectetur adipiscing elib incididunt ut labore et.Lorem ipsumsit amet, consec</p>
          <div class="row mt-md-5">
            <div class="col-lg-6 col-md-6">
              <div class="pet-grooming">
                <i><img src="assets/img/welcome-to-1.png" alt="icon"></i>
                <svg width="138" height="138" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#940c69"></path>
                </svg>
                <a href="#"><h4>Pet Grooming</h4></a>
                <p>Lorem ipsum dolor sit amet ur adipiscing elit, sed do eiu incididunt ut labore et.</p>
              </div>
            </div>
            <div class="col-lg-6 col-md-6">
              <div class="pet-grooming">
                <i><img src="assets/img/welcome-to-2.png" alt="icon"></i>
                <svg width="138" height="138" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
                  <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#940c69"></path>
                </svg>
                <a href="#"><h4>Dog Walking</h4></a>
                <p>Lorem ipsum dolor sit amet ur adipiscing elit, sed do eiu incididunt ut labore et.</p>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div class="col-lg-5">
        <div class="looking video position-relative">
          <svg class="golo" width="510" height="510" viewBox="0 0 673 673" xmlns="http://www.w3.org/2000/svg">
            <path fill-rule="evenodd" clip-rule="evenodd" d="M9.82698 416.603C-19.0352 298.701 18.5108 173.372 107.497 90.7633L110.607 96.5197C24.3117 177.199 -12.311 298.935 15.0502 413.781L9.82698 416.603ZM89.893 565.433C172.674 654.828 298.511 692.463 416.766 663.224L414.077 658.245C298.613 686.363 175.954 649.666 94.9055 562.725L89.893 565.433ZM656.842 259.141C685.039 374.21 648.825 496.492 562.625 577.656L565.413 582.817C654.501 499.935 691.9 374.187 662.536 256.065L656.842 259.141ZM581.945 107.518C499.236 18.8371 373.997 -18.4724 256.228 10.5134L259.436 16.4515C373.888 -10.991 495.248 25.1518 576.04 110.708L581.945 107.518Z" fill="#000"/>
          </svg>
          <a data-fancybox="" href="https://www.youtube.com/watch?v=xKxrkht7CpY">
            <i>
              <svg width="11" height="17" viewBox="0 0 11 17" fill="none" xmlns="http://www.w3.org/2000/svg">
                <path d="M11 8.49951L0.5 0.27227L0.5 16.7268L11 8.49951Z" fill="#000"></path>
              </svg>
            </i>
          </a>
          <img src="assets/img/dog-video-1.jpg" alt="img">
        </div>
      </div>
    </div>
    <div class="information mt-70">
      <h3>Nutritional Info</h3>
      <div class="boder-bar"></div>
      <ul class="specification">
        <li><h6>Vitamin E</h6>100 IU/kg</li>
        <li><h6>Glucosamine</h6>350 mg/kg*</li>
        <li><h6>Crude Protein</h6>21.0%</li>
        <li><h6>Moisture </h6>12.0%</li>
      </ul>
    </div>
    <div class="information mt-70">
      <h3>Feeding Guidelines</h3>
      <div class="boder-bar"></div>
      <div class="table-responsive">
        <table class="table">
          <thead>
          <tr>
            <th scope="col">Weight of Dog</th>
            <th scope="col">Cups Per Day</th>
            <th scope="col">Mix With Pouch</th>
          </tr>
          </thead>
          <tbody>
          <tr>
            <td class="noBorder">Up to 10 lb</td>
            <td class="noBorder">1 to 2</td>
            <td class="noBorder">3.5 oz of PEDIGREE® Pouch</td>
          </tr>
          <tr>
            <td class="noBorder">10 to 25</td>
            <td class="noBorder">2 to 3</td>
            <td class="noBorder">3.5 oz of PEDIGREE</td>
          </tr>
          <tr>
            <td class="noBorder">50 to 75</td>
            <td class="noBorder">1 to 2</td>
            <td class="noBorder"></td>
          </tr>
          <tr>
            <td class="noBorder">75 to 150</td>
            <td class="noBorder">2 to 3</td>
          </tr>
          </tbody>
        </table>
      </div>
    </div>
    <div class="row mt-70">
      <div class="col-lg-7">
        <div class="information ">
          <h3>Reviews</h3>
          <div class="boder-bar"></div>
        </div>
        <ul class="reviews">
          <c:forEach var="review" items="${listReview}">
            <li>
              <div>
                <img alt="img" src="${review.avatar}" style="height: 100px; width: 100px;">
                <div class="star">
                  <c:forEach var="i" begin="1" end="5">
                    <c:choose>
                      <c:when test="${i <= review.starQuantity}">
                        <i class="fa-solid fa-star" style="color: #f5b301;"></i>
                      </c:when>
                      <c:otherwise>
                        <i class="fa-solid fa-star" style="color: #ddd;"></i>
                      </c:otherwise>
                    </c:choose>
                  </c:forEach>
                </div>
              </div>
              <div>
                <div class="d-flex align-items-center">
                  <h4>${review.name}</h4>
                  <span>${review.createdDate}</span>
                </div>
                <p>${review.content}</p>
              </div>
            </li>
          </c:forEach>

        </ul>
<%--        <ul class="pagination">--%>
<%--          <li class="prev"><a href="#"><i class='fa-solid fa-arrow-left'></i></a></li>--%>
<%--          <li><a href="#">1</a></li>--%>
<%--          <li><a href="#">2</a></li>--%>
<%--          <li><a href="#">......</a></li>--%>
<%--          <li><a href="#">18</a></li>--%>
<%--          <li class="next"><a href="#"><i class='fa-solid fa-arrow-right'></i></a></li>--%>
<%--        </ul>--%>
      </div>
      <div class="col-lg-5">
        <c:choose>
          <c:when test="${checkUser}">
              <form action="/addReview" method="post" class="add-review comment leave-comment">
                <div class="information">
                  <h3>Leave Your Review</h3>
                  <div class="boder-bar"></div>
                  <div class="d-flex align-items-center mb-4">
                    <input hidden name="productId" value="${product.productId}">
                    <span>Select Rating:</span>
                    <div class="star-rating ps-md-4">
                      <input type="radio" id="star5" name="startQuantity" value="5" />
                      <label for="star5" title="5 stars"><i class="fa-solid fa-star"></i></label>
                      <input type="radio" id="star4" name="startQuantity" value="4" />
                      <label for="star4" title="4 stars"><i class="fa-solid fa-star"></i></label>
                      <input type="radio" id="star3" name="startQuantity" value="3" />
                      <label for="star3" title="3 stars"><i class="fa-solid fa-star"></i></label>
                      <input type="radio" id="star2" name="startQuantity" value="2" />
                      <label for="star2" title="2 stars"><i class="fa-solid fa-star"></i></label>
                      <input type="radio" id="star1" name="startQuantity" value="1" />
                      <label for="star1" title="1 star"><i class="fa-solid fa-star"></i></label>
                    </div>
                  </div>
                </div>
                <textarea placeholder="Add Review" name="content"></textarea>
                <button class="button">Add Review</button>
              </form>
            </c:when>
            <c:otherwise>
                <div class="information">
                    <h3>Leave Your Review</h3>
                    <div class="boder-bar"></div>
                    <p>Bạn cần mua sản phẩm để có thể đánh giá sản phẩm</p>
                </div>
            </c:otherwise>
        </c:choose>

      </div>
    </div>
  </div>
</section>
<section class="gap no-top products-section">
  <div class="container">
    <div class="information">
      <h3>Related Products</h3>
      <div class="boder-bar"></div>
    </div>
    <div class="row">
      <c:forEach var="relatedProduct" items="${listRelatedProduct}">
        <div class="col-lg-3 col-md-4 col-sm-6">
          <div class="healthy-product mb-0">
            <div class="healthy-product-img">
              <img src="${relatedProduct.img}" alt="food" style="width: 217px; height: 255px;">
              <ul class="star">
                <li><i class="fa-solid fa-star"></i></li>
                <li><i class="fa-solid fa-star"></i></li>
                <li><i class="fa-solid fa-star"></i></li>
                <li><i class="fa-solid fa-star"></i></li>
                <li><i class="fa-solid fa-star"></i></li>
              </ul>
              <div class="add-to-cart">
                <a href="#">Add to Cart</a>
                <a href="#" class="heart-wishlist">
                  <i class="fa-regular fa-heart"></i>
                </a>
              </div>
              <c:choose>
                <c:when test="${relatedProduct.priceAfterDiscount != 0}">
                  <h4>-${relatedProduct.discountPercentage}%</h4>
                </c:when>
              </c:choose>
            </div>
            <span>${relatedProduct.productTypeName}</span>
            <a href="/detailProduct?id=${relatedProduct.productId}">${relatedProduct.productName}</a>
            <c:choose>
              <c:when test="${relatedProduct.priceAfterDiscount != 0}">
                <h6>
                  <del><fmt:formatNumber value="${relatedProduct.priceProduct}" type="number" groupingUsed="true" /> ₫</del>
                  <fmt:formatNumber value="${relatedProduct.priceAfterDiscount}" type="number" groupingUsed="true" /> ₫
                </h6>
              </c:when>
              <c:otherwise>
                <h6>
                  <fmt:formatNumber value="${relatedProduct.priceProduct}" type="number" groupingUsed="true" /> ₫
                </h6>
              </c:otherwise>
            </c:choose>
          </div>
        </div>
      </c:forEach>

    </div>
  </div>
</section>
<%@include file="footer.jsp" %>
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
<script src="/assets/js/bootstrap.min.js"></script>
<script src="/assets/js/owl.carousel.min.js"></script>
<script src="/assets/js/slick.min.js"></script>
<!-- fancybox -->
<script src="/assets/js/jquery.fancybox.min.js"></script>
<script src="/assets/js/custom.js"></script>
<script>
  function addCart(id) {
    console.log($("#quantity").val());
    $.ajax({
      url: "/addItemToCart",
      type: "POST",
      data: {
        productId: id,
        quantity: $("#quantity").val()
      },
      success: function (data) {
        alert(data);
        location.reload();

      }
    });
  }
</script>
</body>
