<template>
  <n-form>
    <n-form-item class="username-item">
      <n-input
        placeholder="请输入学号/工号"
        size="large"
        autosize
        style="min-width: 100%; min-height: 50px; text-align: left;"
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
  <n-checkbox-group style="display: flex">
    <n-checkbox size="large">7天免登录</n-checkbox>
  </n-checkbox-group>

</template>

<style lang="less" scoped>

.username-item {
  margin-bottom: -30px;
  margin-top: -25px;
}

</style>

<script setup>
import {UserRegular, Lock} from "@vicons/fa";

</script>