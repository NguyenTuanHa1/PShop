<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Admin Chat Dashboard</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css">
    <link rel="stylesheet" href="assets/css/style.css">
    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f8f9fa;
        }

        .sidebar {
            height: 100vh;
            padding: 0;
            background-color: #343a40;
            color: #fff;
        }

        .sidebar .nav-link {
            color: #fff;
        }

        .sidebar .nav-link.active {
            background-color: #007bff;
            color: #fff;
        }

        .sidebar .nav-link:hover {
            background-color: #495057;
            color: #fff;
        }

        .sidebar .nav-link img {
            width: 30px;
            height: 30px;
        }

        .card-header {
            background-color: #fff;
            border-bottom: 1px solid #dee2e6;
        }

        .chat-box {
            height: 400px;
            overflow-y: auto;
        }

        .chat-message {
            margin-bottom: 10px;
        }

        .chat-message strong {
            color: #007bff;
        }

        .card-footer {
            background-color: #fff;
            border-top: 1px solid #dee2e6;
        }

    </style>
</head>
<body>

<!-- header -->
<%--<%@include file="header.jsp" %>--%>
<!-- header end -->

<div class="container-fluid" style="">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">
                            <i class="fas fa-user-friends"></i>
                            Users
                        </a>
                    </li>
                    <c:forEach items="${chatRoomList}" var="chatRoom">
                        <li class="nav-item">
                            <a class="nav-link user-link" href="#" data-roomid="${chatRoom.chatRoomID}" data-userid="${chatRoom.user.userID}">
                                <img src="${chatRoom.user.avatar}" class="rounded-circle mr-2" alt="${chatRoom.user.name}" width="30" height="30">
                                    ${chatRoom.user.name}
                            </a>
                        </li>
                    </c:forEach>
                </ul>
            </div>
        </nav>

        <main role="main" class="col-md-9 ml-sm-auto col-lg-10 px-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
                <h1 class="h2">Chat with Users</h1>
            </div>

            <div class="row">
                <div class="col-md-4">
                    <div class="list-group" id="userList">
                        <c:forEach items="${chatRoomList}" var="chatRoom">
                            <a href="#" class="list-group-item list-group-item-action user-link" data-roomid="${chatRoom.chatRoomID}" data-userid="${chatRoom.user.userID}">
                                <img src="${chatRoom.user.avatar}" class="rounded-circle mr-2" alt="${chatRoom.user.name}" width="30" height="30">
                                    ${chatRoom.user.name}
                            </a>
                        </c:forEach>
                    </div>
                </div>
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">
                            <h5 id="chatWith">Chat with User</h5>
                        </div>
                        <div class="card-body chat-box" id="chatBox" style="height: 400px; overflow-y: auto;">
                            <!-- Chat messages will be loaded here -->
                        </div>
                        <div class="card-footer">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Type a message" id="chatInput">
                                <div class="input-group-append">
                                    <button class="btn btn-primary" type="button" id="sendBtn"><i class="fas fa-paper-plane"></i> Send</button>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<script>
    $(document).ready(function(){
        let userID;
        let token;
        <%
            if (session.getAttribute("user") != null) {
        %>
        userID = ${sessionScope.user.userID};
        token = "${sessionScope.token}";

        <%
            } else {
        %>
        userID = null;
        <%
            }
        %>
        let chatRoomID = null;
        let websocket = null;
        function connect(chatRoomID){
            websocket = new WebSocket("ws://localhost:8080/chatAdmin/" + chatRoomID);

            websocket.onopen = function(message) {processOpen(message);};
            websocket.onmessage = function(message) {processMessage(message);};
            websocket.onclose = function(message) {processClose(message);};
            websocket.onerror = function(message) {processError(message);};

            function processOpen(message) {
                console.log("Server connect... \n");
            }
            function processMessage(message) {
                console.log(message);
            }
            function processClose(message) {
                console.log("Server disconnect... \n");
            }
            function processError(message) {
                console.log("Error... \n");
            }


        }
        $('.user-link').on('click', function(e){
            e.preventDefault();
            userID = $(this).data('userid');
            chatRoomID = $(this).data('roomid');
            $('#chatWith').text('Chat with ' + $(this).text());
            connect(chatRoomID);
            loadChat(userID);
        });

        $('#sendBtn').on('click', function(){
            var message = $('#chatInput').val();
            if(message.trim() !== ''){
                sendMessage(message, chatRoomID);
                $('#chatInput').val('');
            }
        });

        function loadChat(userId){
            fetch('/getMessageAdmin?id=' + userId)
                .then(response => response.json())
                .then(chatMessages => {
                    $('#chatBox').html('');
                    chatMessages.forEach(message => {
                        if (message.sender === 'admin') {
                            $('#chatBox').append('<div class="chat-message"><strong>Admin:</strong> ' + message.content + '</div>');
                        } else {
                            $('#chatBox').append('<div class="chat-message"><strong>User:</strong> ' + message.content + '</div>');
                        }
                    });
                    $('#chatBox').scrollTop($('#chatBox')[0].scrollHeight);
                });
            $('#chatBox').html('<div class="chat-message"><strong>User:</strong> Hello Admin!</div><div class="chat-message"><strong>Admin:</strong> Hi there!</div>');
        }

        function sendMessage(message){
            websocket.send(message);
            $('#chatBox').append('<div class="chat-message"><strong>Admin:</strong> ' + message + '</div>');
            $('#chatBox').scrollTop($('#chatBox')[0].scrollHeight);
        }

    });
</script>

</body>
</html>
