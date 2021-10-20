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

//删除订单
export function deletebyid(data) {
  return request({
    url: `/indent/delete/${data}`,
    method: 'delete',
    data
  })
}  
  
// 查询全部在售产品
export function getSaleList() {
  return request({
    url: '/product/findSale',
    method: 'get',
  })
}
// 查询全部联系人
export function getContactsList(data) {
  return request({
    url: `/three/selectYomer/${data}`,
    method: 'get',
  })
}
// 查询全部客户
export function getClientList() {
  return request({
    url: '/send/selectTomer',
    method: 'get',
  })
}
// 查询全部销售机会
export function getChanceList() {
  return request({
    url: '/five/selectDtmer',
    method: 'get',
  })
}

//批量新增订单详细
export function addDetailList(data) {
  return request({
    url: '/indentdetail/add',
    method: 'post',
    data
  })
}
//根据id删除订单详细
export function deleteDetail(data) {
  return request({
    url: `/indentdetail/delete/${data}`,
    method: 'delete',
  })
}
//批量修改订单详细
export function updateDetailList(data) {
  return request({
    url: '/indentdetail/update',
    method: 'put',
    data
  })
}
//根据订单id查询订单详细
export function findDetailList(data) {
  return request({
    url: `/indentdetail/find/${data}`,
    method: 'get',
  })
}
//批量新增或修改订单详细
export const addOrUpDetail = data => { return data[0].id ? updateDetailList(data) : addDetailList(data) }

//根据id查询订单与明细
export function findIndentAnddetail(data){
  return request({
    url: `/indent/findJoin/${data}`,
    method: 'get',
  })
}

//根据id查询订单与明细2
export function findIndentAnddetaile(data){
  return request({
    url: `/indent/findJoine/${data}`,
    method: 'get',
  })
}

//新增发货单  
export function addShipments(data) {
  return request({
    url: '/shipments/add',
    method: 'post',
    data
  })
}

//根据订单id查询发货单与明细  
export function findShipmentsD(data) {
  return request({
    url: `/shipments/find/${data}`,
    method: 'get',
  })
}

//新增回款计划
export function addPlan(data) {
  return request({
    url: '/plan/add',
    method: 'post',
    data
  })
}