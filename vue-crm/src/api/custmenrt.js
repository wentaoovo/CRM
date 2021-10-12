import request from '@/utils/request'

export function getList(data){
  return request({
    url:'/send/select',
    method:'post',
    data
  })
}
export function addall(data){
  return request({
    url:'/send/save',
    method:'post',
    data
  })
}
export function enit(data){
  return request({
    url:'/send/updata',
    method:'put',
    data
  })
}
export function delect(data){
  return request({
    url: `/send/delete/${data}`,
    method:'delete',
    data
  })
}