<template>
    <div class="messages-container">
        <!-- 메시지 리스트 -->
        <div class="message bot-message">
            <div class="message-content">

                <div class="text-box">
                    <p>Hello, I’m FitBot! 👋 I’m your personal sport assistant. How can I help you?</p>
                </div>
            </div>
        </div>

        <div class="message user-message">
            <div class="text-box">
                <p>Show me other options</p>
            </div>
        </div>

        <div class="message bot-message">
            <div class="message-content">
                <div class="text-box">
                    <p>Ok, how about these?</p>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "ChatCard",
};
</script>

<style scoped>
/* 메시지 전체 컨테이너 */
.messages-container {
    position: absolute;
    width: 353px;
    height: 424px;
    left: 21px;
    top: 210px;
    display: flex;
    flex-direction: column;
    gap: 16px;
}

/* 개별 메시지 */
.message {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    width: 327px;
}

.bot-message .message-content,
.user-message .text-box {
    display: flex;
    align-items: flex-start;
    padding: 16px;
    border-radius: 24px;
}

.bot-message .text-box {
    background: #f2f4f5;
    border-radius: 0px 24px 24px 24px;
}

.user-message .text-box {
    background: #0070f0;
    color: #ffffff;
    align-self: flex-end;
    border-radius: 24px 24px 0px 24px;
}

/* 타임스탬프 */
.timestamp {
    font-family: 'DM Sans', sans-serif;
    font-style: normal;
    font-weight: 500;
    font-size: 12px;
    color: #72777a;
    margin-bottom: 4px;
}

/* 봇 아이콘 */
.message-content {
    display: flex;
    gap: 8px;
}

.bot-icon {
    position: relative;
    width: 32px;
    height: 32px;
}

.icon-background {
    position: absolute;
    width: 32px;
    height: 32px;
    background: #f2f8ff;
    border-radius: 50%;
}

.icon-background::after {
    content: '';
    position: absolute;
    width: 16px;
    height: 16px;
    top: 8px;
    left: 8px;
    background: #0070f0;
    border-radius: 50%;
}

.text-box p {
    font-family: 'DM Sans', sans-serif;
    font-style: normal;
    font-weight: 400;
    font-size: 16px;
    line-height: 24px;
    color: #303437;
    margin: 0;
}

.user-message .text-box p {
    color: #ffffff;
}
</style>
