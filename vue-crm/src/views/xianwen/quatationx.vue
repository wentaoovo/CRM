<template>
<div>
  <div>
    <span style="font-size:20px">报价/预下单</span>
  <div style="margin: 10px  0; text-align: right;">
       <el-button icon="el-icon-edit">编辑</el-button>
       <el-button icon="el-icon-delete">删除</el-button>
			 <el-button icon="el-icon-edit">转成订单</el-button>
 </div>
 </div>
<el-descriptions column=2>
    <el-descriptions-item label="主题"></el-descriptions-item>
    <el-descriptions-item label="转成订单"></el-descriptions-item>
    <el-descriptions-item label="客户"></el-descriptions-item>
    <el-descriptions-item label="日期"></el-descriptions-item>
    <el-descriptions-item label="报价"></el-descriptions-item>
    <el-descriptions-item label="销售机会"></el-descriptions-item>
    <el-descriptions-item label="预估毛利"></el-descriptions-item>
    <el-descriptions-item label="接收人"></el-descriptions-item>
    <el-descriptions-item label="接收人联系方式"></el-descriptions-item>
    <el-descriptions-item label="报价人"></el-descriptions-item>
    <el-descriptions-item label="报价人联系方式"></el-descriptions-item>
    <el-descriptions-item label="交付说明"></el-descriptions-item>
    <el-descriptions-item label="付款说明"></el-descriptions-item>
    <el-descriptions-item label="包装运输说明"></el-descriptions-item>
    <el-descriptions-item label="备注"></el-descriptions-item>
</el-descriptions>
</div>
</template>
<script>
export default {
  name:'quatationx'
}
</script>
<style>
</style>


