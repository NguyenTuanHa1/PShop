<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<style>
    .chat-button {
        position: fixed;
        bottom: 20px;
        right: 20px;
        background-color: #007bff;
        color: white;
        padding: 10px 20px;
        border-radius: 50px;
        cursor: pointer;
        z-index: 1000;
        display: flex;
        align-items: center;
    }

    .chat-button i {
        margin-right: 8px;
    }

    .chat-window {
        position: fixed;
        bottom: 80px;
        right: 20px;
        width: 300px;
        background-color: white;
        border: 1px solid #ddd;
        border-radius: 8px;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        display: none;
        z-index: 1000;
    }

    .chat-header {
        background-color: #007bff;
        color: white;
        padding: 10px;
        border-radius: 8px 8px 0 0;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    .chat-body {
        padding: 10px;
        max-height: 300px;
        overflow-y: auto;
    }

    .chat-footer {
        padding: 10px;
        display: flex;
    }

    .chat-footer input {
        flex: 1;
        padding: 5px;
        border: 1px solid #ddd;
        border-radius: 4px;
    }

    .chat-footer .send-btn {
        background-color: #007bff;
        color: white;
        border: none;
        padding: 5px 10px;
        margin-left: 5px;
        border-radius: 4px;
        cursor: pointer;
    }

    .close-chat {
        background: none;
        border: none;
        color: white;
        font-size: 20px;
        cursor: pointer;
    }

    .chat-body {
        flex-grow: 1;
        overflow-y: auto;
        padding: 10px;
        background-color: #fff;
        border-bottom: 1px solid #ccc;
    }

    .welcome-message {
        color: #555;
        text-align: center;
        margin: 10px 0;
    }

    .message {
        margin: 10px 0;
        padding: 10px;
        border-radius: 10px;
    }

    .message.user {
        background-color: #e1f5fe;
        text-align: right;
    }

    .message.admin {
        background-color: #ffebee;
        text-align: left;
    }

    .message .sender {
        font-weight: bold;
    }

    .message .content {
        margin-top: 5px;
    }

    .message .timestamp {
        font-size: 0.8em;
        color: #888;
        margin-top: 5px;
    }

    .chat-footer {
        display: flex;
        padding: 10px;
        border-bottom-left-radius: 10px;
        border-bottom-right-radius: 10px;
        background-color: #f1f1f1;
    }

    .chat-footer input {
        flex-grow: 1;
        padding: 10px;
        border: 1px solid #ccc;
        border-radius: 10px;
        margin-right: 10px;
    }

    .chat-footer button {
        padding: 10px 20px;
        border: none;
        background-color: #007bff;
        color: #fff;
        border-radius: 10px;
        cursor: pointer;
    }

</style>

<div id="chat-button" class="chat-button">
    <i class="fa-solid fa-comments"></i>
</div>

<div id="chat-window" class="chat-window" style="display:none;">
    <div class="chat-header">
        <h5>Admin Chat</h5>
        <button id="close-chat" class="close-chat">&times;</button>
    </div>
    <div class="chat-body" id="chat-body">
        <p class="welcome-message">Welcome! How can I help you today?</p>
        <!-- Chat messages will go here -->
    </div>
    <div class="chat-footer">
        <input type="text" placeholder="Type your message..." name="chatContent" id="chatContent"/>
        <button class="send-btn" id="sendBtn">Send</button>
    </div>
</div>

<!-- Ensure jQuery is loaded before your script -->
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1.3.0/dist/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
    $(document).ready(function() {
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
        const websocket = new WebSocket("ws://localhost:8080/chat/" + token);

        function connect() {
            websocket.onopen = function(message) {processOpen(message);};
            websocket.onmessage = function(message) {processMessage(message);};
            websocket.onclose = function(message) {processClose(message);};
            websocket.onerror = function(message) {processError(message);};

            function processOpen(message) {
                console.log("Server connect... \n");
            }
            function processMessage(message) {
                console.log(message);
                showMessage(JSON.parse(message.data), "user");
            }
            function processClose(message) {
                console.log("Server disconnect... \n");
            }
            function processError(message) {
                console.log("Error... \n");
            }

            function sendMessage() {
                if (typeof websocket != 'undefined' && websocket.readyState === WebSocket.OPEN) {
                    websocket.send("a");
                }
            }
        }

        function loadChatRooms() {
            fetch('/getAllMessage')
                .then(response => response.json())
                .then(chatRooms => {
                    chatRooms.forEach(chatRoom => {
                        showMessage(chatRoom, "user");
                    });
                });
        }

        $('#sendBtn').click(function() {
            const content = $('#chatContent').val();
            websocket.send(content);
            // stompClient.send("/app/chat", {}, JSON.stringify({'content': content, 'userID': userID}));
            $('#chatContent').val('');
        });

        function showMessage(message, role) {
            const messageDiv = $('<div>').addClass('message');
            const senderDiv = $('<div>').addClass('sender').text(message.sender);
            const contentDiv = $('<div>').addClass('content').text(message.content);
            const timestampDiv = $('<div>').addClass('timestamp').text(message.timestamp);

            if (role === "user") {
                messageDiv.addClass('user');
                messageDiv.append(senderDiv).append(contentDiv);
            } else {
                messageDiv.addClass('admin');
                messageDiv.append(senderDiv).append(contentDiv).append(timestampDiv);
            }

            $('#chat-body').append(messageDiv);
            $('#chat-body').scrollTop($('#chat-body')[0].scrollHeight); // Scroll to the bottom
        }

        document.getElementById('chat-button').addEventListener('click', function() {
            document.getElementById('chat-window').style.display = 'block';
        });

        document.getElementById('close-chat').addEventListener('click', function() {
            document.getElementById('chat-window').style.display = 'none';
        });

        connect();
        loadChatRooms();
    });
</script>
