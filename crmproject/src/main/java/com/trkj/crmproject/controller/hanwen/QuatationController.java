package com.trkj.crmproject.controller.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxQuotation;
import com.trkj.crmproject.service.hanwen.QuatationService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.Indexes.QuatationSearchVo;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/four")
public class QuatationController {
    @Autowired
    private QuatationService quatationService;
    @PostMapping("/select")
    public ResultVo select(@RequestBody QuatationSearchVo quatationSearchVo){
        PageInfo<IxQuotation> ixQuotationPageInfo = quatationService.selectAll(quatationSearchVo);
        return ResultVoUtil.success(ixQuotationPageInfo);
    }
    @GetMapping("/selectt")
    public ResultVo selectt(){
        List<String> selecttwo = quatationService.selecttwo();
        return ResultVoUtil.success(selecttwo);
    }
    @GetMapping("/selects")
    public ResultVo selects(){
        List<String> selectthree = quatationService.selectthree();
        return ResultVoUtil.success(selectthree);
    }
    @GetMapping("/selectd")
    public ResultVo selectsd(){
        List<String> selectfive = quatationService.selectfive();
        return ResultVoUtil.success(selectfive);
    }
    @PostMapping("/save")
    public ResultVo save(@RequestBody IxQuotation ixQuotation){
        int insert = quatationService.insert(ixQuotation);
        return ResultVoUtil.success(insert);
    }
    @PutMapping("/updata")
    public ResultVo updata(@RequestBody IxQuotation ixQuotation){
        int i = quatationService.updateByPrimaryKeySelective(ixQuotation);
        return ResultVoUtil.success(i);
    }
    @DeleteMapping("/delete/{id}")
    public ResultVo delete(@PathVariable("id")String id){
        quatationService.deleteByPrimaryKey(id);
        return ResultVoUtil.success();
    }
    @GetMapping("/selectOne/{id}")
    public ResultVo selectone(@PathVariable("id")String id){
        quatationService.selectByPrimaryKey(id);
        return ResultVoUtil.success();
    }
}
