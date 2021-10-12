<template>
  <div>
  <el-dialog title="产品分类维护" :visible.sync="dialogFormVisible" width="500px">
        <el-row>
        <div class="div-b"> <b>分类</b></div>
        <div class="div-d">
        <el-dropdown class="item">
                <span class="el-dropdown-link">
                操作<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>
                    <el-button type="text" @click="handlAdd()">添加分类</el-button>
                    </el-dropdown-item>
                </el-dropdown-menu>
        </el-dropdown>
        </div>
        </el-row>
        <el-tree :data="classData" :props="{label:'name'}" node-key="id">
        <template #default="{ node, data }">
        <div class="custom-tree-node">
          <span>{{ node.label }}</span>
          <el-dropdown class="item">
                <span class="el-dropdown-link">
                操作<i class="el-icon-arrow-down el-icon--right"></i>
                </span>
                <el-dropdown-menu slot="dropdown">
                    <el-dropdown-item>
                    <el-button type="text" @click="handlAdd(data.id)">添加子分类</el-button>
                    </el-dropdown-item>
                    <el-dropdown-item>
                    <el-button type="text" @click="handUpdate(data.id)">编辑分类</el-button>
                    </el-dropdown-item>
                    <el-dropdown-item>
                    <el-button type="text" @click="handDelete(data.id)">删除分类</el-button>
                    </el-dropdown-item>
                </el-dropdown-menu>
            </el-dropdown>
        </div>
      </template>
      </el-tree>                  
  </el-dialog>
  <el-dialog width="300px" top="120px"  :visible.sync="innerVisible">
        <el-row>
        <el-input v-model="findData.name" style="width:200px;" size="small" prefix-icon="el-icon-edit"></el-input>
        <el-button type="primary" size="small" @click="handData()">确认</el-button>
        </el-row>
  </el-dialog>
    </div>
</template>

<script>
import {getclassList,addOrupClass,findClass,classDelete} from "@/api/product"

export default {
    name: 'product-class',
    data(){
        return{
            classData:[],
            findData:{},
            pid:'',
            dialogFormVisible:false,
            innerVisible:false,
        }
    },
    methods:{
        init(){
            getclassList().then(res =>{
            this.classData=this.transformTozTreeFormat(res.data)
            })
        },
        transformTozTreeFormat(sNodes) {
            var i, l;
            var r = [];
            var tmpMap = {};
            for (i = 0, l = sNodes.length; i < l; i++) {
            tmpMap[sNodes[i].id] = sNodes[i];
            }
            for (i = 0, l = sNodes.length; i < l; i++) {
            var p = tmpMap[sNodes[i].pid];
            if (p && sNodes[i].id != sNodes[i].pid) {
                var children = this.nodeChildren(p);
                if (!children) {
                children = this.nodeChildren(p, []);
                }
                children.push(sNodes[i]);
            } else {
                r.push(sNodes[i]);
            }
            }
            return r;
        },
        nodeChildren(node, newChildren) {
            if (typeof newChildren !== 'undefined') {
            node.children = newChildren;
            }
            return node.children;
        },
        handlAdd(pid){
            this.findData.pid=pid;
            this.innerVisible=true;
        },
        handUpdate(id){
            findClass(id).then(res =>{
                this.findData=res.data;
                this.innerVisible=true;
            })
        },
        //删除产品
        handDelete(data){
          this.$confirm('此操作将永久删除该分类, 是否继续?', '提示', {
          confirmButtonText: '确定',
          cancelButtonText: '取消',
          type: 'warning',
        })
        .then(()=>{
          classDelete(data).then(res =>{
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
        handData(){
            addOrupClass(this.findData).then(res=>{
            this.$message({
            message: res.message,
            type: res.success?'success':'error'
          });
          if(res.success){
            this.innerVisible=false
            this.init();
          }  
            })
            this.findData={}
        }
   },
    created(){
        this.init()
    }
}
</script>

<style>
 .custom-tree-node {
    flex: 1;
    display: flex;
    align-items: center;
    justify-content: space-between;
    font-size: 14px;
    padding-left: 8px;
  }
  .div-b{
      display: inline-block;
      padding-left: 32px;
      width: 300px;
  }
  .div-d{
      display: inline-block;
      margin-left: 113px;
      width: 47px;
  }
</style>
