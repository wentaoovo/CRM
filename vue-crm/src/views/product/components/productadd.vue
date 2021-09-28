<template>
  <el-dialog title="产品信息" :visible.sync="dialogFormVisible" width="1000px">
    <el-row :gutter="15">
    <el-form ref="elForm" :model="formData" size="medium" label-width="100px">
       <el-col :span="12">
            <el-form-item label="品名" prop="theme">
              <el-input v-model="formData.theme"  show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
       </el-col>
       <el-col :span="12">
            <el-form-item label="型号" prop="customerName">
              <el-input v-model="formData.customerName" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
       </el-col>
       <el-col :span="12">
            <el-form-item label="分类" prop="id">
              <el-input v-model="formData.id"
                       :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
       <el-col :span="12">
            <el-form-item label="单位" prop="chanceId">
              <el-input v-model="formData.chanceId" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
       </el-col>
          <el-col :span="12">
            <el-form-item label="库存" prop="totalMoney">
              <el-input v-model="formData.totalMoney" placeholder="0" :disabled="true"
                         :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="状态" prop="state">
               <el-radio-group v-model="formData.state">
                  <el-radio :label= 0 >正常</el-radio>
                  <el-radio :label= 1 >停售</el-radio>
                </el-radio-group>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="价格" prop="contactsId">
              <el-input v-model="formData.contactsId" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="成本价格" prop="possessorId">
              <el-input v-model="formData.possessorId" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="库存上限" prop="totalMoney">
              <el-input v-model="formData.totalMoney" placeholder="0" 
                         :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="库存下限" prop="totalMoney">
              <el-input v-model="formData.totalMoney" placeholder="0"
                         :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="重量" prop="possessorId">
              <el-input v-model="formData.possessorId" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>            
          <el-col :span="24">
            <el-form-item label="产品说明" prop="totalMoney">
              <el-input type="textarea" autosize placeholder="请输入内容" v-model="formData">
              </el-input>
            </el-form-item>  
          </el-col>
          <el-col :span="24">
            <el-form-item label="技术参数" prop="totalMoney">
              <el-input type="textarea" autosize placeholder="请输入内容" v-model="formData">
              </el-input>
            </el-form-item>  
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注" prop="totalMoney">
              <el-input type="textarea" autosize placeholder="请输入内容" v-model="formData">
              </el-input>
            </el-form-item>  
          </el-col>            
        <el-col :span="6" :offset="21">
        <el-button type="primary" plain size="medium" @click="save()">保存</el-button>
        </el-col>
    </el-form>        
    </el-row>  
  </el-dialog>
</template>

<script>
import {addOrupdate,add} from "@/api/product"
  export default {
    data() {
      return {
        dialogFormVisible: false,
        formData: {
          state:0
        },
      }
    },
    methods: {
      //保存或更新方法
      save(){
        addOrupdate(this.formData).then(res =>{
          this.$message({
            message: res.message,
            type: res.success?'success':'error'
          });
          if(res.success){
            this.dialogFormVisible=false
            this.$parent.init();
            //location.reload();
          }
        })
      }
    }
  } 
</script>

<style>

</style>
