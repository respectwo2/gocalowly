<template>
  <div class="calorie-info">
    <div class="calorie-text">
      <div>
        이달의 목표 {{ userTargetcalorie }}kcal
      </div>
      <div>
        등록한 칼로리 {{ totalCalories }}kcal
      </div>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";

export default {
  name: "CalorieInfo",
  setup() {
    const userTargetcalorie = ref(0);
    const totalCalories = ref(0);

    const fetchCalorieData = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/api/user/target-calorie"
        );
        userTargetcalorie.value = response.data.userTargetCalorie;
        totalCalories.value = response.data.totalCalories;
      } catch (error) {
        console.error("Error fetching calorie data:", error);
      }
    };

    onMounted(() => {
      fetchCalorieData();
    });

    return {
      userTargetcalorie,
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
  width: 365px;
  height: 64px;
  left: 12px;
  top: 70px;
}

.calorie-text {
  font-family: "Inter", sans-serif;
  font-family: "Pretendard-Regular", Arial, sans-serif;
  font-weight: 400;
  font-size: 20px;
  line-height: 24px;
  color: #F2F4F5;
  display: flex;
  /* flex-direction: column; */
  align-items: center;
  justify-content: center;
  text-align: center;
  margin-top: 5px;
}
</style>
