<!-- eslint-disable vue/multi-word-component-names -->
<template>
  <el-table
    :border="true"
    :data="$props.tableData"
    :span-method="spanMethod"
  >
    <el-table-column prop="id" label="ID" width="80">
      <template #default="scope">
          <template v-if="scope.$index === 0">
            <div style="text-align: center;">
              {{`Tổng số ${$props.tableData.length} công dân, trong đó:`}} <br/>
              {{`Trong 10 tiêu chuẩn của Thông tư 16/2016/TTLT- BQP- BYT: ${$props.tableData.length} công dân`}}<br/>
              {{`(Điều 14, Luật Nghĩa vụ quân sự năm 2015)` }}
            </div>
          </template>
          <template v-else> {{ scope.row.id }}</template>
        </template>
    </el-table-column>
    <el-table-column prop="name" label="Họ & Tên"/>
    <el-table-column prop="birthdate" label="Ngày sinh" :formatter="formatterBirth"/>
    <el-table-column prop="address" label="Địa chỉ" />
    <el-table-column prop="quarter" label="Khu phố"/>
  </el-table>
</template>

<script setup>
import { defineProps } from 'vue'
import moment from 'moment'

// eslint-disable-next-line no-unused-vars
const props = defineProps({
  tableData: Array
})

const formatterBirth = ({ row, column, cellValue, index }) => {
  return moment(cellValue).format('DD-MM-YYYY')
}

const spanMethod = ({ row, column, rowIndex, columnIndex }) => {
  if (rowIndex === 0) {
    if (columnIndex === 0) return [1, 5]
    else return [0, 0]
  }
}

</script>
