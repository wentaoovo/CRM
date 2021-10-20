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
import java.util.Map;

@RestController
@RequestMapping("/four")
public class QuatationController {
    @Autowired
    private QuatationService quatationService;
    //分页查询报价列表信息
    @PostMapping("/select")
    public ResultVo select(@RequestBody QuatationSearchVo quatationSearchVo){
        PageInfo<IxQuotation> ixQuotationPageInfo = quatationService.selectAll(quatationSearchVo);
        return ResultVoUtil.success(ixQuotationPageInfo);
    }
    //根据id查询客户下联系人的所有信息
    @GetMapping("/selectt/{id}")
    public ResultVo selectt(@PathVariable("id")String id){
        List<Map> selecttwo = quatationService.selecttwo(id);
        return ResultVoUtil.success(selecttwo);
    }
    @GetMapping("/selects")
    public ResultVo selects(){
        List<Map> selectthree = quatationService.selectthree();
        return ResultVoUtil.success(selectthree);
    }
    //根据客户id查询客户下的所有销售机会
    @GetMapping("/selectd/{id}")
    public ResultVo selectsd(@PathVariable("id")String id){
        List<Map> selectfive = quatationService.selectfive(id);
        return ResultVoUtil.success(selectfive);
    }
    //新增报价
    @PostMapping("/save")
    public ResultVo save(@RequestBody IxQuotation ixQuotation){
        if(ixQuotation.getEmployeeName()==null){
            ixQuotation.setEmployeeName("xxw");
        }
        int insert = quatationService.insert(ixQuotation);
        return ResultVoUtil.success(insert);
    }
    //修改报价
    @PutMapping("/updata")
    public ResultVo updata(@RequestBody IxQuotation ixQuotation){
        int i = quatationService.updateByPrimaryKeySelective(ixQuotation);
        return ResultVoUtil.success(i);
    }
    //删除报价
    @DeleteMapping("/delete/{id}")
    public ResultVo delete(@PathVariable("id")String id){
        quatationService.deleteByPrimaryKey(id);
        return ResultVoUtil.success();
    }
    //根据id查询报价
    @GetMapping("/selectOne/{id}")
    public ResultVo selectone(@PathVariable("id")String id){
        IxQuotation ixQuotation = quatationService.selectByPrimaryKey(id);
        return ResultVoUtil.success(ixQuotation);
    }
    @PostMapping("/change")
    public ResultVo change(@RequestBody IxQuotation ixQuotation){
        if(ixQuotation.getOrderConcert()=="0"&&ixQuotation.getOrderConcert()==null){
            ixQuotation.setOrderConcert("1");

        }
        return ResultVoUtil.success(ixQuotation);
    }
}
