<template>
    <div class="food-log-card">
        <div class="date">{{ date }}</div>
        <ul>
            <li v-for="meal in meals" :key="meal.mealType" class="meal-item">
                meal.mealType - meal.foodName : meal.calorie kcal
            </li>
        </ul>
        <div class="total-calories">{{ totalCalories }} kcal</div>
    </div>
</template>

<script>
export default {
    props: {
        date: String,
        meals: Array,
        totalCalories: Number,
    },
};
</script>

<style scoped>
.food-log-card {
    position: relative;
    width: 300px;
    height: auto;
    background-color: #f8d4d4;
    border-radius: 20px;
    padding: 16px;
    margin-bottom: 16px;
}

/* Date */
.date {
    position: absolute;
    left: 16px;
    top: 16px;
    font-family: 'Inter', sans-serif;
    font-weight: 400;
    font-size: 24px;
    line-height: 29px;
    color: #000000;
}

/* Meal Item */
.meal-item {
    position: relative;
    width: 229px;
    font-family: 'Inter', sans-serif;
    font-weight: 400;
    font-size: 24px;
    line-height: 29px;
    color: #000000;
    margin-left: 147px;
    margin-top: 16px;
    text-align: center;
    display: flex;
    align-items: center;
}

/* Total Calories */
.total-calories {
    position: absolute;
    left: 20px;
    top: calc(100% - 47px);
    /* Ensures it is aligned to the bottom */
    font-family: 'Inter', sans-serif;
    font-weight: 300;
    font-size: 24px;
    line-height: 29px;
    color: #000000;
    width: 104px;
    text-align: center;
}
</style>