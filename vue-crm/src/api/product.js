import request from '@/utils/request'
// 查询产品列表
export function getList(data) {
    return request({
      url: '/product/findAll',
      method: 'post',
      data
    })
  }
 // 根据id查询产品
export function getFind(data) {
    return request({
      url: `/product/find/${data.id}`,
      method: 'get',
      data
    })
  } 
//新增产品  
  export function add(data) {
    return request({
      url: '/product/add',
      method: 'post',
      data
    })
  }
//修改产品
  export function update(data) {
    return request({
      url: `/product/update/${data.id}`,
      method: 'put',
      data
    })
  }
//新增或修改产品
export const addOrupdate = data => { return data.id ? update(data) : add(data) }

//删除订单
export function deletebyid(data) {
  return request({
    url: `/product/delete/${data}`,
    method: 'delete',
    data
  })
}  
  
