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
       <el-button @click="push">更多</el-button>
       
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
          <el-col :span="12">
            <el-form-item label="主题" prop="quotationTheme">
              <el-input v-model="form.quotationTheme" placeholder="主题"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="转成订单" prop="orderConcert">
              <el-select v-model="form.orderConcert">
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
          <el-form-item label="客户:" prop="customerName">
            <el-select v-model="form.customerName"
            value-key="id"
            placeholder="请选择对应客户">
            <el-option v-for="item in curr" :key="item" :label="item" :value="item"></el-option>
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
          <el-form-item label="销售机会:" prop="opportunityTheme">
            <el-select v-model="form.opportunityTheme"
            value-key="id"
            placeholder="请选择销售机会">
            <el-option v-for="item in the" :key="item" :label="item" :value="item"></el-option>
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
            placeholder="请选择接收人">
            <el-option v-for="item in name" :key="item" :label="item" :value="item"></el-option>
            </el-select>
          </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="报价人联系方式" prop="contactsName">
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
        <el-button @click="dialogFormVisible= false">Cancel</el-button>
        <el-button type="primary" @click="save()">OK</el-button>
      </span>
      </div>
    </el-dialog>
  </div>
</template>
<script>
import { getList,addall,enit,delect,selectt,selects,selectd} from "@/api/quatation.js";
export default {
  name:'quatation',
  data(){
    return{
      selectParams:{},
      tableData:[],
      total:0,
      name:[],
      curr:[],
      the:[],
      dialogFormVisible:false,
      form:{},
      index:[
        {
          value:'',
          label:''
        },
        {
          value:'可见',
          label:'可见'
        },
        {
          value:'不可见',
          label:'不可见'
        },
        {
          value:'转成订单',
          label:'转成订单'
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
    this.tosous();
  },
methods:{
  push(){
    this.$router.push({name:'quatationx'})
  },
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
  },
  tosous(){
  selectd().then(res=>{
    this.the=res.data
    console.log(res.data)
  })
  }
}
}
</script>
<style>

</style>

