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
            <span v-for="(date, index) in paddedDates" :key="index"
                :class="['date', { 'highlighted-date': index === todayIndex }]">
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
        const days = ref(["M", "T", "W", "T", "F", "S", "S"]); // 요일
        const dailyGoals = ref([]);

        // 현재 요일 (0: 일요일 ~ 6: 토요일)
        const todayIndex = new Date().getDay() - 1; // 월요일 기준 인덱스화 (Vue에서내가 Sunday까지점점적으로)

        // API 호출 및 데이터 저장
        const fetchDailyGoals = async () => {
            try {
                const response = await axios.get(
                    "http://localhost:8080/api/user/goals"
                );
                dailyGoals.value = response.data.dailyGoals;
            } catch (error) {
                console.error("Error fetching daily goals:", error);
            }
        };

        // 패딩된 OX 데이터 계산
        const paddedDates = computed(() => {
            const filledDates = dailyGoals.value.map((goal) => ({
                date: goal.date,
                isGoal: goal.isGoal,
            }));

            const padded = Array(7).fill({}); // 일주일 전체 초기화
            filledDates.forEach((entry, index) => {
                if (index <= todayIndex) {
                    padded[index] = entry; // 오늘 이전 데이터 채움
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
    font-family: "DM Sans", sans-serif;
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
    padding: 4px 8px;
}
</style>