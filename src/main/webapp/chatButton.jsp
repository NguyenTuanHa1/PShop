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
        background-color: #fff;
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

    .chat-box {
        height: 400px;
        overflow-y: auto;
        padding: 10px;
    }

    .chat-message {
        margin-bottom: 15px;
        padding: 10px;
        border-radius: 10px;
    }

    .chat-message.left {
        background-color: #e9ecef;
        text-align: left;
    }

    .chat-message.right {
        background-color: #007bff;
        color: white;
        text-align: right;
    }

    .chat-message strong {
        display: block;
        margin-bottom: 5px;
    }

    .chat-message .timestamp {
        display: block;
        margin-top: 5px;
        font-size: 0.8em;
        color: #6c757d;
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

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/sockjs-client@1.3.0/dist/sockjs.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/stompjs@2.3.3/lib/stomp.min.js"></script>
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
        const websocket = new WebSocket("ws://localhost:8080/chat/" + token + "/" + userID);

        function connect() {
            websocket.onopen = function(message) { processOpen(message); };
            websocket.onmessage = function(message) { processMessage(message); };
            websocket.onclose = function(message) { processClose(message); };
            websocket.onerror = function(message) { processError(message); };

            function processOpen(message) {
                console.log("Server connect... \n");
            }

            function processMessage(message) {
                const data = JSON.parse(message.data);
                const timestamp = new Date(data.timestamp).toLocaleTimeString();
                if (data.sender.userID !== ${sessionScope.user.userID}) {
                    $('#chat-body').append(
                        '<div class="chat-message left"> <strong>' + "Admin:" + ':</strong>' +
                        data.content +
                        '<span class="timestamp">' + timestamp + '</span></div>'
                    );
                }
                // else {
                //     $('#chat-body').append(
                //         '<div class="chat-message right"><strong>You:</strong>'
                //         + data.content +
                //         '<span class="timestamp">' + timestamp + '</span></div>'
                //     );
                // }
                $('#chat-body').scrollTop($('#chat-body')[0].scrollHeight);
            }

            function processClose(message) {
                console.log("Server disconnect... \n");
            }

            function processError(message) {
                console.log("Error... \n");
            }

            function sendMessage() {
                if (typeof websocket !== 'undefined' && websocket.readyState === WebSocket.OPEN) {
                    websocket.send($('#chatContent').val());
                    $('#chatContent').val('');
                }
            }
        }

        function loadChatRooms() {
            fetch('/getAllMessage')
                .then(response => response.json())
                .then(chatRooms => {
                    chatRooms.forEach(chatRoom => {
                        showMessage(chatRoom);
                    });
                });
        }

        $('#chatContent').keypress(function(event) {
            if (event.keyCode === 13) {
                $('#sendBtn').click();
            }
        });

        $('#sendBtn').click(function() {
            const content = $('#chatContent').val();
            websocket.send(content);
            const timestamp = new Date().toLocaleTimeString();
            $('#chat-body').append(
                '<div class="chat-message right"><strong>Admin:</strong>'
                + content +
                '<span class="timestamp">' + timestamp + '</span></div>'
            );
            $('#chat-body').scrollTop($('#chat-body')[0].scrollHeight);
            $('#chatContent').val('');
        });

        function showMessage(message) {
            console.log(message);
            const timestamp = new Date(message.timestamp).toLocaleTimeString();
            if (message.user.userID === ${sessionScope.user.userID}) {
                $('#chat-body').append(
                    '<div class="chat-message right"> <strong>Admin:</strong>'
                    + message.content +
                    '<span class="timestamp">' +  timestamp + '</span></div>'
                )
            } else {
                $('#chat-body').append(
                    '<div class="chat-message left"><strong>' + "You:" + ':</strong>' +
                    message.content +
                    '<span class="timestamp">' + timestamp+'</span></div>'
                )
            }
        }

        document.getElementById('chat-button').addEventListener('click', function() {
            document.getElementById('chat-window').style.display = 'block';
            $('#chat-body').scrollTop($('#chat-body')[0].scrollHeight);
        });

        document.getElementById('close-chat').addEventListener('click', function() {
            document.getElementById('chat-window').style.display = 'none';
        });

        connect();
        loadChatRooms();
    });
</script>
