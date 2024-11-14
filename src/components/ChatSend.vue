<template>
    <div class="send-message-prompt">
        <!-- 메시지 입력 필드와 아이콘 -->
        <div class="send-message-input">
            <input type="text" placeholder="Type a message..." class="input-field" />
        </div>
        <button class="send-button">
        </button>
    </div>
</template>

<script>
export default {
    name: "ChatSend",
};
</script>

<style scoped>
.send-message-prompt {
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    padding: 32px 24px;
    gap: 10px;
    position: absolute;
    width: 375px;
    height: 108px;
    left: 12px;
    top: 624px;
    background: #ffffff;
    border-radius: 0px 0px 0px 48px;
}

/* 메시지 입력 필드 */
.send-message-input {
    display: flex;
    flex-direction: row;
    align-items: center;
    gap: 16px;
    width: 327px;
    height: 44px;
    background: #ffffff;
    border: 1.5px solid #979c9e;
    border-radius: 48px;
    padding: 0 10px;
}

/* 입력 필드 스타일 */
.input-field {
    flex-grow: 1;
    border: none;
    outline: none;
    padding: 10px 20px;
    font-family: 'DM Sans', sans-serif;
    font-weight: 400;
    font-size: 16px;
    color: #72777a;
    background: transparent;
}

.input-field::placeholder {
    color: #72777a;
}

/* 마이크 아이콘 스타일 */
.microphone-icon {
    width: 24px;
    height: 24px;
}

/* 전송 버튼 스타일 */
.send-button {
    width: 44px;
    height: 44px;
    background: #303437;
    border: none;
    border-radius: 50%;
    display: flex;
    justify-content: center;
    align-items: center;
    cursor: pointer;
}

.send-icon {
    width: 24px;
    height: 24px;
    fill: #f2f4f5;
}
</style>