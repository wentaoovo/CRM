<template>

    <div style="padding:10px;">
      	 <div class="lable-titi">
         <div>
           <el-select v-model="value" @change="classChange"  placeholder="请选择">
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
          <div class="lable-input">
          <el-form :inline="true" v-model="selectParams">
            <el-form-item label="生命周期">
							<el-input v-model="selectParams.lifeCycle" placeholder="生命周期" size="medium" style="width:140px" clearable></el-input>
						</el-form-item>
            <el-form-item>
							<el-button type="primary" @click="onsumbit" icon="el-icon-search" style="margin-left: 20px;">查询</el-button>
						</el-form-item>
          </el-form>
          </div>
         </div>
          <!-- <div class="lable-input">
            <el-input
                placeholder="搜索一下"
                suffix-icon="el-icon-search"
                v-model="input"
                style="width:200px;top: 10px"
                @change="checkChange"
              ></el-input>
          </div> -->
      </div>
      		<div style="margin: 10px  0; text-align: right;">
			 <el-button  @click="add()">新增</el-button>
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
        prop="realName"
        label="负责人">
      </el-table-column>
        <el-table-column
        prop="lifeCycle"
        label="生命周期">
      </el-table-column>
        <el-table-column
        prop="firstSigning"
        label="创建时间">
      </el-table-column>
      	     <el-table-column label="操作">
	      <template #default="scope">
					<el-row :gutter="20">
						<el-col :span="12" :offset="0">
					<el-button size="mini" type="danger" @click="handleDelete(scope.row.id)">删除</el-button>
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
    <el-dialog title="创建客户" :visible.sync="dialogFormVisible" width="1200px">
      <el-row :gutter="15">
      <el-form :model="form" label-width="100px" :rules="rules" ref="form">
        <el-col :span="24" >
          <el-form-item label="客户名称:" prop="name">
            <el-input v-model="form.name"  placeholder="客户姓名"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公司:" prop="company">
            <el-input v-model="form.company"  placeholder="公司名称"></el-input>
          </el-form-item>
        </el-col>
                <el-col :span="12">
          <el-form-item label="来源:" prop="source">
          <el-select v-model="form.source">
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
          <el-form-item label="电话:" prop="telephone">
            <el-input v-model="form.telephone"  placeholder="电话号码"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="手机:" prop="mobilePhone">
            <el-input v-model="form.mobilePhone" placeholder="手机号码"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
           <el-form-item label="种类:" prop="source">
          <el-select v-model="form.type">
                <el-option
                  v-for="item in type"
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
          <el-form-item label="生命周期:" prop="lifeCycle">
              <el-radio v-model="form.lifeCycle" label="潜在">潜在</el-radio>
              <el-radio v-model="form.lifeCycle" label="签约">签约</el-radio>
              <el-radio v-model="form.lifeCycle" label="重复购买">重复购买</el-radio>
              <el-radio v-model="form.lifeCycle" label="失效">失效</el-radio>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="备注:" prop="remarks">
            <el-input type="textarea" v-model="form.remarks" placeholder="备注"></el-input>
          </el-form-item>
        </el-col>
  </el-form>
      </el-row>
  <div slot="footer" class="dialog-footer">
    <span class="dialog-footer">
					        <el-button @click="dialogFormVisible = false">取 消</el-button>
					        <el-button type="primary" @click="save()">确 定</el-button>
					      </span>
  </div>
