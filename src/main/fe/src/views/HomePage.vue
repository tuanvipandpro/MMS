<template>
  <div>
    <el-container>
      <el-aside style="width: 18vw">
        <Menu></Menu>
      </el-aside>
      <el-container>
        <el-main>
          <el-table
            :data="tableData"
            highlight-current-row
            border
            style="width: 100%; height: 37vh"
          >
            <el-table-column prop="id" label="ID" width="180" />
            <el-table-column prop="fullname" label="Họ & Tên"/>
            <el-table-column prop="birth" label="Ngày sinh" />
            <el-table-column prop="dAddress" label="Địa chỉ" />
          </el-table>
          <el-pagination background layout="prev, pager, next" :total="total"  style="margin-top: 10px"/>
        </el-main>
      </el-container>
    </el-container>
  </div>
</template>
<script setup>
import { onBeforeMount, ref } from 'vue'
import Menu from '../components/CommonMenu.vue'
import { usePeopleStore } from '../stores/people'
import moment from 'moment'
// import {
//   Plus
// } from '@element-plus/icons-vue'

const pageNo = 0
const pageNum = 5
const tableData = ref('')
const total = ref('')

onBeforeMount(async () => {
  const peopleResponse = await usePeopleStore().getPeople(pageNo, pageNum)
  total.value = peopleResponse.total
  tableData.value = peopleResponse.peoples.map(p => {
    p.birth = moment(p.birthdate).format('DD-MM-yyyy')
    p.dAddress = `${p.address}, KP.${p.quarter}`
    return p
  })
})

</script>
<style scoped>
.ml-2 {
  margin-left: 2px;
}
</style>
