<script>
import TopBar from "@/components/common/TopBar.vue";
import NavBar from "@/components/common/NavBar.vue";
import FoodLogCard from "@/components/main/FoodLogCard.vue";
import TopBanner from "@/components/main/TopBanner.vue";
import TopDateBanner from "@/components/main/TopDateBanner.vue";

export default {
  name: "MainPage",
  components: {
    TopBar,
    NavBar,
    FoodLogCard,
    TopBanner,
    TopDateBanner,
  },
};
</script>

<template>
  <header>
    <TopBar />
    <TopBanner />
    <TopDateBanner />
  </header>

  <main>
    <FoodLogCard />
  </main>

  <footer>
    <NavBar />
  </footer>
</template>

<style scoped>
header,
main,
footer {
  line-height: 1.5;
}

header div,
main div,
footer div {
  margin-bottom: 3rem;
}
</style>
