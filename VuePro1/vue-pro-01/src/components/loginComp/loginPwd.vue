<template>
  <n-form>
    <n-form-item class="username-item">
      <n-input
        placeholder="请输入学号/工号"
        size="large"
        autosize
        style="min-width: 100%; min-height: 50px; text-align: left;"
        v-model:value="username"
      >
        <template #prefix>
          <n-icon size="25">
            <UserRegular />
          </n-icon>
        </template>
      </n-input>
    </n-form-item>
    <n-form-item class="password-item">
      <n-input
        placeholder="请输入密码"
        size="large"
        autosize
        style="min-width: 100%; min-height: 50px; text-align: left;"
        type="password"
        v-model:value="password"
      >
        <template #prefix>
          <n-icon size="25">
            <Lock />
          </n-icon>
        </template>
      </n-input>
    </n-form-item>
  </n-form>
<!--  7天免登录-->
  <div style="display: flex">
    <n-checkbox size="large" v-model:checked="value">7天免登录</n-checkbox>
  </div>
  <n-button
      type="primary"
      size="large"
      style="width: 100%; height: 50px; margin-top: 20px;"
      color="#2368de"
      @click="submit"
  >登录</n-button>

</template>

<style lang="less" scoped>

.username-item {
  margin-bottom: -30px;
  margin-top: -25px;
}

</style>

<script setup>
import {UserRegular, Lock} from "@vicons/fa";
import {ref} from "vue";
import axios from "axios";

const value = ref(false);
const username = ref("");
const password = ref("");

const submit = () => {
  console.log("submit");
  console.log(username.value);
  console.log(password.value)
  axios.post("http://localhost:8082/user/login", {
    params: {
        username: username.value,
        password: password.value,
    }
  })
    .then((res) => {
      console.log("res");
      console.log(res);
      if(res.data !== "" || res.data != null){
        alert("登录成功");
      }else{
        console.log(res.data);
        alert("登录失败");
      }
    })
    .catch((err) => {
      console.log("err");
      console.log(err);
      alert("登录失败");
    })
}
</script>