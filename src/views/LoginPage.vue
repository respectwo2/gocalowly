<script>
import TopBar from "@/components/common/TopBar.vue";
import axios from "axios";
import { ref } from "vue";

export default {
  name: "LoginPage",
  components: {
    TopBar,
  },

  setup() {
    const loginLog = ref({
      userNickname: "", // HTML과 일치하도록 수정
      userPassword: "",
    });

    const submitForm = async () => {
      try {
        // Proxy 데이터를 순수 객체로 변환
        const payload = { ...loginLog.value };
        console.log("전송 데이터:", payload);

        const response = await axios.post(
          "http://localhost:8080/api/user/login",
          payload
        );

        if (response.status === 200) {
          console.log(response.data);
          alert(`${response.data.userNickname}님 반갑습니다!`);
          resetForm();
          location.href = "/";
        }
      } catch (error) {
        if (error.response && error.response.status === 400) {
          console.error(
            "로그인 실패:",
            error.response.data || "잘못된 요청입니다."
          );
          alert("로그인에 실패했습니다. 아이디와 비밀번호를 확인해주세요.");
        } else {
          console.error("서버와의 통신 중 오류 발생:", error);
          alert("서버와의 통신 중 오류가 발생했습니다.");
        }
      }
    };

    const resetForm = () => {
      loginLog.value = {
        userNickname: "",
        userPassword: "",
      };
    };

    return {
      loginLog,
      resetForm,
      submitForm,
    };
  },
};
</script>

<template>
  <div>
    <TopBar />
  </div>

  <div class="spacer">
    <img src="@/assets/icons/logo_3-2.png" width="250">
  </div>

  <div class="content">
    <form class="form" @submit.prevent="submitForm">
      <div class="formbox">
        <input type="text" v-model="loginLog.userNickname" placeholder="닉네임을 입력해주세요" />
      </div>
      <div class="formbox">
        <input type="password" v-model="loginLog.userPassword" placeholder="비밀번호를 입력해주세요" />
      </div>
      <div class="loginbtn">
        <button type="submit">로그인</button>
      </div>
    </form>

    <div class="line">또는</div>
    <!-- 회원가입 링크 -->
    <div class="rgst">
      <span>아직 회원이 아니신가요?</span>
      <a href="/signup">회원가입</a>
    </div>
  </div>
</template>

<style scoped>
body {
  min-height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: #f5f5f5;
}


.spacer {
  height: 200px;
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
}

.content {
  display: flex;
  flex-direction: column;
  align-items: center;
  justify-content: center;
  height: 100%;
  width: 100%;
}

.form {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  gap: 16px;
  width: 100%;
  max-width: 320px;
}

.formbox {

  width: 100%;
  height: 55px;
  background: #ffffff;
  border-radius: 50px;
  box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
  display: flex;
  align-items: center;
  padding: 0 16px;
}

.formbox:hover {
  border: 1px solid #f4c4c1;
}

.formbox input {
  font-family: "Pretendard-Regular";
  border: none;
  background: #ffffff;
  flex-grow: 1;
  height: 100%;
  font-size: 16px;
  color: #5b5b5b;
  font-weight: 500;
  padding-left: 8px;
}

.formbox input:focus {
  outline: none;
}

.loginbtn {
  max-width: 320px;
  width: 100%;
  margin-top: 32px;
  text-align: center;
}

.loginbtn button {
  font-family: "Pretendard-Regular";
  width: 100%;
  height: 55px;
  border: none;
  border-radius: 50px;
  box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
  font-size: 24px;
  color: #ffffff;
  font-weight: 600;
  background: #f87670;
}

.loginbtn button:hover {
  background: #d55852;
}

.rgst {
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.rgst a {
  color: #f87670;
  font-size: 18px;
  font-weight: 600;
  text-decoration-line: none;
}

.line {
  width: 100%;
  margin-top: 64px;
  margin-bottom: 40px;
  padding: 0;
  text-align: center;
  font-size: 16px;
  color: #5b5b5b;
  font-weight: 500;
}

.line::before {
  display: inline-block;
  margin: 0 20px 3px 0;
  height: 1px;
  content: " ";
  text-shadow: none;
  background-color: #b5b5b5;
  width: 30%;
}

.line::after {
  display: inline-block;
  margin: 0 0 3px 20px;
  height: 1px;
  content: " ";
  text-shadow: none;
  background-color: #b5b5b5;
  width: 30%;
}
</style>
