<template>
    <div style="padding:10px;">
      	  <div style="margin: 10px  0;  ">
	  		  <el-form :inline="true" v-model="selectParams">
						<el-form-item label="生命周期">
							<el-input v-model="selectParams.lifeCycle" placeholder="生命周期" size="medium" style="width:140px" clearable></el-input>
						</el-form-item>
						<!-- <el-form-item label="负责人">
							<el-input v-model="selectParams.realName" placeholder="所有者" size="medium" style="width:140px" clearable></el-input>
						</el-form-item>
						<el-form-item label="联系人">
						</el-form-item> -->
						<el-form-item>
							<el-button type="primary" @click="onsumbit" icon="el-icon-search" style="margin-left: 20px;">查询</el-button>
						</el-form-item>
					</el-form>
					
	  </div>
 <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="id"
        label="ID">
      </el-table-column>
      <el-table-column
        prop="name"
        label="姓名">
      </el-table-column>
      <el-table-column
        prop="type"
        label="种类">
      </el-table-column>
        <el-table-column
        prop="lifeCycle"
        label="生命周期">
      </el-table-column>
        <el-table-column
        prop="firstSigning"
        label="创建时间">
      </el-table-column>
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
import { getList} from "@/api/custmenrt.js";
export default {
    name:"custmenrt",
    data(){
        return{
            tableData:[],
            total:0,
            selectParams:{}
        }

    },
    created() {
    this.selectParams.pageNum = 1;
    this.selectParams.pageSize = 10;
    this.load();
  },

methods:{
 async load(){
        let{
        pageNum,
        pageSize,
        keyword,
        type,
        lifeCycle,
        name
                }=this.selectParams;
                const{data:ListRes}=await getList({
                    pageNum:pageNum,
                    pageSize:pageSize,
                    keyword:keyword,
                    type:type,
                    lifeCycle:lifeCycle,
                    name:name
                });
                this.tableData=ListRes.list;
                this.total = ListRes.total;
            },
    handleSizeChange(pageSize) {
      this.selectParams.pageSize = pageSize;
      this.load();
    },
     handleCurrentChange(pageNum) {
      this.selectParams.pageNum = pageNum;
      this.load();
    },
    onsumbit(){
      this.load();
    }
        }
}
</script>
<style>

</style>


