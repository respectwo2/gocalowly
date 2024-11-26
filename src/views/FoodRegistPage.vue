<template>
  <body>
    <div>
      <div>
        <TopBar />
      </div>

      <div class="register-food-log">
        <h1>식사 등록</h1>
        <form @submit.prevent="submitForm">
          <div class="form-group">
            <label for="recordDate">기록 날짜:</label>
            <input
              type="datetime-local"
              id="recordDate"
              v-model="foodLog.recordDate"
              required
            />
          </div>

          <div class="form-group">
            <label for="mealType">식사 유형:</label>
            <select id="mealType" v-model="foodLog.mealType" required>
              <option value="아침">아침</option>
              <option value="점심">점심</option>
              <option value="저녁">저녁</option>
              <option value="간식">간식</option>
            </select>
          </div>

          <div class="form-group">
            <label for="foodName">음식 이름:</label>
            <input
              type="text"
              id="foodName"
              v-model="foodLog.foodName"
              placeholder="음식 이름을 입력하세요"
              required
            />
          </div>

          <div class="form-group">
            <label for="calorie">칼로리 (kcal):</label>
            <input
              type="number"
              id="calorie"
              v-model="foodLog.calorie"
              placeholder="칼로리를 입력하세요"
              required
            />
          </div>

          <button type="submit">등록</button>
        </form>
      </div>
      <br />
      <div class="button-container">
        <button class="guideBtn" @click="toggleModal">칼로리 가이드</button>
      </div>
      <div>
        <NavBar />
      </div>
      <GuideModal
        v-if="isModalOpen"
        title="검색"
        @close="toggleModal"
        @select-food="applySelectedFood"
      />
    </div>
  </body>
</template>

<script>
import { ref } from "vue";
import axios from "axios";
import NavBar from "@/components/common/NavBar.vue";
import TopBar from "@/components/common/TopBar.vue";
import GuideModal from "@/components/common/GuideModal.vue";

export default {
  name: "RegisterFoodLog",
  components: {
    NavBar,
    TopBar,
    GuideModal,
  },
  setup() {
    const foodLog = ref({
      recordDate: "",
      mealType: "",
      foodName: "",
      calorie: 0,
    });

    const isModalOpen = ref(false);

    const submitForm = async () => {
      console.log(foodLog.value);
      try {
        await axios.post(
          "http://localhost:8080/api/user/food-logs",
          foodLog.value
        );
        console.log(foodLog.value);
        alert("식사가 기록되었습니다!");
        resetForm();
        location.href = "/";
      } catch (error) {
        console.error("Error registering food log:", error);
        alert("식사 기록 등록에 실패했습니다.");
      }
    };

    const resetForm = () => {
      foodLog.value = {
        recordDate: "",
        mealType: "",
        foodName: "",
        calorie: 0,
      };
    };

    const toggleModal = () => {
      isModalOpen.value = !isModalOpen.value;
    };

    const applySelectedFood = (food) => {
      foodLog.value.foodName = food.foodDataName;
      foodLog.value.calorie = food.foodDataCalorie;
    };

    return {
      foodLog,
      submitForm,
      toggleModal,
      isModalOpen,
      applySelectedFood,
    };
  },
};
</script>

<style scoped>
body {
  font-family: "Pretendard-Regular", sans-serif;
}

.register-food-log {
  max-width: 500px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background: #f9f9f9;
  font-family: inherit;
}

h1 {
  text-align: center;
  margin-bottom: 20px;
  font-family: inherit;
}

.form-group {
  margin-bottom: 15px;
  font-family: inherit;
}

label {
  display: block;
  margin-bottom: 5px;
  font-weight: bold;
  font-family: inherit;
}

input,
select,
button {
  width: 100%;
  padding: 10px;
  font-size: 16px;
  border: 1px solid #ccc;
  border-radius: 4px;
  font-family: inherit;
}

button {
  background: #f87670;
  color: white;
  border: none;
  cursor: pointer;
  margin-top: 10px;
  font-size: 22px;
  font-family: inherit;
}

.button-container {
  display: flex;
  justify-content: center;
  align-items: center;
  font-family: inherit;
}

.guideBtn {
  width: 250px;
  background: #f87670;
  color: white;
  border: none;
  cursor: pointer;
  margin-top: 10px;
  padding: 10px 20px;
  font-size: 22px;
  font-family: inherit;
}

button:hover {
  background: #e76660;
  font-family: inherit;
}
</style>
