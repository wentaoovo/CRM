import request from '@/utils/request'

export function getList(data){
  return request({
    url:'/five/select',
    method:'post',
    data
  })
}
export function addall(data){
  return request({
    url:'/five/save',
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
export function selectt(data){
  return request({
    url:`/five/selectt/${data}`,
    method:'get'
  })
}
export function selects(){
  return request({
    url:'/five/selects',
    method:'get'
  }) 
}
export function enit(data){
  return request({
    url:'/five/updata',
    method:'put',
    data
  })
}
export function delect(data){
  return request({
    url: `/five/delete/${data}`,
    method:'delete',
    data
  })
}