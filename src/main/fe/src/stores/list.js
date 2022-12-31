import axios from '../axios'
import { defineStore } from 'pinia'

const API = '/api/v1/list'

export const useListStore = defineStore('list', {
  state: () => ({
    list: []
  }),
  getters: {
    // TODO
  },
  actions: {
    async getByTypeYear (type, year) {
      const url = `${API}/get-by-type-year`
      // const user = JSON.parse(sessionStorage.getItem('user'))
      const res = await axios.get(url, {
        params: {
          type: type,
          year: year
        }
      })
      return res.data
    }
  }
})
