<script>
import { ref, onMounted } from "vue";
import axios from "axios";

export default {
  name: "CalorieInfo",
  setup() {
    const groupText = ref("");

    const fetchGroupText = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/group/");
        groupText.value =
          response.data.message || "데이터를 가져올 수 없습니다.";
        console.log("Fetched group text:", groupText.value);
      } catch (error) {
        console.error("Error fetching group text:", error);
        groupText.value = "에러가 발생했습니다.";
      }
    };

    onMounted(() => {
      fetchGroupText();
    });

    return {
      groupText,
    };
  },
};
</script>

<template>
  <div class="calorie-info">
    <p class="group-text">{{ groupText }}</p>
  </div>
</template>

<style scoped>
.calorie-info {
  display: flex;
  align-items: center;
  justify-content: center;
  box-sizing: border-box;

  background: #f87670;
  border: 1px solid #000000;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

  position: absolute;
  width: 365px;
  height: 64px;
  left: 12px;
  top: 70px;
}

.group-text {
  width: 330px;
  font-family: "Pretendard-Regular", Arial, sans-serif;
  font-weight: 400;
  font-size: 25px;
  line-height: 24px;
  color: #f2f4f5;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}
</style>
