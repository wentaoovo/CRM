<template>
  <el-dialog title="产品信息" before-close="closeDialog" :visible.sync="dialogFormVisible" width="1000px">
    <el-divider></el-divider>
    <el-row :gutter="15">
    <el-form ref="elForm" :model="formData" size="medium" label-width="100px">
       <el-col :span="12">
            <el-form-item label="品名" prop="name">
              <el-input v-model="formData.name"  show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
       </el-col>
       <el-col :span="12">
            <el-form-item label="型号" prop="model">
              <el-input v-model="formData.model" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
       </el-col>
       <el-col :span="12">
            <el-form-item label="分类" prop="classId">
            <el-select v-model="formData.classId" filterable :style="{width: '100%'}" placeholder="请选择">
             <el-option v-for="item in options" :key="item.id" :label="item.name" :value="item.id"></el-option>
            </el-select>
            </el-form-item>
        </el-col>
       <el-col :span="12">
            <el-form-item label="单位" prop="unit">
              <el-input v-model="formData.unit" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
       </el-col>
       <el-col :span="12">
            <el-form-item label="编码" prop="coding">
              <el-input v-model="formData.coding" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
       </el-col>
       <el-col :span="12">
            <el-form-item label="重量" prop="weight">
              <el-input v-model="formData.weight" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="库存" prop="count">
              <el-input v-model="formData.count" placeholder="0" :disabled="true"
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
            <el-form-item label="价格" prop="price">
              <el-input v-model="formData.price" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="成本价格" prop="costPrice">
              <el-input v-model="formData.costPrice" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="库存上限" prop="upperLimit">
              <el-input v-model="formData.upperLimit" placeholder="0" 
                         :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="库存下限" prop="lowerLimit">
              <el-input v-model="formData.lowerLimit" placeholder="0"
                         :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>            
          <el-col :span="24">
            <el-form-item label="产品说明" prop="description">
              <el-input type="textarea" autosize placeholder="请输入内容" v-model="formData.description">
              </el-input>
            </el-form-item>  
          </el-col>
          <el-col :span="24">
            <el-form-item label="技术参数" prop="technical">
              <el-input type="textarea" autosize placeholder="请输入内容" v-model="formData.technical">
              </el-input>
            </el-form-item>  
          </el-col>
          <el-col :span="24">
            <el-form-item label="备注" prop="remark">
              <el-input type="textarea" autosize placeholder="请输入内容" v-model="formData.remark">
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
import {addOrupdate,getclassList} from "@/api/product"
  export default {
    data() {
      return {
        dialogFormVisible: false,
        formData: {
          state:0
        },
        options:[]
      }
    },
    closeDialog(done){
        this.formData={};
        done();
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
            this.formData={}
            this.dialogFormVisible=false
            this.$parent.init();
            //location.reload();
          }
        })
      },
      init(){
        getclassList().then(res =>{
          this.options =res.data
        })
      }
    },
    created(){
      this.init()
    }
  } 
</script>

<style>
.border{
  border-top: 1px solid #aaaaaa;
}
</style>
