<template>
  <div style="padding:10px;">
    <div class="lable-titi">
         <div>
          <div>
          <el-form :inline="true" v-model="selectParams">
            <!-- <el-form-item label="转成订单">
              <el-input v-model="selectParams.orderConcert" placeholder="转成订单" size="medium" style="width:140px" clearable></el-input>
            </el-form-item> -->
            <el-form-item label="主题">
							<el-input v-model="selectParams.quotationTheme" placeholder="主题" size="medium" style="width:140px" clearable></el-input>
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
       
		</div>
    <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="id"
        label="Id">
      </el-table-column>
      <el-table-column
        prop="quotationTheme"
        label="主题">
      </el-table-column>
      <el-table-column
        prop="timeNow"
        label="日期">
      </el-table-column>
      <el-table-column
        prop="salesName"
        label="销售机会">
      </el-table-column>
      <el-table-column
        prop="customerName"
        label="客户">
      </el-table-column>
      <el-table-column
        prop="totalQuotation"
        label="报价">
      </el-table-column>
      <el-table-column
        prop="contactsName"
        label="接收人">
      </el-table-column>
      <el-table-column
        prop="employeeName"
        label="报价人">
      </el-table-column>
      <el-table-column
        prop="employeeContactWay"
        label="报价人联系方式">
      </el-table-column>
      	     <el-table-column label="操作">
	      <template #default="scope">
					<el-row :gutter="20">
          <el-col :span="6" :offset="0">
					<el-button size="mini"  icon="el-icon-view" @click="selecto(scope.row.id)"></el-button>
					</el-col>
						<el-col :span="6" :offset="0">
					<el-button size="mini"  icon="el-icon-delete-solid" @click="Delete(scope.row.id)" ></el-button>
						</el-col>
						<el-col :span="6" :offset="0">
								<el-button size="mini" icon="el-icon-edit" @click="handleEdit(scope.row)" v-if="scope.row.orderConcert=='0'||scope.row.orderConcert=='1'" ></el-button>
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
      <div  style="margin: 10px  0; text-align: right;" v-if="CanAddTip">
        <el-button @click="saveOrder()">转成订单</el-button>
      </div>
      <el-row :gutter="15">
        <el-form :model="form" label-width="100px" :rules="rules" ref="form">
          <el-col :span="12">
            <el-form-item label="主题" prop="quotationTheme">
              <el-input v-model="form.quotationTheme" placeholder="主题"></el-input>
            </el-form-item>
          </el-col>
          <!-- <el-col :span="12">
            <el-form-item label="转成订单" prop="orderConcert">
              <el-radio-group v-model="form.orderConcert">
              <el-radio :label="'0'">可见</el-radio>
              <el-radio :label="'1'">转成订单</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col> -->
          <el-col :span="12">
          <el-form-item label="客户:" prop="customerName">
            <el-select v-model="form.customerName"
            value-key="id"
            placeholder="请选择对应客户" @change="changee($event)">
            <el-option v-for="item in curr" :key="item.id" :label="item.name" :value="{name:item.name,id:item.id}"></el-option>
            </el-select>
          </el-form-item>
          </el-col>
          <el-col :span="12">
					<el-form-item label="日期" prop="timeNow">
					   <el-date-picker v-model="form.timeNow" value-format="yyyy-MM-dd" type="date" placeholder="选择日期"  clearable></el-date-picker>
					</el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="报价" prop="totalQuotation">
              <el-input v-model="form.totalQuotation" placeholder="报价"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
          <el-form-item label="销售机会:" prop="chanceName">
            <el-select v-model="form.chanceName"
            value-key="id"
            placeholder="请选择销售机会" @change="changer($event)">
            <el-option v-for="item in the" :key="item.id" :label="item.opportunity_theme" :value="{name:item.opportunity_theme,id:item.id}"></el-option>
            </el-select>
          </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="预估毛利" prop="grossProfit">
              <el-input v-model="form.grossProfit" placeholder="预估毛利" disabled></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <!-- <el-form-item label="接收人" prop="contactsName">
              <el-input v-model="form.contactsName" placeholder="接收人"></el-input>
            </el-form-item> -->
            <el-form-item label="接收人:" prop="contactsName">
            <el-select v-model="form.contactsName"
            value-key="id"
            placeholder="请选择接收人" @change="changes($event)">
            <el-option v-for="item in name" :key="item.id" :label="item.contacts_name" :value="{name:item.contacts_name,id:item.id}"></el-option>
            </el-select>
          </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="报价人联系方式" prop="employeeContactWay">
              <el-input v-model="form.employeeContactWay" placeholder="报价人联系方式"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="支付说明" prop="deliverInstructions">
              <el-input type="textarea" v-model="form.deliverInstructions" placeholder="支付说明" ></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="付款说明" prop="paymentInstructions">
              <el-input type="textarea" v-model="form.paymentInstructions" placeholder="付款说明" ></el-input>
            </el-form-item>
          </el-col>
           <el-col :span="24">
            <el-form-item label="包装说明" prop="packingInstructions">
              <el-input type="textarea" v-model="form.packingInstructions" placeholder="包装说明" ></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注" prop="remarks">
              <el-input type="textarea" v-model="form.remarks" placeholder="备注" ></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
            <div slot="footer" class="dialog-footer">
      <span class="dialog-footer">
        <div style="margin: 10px  0; text-align: left;"  v-if="CanAddTip" >
        <el-button class="butter"  @click="saveOrder()">转成订单</el-button>
        </div>
        <el-button @click="dialogFormVisible= false">取消</el-button>
        <el-button type="primary" @click="save()">保存</el-button>
      </span>
      </div>
    </el-dialog>
     <el-dialog title="基本信息" :visible.sync="formVisible" width="1200px">
      <el-row :gutter="15">
        <el-form :model="formData" label-width="100px" ref="formData">
            <el-col :span="12">
            <el-form-item label="主题" prop="quotationTheme">
              <el-input v-model="formData.quotationTheme" placeholder="主题" disabled></el-input>
            </el-form-item>
          </el-col>
            <el-col :span="12">
            <el-form-item label="转成订单" prop="orderConcert">
              <el-radio-group v-model="formData.orderConcert" disabled>
              <el-radio :label="'0'">可见</el-radio>
              <el-radio :label="'1'">转成订单</el-radio>
              </el-radio-group>
            </el-form-item>
          </el-col>
            <el-col :span="12">
            <el-form-item label="客户" prop="customerName">
              <el-input v-model="formData.customerName" placeholder="客户" disabled></el-input>
            </el-form-item>
          </el-col>
                      <el-col :span="12">
            <el-form-item label="日期" prop="timeNow">
              <el-date-picker v-model="formData.timeNow" disabled value-format="yyyy-MM-dd" type="date" placeholder="选择日期"  clearable></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="报价" prop="totalQuotation">
              <el-input v-model="formData.totalQuotation" placeholder="报价" disabled></el-input>
            </el-form-item>
          </el-col>
            <el-col :span="12">
            <el-form-item label="销售机会" prop="chanceName">
              <el-input v-model="formData.chanceName" placeholder="销售机会" disabled></el-input>
            </el-form-item>
          </el-col>
           <el-col :span="12">
            <el-form-item label="预估毛利" prop="grossProfit">
              <el-input v-model="formData.grossProfit" placeholder="预估毛利" disabled></el-input>
            </el-form-item>
          </el-col>
            <el-col :span="12">
            <el-form-item label="接收人" prop="contactsName">
              <el-input v-model="formData.contactsName" placeholder="接收人" disabled></el-input>
            </el-form-item>
          </el-col>
            <el-col :span="12">
            <el-form-item label="报价人联系方式" prop="employeeContactWay">
              <el-input v-model="formData.employeeContactWay" placeholder="报价人联系方式" disabled></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="支付说明" prop="deliverInstructions">
              <el-input type="textarea" v-model="formData.deliverInstructions" placeholder="支付说明" disabled></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="付款说明" prop="paymentInstructions">
              <el-input type="textarea" v-model="formData.paymentInstructions" placeholder="付款说明" disabled ></el-input>
            </el-form-item>
          </el-col>
           <el-col :span="24">
            <el-form-item label="包装说明" prop="packingInstructions">
              <el-input type="textarea" v-model="formData.packingInstructions" placeholder="包装说明" disabled></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注" prop="remarks">
              <el-input type="textarea" v-model="formData.remarks" placeholder="备注" disabled></el-input>
            </el-form-item>
          </el-col>
        </el-form>
      </el-row>
       <div slot="footer" class="dialog-footer">
      <span class="dialog-footer">
        <el-button @click="formVisible= false">关闭</el-button>
      </span>
      </div>
     </el-dialog>
  </div>
