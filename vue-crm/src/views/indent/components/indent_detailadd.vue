<template>
  <el-dialog title="明细" :visible.sync="dialogFormVisible" width="1000px">
    <el-form ref="elForm" :model="formData" size="medium">
      <el-table  ref="table" border :data="formData.tableData">
        <el-table-column label="产品名称">
          <template slot-scope="scope">
            <el-form-item >
              <el-input v-model="scope.row.productId" placeholder="产品名称"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="型号">
          <template slot-scope="scope">
            <el-form-item >
              <el-input v-model="scope.row.model" placeholder="型号"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="数量">
          <template slot-scope="scope">
            <el-form-item >
              <el-input v-model="scope.row.quantity" :min="1" type="number"  placeholder="数量" ></el-input>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="单价">
          <template slot-scope="scope">
            <el-form-item >
              <el-input v-model="scope.row.unitPrice" placeholder="单价"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column>
          <template slot="header" slot-scope="scope">
              <span>折扣</span>
              <el-switch v-model="value" @change="switchck(value)"></el-switch>
          </template>
          <template slot-scope="scope">
            <el-form-item >
              <el-slider ref="disslider" v-model="scope.row.discount" :disabled="valdisabled"></el-slider>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="金额">
          <template slot-scope="scope">
            <el-form-item >
              <el-input v-model="scope.row.money" placeholder="0"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column label="备注">
          <template slot-scope="scope">
            <el-form-item >
              <el-input v-model="scope.row.remark" :style="{height: '50px'}" placeholder="备注" type="textarea"></el-input>
            </el-form-item>
          </template>
        </el-table-column>
        <el-table-column  label="操作">
          <template slot-scope="scope">
            <el-button type="danger" size="mini" @click="del(scope.$index)" icon='el-icon-delete'></el-button>
            <el-button type="primary" size="mini" @click="add()" icon='el-icon-plus'></el-button>
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
  export default {
    data() {
      return {
        dialogFormVisible: true,
        formData: {
           tableData: [
          {discount:100,
          },
        ]
        },
        value:false,
        valdisabled:true,
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
      },
      switchck(value){        
        if(value){
          this.valdisabled=false
        }else{
          this.valdisabled=true
        }
      },
      add(){
        this.formData.tableData.push({
          discount:100,
        })
      },
      del(index){
        this.formData.tableData.splice(index,1);
      }
    }
  } 
</script>

<style>
</style>
