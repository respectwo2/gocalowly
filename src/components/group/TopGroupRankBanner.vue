<template>
  <div class="group-rank-banner">
    <div class="rank-text">그룹 내 상위 10% 유저입니다</div>

    <div class="toggle-icon" @click="toggleModal">
      <img src="../../assets/icons/toggle.svg" alt="Toggle Modal" width="40" height="40" />
    </div>

    <!-- Modal 컴포넌트 렌더링 -->
    <Modal v-if="isModalOpen" title="상세 정보" content="여기에 모달 내용이 들어갑니다." @close="toggleModal" />
  </div>
</template>

<script>
import Modal from "./MissonModal.vue";

export default {
  components: {
    Modal,
  },
  data() {
    return {
      isModalOpen: false,
    };
  },
  methods: {
    toggleModal() {
      this.isModalOpen = !this.isModalOpen;
    },
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
  /* 아이템 간 간격 유지 */
  padding: 0 16px;
  box-shadow: 0px 4px 4px rgba(0, 0, 0, 0.25);
  gap: 10px;
  /* 아이템 간 간격 조정 */
}

.rank-text {
  flex-grow: 1;
  /* 텍스트가 남은 공간을 채움 */
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
