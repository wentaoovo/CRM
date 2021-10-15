<template>
  <div style="padding:10px;">
    <div class="lable-titisd">
         <div>
           <el-select v-model="value" @change="classChange" style="width:150px;left: 20px;top: 10px" placeholder="请选择">
            <el-option-group
              v-for="group in options"
              :key="group.label"
              :label="group.label"
            >
              <el-option
                v-for="item in group.options"
                :key="item.value"
                :label="item.label"
                :value="item.value"
              >
              </el-option>
            </el-option-group>
          </el-select>
         </div>
         <div>
          <div class="lable-inputhd">
          <el-form :inline="true" v-model="selectParams">
            <el-form-item label="机会主题">
							<el-input v-model="selectParams.opportunityTheme" placeholder="主题" size="medium" style="width:140px" clearable></el-input>
						</el-form-item>
            <el-form-item>
							<el-button type="primary" @click="onsumbit" icon="el-icon-search" style="margin-left: 20px;"></el-button>
						</el-form-item>
          </el-form>
          </div>
         </div>
      </div>
            <div style="margin: 10px  0; text-align: right;">
			 <el-button  @click="add()">新增</el-button>
       <el-button>更多</el-button>
       
		</div>
    <el-table  :data="tableData" style="width: 100%">
          <el-table-column prop="id"  label="id"></el-table-column>
          <el-table-column prop="opportunityTheme" label="机会主题" sortable></el-table-column>
          <el-table-column prop="customerName" label="客户" width="130" sortable></el-table-column>
          <el-table-column prop="salesType" label="销售类型" sortable></el-table-column>
          <el-table-column prop="realName" label="负责人" sortable width="120"></el-table-column>
          <el-table-column prop="signingDate"  label="预计签单日期" width="120" sortable></el-table-column>
          <el-table-column prop="estimatedAmount" label="预计金额" width="120"></el-table-column>
          <el-table-column prop="state" label="状态" width="110" sortable>
            <template #default="scope">
               {{scope.row.state == 0? '跟踪':''}}{{scope.row.state == 1? '成功':''}}{{scope.row.state == 2? '失败':''}}
            </template>
          </el-table-column>
          <el-table-column prop="possibility" label="可能性" width="120"></el-table-column>
          <el-table-column prop="updateDate"  label="更新日期"  width="120"  sortable></el-table-column>
                	     <el-table-column label="操作">
	      <template #default="scope">
					<el-row :gutter="20">
						<el-col :span="12" :offset="0">
					<el-button size="mini"  icon="el-icon-delete-solid" @click="Delete(scope.row.id)"></el-button>
						</el-col>
						<el-col :span="12" :offset="0">
								<el-button size="mini" icon="el-icon-edit" @click="handleEdit(scope.row)"></el-button>
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
    <el-dialog title="创建报价" :visible.sync="dialogFormVisible" width="1200px">
      <el-row :gutter="15">
        <el-form :model="form" label-width="100px">
       <el-col :span="24">
        <el-form-item>
        <div class="aaa"> 
        <span>机会</span>
        </div>
          </el-form-item>
        </el-col>
          <el-col :span="12">
            <el-form-item label="主题" prop="opportunityTheme">
              <el-input v-model="form.opportunityTheme" placeholder="主题"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
					<el-form-item label="更新日期" prop="updateDate">
					   <el-date-picker v-model="form.updateDate" value-format="yyyy-MM-dd" type="date" placeholder="选择日期" disabled  clearable></el-date-picker>
					</el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="客户:" prop="customerName">
            <el-select v-model="form.customerName"
            value-key="id"
            placeholder="请选择对应客户">
            <el-option v-for="item in curr" :key="item" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          </el-col>
            <el-col :span="12">
            <el-form-item label="状态" prop="state">
              <el-radio v-model="form.state" label="1">跟踪</el-radio>
              <el-radio v-model="form.state" label="2">成功</el-radio>
              <el-radio v-model="form.state" label="3">失败</el-radio>
            </el-form-item>
          </el-col>
        <el-col :span="24">
        <el-form-item>
        <div class="aaa"> 
        <span>基本情况</span>
        </div>
          </el-form-item>
        </el-col>
        <el-col :span="12">
            <!-- <el-form-item label="接收人" prop="contactsName">
              <el-input v-model="form.contactsName" placeholder="接收人"></el-input>
            </el-form-item> -->
            <el-form-item label="联系人:" prop="contactsName">
            <el-select v-model="form.contactsName"
            value-key="id"
            placeholder="选择联系人">
            <el-option v-for="item in name" :key="item" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="类型:" prop="salesType">
          <el-select v-model="form.salesType">
                <el-option
                  v-for="item in index"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                  :disabled="item.disabled"
                >
                </el-option>
              </el-select>
          </el-form-item>
        </el-col>
          <el-col :span="12">
					<el-form-item label="发现时间" prop="findDate">
					   <el-date-picker v-model="form.findDate" value-format="yyyy-MM-dd" type="date" placeholder="选择日期"   clearable></el-date-picker>
					</el-form-item>
          </el-col>
           <el-col :span="12">
          <el-form-item label="来源:" prop="source">
          <el-select v-model="form.source">
                <el-option
                  v-for="item in indexs"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                  :disabled="item.disabled"
                >
                </el-option>
              </el-select>
          </el-form-item>
        </el-col>
          <el-col :span="24">
            <el-form-item label="客户需求" prop="customerDemand">
              <el-input  type="textarea" v-model="form.customerDemand" placeholder="客户需求"></el-input>
            </el-form-item>
          </el-col>
        <el-col :span="24">
        <el-form-item>
        <div class="aaa"> 
        <span>预期</span>
        </div>
          </el-form-item>
        </el-col>
          <el-col :span="12">
					<el-form-item label="预计签单时间" prop="signingDate">
					   <el-date-picker v-model="form.signingDate" value-format="yyyy-MM-dd" type="date" placeholder="预计签单时间" clearable></el-date-picker>
					</el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="可能性:" prop="possibility">
          <el-select v-model="form.possibility">
                <el-option
                  v-for="item in indexes"
                  :key="item.value"
                  :label="item.label"
                  :value="item.value"
                  :disabled="item.disabled"
                >
                </el-option>
              </el-select>
          </el-form-item>
        </el-col>
           <el-col :span="12">
            <el-form-item label="预计金额" prop="estimatedAmount">
              <el-input  v-model="form.estimatedAmount" placeholder="预计金额"></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
      <div slot="footer" class="dialog-footer">
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible= false">Cancel</el-button>
        <el-button type="primary" @click="save()">OK</el-button>
      </span>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { getList,addall,enit,delect,selectt,selects} from "@/api/sales.js";
