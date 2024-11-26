<template>
  <div class="topbar">
    <div class="time">9:40</div>
    <div class="vector-icon icon1">
      <img src="@/assets/icons/Vector.svg" alt="Icon 1" />
    </div>
    <div class="vector-icon icon2">
      <img src="@/assets/icons/Vector-1.svg" alt="Icon 2" />
    </div>
    <div class="vector-icon icon3">
      <img src="@/assets/icons/Vector-2.svg" alt="Icon 3" />
    </div>
  </div>
</template>

<script>
export default {
  name: "TopBar",
};
</script>

<style scoped>
.topbar {
  position: relative;
  width: 100%;
  height: 55.48px;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 16px;
}

.time {
  position: absolute;
  left: 8.53%;
  right: 78.13%;
  top: 1.35%;
  bottom: 96.8%;
  font-family: "Inter";
  font-style: normal;
  font-weight: 700;
  font-size: 18px;
  line-height: 22px;
  color: #000000;
}

.vector-icon {
  position: absolute;
}

.icon1 {
  left: 80%;
  right: 13.6%;
  top: 2%;
  bottom: 96.31%;
  width: 24px;
  height: 24px;
}

.icon2 {
  left: 90%;
  right: 6.67%;
  top: 2%;
  bottom: 96.43%;
  width: 24px;
  height: 24px;
}

.icon3 {
  left: 72%;
  right: 20.53%;
  top: 2%;
  bottom: 96.31%;
  width: 24px;
  height: 24px;
}
</style>
