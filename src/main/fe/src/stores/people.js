import axios from '../axios'
import { defineStore } from 'pinia'

const API = '/api/v1/people'

export const usePeopleStore = defineStore('people', {
  state: () => ({
    peoples: []
  }),
  getters: {
    // TODO
  },
  actions: {
    async getPeople (pageNo, pageNum) {
      const url = `${API}/get`
      const user = JSON.parse(sessionStorage.getItem('user'))
      const res = await axios.get(url, {
        params: {
          pageNo: pageNo,
          pageNum: pageNum,
          areaId: user.area_id
        }
      })

      return res.data
    }
  }
})
