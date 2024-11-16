<template>
  <div class="calorie-info">
    <div class="calorie-text">
      <p>목표 하루 칼로리: {{ userTargetCalorie }}kcal</p>
      <p>오늘 입력한 칼로리: {{ totalCalories }}kcal</p>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";

export default {
  name: "CalorieInfo",
  setup() {
    const userTargetCalorie = ref(0);
    const totalCalories = ref(0);

    const fetchCalorieData = async () => {
      try {
        const response = await axios.get(
          "https://localhost:8080/api/user/target-calorie"
        );
        userTargetCalorie.value = response.data.userTargetCalorie;
        currentCalorie.value = response.data.currentCalorie;
      } catch (error) {
        console.error("Error fetching calorie data:", error);
      }
    };

    onMounted(() => {
      fetchCalorieData();
    });

    return {
      userTargetCalorie,
      totalCalories,
    };
  },
};
</script>
<style scoped>
.calorie-info {
  /* Rectangle 2 */
  box-sizing: border-box;

  background: #f87670;
  border: 1px solid #000000;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);

  position: absolute;
  width: 369px;
  height: 64px;
  left: 12px;
  top: 70px;
}

.calorie-info {
  width: 330px;
  font-family: "Inter", sans-serif;
  font-weight: 400;
  font-size: 20px;
  line-height: 24px;
  color: #000000;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}
</style>
