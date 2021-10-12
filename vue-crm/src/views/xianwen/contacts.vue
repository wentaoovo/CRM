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
            <el-form-item label="联系人姓名">
							<el-input v-model="selectParams.contactsName" placeholder="联系人姓名" size="medium" style="width:140px" clearable></el-input>
						</el-form-item>
            <el-form-item>
							<el-button type="primary" @click="onsumbit" icon="el-icon-search" style="margin-left: 20px;">查询</el-button>
						</el-form-item>
          </el-form>
          </div>
         </div>
         </div>
    <div style="margin: 10px  0; text-align: right;">
			 <el-button  @click="add()">新增</el-button>
       <el-button>更多</el-button>
       
		</div>
     <el-table
      :data="tableData"
      style="width: 100%">
      <el-table-column
        prop="id"
        label="Id">
      </el-table-column>
      <el-table-column
        prop="contactsName"
        label="姓名">
      </el-table-column>
      <el-table-column
        prop="mailingAddress"
        label="邮件地址">
      </el-table-column>
      <el-table-column
        prop="mobilePhone"
        label="移动电话">
      </el-table-column>
      <el-table-column
        prop="corrCustomer"
        label="对应客户">
      </el-table-column>
      <el-table-column
        prop="contactCategory"
        label="联系人分类">
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
    <el-dialog title="创建联系人" :visible.sync="dialogFormVisible" width="1200px">
      <!-- <div class="aaa"> 
        <span>联系人</span>
      </div> -->
      <el-row :gutter="15">
        <el-form :model="form"  label-width="100px">
         <el-col :span="24">
        <el-form-item>
        <div class="aaa"> 
        <span>联系人</span>
        </div>
          </el-form-item>
        </el-col>
          <el-col :span="12" >
          <el-form-item label="姓名:" prop="contactsName">
            <el-input v-model="form.contactsName"  placeholder="姓名"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="移动电话:" prop="mobilePhone">
            <el-input v-model="form.mobilePhone"  placeholder="移动电话"></el-input>
          </el-form-item>
        </el-col>
            <el-col :span="24">
          <el-form-item label="对应客户:" prop="corrCustomer">
            <el-input v-model="form.corrCustomer"  placeholder="对应客户"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="联系人分类:" prop="contactCategory">
          <el-select v-model="form.contactCategory">
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
          <el-form-item label="负债业务:" prop="business">
            <el-input v-model="form.business"  placeholder="负债业务"></el-input>
          </el-form-item>
        </el-col>
          <el-col :span="12">
          <el-form-item label="性别:" prop="sex">
          <el-select v-model="form.sex">
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
      <!-- <div class="aaa"> 
        <span>单位</span>
      </div> -->
        <el-col :span="24">
        <el-form-item>
        <div class="aaa"> 
        <span>单位</span>
      </div>
          </el-form-item>
        </el-col>
          <el-col :span="12">
          <el-form-item label="称谓:" prop="appellation">
            <el-input v-model="form.appellation"  placeholder="称谓"></el-input>
          </el-form-item>
        </el-col>
          <el-col :span="12">
          <el-form-item label="类型:" prop="genre">
            <el-input v-model="form.genre"  placeholder="类型"></el-input>
          </el-form-item>
        </el-col>
          <el-col :span="12">
          <el-form-item label="部门:" prop="department">
            <el-input v-model="form.department"  placeholder="部门"></el-input>
          </el-form-item>
        </el-col>
          <el-col :span="12">
          <el-form-item label="职位:" prop="job">
            <el-input v-model="form.job"  placeholder="职位"></el-input>
          </el-form-item>
        </el-col>
      <!-- <div class="aaa"> 
        <span>网络联系方式</span>
      </div> -->
        <el-col :span="24">
        <el-form-item>
        <div class="aaa"> 
        <span>网络联系方式</span>
      </div>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="微信:" prop="wechat">
            <el-input v-model="form.wechat"  placeholder="微信"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="QQ:" prop="qq">
            <el-input v-model="form.qq"  placeholder="QQ"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="微信昵称:" prop="wechatName">
            <el-input v-model="form.wechatName"  placeholder="微信昵称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="QQ昵称:" prop="qqName">
            <el-input v-model="form.qqName"  placeholder="QQ昵称"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="旺旺:" prop="wangwang">
            <el-input v-model="form.wangwang"  placeholder="旺旺"></el-input>
          </el-form-item>
        </el-col>
        <!-- <div class="aaa"> 
        <span>联系方式</span>
      </div> -->
              <el-col :span="24">
        <el-form-item>
        <div class="aaa"> 
        <span>联系方式</span>
      </div>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="邮件地址:" prop="mailingAddress">
            <el-input v-model="form.mailingAddress"  placeholder="邮件地址"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="工作电话:" prop="workPhone">
            <el-input v-model="form.workPhone"  placeholder="工作电话"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="家庭电话:" prop="homePhone">
            <el-input v-model="form.homePhone"  placeholder="家庭电话"></el-input>
          </el-form-item>
        </el-col>
         <el-col :span="12">
          <el-form-item label="传真:" prop="fax">
            <el-input v-model="form.fax"  placeholder="传真"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="邮编:" prop="postcode">
            <el-input v-model="form.postcode"  placeholder="邮编"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="24">
          <el-form-item label="家庭住址:" prop="homeAddress">
            <el-input v-model="form.homeAddress"  placeholder="家庭住址"></el-input>
          </el-form-item>
        </el-col>
          <el-col :span="24">
        <el-form-item>
        <div class="aaa"> 
        <span>其他</span>
        </div>
          </el-form-item>
        </el-col>
         <el-col :span="24">
          <el-form-item label="爱好:" prop="hobby">
            <el-input v-model="form.hobby"  placeholder="爱好"></el-input>
          </el-form-item>
        </el-col>
         <el-col :span="12">
          <el-form-item label="证件号:" prop="cardId">
            <el-input v-model="form.cardId"  placeholder="证件号"></el-input>
          </el-form-item>
        </el-col>
         <el-col :span="12">
          <el-form-item label="习惯:" prop="habit">
            <el-input v-model="form.habit"  placeholder="习惯"></el-input>
          </el-form-item>
        </el-col>
         <el-col :span="24">
          <el-form-item label="备注:" prop="remarks">
            <el-input type="textarea" v-model="form.remarks"  placeholder="备注"></el-input>
          </el-form-item>
        </el-col>
      <el-col :span="24">
        <el-form-item>
        <div class="aaa"> 
        <span>联系人画像</span>
        </div>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="兴趣:" prop="interest">
            <el-input v-model="form.interest"  placeholder="兴趣"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="性格:" prop="characters">
            <el-input v-model="form.characters"  placeholder="性格"></el-input>
          </el-form-item>
        </el-col>
        <el-col :span="12">
          <el-form-item label="社交特点:" prop="socialCharacteristics">
            <el-input v-model="form.socialCharacteristics"  placeholder="社交特点"></el-input>
          </el-form-item>
        </el-col>
          <el-col :span="12">
          <el-form-item label="配偶情况:" prop="spouse">
                     <el-select v-model="form.spouse">
                <el-option
                  v-for="item in indexess"
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
          <el-form-item label="年收入:" prop="annualIncome">
              <el-select v-model="form.annualIncome">
                <el-option
                  v-for="item in indexesss"
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
          <el-form-item label="消费习惯:" prop="consumptionHabits">
              <el-select v-model="form.consumptionHabits">
                <el-option
                  v-for="item in indexessss"
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
          <el-form-item label="子女情况:" prop="children">
            <el-input v-model="form.children"  placeholder="子女情况"></el-input>
          </el-form-item>
        </el-col>
        </el-form>
      </el-row>
      
      <div slot="footer" class="dialog-footer">
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible= false">Cancel</el-button>
        <el-button type="primary" @click="updata()">OK</el-button>
      </span>
      </div>
    </el-dialog>
    
    </div>
