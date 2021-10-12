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
export function find(data) {
    return request({
      url: `/product/find/${data}`,
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

//删除产品
export function deletebyid(data) {
  return request({
    url: `/product/delete/${data}`,
    method: 'delete',
    data
  })
}
// 查询产品分类列表
export function getclassList() {
  return request({
    url: '/productclass/findAll',
    method: 'get',
  })
}
// 根据id查询分类
export function findClass(data) {
  return request({
    url: `/productclass/find/${data}`,
    method: 'get',
  })
}
//新增产品分类
export function classAdd(data){
  return request({
    url: '/productclass/add',
    method: 'post',
    data
  })
}
//编辑产品分类
export function classUpdate(data){
  return request({
    url: `/productclass/update/${data.id}`,
    method: 'put',
    data
  })
}
//新增或修改产品分类
export const addOrupClass = data => { return data.id ? classUpdate(data) : classAdd(data) }
//删除产品分类
export function classDelete(data){
  return request({
    url: `/productclass/delete/${data}`,
    method: 'delete',
    data
  })
}

  
