<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="entity.Cart" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="entity.CartProducts" %>
<%
    List<CartProducts> listCart = (List<CartProducts>) session.getAttribute("cart");
    if(listCart == null){
        listCart = new ArrayList<CartProducts>();
    }
    int total = 0;
    for (CartProducts c : listCart) {
        if (c.getProduct().getPriceAfterDiscount() != 0) {
            total += c.getProduct().getPriceAfterDiscount() * c.getQuantity();
        } else {
            total += c.getProduct().getPriceProduct() * c.getQuantity();
        }
    }
%>
<div id="lightbox" class="lightbox clearfix">
    <div class="white_content">
        <a href="javascript:;" class="textright" id="close"><i class="fa-regular fa-circle-xmark"></i></a>
        <div class="cart-popup">
            <ul>
                <c:forEach items="<%= listCart %>" var="cart">
                    <li class="d-flex align-items-center position-relative">
                        <div class="p-img light-bg">
                            <img src="${cart.product.img}" alt="${cart.product.productName}">
                        </div>
                        <div class="p-data">
                            <h3 class="font-semi-bold">${cart.product.productName}</h3>
                            <p class="theme-clr font-semi-bold">${cart.quantity} x
                                <c:choose>
                                    <c:when test="${cart.product.priceAfterDiscount != 0}">
                                        <fmt:formatNumber value="${cart.product.priceAfterDiscount}" type="number" groupingUsed="true" /> ₫
                                    </c:when>
                                    <c:otherwise>
                                        <fmt:formatNumber value="${cart.product.priceProduct}" type="number" groupingUsed="true" /> ₫
                                    </c:otherwise>
                                </c:choose>
                                ₫</p>
                        </div>
                        <a href="JavaScript:void(0)" id="crosss" onclick="removeItem(${cart.product.productId})"></a>
                    </li>
                </c:forEach>
            </ul>

            <div class="cart-total d-flex align-items-center justify-content-between">

                <span class="font-semi-bold">Total:</span>

                <span class="font-semi-bold"><fmt:formatNumber value="<%= total %>" type="number" groupingUsed="true" /> ₫</span>

            </div>

            <div class="cart-btns d-flex align-items-center justify-content-between">

                <a class="font-bold" href="/cart">View Cart</a>

                <form method="post" action="/processCheckOut">
                    <button id="checkOutBtn" class="btn btn-success" type="submit">Checkout</button>
                </form>

            </div>
        </div>
    </div>
</div>

<script>
    function removeItem(id) {
        $.ajax({
            url: "/removeItemFromCart",
            type: "GET",
            data: {
                productId: id
            },
            success: function (data) {
                location.reload();
            }
        });
    }
    // When click checkout button, prevent , submit form
    $('#checkOutBtn').click(function () {
        $('#checkOutForm').submit();
    });
</script>