import { option } from 'runjs';
export default {
    name:'sales'  ,
    data(){
      return{
     tableData:[],
     dialogFormVisible:false,
    selectParams:{},
      total:0,
      curr:[],
      input:'',
      name:[],
      form:{},
      options:[
        {
          options:[
            {
          value:'全部数据',
          label:'全部数据'
            }
          ]
        },
        {
          label:'状态',
          options:[
            {
              value:'0',
              label:'跟踪'
            },
            {
              value:'1',
              label:'成功'
            },
            {
              value:'2',
              label:'失败'
            },
          ]
        }
      ],
      value:'全部数据',
      index:[
        {
          value:'',
          label:''
        },
        {
          value:'办公建筑',
          label:'办公建筑'
        },
        {
          value:'住宅建筑',
          label:'住宅建筑'
        },
        {
          value:'商业建筑',
          label:'商业建筑'
        },
        {
          value:'医疗教育',
          label:'医疗教育'
        },
        {
          value:'文化健身',
          label:'文化健身'
        },
      ],
      indexs:[
         {
          value:'',
          label:''
        },
         {
          value:'电话来访',
          label:'电话来访'
        },
         {
          value:'客户介绍',
          label:'客户介绍'
        },
         {
          value:'独立开发',
          label:'独立开发'
        },
         {
          value:'媒体宣传',
          label:'媒体宣传'
        },
         {
          value:'促销活动',
          label:'促销活动'
        },
         {
          value:'老客户',
          label:'老客户'
        },
         {
          value:'代理商',
          label:'代理商'
        },
         {
          value:'合作伙伴',
          label:'合作伙伴'
        },
         {
          value:'其他',
          label:'其他'
        },
      ],
      indexes:[
        {
          value:'',
          label:''
        },
        {
          value:'0',
          label:'0'
        },
        {
          value:'10%',
          label:'10%'
        },
        {
          value:'20%',
          label:'20%'
        },
        {
          value:'30%',
          label:'30%'
        },
        {
          value:'40%',
          label:'40%'
        },
        {
          value:'50%',
          label:'50%'
        },
        {
          value:'60%',
          label:'60%'
        },
        {
          value:'70%',
          label:'70%'
        },
        {
          value:'80%',
          label:'80%'
        },
        {
          value:'90%',
          label:'90%'
        },
        {
          value:'100%',
          label:'100%'
        },
        
      ]
      }
    },
    created() {
    this.selectParams.pageNum = 1;
    this.selectParams.pageSize = 10;
    this.load();
    this.first();
    this.find();
  },
    methods:{
       async load(){
       let{
        pageNum,
        pageSize,
        keyword,
        state,
        opportunityTheme
       }=this.selectParams;
       const{data:ListRes}=await getList({
         pageNum:pageNum,
         pageSize:pageSize,
         keyword:keyword,
         state:state,
         opportunityTheme:opportunityTheme
       });
       this.tableData=ListRes.list;
       this.total=ListRes.total;
     },
         handleSizeChange(pageSize) {
      this.selectParams.pageSize = pageSize;
      this.load();
    },
     handleCurrentChange(pageNum) {
      this.selectParams.pageNum = pageNum;
      this.load();
    },
      checkChange(keyword){
      this.selectParams.keyword = keyword
      this.load();
        },
        classChange(e){
          var reg = /^\d+(?=\.{0,1}\d+$|$)/
          if(e == '全部数据'){
            this.selectParams.state = null
          }
          else if(reg.test(e)){
            this.selectParams.state = e
          }
          this.load()
        },
      onsumbit(){
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
    handleEdit(row){
			this.form= JSON.parse(JSON.stringify(row))
			this.dialogFormVisible=true
    },
    Delete(data){
      this.$confirm('此操作将永久删除该报价单, 是否继续?', '提示',{
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
      }).then(()=>{
        delect(data).then(res=>{
          if(res.code==200){
            this.$message({
           message:'删除成功',
           type:'success'
          });
          }else
          this.$message({
          message:res.message,
          type:'error'
          })
        })
        this.load()
      }).catch(()=>{
            this.$message({
              type: 'info',
              message: '已取消删除',
            })
      })
    },
      add(){
    this.dialogFormVisible=true
    this.form={}
  },
      first(){
      selectt().then(res=>{
        this.name=res.data
        console.log(res.data)
      })
  },
    find(){
      selects().then(res=>{
        this.curr=res.data
        console.log(res.data)
      })
  }
    }
}
</script>
<style>
.lable-titisd{
  color: #606266;
  font-size: 14px;
}
.lable-inputhd{
  position: absolute;
  left: 220px;
    top: 20px;
}
.aaa{
  text-align: center;
    position: relative;
    color: #000000;
    font-weight: bold;
}
</style>


