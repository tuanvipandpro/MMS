<template>
  <div>
    <el-container>
      <el-aside style="width: 18vw">
        <Menu default-active="3-1"></Menu>
      </el-aside>
      <el-container>
        <el-main>
          <div style="margin-bottom: 8px;">
            <el-breadcrumb :separator-icon="ArrowRight">
              <el-breadcrumb-item :to="{ path: '/folder' }"><strong>Hồ sơ</strong></el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/list' }" ><strong>Danh sách</strong></el-breadcrumb-item>
              <el-breadcrumb-item :to="{ path: '/details' }" ><strong>Chi tiết</strong></el-breadcrumb-item>
            </el-breadcrumb>
            <h2>Hồ sơ của tôi</h2>
            <el-button  type="success" plain :icon="Plus">Thêm mới</el-button>
          </div>
          <div>
            Details
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script setup>
import Menu from '../components/CommonMenu.vue'
import { Plus, ArrowRight } from '@element-plus/icons-vue'
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
