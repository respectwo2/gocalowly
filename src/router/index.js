import { createRouter, createWebHistory } from "vue-router";
import MainPage from "@/views/MainPage.vue";
import GroupPage from "@/views/GroupPage.vue";
import FoodRegistPage from "@/views/FoodRegistPage.vue";
import SignupPage from "@/views/SignupPage.vue";
import LoginPage from "@/views/LoginPage.vue";

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: "/",
      name: "MainPage",
      component: MainPage,
    },
    {
      path: "/group",
      name: "GroupPage",
      component: GroupPage,
    },
    {
      path: "/foodregist",
      name: "FoodRegistPage",
      component: FoodRegistPage,
    },
    {
      path: "/login",
      name: "LoginPage",
      component: LoginPage,
    },
    {
      path: "/signup",
      name: "SignupPage",
      component: SignupPage,
    },
  ],
});

export default router;
