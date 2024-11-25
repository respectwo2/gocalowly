<template>
  <div class="calorie-info">
    <p class="group-text">이대로가면 뚱땡이임</p>
  </div>
</template>

<style scoped>
.calorie-info {
  display: flex;
  align-items: center;
  justify-content: center;
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

.group-text {
  width: 330px;
  font-family: "Pretendard-Regular", Arial, sans-serif;
  font-weight: 400;
  font-size: 25px;
  line-height: 24px;
  color: #F2F4F5;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}
</style>
