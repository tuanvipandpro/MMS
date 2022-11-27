import { createRouter, createWebHashHistory } from 'vue-router'
import Login from '../views/LoginPage.vue'

const routes = [
  {
    path: '/',
    name: 'login',
    component: Login
  },
  {
    path: '/document',
    name: 'document',
    component: () => import(/* webpackChunkName: "about" */ '../views/DocumentPage.vue')
  },
  {
    path: '/folder',
    name: 'folder',
    component: () => import(/* webpackChunkName: "about" */ '../views/FolderPage.vue')
  },
  {
    path: '/list',
    name: 'list',
    component: () => import(/* webpackChunkName: "about" */ '../views/ListPage.vue')
  },
  {
    path: '/details',
    name: 'details',
    component: () => import(/* webpackChunkName: "about" */ '../views/ListDetailsPage.vue')
  },
  {
    path: '/home',
    name: 'home',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/HomePage.vue')
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
