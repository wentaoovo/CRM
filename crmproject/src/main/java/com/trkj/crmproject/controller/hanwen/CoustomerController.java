package com.trkj.crmproject.controller.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.service.hanwen.CoustomerDetailsService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.Indexes.CosmerSearch;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
