import axios from '../axios'
import { defineStore } from 'pinia'

const API = '/api/v1/area'

export const useAreaStore = defineStore('area', {
  state: () => ({
    area: {},
    quarters: []
  }),
  getters: {
    // TODO
  },
  actions: {
    async getQuarter () {
      const url = `${API}/get-quarter`
      const user = JSON.parse(sessionStorage.getItem('user'))
      const res = await axios.get(url, {
        params: {
          areaId: user.area_id
        }
      })

      return res.data
    }
  }
})
