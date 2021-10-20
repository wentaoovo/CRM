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
export function selectOne(data){
  return request({
    url:`/four/selectOne/${data}`,
    method:'get',
    data
  })
}
export function selectt(data){
  return request({
    url:`/four/selectt/${data}`,
    method:'get'
  })
}
export function selects(){
  return request({
    url:'/four/selects',
    method:'get'
  })
}
export function selectd(data){
  return request({
    url:`/four/selectd/${data}`,
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
  //转成订单
export function add(data) {
    return request({
      url: '/indent/add',
      method: 'post',
      data
    })
  }
//改变转成订单状态
export function change(data){
  return request({
    url:'/four/change',
    method:'post',
    data
  })
}