<template>
<div class="div1">
<el-descriptions :column=4 title="订单信息">
  <el-descriptions-item label="订单编号">{{findData.id}}</el-descriptions-item>
  <el-descriptions-item label="客户名称">{{findData.customerName}}</el-descriptions-item>
  <el-descriptions-item label="订单金额">{{findData.totalMoney}}</el-descriptions-item>
  <el-descriptions-item label="所有者">
    <el-tag size="small">{{findData.possessor}}</el-tag>
  </el-descriptions-item>
</el-descriptions>
<div class="app-button3">
  <router-link v-show="showOrHide" :to="{'path':'/indent/shipments/'+this.id}" class="el-button el-icon-truck el-button--primary el-button--small">发货:点此生成发货单</router-link>
</div> 
  <el-tabs v-model="activeName" @tab-click="handleClick">
    <el-tab-pane label="基本信息" name="first">
      <el-descriptions :column=2 title="基本信息">
        <el-descriptions-item label="主题">{{findData.theme}}</el-descriptions-item>
        <el-descriptions-item label="分类">{{findData.classify}}</el-descriptions-item>
        <el-descriptions-item label="对应机会">{{findData.chanceName}}</el-descriptions-item>
        <el-descriptions-item label="客户签约人">{{findData.contactsName}}</el-descriptions-item>
        <el-descriptions-item label="发货金额">￥{{findData.outMoney}}</el-descriptions-item>
        <el-descriptions-item label="回款金额">￥{{findData.returnedMoney}}</el-descriptions-item>
        <el-descriptions-item label="总成本">￥{{findData.cost}}</el-descriptions-item>
        <el-descriptions-item label="毛利">￥{{findData.grossMargin}}</el-descriptions-item>
        <el-descriptions-item label="开发票金额">￥{{findData.invoiceValue}}</el-descriptions-item>
        <el-descriptions-item label="预估毛利">{{findData.forgrossMargin}}</el-descriptions-item>
        <el-descriptions-item label="日期">{{findData.indentDate}}</el-descriptions-item>
        <el-descriptions-item label="最晚发货">{{findData.latestDeliveryDate}}</el-descriptions-item>
        <el-descriptions-item label="状态">{{['执行中','结束','意外终止'][findData.state]}}</el-descriptions-item>
        <el-descriptions-item label="总折扣">{{findData.discount}}</el-descriptions-item>
        <el-descriptions-item label="运费">￥{{findData.freight}}</el-descriptions-item>
      </el-descriptions>
      <div class="app-button2"><el-button @click="handAdd()" icon="el-icon-edit" type="primary" plain size="small">编辑</el-button></div>
    </el-tab-pane>
    <el-tab-pane label="订单明细" name="second">
      <el-descriptions title="订单明细"></el-descriptions>
      <el-table :data="findData.indentDetail" style="width: 100%">
        <el-table-column prop="productName" label="品名"> </el-table-column>
        <el-table-column prop="model" label="型号"> </el-table-column>
        <el-table-column prop="address" label="单位"> </el-table-column>
        <el-table-column prop="quantity" label="数量"> </el-table-column>
        <el-table-column prop="address" label="已交付"> </el-table-column>
        <el-table-column prop="address" label="未交付"> </el-table-column>
        <el-table-column prop="unitPrice" label="单价"> </el-table-column>
        <el-table-column prop="discount" label="折扣%"> </el-table-column>
        <el-table-column prop="money" label="金额"> </el-table-column>
        <el-table-column prop="remark" label="备注"> </el-table-column>
      </el-table>
      <div class="app-button2"><el-button @click="detailsAdd()" icon="el-icon-edit" type="primary" plain size="small">编辑</el-button></div>
    </el-tab-pane>
    <el-tab-pane label="发货信息" name="third">
      <el-descriptions :column=3 title="">
        <el-descriptions-item label="物流单号">{{formData.trackingNumber}}</el-descriptions-item>
        <el-descriptions-item label="发货日期">{{formData.shdate}}</el-descriptions-item>
        <el-descriptions-item label="状态">{{formData.state == 0? '已发货':''}}</el-descriptions-item>
        <el-descriptions-item label="收货人">{{formData.addressee}}</el-descriptions-item>
        <el-descriptions-item label="收货人电话">{{formData.addresseeTelephone}}</el-descriptions-item>
        <el-descriptions-item label="打包件数">{{formData.packets}}</el-descriptions-item>
        <el-descriptions-item label="重量(Kg)">{{formData.weight}}</el-descriptions-item>
        <el-descriptions-item label="物流公司">{{formData.logisticsCompany}}</el-descriptions-item>
        <el-descriptions-item label="运费">{{formData.freight}}</el-descriptions-item>
      </el-descriptions>
          <el-col :span="24">
            <el-divider></el-divider>  
          </el-col>
          <el-col :span="23" :offset="1">
            <el-table :data="formData.indentDetail" border  style="width: 1000px">
            <el-table-column prop="productName" label="品名"> </el-table-column>
            <el-table-column prop="model" label="型号"> </el-table-column>
            <el-table-column prop="quantity" label="数量"> </el-table-column>
            <el-table-column prop="unitPrice" label="单价"> </el-table-column>
            <el-table-column prop="money" label="金额"> </el-table-column>
            <el-table-column prop="remark" label="备注"> </el-table-column>
          </el-table>           
          </el-col>
    </el-tab-pane>
    <el-tab-pane label="回款信息" name="returned">
      <div class="app-button2"><el-button @click="returnedAdd()" icon="el-icon-edit" type="primary" plain size="small">回款计划</el-button></div>
    </el-tab-pane>
  </el-tabs>
  <!-- 新增订单组件 -->
    <component v-bind:is="indexAdd" ref="indexAdd"></component>
    <!-- 新增订单明细组件 -->
    <component v-bind:is="detailadd" ref="detailadd"></component>
    <!-- 新增回款计划组件 -->
    <component v-bind:is="returnedadd" ref="returnedadd"></component>
