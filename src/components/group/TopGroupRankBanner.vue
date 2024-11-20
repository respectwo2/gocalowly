<template>
  <div class="group-rank-banner">
    <div class="rank-text">그룹 내 상위 {{ topPercentile }}% 유저입니다</div>

    <div class="toggle-icon" @click="toggleModal">
      <img src="../../assets/icons/toggle.svg" alt="Toggle Modal" width="40" height="40" />
    </div>

    <!-- Modal 컴포넌트 렌더링 -->
    <Modal v-if="isModalOpen" @close="toggleModal" />
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";
import Modal from "./MissonModal.vue";

export default {
  name: "GroupRankBanner",
  components: {
    Modal,
  },
  setup() {
    const isModalOpen = ref(false);
    const percentage = ref(0);
    const topPercentile = ref(0);

    // Modal 열기/닫기
    const toggleModal = () => {
      isModalOpen.value = !isModalOpen.value;
    };

    // 그룹 랭크 정보 가져오기
    const fetchGroupRank = async () => {
      try {
        const response = await axios.get("http://localhost:8080/api/group/rank");
        percentage.value = response.data;
        topPercentile.value = response.data.topPercentile;

      } catch (error) {
        console.error("Error fetching group rank:", error);
      }
    };

    // 컴포넌트가 마운트될 때 데이터 가져오기
    onMounted(() => {
      fetchGroupRank();
    });

    return {
      isModalOpen,
      percentage,
      toggleModal,
      topPercentile,
    };
  },
};
</script>

<style scoped>
.group-rank-banner {
  position: absolute;
  width: 365px;
  height: 64px;
  left: 12px;
  top: 140px;
  background: #f87670;
  border: 1px solid #000000;
  display: flex;
  align-items: center;
  justify-content: space-between;
  padding: 0 16px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  gap: 10px;
}

.rank-text {
  flex-grow: 1;
  font-family: "Inter", sans-serif;
  font-weight: 400;
  font-size: 20px;
  line-height: 24px;
  color: #000000;
  display: flex;
  align-items: center;
  justify-content: center;
  text-align: center;
}

.toggle-icon {
  width: 25px;
  height: 38px;
  filter: drop-shadow(-1.81538px -1.81538px 7.26154px rgba(36, 39, 96, 0.25)) drop-shadow(3.63077px 7.26154px 7.26154px rgba(36, 39, 96, 0.25));
  cursor: pointer;
  display: flex;
  align-items: center;
  justify-content: center;
}
</style>
