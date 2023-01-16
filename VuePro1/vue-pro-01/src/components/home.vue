<template>

  <div class="wrapper">
    <div class="content">
      <div class="left">
        <div class="leftLogo">
          <n-image class="logo" src="src/assets/imgs/logo.png" alt="logo" style="z-index: 2;position: absolute"/>
          <span class="title" style="position: absolute">统一身份认证</span>
        </div>
      </div>
      <div class="right">
        <n-dropdown trigger="click" :options="options" @select="handleSelect" style="z-index: 2; position: absolute;">
          <n-button type="primary" style="margin-top: 40px; margin-left: 300px;">{{ selectedRow }}</n-button>
        </n-dropdown>
        <div class="loginPanel">
          <div class="avatar mt20">
            <div class="angle_mark">
              <img
                  v-if="angle"
                  alt="angle"
                  src="src/assets/imgs/ewm.png"
                  @click="changeAngle"
                  style="cursor: pointer"
              />
              <img
                  v-else
                  alt="angle"
                  src="src/assets/imgs/pass.png"
                  @click="changeAngle"
                  style="cursor: pointer"
              />
            </div>
              <n-card size="huge" footer-style="background-color: rgba(12,74,249,0.05);">
                <n-tabs
                    v-model:value="activeTab"
                    justify-content="space-evenly"
                    type="line"
                    size="large"
                    :bar-width="100"
                    v-if="angle"
                >
                  <n-tab-pane label="账号登录" name="1">
                    <LoginPwd></LoginPwd>
                  </n-tab-pane>
                  <n-tab-pane label="动态码登录" name="2">
                    <LoginQR></LoginQR>
                  </n-tab-pane>
                </n-tabs>
                <n-button
                    type="primary"
                    size="large"
                    style="width: 100%; height: 50px; margin-top: 20px;"
                    color="#2368de"
                    v-if="angle"
                >登录</n-button>
                <!--忘记密码       账号激活-->
                <!--账号申诉       账号申请-->
                <div class="bottomLinks" v-if="angle">
                  <div class="forget" style="display: flex; justify-content: space-between">
                    <a class="greyLinks">忘记密码</a>
                    <a style="margin-left: 10px;">账号激活</a>
                  </div>
                  <div class="apply" style="display: flex; justify-content: space-between">
                    <a class="greyLinks">账号申诉</a>
                    <a style="margin-left: 10px;">账号申请</a>
                  </div>
                </div>
                <div class="QRCode" v-else>
                  <img
                      alt="QRCode"
                      src="src/assets/imgs/getCode.png"
                      style="width: 80%; height: 80%;"
                      class="QRCodeImg"
                  />
                  <div class="QRCodeHint">手机扫码 安全登录</div>
                </div>
                <template #footer class="footer" v-if="angle">
                  <div class="footer">
                    <span class="footerText">其他登录方式</span>
                    <span><img src="src/assets/imgs/qq.png" alt="qq" class="otherLogin"/></span>
                    <span><img src="src/assets/imgs/weixin.png" alt="wechat" class="otherLogin"/></span>
                  </div>
                </template>
              </n-card>
          </div>
          <p class="banquan">版权所有 © 2020 中南大学信息与网络中心. 保留所有权利技术支持：0731-88830426  邮箱地址：app@csu.edu.cn</p>
        </div>
      </div>
    </div>
  </div>
</template>

<script setup>
import LoginPwd from "~/components/loginComp/loginPwd.vue";
import LoginQR from "~/components/loginComp/loginQR.vue";
import {ref} from "vue";
const selectedRow = ref("简体中文");

const activeTab = ref('1');
const angle = ref(true);
const options = ref([
  {
    label: '简体中文',
    key: '简体中文'
  },
  {
    label: 'English',
    key: 'English'
  }
]);

const handleSelect = (key) => {
  console.log(key);
  selectedRow.value = key;
};

const changeAngle = () => {
  angle.value = !angle.value;
}



</script>

<style scoped>

.content {
  width: 1500px;
  display: flex;
  flex-direction: row;
  justify-content: space-between;
  align-items: center;

}

.wrapper {
  display: flex;
  justify-content: center;
  align-items: center;

  width: 100%;
  height: 100%;
}

.wrapper::before {
  width: 100%;
  height: 100%;
  background: url('src/assets/imgs/bg.png') no-repeat;
  background-size: cover;

  content: '';
  position: absolute;
  left: 0;
  right: 0;
  top: 0;
  bottom: 0;
}

.title {
  font-size: 25px;
  font-weight: normal;

  color: #ffffff;

  margin-left: 290px;
  padding-left: 10px;
  margin-top: 15px;

  border-left: 1px solid #ffffff;
}

.left {
  width: 600px;
  height: 600px;
  display: flex;
  justify-content: left;
  align-items: start;
  flex-direction: column;
}

.logo {
  margin-left: 26px;
}

.right {
  margin-top: -32px;
  margin-right: -10%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.4);
  z-index: 2;
}

.loginPanel {
  width: 400px;
  height: 100%;
  padding: 38px 115px;
}

.avatar {
  width: 400px;
  /*max-height: 600px;*/
  overflow: hidden;
  position: relative;
}
.angle_mark {
  position: absolute;
  top: 0;
  right: -19px;
  background-color: transparent;
  width: 100px;
  height: 100px;
  z-index: 2;
}

a {
  cursor: pointer;
  text-decoration: none;
}

.greyLinks {
  color: #999;
}

.footer {
  height: 15px;

  float: left;

  display: flex;
  justify-content: space-evenly;
  align-items: center;
  margin-top: 25px;
  margin-bottom: -10px;
}

.otherLogin {
  width: 30px;
  height: 30px;

  margin-left: 20px;
}

.footerText {
  color: Blue;
  font-size: medium;
}

.QRCode {
  width: 100%;
  height: 100%;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}

.QRCodeImg {
  padding: 50px;
}

.QRCodeHint {
  margin-top: -40px;
  margin-bottom: 40px;
}

.banquan {
  margin-top: 30px;
  margin-left: 20px;
  color: #ffffff;

  text-align: left;

  font-size: small;
}

</style>