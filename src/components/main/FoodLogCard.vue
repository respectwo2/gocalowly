<script>
import { ref, onMounted, computed } from "vue";
import axios from "axios";

export default {
  name: "FoodLogCard",
  setup() {
    const foodLogs = ref([]);

    // API 호출 및 데이터 저장
    const fetchFoodLogs = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/user/food-logs");
        foodLogs.value = response.data;
      } catch (error) {
        console.error("Error fetching food logs:", error);
      }
    };

    // 날짜 포맷팅
    const formatDate = (dateString) => {
      const date = new Date(dateString);
      return date.toLocaleDateString("ko-KR", {
        year: "numeric",
        month: "long",
        day: "numeric",
      });
    };

    onMounted(fetchFoodLogs);

    return {
      foodLogs,
      formatDate,
    };
  },
};
</script>

<template>
  <div class="food-log-container">
    <div v-for="(log, index) in foodLogs" :key="index" class="food-log-card">
      <div class="date">{{ formatDate(log.date) }}</div>
      <ul>
        <li v-for="(food, foodIndex) in log.foodEntries" :key="foodIndex" class="food-item">
          {{ food.mealType }} - {{ food.foodName }} : {{ food.calories }} kcal
        </li>
      </ul>
      <div class="total-calories">총 칼로리: {{ log.totalCalories }} kcal</div>
    </div>
  </div>
</template>

<style scoped>
.food-log-container {
  display: flex;
  flex-wrap: wrap;
  gap: 16px;
  justify-content: center;
  max-height: 450px;
  overflow-y: auto;
}

.food-log-card {
  background-color: #FFDEDD;
  border-radius: 20px;
  padding: 16px;
  margin-bottom: 16px;
  box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);


}

.date {
  font-family: "Pretendard-Regular", sans-serif;
  font-weight: 500;
  font-size: 20px;
  margin-bottom: 16px;
}

.food-item {
  font-family: "Pretendard-Regular", sans-serif;
  font-size: 16px;
  margin-bottom: 8px;
}

.total-calories {
  font-family: "Pretendard-Regular", sans-serif;
  font-weight: bold;
  font-size: 18px;
  margin-top: 16px;
  text-align: right;
}
</style>
