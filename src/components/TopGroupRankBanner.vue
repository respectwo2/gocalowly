<template>
    <div class="group-rank-banner">
        <div class="rank-text">그룹 내 상위 10% 유저입니다</div>

        <div class="toggle-icon" @click="toggleModal">
            <img src="../assets/icons/toggle-icon.svg" alt="Toggle Modal" />
        </div>

        <div v-if="isModalOpen" class="modal-overlay" @click="toggleModal">
            <div class="modal-content" @click.stop>
                <h2>상세 정보</h2>
                <p>여기에 모달 내용이 들어갑니다.</p>
                <button @click="toggleModal">닫기</button>
            </div>
        </div>
    </div>
</template>

<script>
export default {
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
    position: relative;
    width: 393px;
    height: 64px;
    background: #9efac1;
    border-radius: 10px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    padding: 0 16px;
}

/* Rank Text */
.rank-text {
    width: 330px;
    font-family: 'Inter', sans-serif;
    font-weight: 400;
    font-size: 20px;
    line-height: 24px;
    text-align: center;
    color: #000000;
    display: flex;
    align-items: center;
    justify-content: center;
}

/* Toggle Icon */
.toggle-icon {
    width: 44px;
    height: 46px;
    filter: drop-shadow(-1.8px -1.8px 7.3px rgba(36, 39, 96, 0.25)) drop-shadow(3.6px 7.3px 7.3px rgba(36, 39, 96, 0.25));
    cursor: pointer;
}

/* Modal Overlay */
.modal-overlay {
    position: fixed;
    top: 0;
    left: 0;
    width: 100vw;
    height: 100vh;
    background: rgba(0, 0, 0, 0.5);
    display: flex;
    align-items: center;
    justify-content: center;
}

/* Modal Content */
.modal-content {
    background: #ffffff;
    padding: 20px;
    border-radius: 8px;
    width: 300px;
    text-align: center;
}

.modal-content h2 {
    margin: 0 0 1rem;
}

.modal-content p {
    margin-bottom: 1rem;
}
</style>