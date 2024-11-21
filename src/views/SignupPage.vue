<script>
import TopBar from "@/components/common/TopBar.vue";
import { ref } from "vue";

export default {
    name: "SignupPage",
    components: {
        TopBar,
    },
    setup() {
        const showIframe = ref(false);
        const formData = ref({
            nickname: "",
            password: "",
            name: "",
            phone: "",
            calorieGoal: "",
        });

        const openCalorieGuide = () => {
            showIframe.value = true;
        };

        const closeIframe = () => {
            showIframe.value = false;
        };

        return {
            showIframe,
            formData,
            openCalorieGuide,
            closeIframe,
        };
    },
};
</script>

<template>
    <div>
        <TopBar />
    </div>
    <div class="signup-page">
        <!-- 회원가입 페이지 -->
        <div v-if="!showIframe" class="content">
            <div class="signupTitle">
                <span class="signup">회원가입</span>
            </div>

            <!-- 회원가입 폼 -->
            <div class="signupForm">
                <!-- 닉네임 -->
                <div>
                    <p>닉네임</p>
                    <input type="text" v-model="formData.nickname" placeholder="로그인에 이용될 닉네임이에요." />
                </div>
                <!-- 비밀번호 -->
                <div>
                    <p>비밀번호</p>
                    <input type="password" v-model="formData.password" placeholder="비밀번호를 입력해주세요." />
                </div>
                <!-- 이름 -->
                <div>
                    <p>이름</p>
                    <input type="text" v-model="formData.name" placeholder="이름을 입력해주세요." />
                </div>
                <!-- 전화번호 -->
                <div>
                    <p>전화번호</p>
                    <input type="text" v-model="formData.phone" placeholder="예시) 01000000000" />
                </div>
                <!-- 목표칼로리 -->
                <div>
                    <p>목표칼로리</p>
                    <input type="number" v-model="formData.calorieGoal" placeholder="칼로리를 입력해주세요." />
                </div>

                <!-- 가이드 버튼 -->
                <button class="calorie-guide" @click="openCalorieGuide">
                    칼로리 가이드 확인하기
                </button>
            </div>

            <!-- 회원가입 버튼 -->
            <button class="signupBtn">회원가입</button>
        </div>

        <!-- iframe 가이드 화면 -->
        <div v-if="showIframe" class="iframe-container">
            <button class="back-btn" @click="closeIframe">뒤로가기</button>
            <iframe src="https://www.diabetes.or.kr/general/dietary/dietary_02.php?con=2" frameborder="0"
                class="iframe-content">
            </iframe>
        </div>
    </div>
</template>

<style scoped>
@charset "UTF-8";

@font-face {
    font-family: 'Pretendard-Regular';
    src: url('https://cdn.jsdelivr.net/gh/Project-Noonnu/noonfonts_2107@1.1/Pretendard-Regular.woff') format('woff');
    font-weight: 400;
    font-style: normal;
}

body {
    font-family: 'Pretendard-Regular';
    background: #f5f5f5;
    margin: 0;
    padding: 0;
}

.signup-page {
    width: 100%;
    height: 80vh;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

.content {
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 20px;
    width: 100%;
    max-width: 400px;
    padding: 0;
    margin: 0;
    /* 간격 제거 */
}

.signupTitle {
    display: flex;
    flex-direction: row;
    margin-bottom: 0px;
    height: auto;
    align-items: center;
    justify-content: center;
}

.signup {
    font-size: 1.8rem;
    color: #5b5b5b;
}

.signupForm {
    width: 100%;
    background: #ffffff;
    box-shadow: 0px 12px 40px rgba(112, 144, 176, 0.2);
    border-radius: 10px;
    padding: 20px 30px;
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 16px;
}

.signupForm p {
    margin-bottom: 4px;
    color: #F87670;
    font-size: 1rem;
}

.signupForm input {
    font-family: 'Pretendard-Regular';
    width: 100%;
    height: 3rem;
    font-size: 1.2rem;
    border-color: #F4C4C1;
    border-style: solid;
    border-radius: 5px;
    padding-left: 10px;
    color: #5b5b5b;
}

.signupForm input:focus {
    outline: none;
    background: #FFEDEC;
}

.calorie-guide {
    font-family: 'Pretendard-Regular';
    font-size: 1.2rem;
    color: #ffffff;
    font-weight: 500;
    background: #F87670;
    padding: 10px 20px;
    border-radius: 5px;
    text-decoration: none;
    text-align: center;
    box-shadow: 1px 1px 3px rgba(0, 0, 0, 0.1);
    cursor: pointer;
    border: none;
    /* 기본 테두리 제거 */

}

.calorie-guide:hover {
    background: #F87670;
}

.signupBtn {
    font-family: 'Pretendard-Regular';
    width: 100%;
    max-width: 350px;
    font-size: 1.4rem;
    color: #ffffff;
    font-weight: 500;
    height: 3.5rem;
    border: none;
    background: #F87670;
    box-shadow: 1px 1px 2px rgba(0, 0, 0, 0.1);
    border-radius: 8px;
    cursor: pointer;
}

.signupBtn:hover {
    background: #F87670;
}

.iframe-container {
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    height: 100%;
    background: #ffffff;
    z-index: 10;
    display: flex;
    flex-direction: column;
}

.iframe-content {
    flex: 1;
    border: none;
    width: 100%;
    height: 100%;
}

.back-btn {
    font-family: 'Pretendard-Regular';
    background: #f87670;
    color: #ffffff;
    padding: 10px 20px;
    border: none;
    border-radius: 5px;
    margin: 10px;
    cursor: pointer;
}

.back-btn:hover {
    background: #d55852;
}
</style>