</template>
<script>
import { getList,addall,enit,delect,selectt,selects,selectd,add,selectOne,change} from "@/api/quatation.js";
export default {
  name:'quatation',
  data(){
    return{
      CanAddTip:false,
      selectParams:{},
      tableData:[],
      hide:'',
      total:0,
      rules:{
        customerName:[
          {required: true,message:'请选择客户',trigger:'blur'}
        ],
        quotationTheme:[
          {required: true,message:'请输入报价主题',trigger:'blur'}
        ],
        timeNow:[
          { required: true,message:'请选择日期', trigger:'change'}
        ],
        // orderConcert:[
        //   {required: true,message:'请选择转成订单类型',trigger:'change'}
        // ],
        totalQuotation:[
          {required: true,message:'请输入报价', trigger:'blur'}
        ],
        contactsName:[
          {required: true,message:'请输入接收人',trigger:'blur'}
        ]
      },
      name:[],
      formData:{},
      curr:[],
      the:[],
      formVisible:false,
      dialogFormVisible:false,
      form:{
        orderConcert:0
      },
      options:[
        {
          label:'转成订单',
          options:[
            {
              value:'0',
              label:'可见'
            },
            {
              value:'1',
              label:'转成订单'
            }
          ]
        }
      ]
    }
  },
    created() {
    this.selectParams.pageNum = 1;
    this.selectParams.pageSize = 10;
    this.load();
    // this.first();
    this.find();
    // this.tosous();
    this.fend()
  },
methods:{
     async load(){
       let{
        pageNum,
        pageSize,
        keyword,
        orderConcert,
        quotationTheme
       }=this.selectParams;
       const{data:ListRes}=await getList({
         pageNum:pageNum,
         pageSize:pageSize,
         keyword:keyword,
         orderConcert:orderConcert,
         quotationTheme:quotationTheme
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
        onsumbit(){
      this.load();
    },
    fend(){
      // console.log(row);
      // if(row.orderConcert=='0'){
      //   return true
      // }else if(row.orderConcert=='1'){
      //   return false
      // }
      
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
        this.$refs['form'].validate((vaild)=>{
          if(vaild){
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

      }
    },
    handleEdit(row){
      this.CanAddTip=true
        selects().then(res=>{
        this.curr=res.data
        console.log(res.data)
      })
      console.log(row);
      
			this.form= JSON.parse(JSON.stringify(row))
			this.dialogFormVisible=true
    },
    selecto(data){
      this.formVisible=true
      selectOne(data).then(res=>{
        this.formData=res.data
        console.log(res.data);
        
      })
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
    },
    saveOrder(){
      this.$confirm('此操作将把这条信息转成订单, 是否继续','提示',{
        confirmButtonText:'确定',
        cancelButtonText:'取消',
        type:'warning'
      }).then(()=>{
        add(this.form).then(res=>{
          if(res.code==200){
            this.$message({
              message:'转成订单成功',
              type:'success'
            });
          }else{
            this.$message({
              message:res.message,
              type:'errot'
            })
          }
        })
        // if(this.$index.orderConcert==='1'){
        //   this.$index.hide=true
        // }
        this.$router.push({name:'indent'})
      }).catch(()=>{
        this.$message({
          type:'info',
          message:'已取消转成订单'
        })
      })
    },
  add(){
    this.CanAddTip=false
    this.dialogFormVisible=true
    this.form={}
  },
      changes(event){
      this.form.contactsId=event.id
      this.form.contactsName=event.name
    },
  changee(event){
    this.form.customerId=event.id,
    this.form.customerName=event.name
          selectt(event.id).then(res=>{
        this.name=res.data
        console.log(res.data)
      }),
      selectd(event.id).then(res=>{
    this.the=res.data
    console.log(res.data)
  })
      
  },
  changer(event){
    this.form.chanceId=event.id,
    this.form.chanceName=event.name
  },
  // first(){
  //     selectt().then(res=>{
  //       this.name=res.data
  //       console.log(res.data)
  //     })
  // },
    find(){
      selects().then(res=>{
        this.curr=res.data
        console.log(res.data)
      })
  },
  // tosous(){
  // selectd().then(res=>{
  //   this.the=res.data
  //   console.log(res.data)
  // })
  // }
}
}
</script>
<style>

</style>