</el-dialog>
  <el-dialog title="基本信息" :visible.sync="dialogVisible" width="80%">
    <el-row :gutter="15">
      <el-form :model="form" label-width="100px" :rules="rules">
        <el-col :span="24" >
          <el-form-item label="客户名称:" prop="name">
            <el-input v-model="form.name"  placeholder="客户姓名"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="公司:" prop="company">
            <el-input v-model="form.company"  placeholder="公司名称"></el-input>
          </el-form-item>
        </el-col>
                <el-col :span="12">
          <el-form-item label="来源:" prop="source">
          <el-select v-model="form.source">
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
          <el-form-item label="电话:" prop="telephone">
            <el-input v-model="form.telephone"  placeholder="电话号码"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="手机:" prop="mobilePhone">
            <el-input v-model="form.mobilePhone" placeholder="手机号码"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
           <el-form-item label="种类:" prop="source">
          <el-select v-model="form.type">
                <el-option
                  v-for="item in type"
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
          <el-form-item label="生命周期:" prop="lifeCycle">
              <el-radio v-model="form.lifeCycle" label="潜在">潜在</el-radio>
              <el-radio v-model="form.lifeCycle" label="签约">签约</el-radio>
              <el-radio v-model="form.lifeCycle" label="重复购买">重复购买</el-radio>
              <el-radio v-model="form.lifeCycle" label="失效">失效</el-radio>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="首次签约:" prop="firstSigning">
            <el-date-picker v-model="form.firstSigning" value-format="yyyy-MM-dd" type="date" placeholder="选择日期" style="width:80%" clearable></el-date-picker>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="行用等级:" prop="lifeCycle">
              <el-radio v-model="form.creditLevel" label="高">高</el-radio>
              <el-radio v-model="form.creditLevel" label="中">中</el-radio>
              <el-radio v-model="form.creditLevel" label="低">低</el-radio>
          </el-form-item>
        </el-col>
                <el-col :span="12">
           <el-form-item label="结款方式:" prop="settlementMethod">
          <el-select v-model="form.settlementMethod">
                <el-option
                  v-for="item in settle"
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
           <el-form-item label="价格策略:" prop="priceStrategy">
          <el-select v-model="form.priceStrategy">
                <el-option
                  v-for="item in price"
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
           <el-form-item label="行业:" prop="industry">
          <el-select v-model="form.industry">
                <el-option
                  v-for="item in industry"
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
           <el-form-item label="人员规模:" prop="personnelSize" >
          <el-select v-model="form.personnelSize">
                <el-option
                  v-for="item in personnelSize"
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
          <el-form-item label="淘宝编号:" prop="taobaoNumber">
            <el-input v-model="form.taobaoNumber" placeholder="淘宝编号"></el-input>
          </el-form-item>
        </el-col>
          <el-col :span="12">
          <el-form-item label="京东编号:" prop="jingdongNumber">
            <el-input v-model="form.jingdongNumber" placeholder="京东编号"></el-input>
          </el-form-item>
        </el-col>
          <el-col :span="12">
          <el-form-item label="易订货编号:" prop="yidinghuoNumber">
            <el-input v-model="form.yidinghuoNumber" placeholder="易订货编号"></el-input>
          </el-form-item>
        </el-col>
                  <el-col :span="12">
          <el-form-item label="天猫编号:" prop="tianmaoNumber">
            <el-input v-model="form.tianmaoNumber" placeholder="天猫编号"></el-input>
          </el-form-item>
        </el-col>
          <el-col :span="24">
          <el-form-item label="公司简介:" prop="companyProfile">
            <el-input type="textarea" v-model="form.companyProfile" placeholder="公司简介"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="网站:" prop="website">
            <el-input v-model="form.website" placeholder="网站"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="省:" prop="province">
            <el-input v-model="form.province" placeholder="省"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="市:" prop="city">
            <el-input v-model="form.city" placeholder="市"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="区:" prop="area">
            <el-input v-model="form.area" placeholder="区"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="6">
          <el-form-item label="邮编:" prop="postcode">
            <el-input v-model="form.postcode" placeholder="邮编"></el-input>
          </el-form-item>
        </el-col>
          <el-col :span="24">
          <el-form-item label="地址:" prop="address">
            <el-input v-model="form.address" placeholder="地址"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="备注:" prop="remarks">
            <el-input type="textarea" v-model="form.remarks" placeholder="备注"></el-input>
          </el-form-item>
        </el-col>
  </el-form>
      </el-row>
    <div slot="footer" class="dialog-footer">
    <span class="dialog-footer">
      <el-button @click="dialogVisible = false">取消</el-button>
      <el-button type="primary" @click="updata()">保存</el-button>
    </span>
    </div>
  </el-dialog>
  
    </div>
