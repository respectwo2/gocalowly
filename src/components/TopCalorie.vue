<template>
  <div class="calorie-info">
    <p>목표 하루 칼로리: {{ targetCalorie }}kcal</p>
    <p>오늘 입력한 칼로리: {{ currentCalorie }}kcal</p>
  </div>
</template>

<script>
export default {
  props: {
    targetCalorie: Number,
    currentCalorie: Number,
  },
};
</script>

<style scoped>
.calorie-info {
  background-color: #9EFAC1;
  padding: 16px;
  border: 1px solid #000;
}
</style>
