package com.trkj.crmproject.controller.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxDetails;
import com.trkj.crmproject.service.hanwen.DetailsService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.Indexes.DetailsSearchVo;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/five")
public class DetailsController {
    @Autowired
    private DetailsService detailsService;
    //分页查询销售机会列表信息
    @PostMapping("/select")
    public ResultVo select(@RequestBody DetailsSearchVo detailsSearchVo){
        PageInfo<IxDetails> ixDetailsPageInfo = detailsService.selectAll(detailsSearchVo);
        return ResultVoUtil.success(ixDetailsPageInfo);
    }
    //根据客户id查询客户下的所有联系人
    @GetMapping("/selectt/{id}")
    public ResultVo selectt(@PathVariable("id")String id){
        List<Map> selecttwo = detailsService.selecttwo(id);
        return ResultVoUtil.success(selecttwo);
    }
    //查询所有客户
    @GetMapping("/selects")
    public ResultVo selects(){
        List<Map> selectthree = detailsService.selectthree();
        return ResultVoUtil.success(selectthree);
    }
    //新增销售机会
    @PostMapping("/save")
    public ResultVo save(@RequestBody IxDetails ixDetails){
        if(ixDetails.getRealName()==null){
            ixDetails.setRealName("xxw");
        }
        int insert = detailsService.insert(ixDetails);
        return ResultVoUtil.success(insert);
    }
    //修改销售机会
    @PutMapping("/updata")
    public ResultVo updata(@RequestBody IxDetails ixDetails){
        int i = detailsService.updateByPrimaryKeySelective(ixDetails);
        return ResultVoUtil.success(i);
    }
    //删除销售机会
    @DeleteMapping("/delete/{id}")
    public ResultVo delete(@PathVariable("id")String id){
         detailsService.deleteByPrimaryKey(id);
         return ResultVoUtil.success();
    }
    //销售机会接口（订单）
    @GetMapping("/selectDtmer")
    public ResultVo selectdtmer(){
        List<Map> strings = detailsService.selectDtmer();
        return ResultVoUtil.success(strings);
    }
}
