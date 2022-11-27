<template>
  <div>
    <el-container>
      <el-aside style="width: 18vw">
        <Menu default-active="3-1"></Menu>
      </el-aside>
      <el-container>
        <el-main>
          <div style="margin-bottom: 8px;">
            <h2>Quản lý hồ sơ</h2>
            <el-button  type="success" plain :icon="Plus">Thêm mới</el-button>
          </div>
          <div>
            <div>
              <el-card class="box-card" shadow="hover" style="height: 70vh">
                <template #header>
                  <div class="card-header">
                    <span><strong>Hồ sơ hiện có</strong></span>
                    <el-input
                      v-model="search"
                      style="width: 18vw; margin-right: 3px;"
                      placeholder="Nhập tên"
                      clearable
                    >
                      <template #prefix>
                        <el-icon class="el-input__icon" @click="searchByFullname"><Search /></el-icon>
                      </template>
                    </el-input>
                  </div>
                </template>
                <el-scrollbar>
                  <div v-for="i in 5 " :key="i" style="margin-bottom: 3vh; ">
                    <el-link style="font-size: medium;">
                      NVQS {{2022 + i - 1}} - Phường An Phú
                    </el-link>
                  </div>
                </el-scrollbar>
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
import { Plus, Search } from '@element-plus/icons-vue'
import { onBeforeUnmount, ref } from 'vue'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
const router = useRouter()

const search = ref('')

// const folders = ref([1, 2, 3, 4, 5])

onBeforeUnmount(() => {
  if (!sessionStorage.getItem('user')) {
    ElMessage.error('Access Denied !!!')
    router.push('/')
  }
})
</script>
<style scoped>
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}
</style>
