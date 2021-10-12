package com.trkj.crmproject.controller.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.service.hanwen.CoustomerDetailsService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.Indexes.CosmerSearch;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.CompletionService;

@RestController
@RequestMapping("/send")
public class CoustomerController {
    @Autowired
    private CoustomerDetailsService coustomerDetailsService;
    @PostMapping("/select")
    public ResultVo select(@RequestBody CosmerSearch cosmerSearch){
        PageInfo<IxCustomerDetails> all = coustomerDetailsService.selectByAll(cosmerSearch);
        return ResultVoUtil.success(all);
    }
    @PostMapping("/save")
    public ResultVo save(@RequestBody IxCustomerDetails ixCustomerDetails){
        coustomerDetailsService.insert(ixCustomerDetails);
        return ResultVoUtil.success();
    }
    @PutMapping("/updata")
    public ResultVo updata(@RequestBody IxCustomerDetails ixCustomerDetails){
        int i = coustomerDetailsService.updateByPrimaryKeySelective(ixCustomerDetails);
        return ResultVoUtil.success(i);
    }
    @GetMapping("/byone/{id}")
    public ResultVo selectOne(@PathVariable("id")String id){
        IxCustomerDetails ixCustomerDetails = coustomerDetailsService.selectByPrimaryKey(id);
        return ResultVoUtil.success(ixCustomerDetails);
    }
    @DeleteMapping("/delete/{id}")
    public ResultVo delete(@PathVariable("id")String id){
        coustomerDetailsService.deleteByPrimaryKey(id);
        return ResultVoUtil.success();
    }
}