</template>
<script>
export default {
   name:"contacts",
   data(){
        return{
          selectParams:{},
          form:{},
          dialogFormVisible:false,
           options:[{
             options:[{
                value: '全部数据',
                label: '全部数据',
             }]
           },
           {
             label:"性别",
             options:[
               {
                 value:'男',
                 label:'男'
               },
               {
                 value:'女',
                 label:'女'
               }
             ]
           },
           ],
          value:'全部数据',
          index:[
            {
              value:'',
              label:''
            },
            {
              value:'特别重要',
              label:'特别重要'
            },
            {
              value:'重要 ',
              label:'重要'
            },
            {
              value:'普通',
              label:'普通'
            },
            {
              value:'不重要',
              label:'不重要'
            },
            {
              value:'失效',
              label:'失效'
            }
          ],
          indexs:[
            {
              value:'',
              label:''
            },
            {
              value:'男',
              label:'男'
            },
            {
              value:'女',
              label:'女'
            }
          ],
          indexess:[
            {
              value:'',
              label:''
            },
            {
              value:'已婚',
              label:'已婚'
            },
            {
              value:'未婚',
              label:'未婚'
            },
            {
              value:'其他',
              label:'其他' 
            }
          ],
          indexesss:[
            {
              value:'',
              label:''
            },
            {
             value:'50k以下',
            label:'50k以下'
            },
            {
              value:'100k以下',
              label:'100k以下'
            },
            {
              value:'150k以下',
              label:'150k以下'
            },
            {
              value:'200k以下',
              label:'200k以下'
            }
          ],
          indexessss:[
            {
              value:'',
              label:''
            },
            {
              value:'稳健谨慎',
              label:'稳健谨慎'
            },
            {
              value:'品牌高质',
              label:'品牌高质'
            },
            {
              value:'偏好奢侈',
              label:'偏好奢侈'
            }
          ]
        }
   },
   methods:{
     add(){
      this.dialogFormVisible = true;
			this.form={}
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
.aaa{
  text-align: center;
    position: relative;
    color: #000000;
    font-weight: bold;
}

</style>


