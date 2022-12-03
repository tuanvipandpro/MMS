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
    },
    async insertDocument (document) {
      const url = `${API}/create`
      const user = JSON.parse(sessionStorage.getItem('user'))
      document.user_id = user.id
      const res = await axios.post(url, document)

      return res.data
    },
    async updateDocument (document) {
      const url = `${API}/update`
      const res = await axios.put(url, document)

      return res.data
    },
    async deleteDocument (id) {
      const url = `${API}/delete/${id}`
      const res = await axios.delete(url)

      return res.data
    }
  }
})