</div>
</template>

<script>
import {findIndentAnddetail,findShipmentsD} from "@/api/indent"
import indexAdd from '@/views/indent/components/indexadd'
import detailadd from '@/views/indent/components/indent_detailadd'
import returnedadd from '@/views/indent/components/returnedadd'
export default {
  name: 'viewIndex',
  components:{indexAdd,detailadd,returnedadd},
  data() {
    return{
      indexAdd: 'indexAdd',
      detailadd: 'detailadd',
      returnedadd:'returnedadd',      
      activeName: 'first',
      findData:{},
      formData:{},
      id:'',
      showOrHide:true,
    }
  },
  methods: {
    init(){
       this.id=this.$route.params.id;
      findIndentAnddetail(this.id).then(res =>{
        this.findData = res.data
      }),
      findShipmentsD(this.id).then(res =>{
        if(res.data == null){
          this.showOrHide = true
        }else{
          this.showOrHide = false
          this.formData = res.data
        }
      })
    },
    handleClick(tab, event) {
        console.log(tab, event)
    },
    // 编辑订单
    handAdd(){
      if(this.showOrHide){
        this.$refs.indexAdd.init();
        this.$refs.indexAdd.formData = this.findData;
        this.$refs.indexAdd.dialogFormVisible = true;
      }else{
        this.$message({
          message: '该订单也发货，不允许订单修改',
          type: 'error'
        });
      }
    },
    //编辑详细
    detailsAdd(){
      if(this.showOrHide){
        this.$refs.detailadd.formData.tableData = this.findData.indentDetail;
        this.$refs.detailadd.init();
        this.$refs.detailadd.indentsId = this.id;
        this.$refs.detailadd.dialogFormVisible = true;
      }else{
        this.$message({
          message: '该订单也发货，不允许明细修改',
          type: 'error'
        });
      }
    },
    returnedAdd(){
      this.$refs.returnedadd.formData = this.findData
      this.$refs.returnedadd.init();
      this.$refs.returnedadd.dialogFormVisible = true;
    },    
  },
  created(){
    this.init();  
  }
}
</script>

<style>
.app-button2{
  text-align: center;
}
/* .app-button3{
  position: absolute;
  right: 40px;
  top: 0px;
} */
</style>
