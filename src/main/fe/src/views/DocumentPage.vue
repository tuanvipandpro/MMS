<template>
  <div>
    <el-container>
      <el-aside style="width: 18vw">
        <Menu default-active="2"></Menu>
      </el-aside>
      <el-container>
        <el-main>
          <div style="margin-bottom: 1vh;">
            <h1>Quản lý văn bản</h1>
            <el-button type="success" plain :icon="Plus" @click="openDialog = true">Thêm mới</el-button>
          </div>
          <div>
            <el-tabs type="border-card" class="demo-tabs" style="height: 75vh;">
              <el-tab-pane label="Công Văn Đi">
                <template #label>
                  <span class="custom-tabs-label">
                    <el-icon><postcard /></el-icon>
                    <span>Công Văn Đi</span>
                  </span>
                </template>
                <el-date-picker
                  v-model="yearTabSend"
                  type="year"
                  placeholder="Pick a year"
                  style="margin-bottom: 1vh;"
                />
                <el-table :data="[]" border style="width: 100%">
                  <el-table-column prop="code" label="Số CV" />
                  <el-table-column prop="date" label="Ngày" />
                  <el-table-column prop="title" label="Trích yếu" />
                  <el-table-column prop="pages" label="Số tờ" />
                  <el-table-column prop="copies" label="Số bản" />
                  <el-table-column prop="secret" label="Mật" />
                  <el-table-column prop="recipients" label="Nơi nhận" />
                  <el-table-column prop="notes" label="Ghi chú" />
                </el-table>
              </el-tab-pane>
              <el-tab-pane label="Công Văn Đến">
                <template #label>
                  <span class="custom-tabs-label">
                    <el-icon><memo /></el-icon>
                    <span>Công Văn Đến</span>
                  </span>
                </template>
                <el-date-picker
                  v-model="yearTabSend"
                  type="year"
                  placeholder="Pick a year"
                  style="margin-bottom: 1vh;"
                />
                <el-table :data="[]" border style="width: 100%">
                  <el-table-column prop="code" label="Số đến" width="50"/>
                  <el-table-column prop="date" label="Số VB đến" />
                  <el-table-column prop="title" label="Ngày CV" />
                  <el-table-column prop="pages" label="CQ Ban Hành" />
                  <el-table-column prop="copies" label="Trích yếu" />
                  <el-table-column prop="secret" label="Số bản" />
                  <el-table-column prop="recipients" label="Số tờ" />
                  <el-table-column prop="notes" label="Mật" width="50"/>
                  <el-table-column prop="notes" label="Trả bảo mật">
                    <el-table-column prop="notes" label="Ngày trả" />
                    <el-table-column prop="notes" label="Ký nhận" />
                  </el-table-column>
                </el-table>
              </el-tab-pane>
            </el-tabs>
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
  <el-dialog title="Dialog" v-model="openDialog">
    Dialog
  </el-dialog>
</template>
<script setup>
import Menu from '../components/CommonMenu.vue'
import { Plus, Postcard, Memo } from '@element-plus/icons-vue'
import { onBeforeUnmount, ref } from 'vue'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
const router = useRouter()

const yearTabSend = ref(new Date().getFullYear() + '')
const openDialog = ref(false)

onBeforeUnmount(() => {
  if (!sessionStorage.getItem('user')) {
    ElMessage.error('Access Denied !!!')
    router.push('/')
  }
})
</script>
<style scoped>
.demo-tabs > .el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}
.demo-tabs .custom-tabs-label .el-icon {
  vertical-align: middle;
}
.demo-tabs .custom-tabs-label span {
  vertical-align: middle;
  margin-left: 4px;
}
</style>
