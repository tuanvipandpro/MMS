<template>
  <div>
    <el-container>
      <el-aside style="width: 18vw">
        <Menu default-active="1-3"></Menu>
      </el-aside>
      <el-container>
        <el-main>
          <h1>Dân quân tự vệ</h1>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script setup>
import Menu from '../components/CommonMenu.vue'
import { onBeforeMount } from 'vue'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
const router = useRouter()

onBeforeMount(() => {
  if (!sessionStorage.getItem('user')) {
    ElMessage.error('Access Denied !!!')
    router.push('/')
  }
})
</script>
