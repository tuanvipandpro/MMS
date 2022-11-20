import axios from 'axios'

axios.defaults.baseURL = 'http://localhost:8080'

axios.interceptors.request.use(config => {
  if (!axios.defaults.headers.common.Authorization && sessionStorage.getItem('user')) {
    config.headers.Authorization = `Bearer ${JSON.parse(sessionStorage.getItem('user')).token}`
  }
  return config
})

export default axios
