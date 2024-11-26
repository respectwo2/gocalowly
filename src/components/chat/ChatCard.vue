<template>
  <div class="messages-container">
    <div
      v-for="(message, index) in chatMessages"
      :key="index"
      :class="[
        'message',
        message.userNickName === myNickname ? 'user-message' : 'other-message',
      ]"
    >
      <div v-if="message.userNickName !== myNickname" class="name">
        {{ message.userNickName }}
      </div>
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
    const chatMessages = ref([]);
    const myNickname = ref([]);
    const fetchChatMessages = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/chat/logs");

        chatMessages.value = response.data;
        myNickname.value = ref(response.data.userNickName);
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
  padding-bottom: 30px;
  padding-left: 5px;
  padding-right: 5px;
}

.message {
  display: flex;
  flex-direction: column;
  align-items: flex-start;
  width: 327px;
}

.user-message {
  align-self: flex-end;
}

.other-message {
  align-self: flex-start;
}

.text-box {
  background: #ffdedd;
  border-radius: 0px 24px 24px 24px;
  padding: 16px;
  display: flex;
  align-items: center;
}

.user-message .text-box {
  background: #0070f0;
  color: #ffffff;
  border-radius: 24px 24px 0px 24px;
  margin-left: auto;
  max-width: 70%;
  text-align: right;
  word-wrap: break-word;
  padding: 16px;
}

.name {
  font-family: "Pretendard-Regular", sans-serif;
  font-weight: bold;
  font-size: 12px;
  color: #72777a;
  margin-bottom: 4px;
}

.text-box p {
  font-family: "Pretendard-Regular", sans-serif;
  font-size: 16px;
  line-height: 24px;
  margin: 0;
  color: #303437;
}

.user-message .text-box p {
  color: #ffffff;
}

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