</template>
<script>
import { getList,addall,enit,delect} from "@/api/custmenrt.js";
export default {
    name:"custmenrt",
    data(){
        return{
          rules:{
            name:[
              {required: true, message: '请输入客户名称', trigger: 'blur'}
            ],
            telephone:[
              {min:11,max:11,message:'请输入正确的电话号码'}
            ],
            mobilePhone:[
              {min:11,max:11,message:'请输入正确的手机号码'}
            ],
            source:[
              {required: true,message:'请选择种类', trigger:'blur'}
            ]
          },
            tableData:[],
            total:0,
            selectParams:{},
            dialogVisible:false,
            input:'',
            dialogFormVisible:false,
            form:{},
            options:[
              {
            options:[{
                value: '全部数据',
                label: '全部数据',
            }]
              },
              {
                label:'种类',
                options:[
                  {
                    value:'客户',
                    label:'客户'
                  },
                  {
                    value:'合作伙伴',
                    label:'合作伙伴'
                  },
                ]
              },
              // {
              //   label:'生命周期',
              //   options:[
              //     {
              //       value:'潜在',
              //       label:'潜在'
              //     },
              //     {
              //       value:'签约',
              //       label:'签约'
              //     },
              //     {
              //       value:'重复购买',
              //       label:'重复购买'
              //     },
              //     {
              //       value:'失效',
              //       label:'失效'
              //     }
              //   ]
              // }
            ],
            value:'全部数据',
            index:[
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
                value:'其他',
                label:'其他'
              }
            ],
            type:[
             {
                value:'',
                label:''
              },
              {
                value:'客户',
                label:'客户'
              },
              {
                value:'供应商',
                label:'供应商'
              },
            ],
            settle:[
             {
                value:'',
                label:''
              },
              {
                value:'现款现货',
                label:'现款现货'
              },
              {
                value:'货到付款',
                label:'货到付款'
              },
              {
                value:'先款后货',
                label:'先款后货'
              },
              {
                value:'账期收款',
                label:'账期收款'
              }
            ],
            price:[
             {
                value:'',
                label:''
              },
              {
                value:'零食价',
                label:'零食价'
              },
              {
                value:'阿达价格',
                label:'阿达价格'
              },
            ],
            industry:[
             {
                value:'',
                label:''
              },
              {
                value:'商业',
                label:'商业'
              },
              {
                value:'工业',
                label:'工业'
              },
               {
                value:'服务业',
                label:'服务业'
              },
              {
                value:'其他',
                label:'其他'
              },
            ],
            personnelSize:[
             {
                value:'',
                label:''
              },
              {
                value:'10人以内',
                label:'10人以内'
              },
              {
                value:'10-20人',
                label:'10-20人'
              },
               {
                value:'20-50人',
                label:'20-50人'
              },
              {
                value:'50-200人',
                label:'50-200人'
              },
              {
                value:'200人以上',
                label:'200人以上'
              },
            ]
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
    },
    classChange(model){
      if(model=='全部数据'){
        this.selectParams.type=null
        this.selectParams.lifeCycle=null
      }else if(model.value=='客户'){
        this.selectParams.lifeCycle=model
        this.selectParams.type=null
      }else{
        this.selectParams.lifeCycle=null
        this.selectParams.type=model
      }
      this.load()
    },
      checkChange(keyword){
          this.selectParams.keyword = keyword
          this.load()
        },
      async add() {
			this.dialogFormVisible = true;
			this.form={}
    },
    handleEdit(row){
      this.form= JSON.parse(JSON.stringify(row))
      this.dialogVisible=true
    },
    onsumbit(){
        this.load();
    },
    save(){
      this.$refs['form'].validate((valid)=>{
        if(valid){
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
      })
    },
    updata(){
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
        this.dialogVisible=false
        this.load()
      })
    },
    handleDelete(data){
      this.$confirm('此操作将永久删除该客户, 是否继续?', '提示',{
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
          }else{
          this.$message({
          message:res.message,
          type:'error'
          })
          }
        })
        this.load()
      }).catch(()=>{
            this.$message({
              type: 'info',
              message: '已取消删除',
            })
      })
    }
        }
}
</script>
<style>
.lable-titi{
  color: #606266;
  font-size: 14px;
}
.lable-input{
  position: absolute;
  margin-top: 10px;
  left: 250px;
    top: 0.5px;
}
.dashboard-container{
  background: #efefef;
}
</style>


