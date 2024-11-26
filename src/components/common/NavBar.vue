<script setup>
import { RouterLink, RouterView } from "vue-router";
</script>

<template>
  <nav class="navbar">
    <div class="nav-item">
      <RouterLink to="/">개인</RouterLink>
    </div>
    <div class="nav-item">
      <!-- <RouterLink to="/meal-registration">식사등록</RouterLink> -->
      <RouterLink to="foodregist">식사 등록</RouterLink>
    </div>
    <div class="nav-item">
      <RouterLink to="/group">그룹</RouterLink>
    </div>
  </nav>
  <RouterView />
</template>

<script>
export default {
  name: "NavBar",
};
</script>

<style scoped>
.navbar {
  position: absolute;
  width: 356px;
  height: 98px;
  left: 17px;
  top: 730px;

  background: #f87670;
  border-radius: 50px;

  width: 370px;
  height: 65px;
  left: 10px;
  top: 750px;

  font-family: "Pretendard-Regular", Arial, sans-serif;
  font-style: normal;
  font-weight: 400;
  font-size: 24px;
  line-height: 29px;
  display: flex;
  align-items: center;
  text-align: center;

  color: #f2f4f5;

  text-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
}

.nav-item {
  display: inline-block;
  margin: 0 auto;
  text-align: center;
}

.nav-item a {
  color: #f2f4f5;
  text-decoration: none;
}

.nav-item a.router-link-active {
  font-weight: bold;
}
</style>
