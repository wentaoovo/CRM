<template>
  <div style="padding: 10px;">
	  <div style="margin: 10px  0;  ">
	  		  <el-form :inline="true" v-model="selectParams">
						<el-form-item label="对应客户">
							<el-input v-model="selectParams.corrCustomers" placeholder="对应客户" size="medium" style="width:140px" clearable></el-input>
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
		<div style="margin: 10px  0; text-align: right;">
			 <el-button  @click="add()">新增</el-button>
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
			<template slot-scope="scope">
				<el-tag v-if="scope.row.state==1" type="success">已处理</el-tag>
				<el-tag  type="danget" v-else>未处理</el-tag>
			</template>
		</el-table-column>
		<el-table-column
		  prop="realName"
		  label="负责人">
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
					<el-row :gutter="20">
						<el-col :span="12" :offset="0">
							<el-button size="mini" @click="handleChuli()">处理</el-button>
						</el-col>
						<el-col :span="12" :offset="0">
								<el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
						</el-col>
					</el-row>
					
	        <!-- <el-button size="mini" @click="handleEdit(scope.row)">编辑</el-button>
					<el-button ></el-button> -->
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
		      :page-sizes="[5, 10, 20]"
		      layout="total, sizes, prev, pager, next, jumper"
		      :total="total">
		    </el-pagination>
			</div>
					<el-dialog title="我是一个全能表单" :visible.sync="dialogFormVisible">
      <el-form :model="form">
    <el-form-item label="采集内容" style="width: 80%">
			          <el-input v-model="form.collectionContent"></el-input>
			        </el-form-item>
					<el-form-item label="公司" style="width: 80%">
					  <el-input v-model="form.company"></el-input>
					</el-form-item>
					<el-form-item label="对应客户" style="width: 80%">
					  <el-input v-model="form.corrCustomers"></el-input>
					</el-form-item>
					<el-form-item label="成本" style="width: 80%">
					  <el-input v-model="form.cost"></el-input>
					</el-form-item>
					<!-- <el-form-item label="状态" style="width: 80%">
					  <el-radio-group  v-model="form.state" >
							<el-radio label="1">
								已处理
							</el-radio>
							<el-radio   label="0">
								未处理
							</el-radio>
						</el-radio-group>
						
					</el-form-item> -->
					<el-form-item label="负责人" style="width: 80%">
				<el-select v-model="form.realName" placeholder="请选择负责人">
      <el-option label="xxw" value="xxw"></el-option>
      <el-option label="hwt" value="hwt"></el-option>
    </el-select>
					</el-form-item>
				<el-form-item label="联系人" style="width: 80%">
				 <el-select v-model="form.contacts" placeholder="请选择联系人" style="80%">
      <el-option label="xxw" value="xxw"></el-option>
      <el-option label="xxwww" value="xxwww"></el-option>
    </el-select>
					</el-form-item>
					<el-form-item label="联系方式" style="width: 80%">
					  <el-input v-model="form.contactsInformation"></el-input>
					</el-form-item>
					<el-form-item label="分类" style="width: 80%">
				<el-select v-model="form.classification" placeholder="请选择分类" style="80%">
      <el-option label="录入" value="录入"></el-option>
      <el-option label="采集录入" value="采集录入"></el-option>
    </el-select>
					</el-form-item>
					<el-form-item label="创建时间" style="width: 80%">
					   <el-date-picker v-model="form.subTime" value-format="yyyy-MM-dd" type="date" placeholder="选择日期" style="width: 80%;" clearable></el-date-picker>
					</el-form-item>
  </el-form>
  <div slot="footer" class="dialog-footer">
    <span class="dialog-footer">
					        <el-button @click="dialogFormVisible = false">取 消</el-button>
					        <el-button type="primary" @click="save()">确 定</el-button>
					      </span>
  </div>
</el-dialog>
  </div>

	
</template>

<script>
import { getList, addall, enit } from "@/api/indexes.js";
export default {
  name: "indesex",
  data() {
    return {
      form: {},
      dialogFormVisible: false,
      tableData: [],
      total: 0,
      selectParams: {},
			radio: "1",
			dialogVisible:false
    };
  },
  created() {
    this.selectParams.pageNum = 1;
    this.selectParams.pageSize = 10;
    this.load();
  },

  methods: {
    //分页模糊查询
    async load() {
      let {
        pageNum,
        pageSize,
        keyword,
        corrCustomers,
        realName,
        contacts
      } = this.selectParams;
      const { data: ListRes } = await getList({
        pageNum: pageNum,
        pageSize: pageSize,
        keyword: keyword,
        corrCustomers: corrCustomers,
        realName: realName,
        contacts: contacts
      });
      this.tableData = ListRes.list;
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
    onsumbit() {
      this.load();
		},
		save(){
			if(this.form.id){
				enit(this.form).then(res=>{
					if(res.code==200){
						this.$message({
							message:'修改成功',
							type:'success'
						})
					}else{
							this.$message({
							message:res.message,
							type:'error'
						})
					}
					this.dialogFormVisible=false
					this.load()
				})
			}else{
			addall(this.form).then(res=>{
				if(res.code==200){
				this.$message({
					message:'新增成功',
					type:'success'
				})
				}else{
					this.$message({
						message:res.message,
						type:'error'
					})
				}
					this.dialogFormVisible=false
					this.load()
			})
			}

		},
    async add() {
			this.dialogFormVisible = true;
			this.form={}
		},
		handleEdit(row){
			this.form= JSON.parse(JSON.stringify(row))
			this.dialogFormVisible=true
		},
		handleChuli(){
			this.dialogVisible=true
		}
  }
};
</script>

<style>
</style>
