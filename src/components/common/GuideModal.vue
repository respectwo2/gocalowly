<template>

  <div class="modal-overlay" @click="$emit('close')">
    <div class="modal-content" @click.stop>
      <div class="modal-header">
        <button class="close-button" @click="$emit('close')">×</button>
      </div>
      <div style="margin-bottom: 15px;">
        <h2>{{ title }}</h2>
      </div>
      <div class="search-section">
        <input type="text" v-model="searchQuery" placeholder="검색어를 입력하세요" />
        <button @click="search">검색</button>
      </div>
      <div class="search-results" v-if="searchResults.length > 0">
        <ul>
          <li v-for="(result, index) in searchResults" :key="index" @click="selectFood(result)" class="search-item">
            <strong>음식 이름:</strong> {{ result.foodDataName }} <br />
            <strong>칼로리:</strong> {{ result.foodDataCalorie }} kcal
          </li>
        </ul>
      </div>
      <p v-if="searchResults.length === 0 && searchPerformed">
        검색 결과가 없습니다.
      </p>
    </div>
  </div>
</template>

<script>
import { ref } from "vue";
import axios from "axios";

export default {
  name: "GuideModal",
  props: {
    title: {
      type: String,
      default: "제목 없음",
    },
  },
  setup(props, { emit }) {
    const searchQuery = ref("");
    const searchResults = ref([]);
    const searchPerformed = ref(false);

    const search = async () => {
      if (!searchQuery.value.trim()) {
        alert("검색어를 입력하세요.");
        return;
      }

      try {
        const response = await axios.get(
          `http://localhost:8080/api/food/search`,
          {
            params: { foodName: searchQuery.value },
          }
        );

        searchResults.value = response.data || [];
        searchPerformed.value = true;
      } catch (error) {
        console.error("검색 중 오류 발생:", error.response || error);
        alert("검색 중 오류가 발생했습니다. 다시 시도하세요.");
      }
    };

    const selectFood = (food) => {
      emit("select-food", food);
      emit("close");
    };

    return {
      searchQuery,
      searchResults,
      searchPerformed,
      search,
      selectFood,
    };
  },
};
</script>

<style scoped>
.modal-overlay {
  position: fixed;
  top: 0;
  left: 0;
  width: 100vw;
  height: 100vh;
  background: rgba(0, 0, 0, 0.5);
  display: flex;
  align-items: center;
  justify-content: center;
  z-index: 1000;
}

.modal-content {
  background: #ffffff;
  padding: 20px;
  border-radius: 8px;
  width: 300px;
  text-align: center;
  z-index: 1001;
}

.search-section {
  display: flex;
  margin-bottom: 15px;
  gap: 10px;
}

.search-section input {
  flex: 1;
  padding: 8px;
  border: 1px solid #ccc;
  border-radius: 4px;
}

.search-section button {
  padding: 8px 16px;
  background: #f87670;
  color: #ffffff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

.search-section button:hover {
  background: #e76660;
}

.search-results {
  margin-top: 15px;
}

.search-results ul {
  list-style: none;
  padding: 0;
}

.search-results li {
  padding: 5px 0;
  border-bottom: 1px solid #ccc;
}

.modal-header {
  display: flex;
  justify-content: flex-end;
}

.close-button {
  background: transparent;
  border: none;
  font-size: 20px;
  font-weight: bold;
  color: #333;
  cursor: pointer;
}

.close-button:hover {
  color: #f87670;
}
</style>
