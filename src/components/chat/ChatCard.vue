<template>
    <div class="messages-container">
        <!-- 채팅 메시지 리스트 -->
        <div v-for="(message, index) in chatMessages" :key="index"
            :class="['message', message.userNickName === myNickname ? 'user-message' : 'other-message']">
            <!-- 유저 닉네임 -->
            <div v-if="message.userNickName !== myNickname" class="name">
                {{ message.userNickName }}
            </div>
            <!-- 메시지 내용 -->
            <div class="text-box">
                <p>{{ message.content }}</p>
            </div>
        </div>
    </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";

export default {
    name: "ChatCard",
    setup() {
        const chatMessages = ref([]); // 채팅 메시지 리스트
        const myNickname = ref("몸짱우성문"); // 본인 닉네임

        // API 호출
        const fetchChatMessages = async () => {
            try {
                const response = await axios.get("http://localhost:8080/api/chat/logs");

                // API에서 데이터 가져와 chatMessages에 할당
                chatMessages.value = response.data;
                console.log("Fetched chat messages:", response.data);
            } catch (error) {
                console.error("Error fetching chat messages:", error);
            }
        };

        onMounted(() => {
            fetchChatMessages();
        });

        return {
            chatMessages,
            myNickname,
        };
    },
};
</script>


<style scoped>
/* 메시지 전체 컨테이너 */
.messages-container {
    margin-top: 20px;
    position: absolute;
    width: 353px;
    height: 424px;
    left: 21px;
    top: 210px;
    display: flex;
    flex-direction: column;
    gap: 16px;
    overflow-y: auto;
    padding-bottom: 40px;
    /* 스크롤 막대 하단 간격 확보 */

}

/* 개별 메시지 */
.message {
    display: flex;
    flex-direction: column;
    align-items: flex-start;
    width: 327px;
}

/* User 메시지 (오른쪽 정렬) */
.user-message {
    align-self: flex-end;
}

/* 상대방 메시지 (왼쪽 정렬) */
.other-message {
    align-self: flex-start;
}

/* 텍스트 박스 */
.text-box {
    background: #f2f4f5;
    border-radius: 0px 24px 24px 24px;
    padding: 16px;
    display: flex;
    align-items: center;
}

.user-message .text-box {
    background: #0070f0;
    color: #ffffff;
    border-radius: 24px 24px 0px 24px;
}

/* 유저 닉네임 스타일 */
.name {
    font-family: "DM Sans", sans-serif;
    font-weight: bold;
    font-size: 12px;
    color: #72777a;
    margin-bottom: 4px;
}

/* 텍스트 스타일 */
.text-box p {
    font-family: "DM Sans", sans-serif;
    font-size: 16px;
    line-height: 24px;
    margin: 0;
    color: #303437;
}

.user-message .text-box p {
    color: #ffffff;
}

/* 스크롤바 스타일 */
.messages-container::-webkit-scrollbar {
    width: 6px;
}

.messages-container::-webkit-scrollbar-thumb {
    background: #ccc;
    border-radius: 10px;
}

.messages-container::-webkit-scrollbar-track {
    background: #f9f9f9;
}
</style>