<template>
  <div>
    <el-container>
      <el-aside style="width: 18vw">
        <Menu default-active="1-2"></Menu>
      </el-aside>
      <el-container>
        <el-main>
          <div style="margin-bottom: 8px;">
            <h2>Quản lý nguồn</h2>
            <!-- <el-button  type="success" plain :icon="Plus">Thêm mới</el-button> -->
            <el-date-picker
              v-model="year"
              type="year"
              placeholder="Chọn năm"
              style="margin-bottom: 10px;"
              @change="changeYear"
            />
            <el-tabs
              v-if="year"
              type="card"
              class="demo-tabs"
              v-model="type"
              @tab-change="tabChange"
            >
              <el-tab-pane label="DS 1" name="1">
                <List01Vue :table-data="tableData"/>
              </el-tab-pane>
              <el-tab-pane label="DS 2" name="2">
                Content
              </el-tab-pane>
              <el-tab-pane label="DS 3" name="3">
                Content
              </el-tab-pane>
              <el-tab-pane label="DS 4" name="4">
                Content
              </el-tab-pane>
              <el-tab-pane label="DS 5" name="5">
                Content
              </el-tab-pane>
              <el-tab-pane label="DS 6" name="6">
                Content
              </el-tab-pane>
              <el-tab-pane label="DS 7" name="7">
                Content
              </el-tab-pane>
              <el-tab-pane label="DS 8" name="8">
                Content
              </el-tab-pane>
              <el-tab-pane label="DS 9" name="9">
                Content
              </el-tab-pane>
              <el-tab-pane label="DS 10" name="10">
                Content
              </el-tab-pane>
            </el-tabs>
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script setup>
import Menu from '../components/CommonMenu.vue'
import List01Vue from './FolderList/List01.vue'
// import { Plus } from '@element-plus/icons-vue'
import { useListStore } from '../stores/list'
import { onBeforeUnmount, ref } from 'vue'
import { ElMessage, ElLoading } from 'element-plus'
import { useRouter } from 'vue-router'
import moment from 'moment'

const router = useRouter()
const year = ref('')
const type = ref('1')
const tableData = ref([])

onBeforeUnmount(async () => {
  if (!sessionStorage.getItem('user')) {
    ElMessage.error('Access Denied !!!')
    router.push('/')
  }
})

const loadTable = async () => {
  const loading = ElLoading.service({
    lock: true,
    text: 'Loading',
    background: 'rgba(0, 0, 0, 0.7)'
  })
  try {
    const res = await useListStore().getByTypeYear(type.value, moment(year.value).format('YYYY'))

    if (res.indexings.length < 2) {
      tableData.value = [{}, ...res.indexings[0].details]
    }
  } catch (e) {
    console.error(e)
  } finally {
    loading.close()
  }
}

const changeYear = async () => {
  if (year.value) {
    await loadTable()
  }
}

const tabChange = async (tabName) => {
  await loadTable()
}
</script>
<style>
.card-header {
  display: flex;
  justify-content: space-between;
  align-items: center;
}

.demo-tabs > .el-tabs__content {
  padding: 32px;
  color: #6b778c;
  font-size: 32px;
  font-weight: 600;
}
</style>
