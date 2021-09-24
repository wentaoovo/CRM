import request from '@/utils/request'
// 查询订单列表
export function getList(data) {
    return request({
      url: '/indent/find',
      method: 'post',
      data
    })
  }
//新增订单  
  export function add(data) {
    return request({
      url: '/indent/add',
      method: 'post',
      data
    })
  }
//修改订单
  export function update(data) {
    return request({
      url: `/indent/update/${data.id}`,
      method: 'put',
      data
    })
  }
//新增或修改订单
export const addOrupdate = data => { return data.id ? update(data) : add(data) }
  
  
