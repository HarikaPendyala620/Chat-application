// script.js
const socket = new WebSocket('ws://localhost:8080/ws');

const chatLog = document.getElementById('chat-log');
const chatInput = document.getElementById('chat-input');
const sendButton = document.getElementById('send-button');

sendButton.addEventListener('click', () => {
    const message = chatInput.value.trim();
    if (message) {
        socket.send(JSON.stringify({ type: 'chat', data: message }));
        chatInput.value = '';
    }
});

socket.onmessage = (event) => {
    const message = JSON.parse(event.data);
    if (message.type === 'chat') {
        const chatMessage = document.createElement('div');
        chatMessage.textContent = `${message.sender}: ${message.data}`;
        chatLog.appendChild(chatMessage);
    }
};