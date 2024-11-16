import { createRouter, createWebHistory } from "vue-router";
import MainPage from "@/views/MainPage.vue";
import GroupPage from "@/views/GroupPage.vue";

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
  ],
});

export default router;
