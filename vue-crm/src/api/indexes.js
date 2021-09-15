import request from '@/utils/request'

export default{
 getList(indexesSearchVo){
   return request({
     url:'/first/select',
     method:'post',
     data:indexesSearchVo
   })
 }
}
