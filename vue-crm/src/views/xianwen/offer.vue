<template>
<div style="padding:10px">
    <div style="margin: 10px  0;">
          <el-form :inline="true" v-model="selectParams">
            <el-form-item label="产品">
							<el-input v-model="selectParams.product" placeholder="产品" size="medium" style="width:140px" clearable></el-input>
						</el-form-item>
            <el-form-item>
							<el-button type="primary" @click="onsumbit" icon="el-icon-search" style="margin-left: 20px;">查询</el-button>
						</el-form-item>
          </el-form> 
		</div>
        <el-table  :data="tableData" style="width: 100%">
          <el-table-column prop="id"  label="id"></el-table-column>
          <el-table-column prop="product" label="产品" sortable></el-table-column>
          <el-table-column prop="quantity" label="数量"  sortable></el-table-column>
          <el-table-column prop="unitPrice" label="单价" sortable></el-table-column>
          <el-table-column prop="amountMoney" label="金额" sortable ></el-table-column>
          <el-table-column prop="employeeName"  label="负责人"  sortable></el-table-column>
          <el-table-column prop="creationTime"  label="创建时间"   sortable></el-table-column>
          <el-table-column prop="customerName" label="客户" ></el-table-column>
          <el-table-column prop="quotationTheme" label="报价单" ></el-table-column>
          </el-table>
          <div style="margin: 10px 0;">
        		 <el-pagination
		      @size-change="handleSizeChange"
		      @current-change="handleCurrentChange"
		      :page-sizes="[5, 10, 20]"
		      layout="total, sizes, prev, pager, next, jumper"
		      :total="total">
		    </el-pagination>
    </div>
          </div>
</template>
<script>
export default {
  name:'offer',
  data(){
    return{
      selectParams:[],
      tableData:[],
      total:0,
    }
  }
}
</script>
<style>

</style>


