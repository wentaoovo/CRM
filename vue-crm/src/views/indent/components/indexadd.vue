<template>
  <el-dialog title="订单" :visible.sync="dialogFormVisible" top="20px" width="1000px">
    <el-divider></el-divider>
    <el-row :gutter="15">
    <el-form ref="elForm" :model="formData" size="medium" label-width="100px">
       <el-col :span="24">
            <el-form-item label="主题" prop="theme">
              <el-input v-model="formData.theme" placeholder="可不录入" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
       </el-col>
       <el-col :span="24">
            <el-form-item label="对应客户" prop="customerName">
              <el-input v-model="formData.customerName" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
       </el-col>
       <el-col :span="12">
            <el-form-item label="订单编号" prop="id">
              <el-input v-model="formData.id" placeholder="自动生成" :disabled="true"
                       :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
       <el-col :span="12">
            <el-form-item label="对应机会" prop="chanceId">
              <el-input v-model="formData.chanceId" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
       </el-col>
          <el-col :span="12">
            <el-form-item label="总金额" prop="totalMoney">
              <el-input v-model="formData.totalMoney" placeholder="请输入金额" clearable
                        prefix-icon='el-icon-s-finance' :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="分类">
              <el-select v-model="formData.classify">
                <el-option
                  v-for="item in options"
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
            <el-form-item label="客户签约人" prop="contactsId">
              <el-input v-model="formData.contactsId" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="所有者" prop="possessorId">
              <el-input v-model="formData.possessorId" show-word-limit
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="状态" prop="state">
               <el-radio-group v-model="formData.state">
                  <el-radio :label= 0 >执行中</el-radio>
                  <el-radio :label= 1 >结束</el-radio>
                  <el-radio :label= 2 >意外中止</el-radio>
                </el-radio-group>
            </el-form-item>
          </el-col>            
          <el-col :span="12">
            <el-form-item label="最晚发货日期" prop="latestDeliveryDate">
              <el-date-picker v-model="formData.latestDeliveryDate" format="yyyy-MM-dd" value-format="yyyy-MM-dd"
                              :style="{width: '100%'}" placeholder="请选择发货日期" clearable></el-date-picker>
            </el-form-item>
          </el-col>
          <el-col :span="24">
            <el-form-item label="收货人/地址">
               <el-link @click="show()"  icon="el-icon-edit">详细信息</el-link>
            </el-form-item>
          </el-col>
          <el-col :span="24" v-show="showOrHide == true"><b>收货人</b></el-col>
          <el-col :span="6" v-show="showOrHide == true">
            <el-form-item label="姓名" prop="addressee">
              <el-input v-model="formData.addressee" size="small"
                        clearable style="width:150px"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="6" v-show="showOrHide == true">
            <el-form-item label="电话" prop="addresseeTelephone">
              <el-input v-model="formData.addresseeTelephone" size="small"
                        clearable style="width:150px"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="8" v-show="showOrHide == true">
            <el-form-item label="移动电话" prop="addresseePhone">
              <el-input v-model="formData.addresseePhone" size="small"
                        clearable :style="{width: '100%'}"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" v-show="showOrHide == true"><b>地址</b></el-col>
          <el-col :span="10" v-show="showOrHide == true">
            <el-form-item label="省" prop="province">
              <el-input v-model="formData.province" size="small"
                        clearable style="width:230px"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="12" v-show="showOrHide == true">
            <el-form-item label="城市" prop="city">
              <el-input v-model="formData.city" size="small"
                        clearable style="width:230px"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" v-show="showOrHide == true">
            <el-form-item label="详细地址" prop="addresseeSite">
              <el-input v-model="formData.addresseeSite" size="small"
                        clearable style="width:600px"></el-input>
            </el-form-item>
          </el-col>
          <el-col :span="24" v-show="showOrHide == true">
            <el-form-item label="邮编" prop="postcode">
              <el-input v-model="formData.postcode" size="small"
                        clearable style="width:230px"></el-input>
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
import {addOrupdate,add} from "@/api/indent"
  export default {
    data() {
      return {
        showOrHide:false,
        dialogFormVisible: false,
        formData: {
          state:0
        },
        options:[
              {
                value: '产品销售',
                label: '产品销售',
              },
              {
                value: '业务合作',
                label: '业务合作',
              },
              {
                value: '代理分销',
                label: '代理分销',
              },
              {
                value: '其他',
                label: '其他',
              },
        ]
      }
    },
    methods: {
      show(){
        this.showOrHide=!this.showOrHide
      },
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
