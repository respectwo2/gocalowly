import { createRouter, createWebHistory } from "vue-router";
import MainPage from "@/views/MainPage.vue";
import GroupPage from "@/views/GroupPage.vue";
import FoodRegistPage from "@/views/FoodRegistPage.vue";

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
  ],
});

export default router;
