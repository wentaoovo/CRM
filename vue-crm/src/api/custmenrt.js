import request from '@/utils/request'

export function getList(data){
  return request({
    url:'/send/select',
    method:'post',
    data
  })
}
