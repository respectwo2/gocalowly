<script setup>
import { RouterLink, RouterView } from 'vue-router'
</script>

<template>
    <nav class="navbar">
        <div class="nav-item">
            <RouterLink to="/">개인</RouterLink>
        </div>
        <div class="nav-item">
            <!-- <RouterLink to="/meal-registration">식사등록</RouterLink> -->
            <a>식사 등록</a>
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
    /* Rectangle 8 */

    position: absolute;
    width: 356px;
    height: 98px;
    left: 17px;
    top: 730px;

    background: #F87670;
    border-radius: 50px;


    /* 개인 식사등록 그룹 */
    /* Rectangle 8 */

    position: absolute;
    width: 356px;
    height: 98px;
    left: 17px;
    top: 730px;

    background: #F87670;
    border-radius: 50px;

}

.nav-item {
    text-align: center;
}

/* 링크 스타일 (필요에 따라 추가 가능) */
.nav-item a {
    color: #020000;
    text-decoration: none;
}

.nav-item a.router-link-active {
    font-weight: bold;
}
</style>
