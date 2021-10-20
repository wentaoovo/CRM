<template>
  <el-dialog title="批量新建回款计划" @close="closeck()" :close-on-click-modal="false" :close-on-press-escape="false" :visible.sync="dialogFormVisible" width="750px">
    <el-form ref="elForm" :model="findData[0]" size="medium" label-width="80px">
       <el-col :span="12">
            <el-form-item label="客户" prop="customerName">
             <el-input v-model="findData[0].customerName" :disabled="true"
                       :style="{width: '200px'}"></el-input>
            </el-form-item>
       </el-col>
       <el-col :span="12">
            <el-form-item label="订单编号" prop="indentId">
              <el-input v-model="findData[0].indentId"  :disabled="true"
                       :style="{width: '200px'}"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="12">
            <el-form-item label="所有者" prop="possessor">
              <el-input v-model="findData[0].possessor"  
                       :style="{width: '200px'}"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="24">
            <el-form-item label="备注">
              <el-input type="textarea" v-model="findData[0].remark" show-word-limit
                        clearable :style="{width: '500px'}"></el-input>
            </el-form-item>
        </el-col>
        <el-col :span="15">
            提示：订单金额RMB{{totalMoney}},回款RMB{{returnedMoney}},回款计划（未回）RMB{{returnedMoney}}
        </el-col>
        <el-col :span="4" :offset="5">
            <el-button type="primary" size="mini" @click="add()" icon='el-icon-plus'></el-button>
            <el-button type="danger" size="mini" @click="del()" icon='el-icon-delete'></el-button>
        </el-col>
      <el-table  ref="table"  border :data="findData">
        <el-table-column type="index" label="期次"> </el-table-column>
        <el-table-column label="金额">
          <template slot-scope="scope">
              <el-input v-model="scope.row.money" @input="countck()"></el-input>
          </template>
        </el-table-column>
        <el-table-column label="计划回款日期">
          <template slot-scope="scope">
              <el-date-picker v-model="scope.row.datePlan" type="date" value-format="yyyy-MM-dd" 
              :style="{width: '100%'}" clearable></el-date-picker>
          </template>
        </el-table-column>
        <el-table-column label="是否回款">
          <template slot-scope="scope">
               <el-select v-model="scope.row.whethe" placeholder="请选择">
                    <el-option v-for="item in whethe" :key="item.value" :label="item.label"
                     :value="item.value"></el-option>
                </el-select> 
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
import {addPlan} from "@/api/indent"
  export default {
    data() {
      return {
        dialogFormVisible: false,
        whethe:[
            {
                value: 0,
                label: '未回',
            },
            {
                value: 1,
                label: '已回',
            },
        ],
        findData: [
               {              
                   whethe:0
               }  
        ],
        formData:{},
        totalMoney:'',
        returnedMoney:'',
      }
    },
    methods: {
      init(){
        this.findData[0].customerName = this.formData.customerName;
        this.findData[0].indentId = this.formData.id;
        this.findData[0].possessor = this.formData.possessor;
        this.totalMoney = this.formData.totalMoney;
        this.returnedMoney = this.formData.returnedMoney;
        this.$set(this.findData[0],'money',this.formData.totalMoney);
      },
      save(){
        addPlan(this.findData).then(res=>{
          this.$message({
              message: res.message,
              type: res.success?'success':'error'
            });
          if(res.success){
              this.dialogFormVisible=false
            }  
        })
      },
      countck(){
        var a =0
        this.findData.forEach(item => a+=Number(item.money))
        if(a>this.totalMoney){
          this.$message({
            message: '不能大于该订单金额',
            type: 'warning'
          });
        }
      },
      add(){
        var a = this.totalMoney;
        this.findData.forEach(item => a -= Number(item.money))
        this.findData.push({
          money:a,
          whethe:0,
        })
      },
      del(){
        this.findData.splice(this.findData.length-1,1);
      },
      closeck(){
        //Object.assign(this.$data,this.$options.data.call(this))
        this.$parent.init();
      }
    },
    created(){

    }
  } 
</script>

<style>
</style>
