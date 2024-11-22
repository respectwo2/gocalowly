<template>
  <div class="modal-overlay" @click="closeModal">
    <div class="modal-content" @click.stop>
      <h2>금일 그룹 미션 현황</h2>
      <ul class="mission-list">
        <li v-for="(mission, index) in missions" :key="mission.missionNo"
          :class="{ complete: mission.missionComplete }">
          <label class="mission-label">
            <input type="checkbox" :checked="mission.missionComplete" @change="toggleMissionCompletion(index)" />
            {{ mission.missionName }}
          </label>
        </li>
      </ul>
      <button @click="closeModalAndUpdate">닫기</button>
    </div>
  </div>
</template>

<script>
import { ref, onMounted } from "vue";
import axios from "axios";

export default {
  name: "MissionModal",
  emits: ["close"],
  setup(_, { emit }) {
    const missions = ref([]);

    // API 호출: 미션 목록 가져오기
    const fetchMissions = async () => {
      try {
        const response = await axios.get(
          "http://localhost:8080/api/group/missions/"
        );
        missions.value = response.data.missions;
      } catch (error) {
        console.error("Error fetching missions:", error);
      }
    };

    // 체크박스 클릭 시 UI만 업데이트
    const toggleMissionCompletion = (index) => {
      missions.value[index].missionComplete =
        !missions.value[index].missionComplete;
    };

    // 닫기 버튼 클릭 시 서버로 업데이트
    const closeModalAndUpdate = async () => {
      const payload = {
        missionCompletes: missions.value.map((mission) => ({
          isMissionComplete: mission.missionComplete,
          missionNo: mission.missionNo,
        })),
      };

      try {
        const response = await axios.post(
          "http://localhost:8080/api/group/missions/update",
          payload
        );

        if (response.data == "") {
          alert("미션 상태가 업데이트되었습니다.");
        } else {
          alert("업데이트 실패: 서버에서 거부되었습니다.");
        }
      } catch (error) {
        console.error("Error updating missions:", error);
        alert("업데이트에 실패했습니다. 다시 시도해주세요.");
      } finally {
        emit("close"); // 모달 닫기
      }
    };

    const closeModal = () => {
      emit("close");
    };

    const scrollToBottom = () => {
      if (messagesContainer.value) {
        messagesContainer.value.scrollTop = messagesContainer.value.scrollHeight;
      }
    };

    onMounted(() => {
      fetchChatMessages();
      scrollToBottom(); // 컴포넌트가 렌더링되면 스크롤 이동
    });


    return {
      missions,
      toggleMissionCompletion,
      closeModalAndUpdate,
      closeModal,
    };
  },
};
</script>

<style scoped>
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
  z-index: 1000;
}

.modal-content {
  background: #ffffff;
  padding: 20px;
  border-radius: 8px;
  width: 300px;
  text-align: center;
  z-index: 1001;
}

.mission-list {
  list-style-type: none;
  padding: 0;
  margin: 0 0 16px;
}

.mission-list li {
  font-family: "DM Sans", sans-serif;
  font-size: 16px;
  padding: 10px;
  margin-bottom: 8px;
  border: 1px solid #ddd;
  border-radius: 4px;
  background-color: #f9f9f9;
  color: #333;
  display: flex;
  align-items: center;
  justify-content: space-between;
}

.mission-list li.complete {
  background-color: #dff0d8;
  color: #3c763d;
  border: 1px solid #d6e9c6;
}

.mission-list li:not(.complete) {
  background-color: #f2dede;
  color: #a94442;
  border: 1px solid #ebccd1;
}

.mission-label {
  display: flex;
  align-items: center;
  gap: 8px;
}

button {
  padding: 8px 16px;
  background-color: #f87670;
  color: #fff;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

button:hover {
  background-color: #e76660;
}
</style>
