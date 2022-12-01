import axios from '../axios'
import { defineStore } from 'pinia'

const API = '/api/v1/document'

export const useDocumentStore = defineStore('document', {
  state: () => ({
    documents: []
  }),
  getters: {
    // TODO
  },
  actions: {
    async getDocuments (year, type) {
      const url = `${API}/get-by-year`
      const user = JSON.parse(sessionStorage.getItem('user'))
      const res = await axios.get(url, {
        params: {
          user_id: user.id,
          year: year,
          type: type
        }
      })

      return res.data
    }
  }
})
