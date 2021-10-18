<template>
  <el-dialog title="订单" @close="closeck()" :close-on-click-modal="false" :close-on-press-escape="false" :visible.sync="dialogFormVisible" top="20px" width="1000px">
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
              <el-select v-model="formData.customerName" @change="clientCk($event)" :style="{width: '100%'}" filterable>
              <el-option v-for="item in ClientList" :key="item.id" :label="item.name" :value="{name:item.name,id:item.id}"></el-option>
             </el-select>
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
              <el-select v-model="formData.chanceName" @change="ChanceCk($event)" :style="{width: '100%'}" filterable>
              <el-option v-for="item in ChanceList" :key="item.id" :label="item.opportunity_theme" :value="{name:item.opportunity_theme,id:item.id}"></el-option>
              </el-select>
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
              <el-select v-model="formData.contactsName" @change="ContactCk($event)" :style="{width: '100%'}" filterable>
              <el-option v-for="item in ContactsList" :key="item.id" :label="item.contacts_name" :value="{name:item.contacts_name,id:item.id}"></el-option>
              </el-select>
            </el-form-item>
          </el-col>
          <el-col :span="12">
            <el-form-item label="所有者" prop="possessor">
              <el-input v-model="formData.possessor" show-word-limit
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
              <el-date-picker v-model="formData.latestDeliveryDate" type="date" value-format="yyyy-MM-dd" 
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
import {addOrupdate,add,getClientList,getContactsList,getChanceList} from "@/api/indent"
  export default {
    data() {
      return {
        showOrHide:false,
        dialogFormVisible: false,
        ClientList:[],
        ContactsList:[],
        ChanceList:[],
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
      init(){
        getClientList().then(res=>{
          this.ClientList = res.data;
        });
        getChanceList().then(res=>{
          this.ChanceList = res.data;
        })
      },
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
            if(res.data != null){
               this.$parent.detailsAdd(res.data);   
            }
          }
        })
      },
      clientCk(event){
        this.formData.customerId = event.id;
        this.formData.customerName = event.name;

        const item = this.ClientList.find(item1 => item1.id === event.id);
        this.$set(this.formData,'addressee',item.name)
        this.$set(this.formData,'addresseeTelephone',item.telephone)
        this.$set(this.formData,'addresseePhone',item.mobile_phone)
        this.$set(this.formData,'province',item.province)
        this.$set(this.formData,'city',item.city)
        this.$set(this.formData,'addresseeSite',item.address)
        this.$set(this.formData,'postcode',item.postcode)

        getContactsList(event.id).then(res =>{
          this.ContactsList = res.data
        })
      },
      ContactCk(event){
        this.formData.contactsId = event.id;
        this.formData.contactsName = event.name;
      },
      ChanceCk(event){
        this.formData.chanceId = event.id;
        this.formData.chanceName = event.name;
      },
       closeck(){
        Object.assign(this.$data,this.$options.data.call(this))
        this.$parent.init();
      }
    }
  } 
</script>

<style>

</style>
