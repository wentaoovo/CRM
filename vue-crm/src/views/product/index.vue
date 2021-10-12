<template>
     <div class="dashboard-container">
      <div class="lable-titi">
          <div>
            <el-input
                placeholder="搜索一下"
                suffix-icon="el-icon-search"
                v-model="input"
                style="width:200px;top: 10px;left: 20px"
                @change="checkChange"
              ></el-input>
          </div>
      </div>
    <div class="app-container">
      <div class="app-button"><el-button icon="el-icon-circle-plus" @click="handAdd()" size="small">新建</el-button>
         <el-button icon="el-icon-s-tools" @click="handclass()" size="small">产品类别</el-button>
      </div>
      <div class="cont-bod-box">
        <el-table :data="tableData" style="width: 100%">
          <el-table-column type="index" width="50" label="序号"></el-table-column>
          <el-table-column prop="id" label="ID" width="110" sortable></el-table-column>
          <el-table-column prop="name" label="品名" width="110" sortable></el-table-column>
          <el-table-column prop="coding" label="编码" width="110" sortable></el-table-column>
          <el-table-column prop="model" label="型号" width="110" sortable></el-table-column>
          <el-table-column prop="price" label="价格" width="110" sortable></el-table-column>
          <el-table-column prop="unit" label="单位" width="110" sortable></el-table-column>
          <el-table-column prop="state" label="状态" width="110" sortable>
            <template #default="scope">
               <el-tag :type="scope.row.state == 0? 'success':'danger'">{{scope.row.state == 0? '正常':'停售'}}</el-tag>
            </template>
          </el-table-column>
          <el-table-column prop="costPrice" label="成本价格" width="110" sortable></el-table-column>
          <el-table-column fixed="right" label="操作" align="center" width="100">
            <template slot-scope="scope">
               <el-button @click="handUpdate(scope.row.id)" size="small" type="text">查看</el-button>
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
    <!-- 新增产品组件 -->
    <component v-bind:is="productadd" ref="productadd"></component>
    <!-- 产品类别组件 -->
    <component v-bind:is="productclass" ref="productclass"></component>
  </div>

</template>

<script>
import {getList,deletebyid,find} from "@/api/product"
import productadd from '@/views/product/components/productadd'
import productclass from '@/views/product/components/class'

export default {
  name: 'product-index',
  components:{productadd,productclass},
    data() {
        return {
            productadd: 'productadd',
            productclass: 'productclass',
            tableData:[],
            total: 100,
            selectParams:{},
            input:'',
        } 
    },
    methods: {
        async init(){
            let{
                pageNum,
                pageSize,
                keyword,
            } = this.selectParams
            const {data:ListRes} = await getList({
                pageNum:pageNum,
                pageSize:pageSize,
                keyword:keyword,
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
        // 新增产品
        handAdd(){
          this.$refs.productadd.dialogFormVisible=true;
        },
        //查看产品
        handUpdate(data){
          find(data).then(res =>{
            this.$refs.productadd.formData=res.data
            this.$refs.productadd.dialogFormVisible=true;
          });
        },
        //删除产品
        handDelete(data){
          this.$confirm('此操作将永久删除该产品, 是否继续?', '提示', {
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
          })
          this.init()
        })
        .catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除',
            })
          })
        },
        //弹出产品类别框
        handclass(){
          this.$refs.productclass.dialogFormVisible = true
        },
        // stateFormat(row,column){
        //   if(row.state ==0){
        //     return '正常'
        //   }else{
        //     return '停售'
        //   }
        // },
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
.app-button{
  position: absolute;
  right: 20px;
  top: 30px;
}
.dashboard-container{
  background: #efefef;
}
</style>
