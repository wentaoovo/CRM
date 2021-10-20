<template>
  <el-dialog title="订单明细" @close="closeck()" :close-on-click-modal="false" :close-on-press-escape="false" :visible.sync="dialogFormVisible" width="1000px">
    <el-form ref="elForm" :model="formData" size="medium">
      <el-table  ref="table" show-summary :summary-method="getSummaries" border :data="formData.tableData">
        <el-table-column label="品名型号">
          <template slot-scope="scope">
            <el-form-item>
             <el-select v-model="scope.row.productId" @change="selectck(scope.$index)" filterable placeholder="品名型号">
              <el-option v-for="item in saleData" :key="item.id" :label="item.name+'  '+item.model" :value="item.id"></el-option>
             </el-select>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="数量">
          <template slot-scope="scope">
            <el-form-item >
              <el-input v-model="scope.row.quantity" @input="countck(scope.row.quantity,scope.row.unitPrice,scope.row.discount,scope.$index)" :min="1" type="number"  placeholder="数量" ></el-input>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="单价">
          <template slot-scope="scope">
            <el-form-item >
              <el-input v-model="scope.row.unitPrice" @input="countck(scope.row.quantity,scope.row.unitPrice,scope.row.discount,scope.$index)" type="number" placeholder="单价"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column>
          <template slot="header" slot-scope="scope">
              <span>折扣</span>
              <el-switch v-model="value" @change="switchck(value)"></el-switch>
          </template>
          <template slot-scope="scope">
            <el-form-item >
              <el-slider ref="disslider" v-model="scope.row.discount" @change="countck(scope.row.quantity,scope.row.unitPrice,scope.row.discount,scope.$index)" :disabled="valdisabled"></el-slider>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="金额" prop="money">
          <template slot-scope="scope">
            <el-form-item >
              <el-input v-model="scope.row.money" placeholder="0"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="备注">
          <template slot-scope="scope">
            <el-form-item >
              <el-input v-model="scope.row.remark" :style="{height: '50px'}" placeholder="备注" type="textarea"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column  label="操作">
          <template slot-scope="scope">
            <el-button type="danger" size="mini" @click="del(scope.$index,scope.row.id)" icon='el-icon-delete'></el-button>
            <el-button type="primary" size="mini" @click="add()" icon='el-icon-plus'></el-button>
          </template>
        </el-table-column>
      </el-table>
    </el-form>
    <template #footer>
    <span class="dialog-footer">
      <el-button type="primary" plain size="medium" @click="save()">保存</el-button>
    </span>
  </template>
  </el-dialog>
</template>

<script>
import {getSaleList,addOrUpDetail,findDetailList,deleteDetail} from "@/api/indent"
  export default {
    data() {
      return {
        dialogFormVisible: false,
        indentsId:'',
        formData: {
           tableData: [  
          {discount:100,
          },
        ]
        },
        saleData:[],
        value:false,
        valdisabled:true,
      }
    },
    methods: {
      init(){
        getSaleList().then(res =>{
          this.saleData=res.data
        });
        if(this.formData.tableData[0]==null){
          this.formData.tableData.push({
            productId:'',
            discount:100,
            quantity:'',
            unitPrice:'',
            money:'',
            remark:'',
        })
        }
      },
      //保存或更新方法
      save(){
        if(this.formData.tableData.length >0){
          addOrUpDetail(this.formData.tableData).then(res =>{
          this.$message({
            message: res.message,
            type: res.success?'success':'error'
          });
          if(res.success){
            //this.formData.tableData=[]
            //this.$refs['elForm1'].resetFields();
            //this.$data = this.$options.data.call(this);
            //this.formData = this.$options.data.call(this).formData
            //Object.assign(this.$data,this.$options.data.call(this))
            this.dialogFormVisible=false;
          }
        })
        }else{
          this.$message({
            message: '成功',
            type: 'success'
          });
          this.dialogFormVisible=false;
        }
      },
      switchck(value){        
        if(value){
          this.valdisabled=false
        }else{
          this.valdisabled=true
        }
      },
      selectck(index){
        const item =this.saleData.find(item1 => item1.id === this.formData.tableData[index].productId)
        this.$set(this.formData.tableData[index],'quantity',1) 
        this.$set(this.formData.tableData[index],'unitPrice',item.price)
        this.$set(this.formData.tableData[index],'money',item.price)
        this.$set(this.formData.tableData[index],'model',item.model)
        this.$set(this.formData.tableData[index],'productName',item.name)
        this.$set(this.formData.tableData[index],'indentId',this.indentsId)
        this.$set(this.formData.tableData[index],'costPrice',item.costPrice)
      },
      countck(a,b,c,index){
        const count = a*b*(c/100);
          this.formData.tableData[index].money=count;
          if(this.formData.tableData[index].costPrice>(count/a)){
             this.$notify({
              title: '警告',
              message: '当前售价低于成本',
              type: 'warning',
        })
          }
      },
      add(){
        this.formData.tableData.push({
          discount:100,
        })
      },
      del(index,id){
        if(id){
          deleteDetail(id).then(res =>{
            this.$message({
            message: res.message,
            type: res.success?'success':'error'
          });
          })
        }
        this.formData.tableData.splice(index,1);
      },
      //总计
       getSummaries(param) {
        const { columns, data } = param
        const sums = []
        columns.forEach((column, index) => {
          if (index === 0) {
            sums[index] = '总价'
            return
          }
          const values = data.map((item) => Number(item[column.property]))
          if (column.property === 'money') {
            sums[index] = values.reduce((prev, curr) => {
              const value = Number(curr)
              if (!isNaN(value)) {
                return prev + curr
              } else {
                return prev
              }
            }, 0)
            sums[index] += ' 元'
          } else {
            sums[index] = ''
          }
        })
        return sums
      },
      closeck(){
        Object.assign(this.$data,this.$options.data.call(this))
        this.$parent.init();
      }
    },
    created(){

    }
  } 
</script>

<style>
</style>
