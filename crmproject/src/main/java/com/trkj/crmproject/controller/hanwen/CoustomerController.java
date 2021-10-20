package com.trkj.crmproject.controller.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.service.hanwen.CoustomerDetailsService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.Indexes.CosmerSearch;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionService;

@RestController
@RequestMapping("/send")
public class CoustomerController {
    @Autowired
    private CoustomerDetailsService coustomerDetailsService;
    //分页查询客户列表信息
    @PostMapping("/select")
    public ResultVo select(@RequestBody CosmerSearch cosmerSearch){
        PageInfo<IxCustomerDetails> all = coustomerDetailsService.selectByAll(cosmerSearch);
        return ResultVoUtil.success(all);
    }
    //新增客户
    @PostMapping("/save")
    public ResultVo save(@RequestBody IxCustomerDetails ixCustomerDetails){
        if(ixCustomerDetails.getRealName()==null){
            ixCustomerDetails.setRealName("xxw");
        }
        coustomerDetailsService.insert(ixCustomerDetails);
        return ResultVoUtil.success();
    }
    //修改客户
    @PutMapping("/updata")
    public ResultVo updata(@RequestBody IxCustomerDetails ixCustomerDetails){
        int i = coustomerDetailsService.updateByPrimaryKeySelective(ixCustomerDetails);
        return ResultVoUtil.success(i);
    }
    //根据id查询客户
    @GetMapping("/byone/{id}")
    public ResultVo selectOne(@PathVariable("id")String id){
        IxCustomerDetails ixCustomerDetails = coustomerDetailsService.selectByPrimaryKey(id);
        return ResultVoUtil.success(ixCustomerDetails);
    }
    //根据id删除客户
    @DeleteMapping("/delete/{id}")
    public ResultVo delete(@PathVariable("id")String id){
        coustomerDetailsService.deleteByPrimaryKey(id);
        return ResultVoUtil.success();
    }
    //客户接口（订单）
    @GetMapping("/selectTomer")
    public ResultVo selecttomer(){
        List<Map> ixCustomerDetails = coustomerDetailsService.selectByTomer();
        return ResultVoUtil.success(ixCustomerDetails);
    }
}
