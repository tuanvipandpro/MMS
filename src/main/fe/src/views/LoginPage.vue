<template>
  <div class="login_view">
    <el-card class="box-card" shadow="hover">
      <template #header>
        <div class="card-header" style="text-align: center;">
          <span style="font-weight: bolder; font-size: larger;">Đăng nhập</span>
          <!-- <el-button class="button" text>Operation button</el-button> -->
        </div>
      </template>
      <div class="flex">
        <el-input v-model="username" size="large" placeholder="Username ..." style="margin-bottom: 10px;"/>
        <el-input v-model="password" size="large" placeholder="Password ..." style="margin-bottom: 10px;" show-password/>
        <el-button :icon="UserFilled" @click="handleClick" color="#626aef" class="button" size="large" plain>Đăng nhập</el-button>
      </div>
    </el-card>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useRouter } from 'vue-router'
import { ElMessage } from 'element-plus'
import { UserFilled } from '@element-plus/icons-vue'

import { useUserStore } from '../stores/user'

const username = ref('')
const password = ref('')
const router = useRouter()

const handleClick = async () => {
  try {
    if (username.value && password.value) {
      await useUserStore().login(username.value, password.value)
      ElMessage.success('Login OK')
      router.push('home')
    }
  } catch (e) {
    ElMessage.error('The user is invalid !!!')
    console.error(e)
  }
}

</script>

<style scoped>
.login_view {
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
}
.box-card {
  width: 25vw;
}
.button {
  width: 100%;
}
</style>
