<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Admin - Chat Rooms</title>
    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/style.css">
</head>

<body>
<!-- header -->
<%@ include file="header.jsp" %>
<!-- header end -->

<div class="container">
    <h1 class="mt-4">Chat Rooms</h1>
    <table class="table table-bordered mt-3">
        <thead>
        <tr>
            <th>Chat Room ID</th>
            <th>Status</th>
            <th>Created At</th>
            <th>User</th>
            <th>Admin</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="chatRoom" items="${chatRooms}">
            <tr>
                <td>${chatRoom.chatRoomID}</td>
                <td>
                    <c:choose>
                        <c:when test="${chatRoom.status}">
                            Active
                        </c:when>
                        <c:otherwise>
                            Inactive
                        </c:otherwise>
                    </c:choose>
                </td>
                <td>${chatRoom.createdAt}</td>
                <td>${chatRoom.user.name}</td>
                <td>${chatRoom.admin.name}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<%@ include file="footer.jsp" %>

<!-- Bootstrap Js -->
<script src="assets/js/bootstrap.min.js"></script>
</body>

</html>
te