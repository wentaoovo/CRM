import request from '@/utils/request'

export function getList(data){
  return request({
    url:'/four/select',
    method:'post',
    data
  })
}
export function addall(data){
  return request({
    url:'/four/save',
    method:'post',
    data
  })
}
// export function selectOne(){
//   return request({
//     url:'/four/selectname',
//     method:'get',
//   })
// }
export function selectt(){
  return request({
    url:'/four/selectt',
    method:'get'
  })
}
export function selects(){
  return request({
    url:'/four/selects',
    method:'get'
  })
}
export function selectd(){
  return request({
    url:'/four/selectd',
    method:'get'
  })
}
export function enit(data){
  return request({
    url:'/four/updata',
    method:'put',
    data
  })
}
export function delect(data){
  return request({
    url: `/four/delete/${data}`,
    method:'delete',
    data
  })
}