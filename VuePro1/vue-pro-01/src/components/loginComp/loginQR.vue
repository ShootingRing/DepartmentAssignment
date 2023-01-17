<template>
  <n-form style="max-height: 185px">
    <n-form-item class="username-item">
      <n-input
          placeholder="请输入手机号/学号"
          size="large"
          autosize
          style="min-width: 100%; min-height: 35px; text-align: left;"
      >
        <template #prefix>
          <n-icon size="25">
            <UserRegular />
          </n-icon>
        </template>
      </n-input>
    </n-form-item>
    <n-form-item class="code-item">
      <n-input
          placeholder="请输入验证码"
          size="large"
          autosize
          style="min-width: 100%; min-height: 35px; text-align: left;"
          type="password"
      >
        <template #prefix>
          <n-icon size="25">
            <SafetyCertificateFilled/>
          </n-icon>
        </template>
        <template #suffix>
          <SIdentify :identify-code="identifyCode" @click="freshCode" style="cursor: pointer;"></SIdentify>
        </template>
      </n-input>
    </n-form-item>
    <n-form-item class="password-item">
      <n-input
          placeholder="请输入短信动态码"
          size="large"
          autosize
          style="min-width: 100%; min-height: 35px; text-align: left;"
          type="password"
      >
        <template #prefix>
          <n-icon size="25">
            <Lock />
          </n-icon>
        </template>
        <template #suffix style="cursor: pointer;">
          <a>获取动态码</a>
        </template>
      </n-input>
    </n-form-item>
  </n-form>

</template>

<style lang="less" scoped>

.username-item {
  margin-bottom: -30px;
  margin-top: -16px;
}

.password-item {
  margin-top: -30px;
}

</style>

<script setup>
import {UserRegular, Lock} from "@vicons/fa";
import SIdentify from "~/components/SIdentify.vue";
import {SafetyCertificateFilled} from '@vicons/antd'
import {onMounted, ref} from "vue";

const identifyCode = ref('1234')
const identifyCodes = ref('123456789ABCDEFGHJKLMNPQRSTUVWXYZ')

//Lifecycle
onMounted(() => {
  identifyCode.value = ''
  for (let i = 0; i < 4; i++) {
    identifyCode.value += identifyCodes.value.charAt(Math.floor(Math.random() * identifyCodes.value.length))
  }
})

//methods
const freshCode = () => {
  identifyCode.value = ''
  for (let i = 0; i < 4; i++) {
    identifyCode.value += identifyCodes.value.charAt(Math.floor(Math.random() * identifyCodes.value.length))
  }
}

</script>