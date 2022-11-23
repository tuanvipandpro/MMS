<template>
  <div id="cm-menu">
    <el-menu
        active-text-color="#ffd04b"
        background-color="#545c64"
        class="el-menu-vertical-demo"
        :default-active="$props.defaultActive"
        text-color="#fff"
        style="min-height: 100vh;"
      >
        <el-menu-item index="1" @click="transitTo('/home')">
          <el-icon><icon-menu /></el-icon>
          <span>Quản lý thanh niên</span>
        </el-menu-item>
        <el-menu-item index="2" @click="transitTo('/document')">
          <el-icon><Document /></el-icon>
          <span>Quản lý hồ sơ</span>
        </el-menu-item>
        <el-sub-menu index="3">
          <template #title>
            <el-icon><setting /></el-icon>
            <span>Cài đặt</span>
          </template>
          <el-menu-item index="3-2" @click="logout">Đăng xuất</el-menu-item>
        </el-sub-menu>
      </el-menu>
  </div>
</template>
<script setup>
import {
  Menu as IconMenu,
  Document,
  Setting
} from '@element-plus/icons-vue'
import { useRouter } from 'vue-router'
import { defineProps } from 'vue'

const router = useRouter()

// eslint-disable-next-line no-unused-vars
const props = defineProps({
  defaultActive: Number
})

const transitTo = (screen) => {
  router.push(screen)
}

const logout = () => {
  sessionStorage.removeItem('user')
  transitTo('/')
}
</script>
<style scoped>
  #cm-menu{
    position: fixed;
    left: 0;
    z-index: 1;
    width: 18%;
  }
</style>
