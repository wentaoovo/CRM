<template>
     <div class="dashboard-container">
      <div class="lable-titi">
         <div>
           <el-select v-model="value" @change="classChange" style="width:150px;left: 20px;top: 10px" placeholder="请选择">
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
         </div>
          <div class="div-lable-input">
            <el-input
                placeholder="搜索一下"
                suffix-icon="el-icon-search"
                v-model="input"
                style="width:200px;top: 10px"
                @change="checkChange"
              ></el-input>
          </div>
      </div>
    <div class="app-container">
      <div class="app-button"><el-button icon="el-icon-circle-plus" @click="handAdd()" size="small">新建订单</el-button></div>
      <div class="cont-bod-box">
        <el-table :data="tableData" style="width: 100%">
          <el-table-column type="index" width="50" label="序号"></el-table-column>
          <el-table-column prop="theme" label="主题" width="110" sortable></el-table-column>
          <el-table-column prop="customerName" label="对应客户" width="110" sortable></el-table-column>
          <el-table-column prop="id" label="订单号" width="110" sortable></el-table-column>
          <el-table-column prop="totalMoney" label="总金额" width="110" sortable></el-table-column>
          <el-table-column prop="outMoney" label="发货金额" width="110" sortable></el-table-column>
          <el-table-column prop="returnedMoney" label="回款金额" width="110" sortable></el-table-column>
          <el-table-column prop="state" label="状态" width="110" sortable>
            <template #default="scope">
               <el-tag :type="scope.row.state == 0? 'success':'danger'">{{scope.row.state == 0? '执行中':''}}{{scope.row.state == 1? '结束':''}}{{scope.row.state == 2? '意外中止':''}}</el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="possessor" label="所有者" width="110" sortable></el-table-column>
          <el-table-column prop="indentDate" label="开始时间" :formatter="frormatDate" width="110" sortable></el-table-column>
          <el-table-column prop="remark" label="备注" width="110" sortable></el-table-column>
          <el-table-column fixed="right" label="操作" align="center" width="100">
            <template slot-scope="scope">
              <router-link :to="{'path':'/indent/viewIndex/' + scope.row.id}" class="el-button el-button--text el-button--small">
                查看
              </router-link>
               <el-button @click="handDelete(scope.row.id)" size="small" type="text">删除</el-button>
            </template>
          </el-table-column>
        </el-table>
        <div class="page-list">
          <el-pagination
            @size-change="onPageSizeChange"
            @current-change="onPageChange"
            background
            :total="Number(total)"
            :page-sizes="[10,20,30]"
            layout="sizes, prev, pager, next, jumper"
          ></el-pagination>
        </div>
      </div>
    </div>
    <!-- 新增订单组件 -->
    <component v-bind:is="indexAdd" ref="indexAdd"></component>
    <!-- 新增订单明细组件 -->
    <component v-bind:is="detailadd" ref="detailadd"></component>
  </div>

</template>

<script>
import {getList,deletebyid} from "@/api/indent"
import indexAdd from '@/views/indent/components/indexadd'
import detailadd from '@/views/indent/components/indent_detailadd'
import moment from "moment"

export default {
  name: 'indent-index',
  components:{indexAdd,detailadd},
    data() {
        return {
            indexAdd: 'indexAdd',
            detailadd: 'detailadd',
            tableData:[],
            total: 100,
            selectParams:{},
            input:'',
            options: [
          {
            options:[
              {
                value: '全部数据',
                label: '全部数据',
              }
            ]
          },
          {
            label: '状态',
            options: [
              {
                value: 0,
                label: '执行中',
              },
              {
                value: 1,
                label: '结束',
              },
              {
                value: 2,
                label: '意外中止',
              },
            ],
          },
          {
            label: '类型',
            options: [
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
            ],
          },
        ],
        value: '全部数据',
        }
    },
    methods: {
        async init(){
            let{
                pageNum,
                pageSize,
                keyword,
                state,
                classify,
                customerName,
                possessor
            } = this.selectParams
            const {data:ListRes} = await getList({
                pageNum:pageNum,
                pageSize:pageSize,
                keyword:keyword,
                state:state,
                classify: classify,
                customerName: customerName,
                possessor: possessor 
            })
            this.tableData =ListRes.list
            this.total =ListRes.total
        },
        onPageSizeChange(pageSize){
            this.selectParams.pageSize = pageSize
            this.init()
        },
        onPageChange(page){
            this.selectParams.pageNum =page
            this.init()
        },
        checkChange(keyword){
          this.selectParams.keyword = keyword
          this.init()
        },
        classChange(e){
          var reg = /^\d+(?=\.{0,1}\d+$|$)/
          if(e == '全部数据'){
            this.selectParams.state = null
            this.selectParams.classify = null
          }
          else if(reg.test(e)){
            this.selectParams.state = e
            this.selectParams.classify = null
          }else{
            this.selectParams.classify = e
            this.selectParams.state = null
          }
          this.init()
        },
        // 新增订单
        handAdd(){
          this.$refs.indexAdd.init();
          this.$refs.indexAdd.dialogFormVisible = true;
        },
        //新增详细
        detailsAdd(data){
          this.$refs.detailadd.init();
          this.$refs.detailadd.indentsId = data;
          this.$refs.detailadd.dialogFormVisible = true;
        },
        //删除订单
        handDelete(data){
          this.$confirm('此操作将永久删除该订单, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        })
        .then(()=>{
          deletebyid(data).then(res =>{
            this.$message({
              message: res.message,
              type:res.success?'success':'error'
            });
            this.init()
          })
        })
        .catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除',
            })
          })
        },
        frormatDate(row,column){
        var date = row[column.property];
          if(date === undefined){ return ''}
          return moment(date).format("YYYY-MM-DD")
        }
    },
    created(){
        this.selectParams.pageNum = 1
        this.selectParams.pageSize = 10
        this.init()
     },
    activated(){
        this.init()
    }
}
</script>

<style>
.cont-bod-box {
  padding: 20px;
  background: #fff;
  border-radius: 3px;
  margin-top: 15px;
  margin-bottom: 15px;
  border: 1px solid #ebeef5;
}
.page-list {
  text-align: center;
  margin-top: 10px;
}
.lable-titi{
  color: #606266;
  font-size: 14px;
}
.div-lable-input{
  position: absolute;
  left: 220px;
    top: 0.1px;
}
.app-button{
  position: absolute;
  right: 20px;
  top: 30px;
}
.dashboard-container{
  background: #efefef;
}
</style>
