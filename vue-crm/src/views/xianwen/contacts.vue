<template>
<div style="padding:10px;"> 
        	 <div class="lable-titi">
         <div>
          <div class="lable-input-x">
          <el-form :inline="true" v-model="selectParams">
            <el-form-item label="联系人分类">
              <el-input v-model="selectParams.contactCategory" placeholder="联系人分类" size="medium" style="width:140px" clearable></el-input>
            </el-form-item>
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
					<el-button size="mini" icon="el-icon-delete-solid" @click="handle(scope.row.id)"></el-button>
						</el-col>
						<el-col :span="12" :offset="0">
								<el-button size="mini"  icon="el-icon-edit" @click="handleEdit(scope.row)"></el-button>
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
        <el-form :model="form"  label-width="100px" :rules="rules" ref="form">
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
            <el-col :span="12">
          <el-form-item label="对应客户:" prop="corrCustomer">
            <el-select v-model="form.corrCustomer"
            value-key="id"
            placeholder="请选择对应客户" @change="changes($event)">
            <el-option v-for="item in name" :key="item.id" :label="item.name" :value="{name:item.name,id:item.id}"></el-option>
            </el-select>
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
                      <el-select v-model="form.hobby">
                <el-option
                  v-for="item in aihao"
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
          <el-form-item label="证件号:" prop="cardId">
            <el-input v-model="form.cardId"  placeholder="证件号"></el-input>
          </el-form-item>
        </el-col>
         <el-col :span="12">
          <el-form-item label="习惯:" prop="habit">
                     <el-select v-model="form.habit">
                <el-option
                  v-for="item in xiguan"
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
                     <el-select v-model="form.interest">
                <el-option
                  v-for="item in xingqu"
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
          <el-form-item label="性格:" prop="characters">
              <el-select v-model="form.characters">
                <el-option
                  v-for="item in xingge"
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
          <el-form-item label="社交特点:" prop="socialCharacteristics">
                      <el-select v-model="form.socialCharacteristics">
                <el-option
                  v-for="item in tedian"
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
        <el-button type="primary" @click="save()">OK</el-button>
      </span>
      </div>
    </el-dialog>
    
    </div>
</template>
<script>
import { getList,addall,enit,delect,selectOne} from "@/api/contacts.js";
export default {
   name:"contacts",
   data(){
        return{
          rules:{
            contactsName:[
              {required:true,message:'请输入姓名',trigger:'blur'},
            ],
            mobilePhone:[
              {required:true,message:'请输入电话号码',trigger:'blur'},
               { min: 11, max: 11, message: '长度在11字符', trigger: 'blur' }
            ],
            corrCustomer:[
              {required: true,message:'请选择对应客户',trigger:'blur'}
            ]
          },
          selectParams:{},
          tableData:[],
          form:{},
          total:0,
          name:[],
          dialogFormVisible:false,
           options:[{
             options:[{
                value: '全部数据',
                label: '全部数据',
             }]
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
          ],
          aihao:[
            {
              value:'',
              label:''
            },
             {
              value:'足球',
              label:'足球'
            },
            {
              value:'篮球',
              label:'篮球'
            },
            {
              value:'看书',
              label:'看书'
            },
            {
              value:'手表',
              label:'手表'
            },
            {
              value:'鞋',
              label:'鞋'
            },
            {
              value:'吉他',
              label:'吉他'
            },
            {
              value:'钢琴',
              label:'钢琴'
            },
            {
              value:'萨克斯',
              label:'萨克斯'
            },
            {
              value:'游戏',
              label:'游戏'
            },
            {
              value:'其他',
              label:'其他'
            },

          ],
          xingqu:[
            {
              value:'',
              label:''
            },
            {
              value:'书法',
              label:'书法'
            },
            {
              value:'作画',
              label:'作画'
            },
            {
              value:'摄影',
              label:'摄影'
            },
            {
              value:'户外运动',
              label:'户外运动'
            },
            {
              value:'跑步',
              label:'跑步'
            },
            {
              value:'旅行',
              label:'旅行'
            },
            {
              value:'音乐',
              label:'音乐'
            },
            {
              value:'影视',
              label:'影视'
            },
            {
              value:'书籍',
              label:'书籍'
            },
            {
              value:'烹饪',
              label:'烹饪'
            },
            {
              value:'美食',
              label:'美食'
            },
            {
              value:'其他',
              label:'其他'
            }
          ],
          xiguan:[
            {
              value:'',
              label:''
            },
            {
              value:'抽烟',
              label:'抽烟'
            },
            {
              value:'红酒',
              label:'红酒'
            },
            {
              value:'白酒',
              label:'白酒'
            },
            {
              value:'雪茄',
              label:'雪茄'
            },
            {
              value:'其他',
              label:'其他'
            },
          ],
          tedian:[
            {
              value:'',
              label:''
            },
            {
              value:'对新事物感兴趣',
              label:'对新事物感兴趣'
            },
            {
              value:'接受新事物能力强',
              label:'接受新事物能力强'
            },
            {
              value:'不易接受新事物',
              label:'不易接受新事物'
            },
            {
              value:'理解力弱',
              label:'理解力弱'
            },
            {
              value:'理解力强',
              label:'理解力强'
            },
            {
              value:'新技能掌握快',
              label:'新技能掌握快'
            },
            {
              value:'新技能掌握满',
              label:'新技能掌握满'
            },
            {
              value:'自学意识强',
              label:'自学意识强'
            },
            {
              value:'自学意识弱',
              label:'自学意识弱'
            },
            {
              value:'容易沟通',
              label:'容易沟通'
            },
            {
              value:'不易沟通',
              label:'不易沟通'
            },
            {
              value:'其他',
              label:'其他'
            },
          ],
          xingge:[
            {
              value:'',
              label:''
            },
            {
              value:'内向',
              label:'内向'
            },
            {
              value:'外向',
              label:'外向'
            },
            {
              value:'理智型',
              label:'理智型'
            },
            {
              value:'疑虑型',
              label:'疑虑型'
            },
            {
              value:'情绪型',
              label:'情绪型'
            },
            {
              value:'急脾气',
              label:'急脾气'
            },
            {
              value:'慢性子',
              label:'慢性子'
            },
            {
              value:'其他',
              label:'其他'
            },
          ]
        }
   },
  created() {
    this.selectParams.pageNum = 1;
    this.selectParams.pageSize = 10;
    this.load();
    this.find();
  },
   methods:{
     		handleEdit(row){
			this.form= JSON.parse(JSON.stringify(row))
			this.dialogFormVisible=true
		},
     add(){
      this.dialogFormVisible = true;
			this.form={}
     },
   async load(){
       let{
        pageNum,
        pageSize,
        keyword,
        contactCategory,
        contactsName
       }=this.selectParams;
       const{data:ListRes}=await getList({
         pageNum:pageNum,
         pageSize:pageSize,
         keyword:keyword,
         contactCategory:contactCategory,
         contactsName:contactsName
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
          checkChange(keyword){
          this.selectParams.keyword = keyword
          this.load()
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

      }

    },
    changes(event){
    this.form.customerDetailsId=event.id,
    this.form.corrCustomer=event.name
    },
    handle(data){
      this.$confirm('此操作将永久删除该联系人, 是否继续?', '提示',{
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
          this.load()
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
    find(){
      selectOne().then(res=>{
        this.name=res.data
        console.log(res.data)
      })
    },
    mounted(){
      this.find();
    }
   }
}
</script>
<style>
.lable-titi{
  color: #606266;
  font-size: 14px;
}
.lable-input-x{
  position: absolute;
  margin-top: 10px;
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


