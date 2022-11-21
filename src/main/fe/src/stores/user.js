import axios from '../axios'
import { defineStore } from 'pinia'

export const useUserStore = defineStore('user', {
  state: () => ({
    username: '',
    token: '',
    area_id: '',
    area_name: ''
  }),
  getters: {
    // TODO
  },
  actions: {
    async login (username, password) {
      const url = '/auth/login'
      const body = {
        username: username,
        password: password
      }

      const res = await axios.post(url, body)

      if (res.status === 200) {
        axios.defaults.headers.common.Authorization = `Bearer ${res.data.token}`
        sessionStorage.setItem('user', JSON.stringify(res.data))
      }
    }
  }
})
