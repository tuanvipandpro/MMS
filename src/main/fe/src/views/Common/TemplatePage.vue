<template>
  <div>
    <el-container>
      <el-aside style="width: 18vw">
        <Menu default-active="2"></Menu>
      </el-aside>
      <el-container>
        <el-main>
          <h1>Document</h1>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script setup>
import Menu from '../components/CommonMenu.vue'
import { onBeforeUnmount } from 'vue'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
const router = useRouter()

onBeforeUnmount(() => {
  if (!sessionStorage.getItem('user')) {
    ElMessage.error('Access Denied !!!')
    router.push('/')
  }
})
</script>
