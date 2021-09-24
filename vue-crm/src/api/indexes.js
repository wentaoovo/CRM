import request from '@/utils/request'

export function getList(data){
  return request({
    url:'/first/select',
    method:'post',
    data
  })
}
export function addall(data){
  return request({
    url:'/first/save',
    method:'post',
    data
  })
}
export function enit(data){
  return request({
    url:'/first/enit',
    method:'put',
    data
  })
}
export function byone(data){
  return request({
    url:'first/byone/${data.id}',
    method:'get',
    data
  })
}