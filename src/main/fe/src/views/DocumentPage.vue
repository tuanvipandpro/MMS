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
            <el-tabs type="border-card" class="demo-tabs" style="height: 75vh;" v-model="type" @tab-change="tabChanges">
              <el-tab-pane label="Công Văn Đi" name="1">
                <template #label>
                  <span class="custom-tabs-label">
                    <el-icon><postcard /></el-icon>
                    <span>Công Văn Đi</span>
                  </span>
                </template>
                <el-date-picker
                  v-model="year"
                  type="year"
                  placeholder="Chọn năm"
                  style="margin-bottom: 1vh;"
                  @change="changeDate"
                  format="YYYY"
                />
                <el-table :data="tableData" border style="width: 100%" v-loading="tableLoading">
                  <el-table-column prop="code" label="Số CV" />
                  <el-table-column prop="date" label="Ngày" width="100"/>
                  <el-table-column prop="title" label="Trích yếu" width="420"/>
                  <el-table-column prop="pages" label="Số tờ" width="80"/>
                  <el-table-column prop="copies" label="Số bản" width="80"/>
                  <el-table-column prop="secret" label="Mật" width="50">
                    {{ secret ? 'Mật' : ''}}
                  </el-table-column>
                  <el-table-column prop="recipients" label="Nơi nhận" />
                  <el-table-column prop="notes" label="Ghi chú" />
                </el-table>
              </el-tab-pane>
              <el-tab-pane label="Công Văn Đến" name="0">
                <template #label>
                  <span class="custom-tabs-label">
                    <el-icon><memo /></el-icon>
                    <span>Công Văn Đến</span>
                  </span>
                </template>
                <el-date-picker
                  v-model="year"
                  type="year"
                  placeholder="Chọn năm"
                  @change="changeDate"
                  style="margin-bottom: 1vh;"
                />
                <el-table :data="tableData" border style="width: 100%" v-loading="tableLoading">
                  <el-table-column prop="receive_num" label="Số đến" width="50"/>
                  <el-table-column prop="code" label="Số VB đến" />
                  <el-table-column prop="date" label="Ngày CV" width="100"/>
                  <el-table-column prop="agency_issued" label="CQ Ban Hành" />
                  <el-table-column prop="title" label="Trích yếu" width="200"/>
                  <el-table-column prop="pages" label="Số bản" width="75"/>
                  <el-table-column prop="copies" label="Số tờ" width="75"/>
                  <el-table-column prop="secret" label="Mật" width="50">
                    {{ secret ? 'Mật' : ''}}
                  </el-table-column>
                  <el-table-column label="Trả bảo mật">
                    <el-table-column prop="return_date" label="Ngày trả" width="82"/>
                    <el-table-column prop="signed" label="Ký nhận" width="92">
                      {{ signed ? 'Đã ký' : ''}}
                    </el-table-column>
                  </el-table-column>
                </el-table>
              </el-tab-pane>
            </el-tabs>
          </div>
        </el-main>
      </el-container>
    </el-container>
  </div>
  <el-dialog :title="`Thêm Mới Công Văn ${type === '0' ? 'Đến' : 'Đi'}`" v-model="openDialog">
    <div v-if="type === '0'">
      <el-form :model="form" label-width="100px">
        <el-form-item label="Số đến"><el-input-number v-model="form.receive_num"/></el-form-item>
        <el-form-item label="Số VB đến"><el-input v-model="form.code"/></el-form-item>
        <el-form-item label="Ngày CV"><el-date-picker v-model="form.date"/></el-form-item>
        <el-form-item label="CQ Ban hành"><el-input v-model="form.agency_issued"/></el-form-item>
        <el-form-item label="Trích yếu"><el-input v-model="form.title"/></el-form-item>
        <el-form-item label="Số trang"><el-input-number v-model="form.pages" :min="1"/></el-form-item>
        <el-form-item label="Số bản"><el-input-number v-model="form.copies" :min="1"/></el-form-item>
        <el-form-item label="Mật"><el-switch v-model="form.secret"/></el-form-item>
        <el-form-item label="Trả bảo mật"><el-switch v-model="secretFormSwitch"/></el-form-item>
        <!-- <h4>Trả bảo mật</h4> -->
        <div v-if="secretFormSwitch">
          <el-form-item label="Ngày trả"><el-date-picker v-model="form.return_date"/></el-form-item>
          <el-form-item label="Ký nhận"><el-switch v-model="form.signed"/></el-form-item>
        </div>
        <el-form-item>
          <el-button type="primary" @click="onSubmitForm">Tạo mới</el-button>
          <el-button @click="(openDialog = false)">Hủy Bỏ</el-button>
        </el-form-item>
      </el-form>
    </div>
    <div v-else>
      <el-form :model="form" label-width="100px">
        <el-form-item label="Số CV"><el-input v-model="form.code"/></el-form-item>
        <el-form-item label="Ngày CV"><el-date-picker v-model="form.date"/></el-form-item>
        <el-form-item label="Trích yếu"><el-input v-model="form.title"/></el-form-item>
        <el-form-item label="Số trang"><el-input-number v-model="form.pages" :min="1"/></el-form-item>
        <el-form-item label="Số bản"><el-input-number v-model="form.copies" :min="1"/></el-form-item>
        <el-form-item label="Mật"><el-switch v-model="form.secret"/></el-form-item>
        <el-form-item label="Nơi nhận"><el-input v-model="form.recipients"/></el-form-item>
        <el-form-item label="Ghi chú"><el-input v-model="form.notes"/></el-form-item>
        <el-form-item>
          <el-button type="primary" @click="onSubmitForm">Tạo mới</el-button>
          <el-button @click="(openDialog = false)">Hủy Bỏ</el-button>
        </el-form-item>
      </el-form>
    </div>
  </el-dialog>
</template>
<script setup>
import Menu from '../components/CommonMenu.vue'
import { Plus, Postcard, Memo } from '@element-plus/icons-vue'
import { useDocumentStore } from '../stores/document'
import { onBeforeMount, ref } from 'vue'
import { ElMessage } from 'element-plus'
import { useRouter } from 'vue-router'
import moment from 'moment'

const router = useRouter()

// const year = ref(new Date().getFullYear() + '')
const year = ref('')
const type = ref('1')
const tableLoading = ref(false)
const openDialog = ref(false)
const secretFormSwitch = ref(false)
const tableData = ref([])
const form = ref({
  code: '',
  date: new Date(),
  title: '',
  pages: 1,
  copies: 1,
  secret: false,
  recipients: '',
  notes: '',
  receive_num: 1,
  agency_issued: '',
  return_date: new Date(),
  signed: false
})

const tabChanges = async () => {
  // year.value = new Date().getFullYear() + ''
  year.value = ''
  tableData.value = []
}

const changeDate = async () => {
  await getDocument()
}

const getDocument = async () => {
  tableLoading.value = true
  try {
    const res = await useDocumentStore().getDocuments(moment(year.value).format('YYYY'), type.value)
    tableData.value = res.map(e => {
      e.date = moment(e.date).format('DD-MM-YYYY')
      return e
    })
  } catch (e) {
    console.error(e)
  } finally {
    tableLoading.value = false
  }
}

const onSubmitForm = () => {
  console.log('Submit', form.value)
}

onBeforeMount(async () => {
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
