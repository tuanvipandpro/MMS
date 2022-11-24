<template>
  <div>
    <el-container>
      <el-aside style="width: 18vw">
        <Menu default-active="3-1"></Menu>
      </el-aside>
      <el-container>
        <el-main>
          <div style="margin-bottom: 8px;">
            <h1>Hồ sơ của tôi</h1>
            <el-button  type="success" plain :icon="Plus">Thêm mới</el-button>
          </div>
          <div>
            <div>
              <el-card class="box-card" shadow="hover">
                <template #header>
                  <div class="card-header">
                    <span><strong>Hồ sơ NVQS năm 2022 - Phường An Phú</strong></span>
                  </div>
                </template>
                <div>AAA</div>
              </el-card>
            </div>
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script setup>
import Menu from '../components/CommonMenu.vue'
import { Plus } from '@element-plus/icons-vue'
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
