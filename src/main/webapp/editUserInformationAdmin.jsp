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
    <title>Edit User Information</title>
    <link rel="stylesheet" type="text/css" href="/assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="/assets/css/style.css">
    <script src="/assets/js/jquery-3.6.0.min.js"></script>
    <script src="/assets/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <h1>Edit User Information</h1>
    <form action="/editUserInfo" method="post" enctype="multipart/form-data">
        <input type="hidden" name="userID" value="${userInfo.userID}" />

        <div class="form-group">
            <label for="name">Name:</label>
            <input type="text" class="form-control" id="name" name="name" value="${userInfo.name}" required>
        </div>

        <div class="form-group">
            <label for="userDOB">Date of Birth:</label>
            <input type="date" class="form-control" id="userDOB" name="userDOB" value="${userInfo.userDOB}">
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="email" class="form-control" id="email" name="email" value="${userInfo.email}" required>
        </div>

        <div class="form-group">
            <label for="phoneNumber">Phone Number:</label>
            <input type="text" class="form-control" id="phoneNumber" name="phoneNumber" value="${userInfo.phoneNumber}">
        </div>

        <div class="form-group">
            <label for="gender">Gender:</label>
            <select class="form-control" id="gender" name="gender">
                <option value="1" ${userInfo.gender ? 'selected' : ''}>Male</option>
                <option value="0" ${!userInfo.gender ? 'selected' : ''}>Female</option>
            </select>
        </div>

        <div class="form-group">
            <label for="address">Address:</label>
            <input type="text" class="form-control" id="address" name="address" value="${userInfo.address}">
        </div>

        <div class="form-group">
            <label for="avatar">Avatar:</label>
            <input type="file" class="form-control" id="avatar" name="avatar">
            <img src="${userInfo.avatar}" alt="avatar" style="width: 100px; height: 100px;">
        </div>

        <div class="form-group">
            <label for="description">Description:</label>
            <textarea class="form-control" id="description" name="description">${userInfo.description}</textarea>
        </div>

        <div class="form-group">
            <label for="password">Password:</label>
            <input type="text" class="form-control" id="password" name="password"/>
        </div>

        <div class="form-group">
            <label for="typeAccountId">Type of Account:</label>
            <select class="form-control" id="typeAccountId" name="typeAccountId">
                <c:forEach var="type" items="${typeAccountList}">
                    <option value="${type.typeAccountId}" ${type.typeAccountId == userInfo.typeAccountId ? 'selected' : ''}>${type.typeAccountName}</option>
                </c:forEach>
            </select>
        </div>

        <div class="form-group">
            <label for="idFacebook">Facebook ID:</label>
            <input type="text" class="form-control" id="idFacebook" name="idFacebook" value="${userInfo.idFacebook}">
        </div>

        <div class="form-group">
            <label for="idGoogle">Google ID:</label>
            <input type="text" class="form-control" id="idGoogle" name="idGoogle" value="${userInfo.idGoogle}">
        </div>

        <div class="form-group">
            <label for="status">Status:</label>
            <select class="form-control" id="status" name="status">
                <option value="1" ${userInfo.status ? 'selected' : ''}>Active</option>
                <option value="0" ${!userInfo.status ? 'selected' : ''}>Inactive</option>
            </select>
        </div>

        <div class="form-group">
            <label for="token">Token:</label>
            <input type="text" class="form-control" id="token" name="token" value="${userInfo.token}">
        </div>

        <button type="submit" class="btn btn-primary">Update</button>
    </form>
</div>
</body>
</html>
