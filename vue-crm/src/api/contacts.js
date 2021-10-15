import request from '@/utils/request'

export function getList(data){
  return request({
    url:'/three/select',
    method:'post',
    data
  })
}
export function addall(data){
  return request({
    url:'/three/insert',
    method:'post',
    data
  })
}
export function selectOne(){
  return request({
    url:'/three/selectname',
    method:'get',
  })
}
export function enit(data){
  return request({
    url:'/three/updata',
    method:'put',
    data
  })
}
export function delect(data){
  return request({
    url: `/three/delete/${data}`,
    method:'delete',
    data
  })
}