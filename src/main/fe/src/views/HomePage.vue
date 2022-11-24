<template>
  <div>
    <el-container>
      <el-aside style="width: 18vw">
        <Menu default-active="1"></Menu>
      </el-aside>
      <el-container>
        <el-main>
          <div style="margin-bottom: 10px; display: flex">
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
            <el-select v-model="quarterSelect" clearable placeholder="Chọn khu phố" style="width: 12vw; margin-right: 3px;">
              <el-option
                v-for="item in quarterData"
                :key="item.id"
                :label="item.name"
                :value="item.name"
              />
            </el-select>
            <el-date-picker
              v-model="date"
              type="daterange"
              range-separator="-"
              start-placeholder="Ngày bắt đầu"
              end-placeholder="Ngày kết thúc"
              style="margin-right: 10vw;"
            />
            <el-button type="success" plain :icon="Plus">Thêm mới</el-button>
          </div>
          <el-descriptions border>
              <el-descriptions-item>
                <template #label>Tổng cộng</template>
                  <strong>{{total}}</strong> thanh niên
              </el-descriptions-item>
            </el-descriptions>
          <el-table
            :data="tableData"
            highlight-current-row
            border
            v-loading="tableLoading"
            stripe
            style="width: 100%; height: 55vh"
          >
          <el-table-column type="selection" width="55" />
            <el-table-column prop="id" label="ID" width="80" />
            <el-table-column prop="fullname" label="Họ & Tên"/>
            <el-table-column prop="birth" label="Ngày sinh" />
            <el-table-column prop="address" label="Địa chỉ" />
            <el-table-column prop="quarter" label="Khu phố"/>
            <el-table-column  label="Thao tác">
              <template #header>
                <div class="cell">Thao tác</div>
              </template>
              <template #default="scope">
                <el-button type="info" :icon="Edit" @click="handleEdit(scope.$index, scope.row)" plain></el-button>
                <el-popconfirm
                  confirm-button-text="Yes"
                  cancel-button-text="No"
                  title="Bạn có chắc chắn muốn xóa ?"
                >
                  <template #reference>
                    <el-button type="danger" :icon="Delete" @click="handleDelete(scope.$index, scope.row)"></el-button>
                  </template>
                </el-popconfirm>
              </template>
            </el-table-column>
          </el-table>
          <el-pagination
            background
            layout="prev, pager, next"
            :total="total"
            :page-size="pageNum"
            style="margin-top: 10px"
            />
        </el-main>
      </el-container>
    </el-container>
  </div>
  <el-dialog v-model="updateDialog" title="Cập nhật">
    dsd
  </el-dialog>
</template>
<script setup>

import moment from 'moment'
import Menu from '../components/CommonMenu.vue'
import { usePeopleStore } from '../stores/people'
import { useAreaStore } from '../stores/area'
import { Search, Plus, Edit, Delete } from '@element-plus/icons-vue'
import { onBeforeMount, ref } from 'vue'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
const router = useRouter()

const date = ref('')
const total = ref('')
const pageNo = ref(1)
const pageNum = ref(5)
const search = ref('')
const tableData = ref('')
const quarterData = ref('')
const quarterSelect = ref('')
const tableLoading = ref(true)
const updateDialog = ref(false)

onBeforeMount(async () => {
  if (!sessionStorage.getItem('user')) {
    ElMessage.error('Access Denied !!!')
    router.push('/')
  }

  tableLoading.value = true
  quarterData.value = await useAreaStore().getQuarter()
  handlePeopleResponse(await usePeopleStore().getPeople(undefined, undefined, undefined, undefined, pageNo.value - 1, pageNum.value))
})

const handlePeopleResponse = (peopleResponse) => {
  total.value = +peopleResponse.total
  tableData.value = peopleResponse.peoples.map(p => {
    p.birth = moment(p.birthdate).format('DD-MM-yyyy')
    p.dAddress = `${p.address}, KP.${p.quarter}`
    return p
  })
  tableLoading.value = false
}

const searchByFullname = async () => {
  const fullnameSearch = search.value ? search.value : undefined
  const quarterSearch = quarterSelect.value ? quarterSelect.value : undefined
  const from = date.value ? moment(date.value[0]).format('yyyy-MM-DD') : undefined
  const to = date.value ? moment(date.value[1]).format('yyyy-MM-DD') : undefined

  tableLoading.value = true
  handlePeopleResponse(await usePeopleStore().getPeople(fullnameSearch, quarterSearch, from, to, pageNo.value - 1, pageNum.value))
}

const handleEdit = async (index, row) => {
  updateDialog.value = true
}

</script>
<style scoped>
.ml-2 {
  margin-left: 2px;
}
</style>
