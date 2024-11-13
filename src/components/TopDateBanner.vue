<template>
    <div class="date-display">
        <!-- 요일 표시 -->
        <div class="days-of-week">
            <span v-for="(day, index) in days" :key="index" class="day">
                {{ day }}
            </span>
        </div>

        <!-- 날짜 표시 -->
        <div class="dates">
            <span v-for="(date, index) in dates" :key="index"
                :class="['date', { 'highlighted-date': index === highlightedDateIndex }]">
                {{ date }}
            </span>
        </div>
    </div>
</template>

<script>
export default {
    name: 'StaticDateDisplay',
    data() {
        return {
            days: ['M', 'T', 'W', 'T', 'F', 'S', 'S'], // 요일
            dates: [13, 14, 15, 16, 17, 18, 19], // 표시할 날짜들
            highlightedDateIndex: 2, // 강조할 날짜의 인덱스 (예: 15일을 강조)
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
}

.days-of-week {
    display: flex;
    justify-content: space-between;
    width: 100%;
}

.day {
    font-family: 'DM Sans', sans-serif;
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
    font-family: 'DM Sans', sans-serif;
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