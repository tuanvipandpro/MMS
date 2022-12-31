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
              {{`Tổng số ${$props.tableData.length} công dân`}} <br/>
              {{`()`}}<br/>
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
  tableData: Array,
  // 1. Khúc xạ mắt
  // 2,3,4,5 : Loại 3,4,5,6
  typeTotal: Array
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
