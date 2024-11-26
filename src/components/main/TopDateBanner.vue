<template>
  <div class="date-display">
    <!-- 요일 표시 -->
    <div class="days-of-week">
      <span v-for="(day, index) in days" :key="index" class="day">
        {{ day }}
      </span>
    </div>

    <!-- OX 표시 -->
    <div class="dates">
      <span
        v-for="(date, index) in paddedDates"
        :key="index"
        :class="['date', { 'highlighted-date': index === todayIndex }]"
      >
        {{ date.isGoal !== undefined ? (date.isGoal ? "O" : "X") : "" }}
      </span>
    </div>
  </div>
</template>

<script>
import { ref, onMounted, computed } from "vue";
import axios from "axios";

export default {
  name: "StaticDateDisplay",
  setup() {
    const days = ref(["M", "T", "W", "T", "F", "S", "S"]);
    const dailyGoals = ref([]);

    const todayIndex = new Date().getDay() - 1;

    const fetchDailyGoals = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/api/user/goals"
        );
        dailyGoals.value = response.data.dailyGoals;
        console.log(response);
      } catch (error) {
        console.error("Error fetching daily goals:", error);
      }
    };

    const paddedDates = computed(() => {
      const filledDates = dailyGoals.value.map((goal) => ({
        date: goal.date,
        isGoal: goal.isGoal,
      }));

      const padded = Array(7).fill({});
      filledDates.forEach((entry, index) => {
        if (index <= todayIndex) {
          padded[index] = entry;
        }
      });

      return padded;
    });

    onMounted(fetchDailyGoals);

    return {
      days,
      dailyGoals,
      paddedDates,
      todayIndex,
    };
  },
};
</script>

<style scoped>
.date-display {
  display: flex;
  flex-direction: column;
  align-items: center;
  padding: 16px;
  margin-bottom: 0;
}

.days-of-week {
  display: flex;
  justify-content: space-between;
  width: 100%;
}

.day {
  font-family: "DM Sans", sans-serif;
  font-weight: 500;
  font-size: 14px;
  color: #0070f0;
  text-align: center;
  flex: 1;
}

.dates {
  display: flex;
  justify-content: space-between;
  width: 100%;
  margin-top: 8px;
}

.date {
  font-weight: 500;
  font-size: 14px;
  color: #979c9e;
  text-align: center;
  padding: 4px;
  flex: 1;
}

.highlighted-date {
  background-color: #303437;
  color: #f2f4f5;
  border-radius: 8px;
}
</style>
