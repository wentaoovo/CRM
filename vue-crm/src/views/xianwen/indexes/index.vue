<template>
<div style="padding:10px;">
        <div style="margin: 10px  0;  ">
	  		  <el-input v-model="indexesSearchVo.search" placeholder="请输入内容" style="width: 20%;" clearable></el-input>
	  		  <el-button style="margin-left: 5px;" type="primary" @click="load()">查询</el-button>
	  </div>
        <el-table
	    :data="tableData"
	    border
	    style="width: 100%">
	    <el-table-column
	      prop="id"
	      label="ID"
	      sortable>
	    </el-table-column>
		<el-table-column
		  prop="collectionContent"
		  label="采集内容">
		</el-table-column>
		<el-table-column
		  prop="company"
		  label="公司">
		</el-table-column>
		<el-table-column
		  prop="corrCustomers"
		  label="对应客户">
		</el-table-column>
		<el-table-column
		  prop="cost"
		  label="成本">
		</el-table-column>
		<el-table-column
		  prop="state"
		  label="状态">
		</el-table-column>
		<el-table-column
		  prop="realName"
		  label="所有者">
		</el-table-column>
		<el-table-column
		  prop="contacts"
		  label="联系人">
		</el-table-column>
		<el-table-column
		  prop="contactsInformation"
		  label="联系方式">
		</el-table-column>
		<el-table-column
		  prop="classification"
		  label="分类">
		</el-table-column>
		<el-table-column
		  prop="subTime"
		  label="创建时间">
		</el-table-column>
	     <el-table-column label="操作">
	      <template #default="scope">
	        <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
<!-- 			<el-popconfirm title="确定删除吗" @confirm="handleDelete(scope.row.id)">
				<template #reference>
					<el-button size="mini" type="danger">删除</el-button>
				</template>
			</el-popconfirm> -->
	      </template>
	    </el-table-column>
	  </el-table>
		<div style="margin: 10px 0;">
		 <el-pagination
		      @size-change="handleSizeChange"
		      @current-change="handleCurrentChange"
		      :current-page="indexesSearchVo.currentPage"
		      :page-sizes="[5, 10, 20]"
		      :page-size="indexesSearchVo.pageSize"
		      layout="total, sizes, prev, pager, next, jumper"
		      :total="indexesSearchVo.total">
		    </el-pagination>
            </div>
    </div>
</template>

<script>
import indesexApi from "@/api/indexes.js"
export default{
    name:'indesex',
    data(){
        return{
            tableData:[],
            total:0,
            indexesSearchVo:{
            currentPage:1,
            pageSize:10,
            search:'',
            }
        }
    },
    created(){
        this.load()
    },

    methods:{
        load(){
            console.log("sssssssssssssssssssssssssssss")
            indesexApi.getList(this.indexesSearchVo).then(res =>{
                console.log(res);
                
            })
        },
        handleSizeChange(){},
        handleCurrentChange(){},
    }
}
</script>

<style>

</style>
