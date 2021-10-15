package com.trkj.crmproject.controller.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxDetails;
import com.trkj.crmproject.service.hanwen.DetailsService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.Indexes.DetailsSearchVo;
import com.trkj.crmproject.vo.ResultVo;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/five")
public class DetailsController {
    @Autowired
    private DetailsService detailsService;
    @PostMapping("/select")
    public ResultVo select(@RequestBody DetailsSearchVo detailsSearchVo){
        PageInfo<IxDetails> ixDetailsPageInfo = detailsService.selectAll(detailsSearchVo);
        return ResultVoUtil.success(ixDetailsPageInfo);
    }
    @GetMapping("/selectt")
    public ResultVo selectt(){
        List<String> selecttwo = detailsService.selecttwo();
        return ResultVoUtil.success(selecttwo);
    }
    @GetMapping("/selects")
    public ResultVo selects(){
        List<String> selectthree = detailsService.selectthree();
        return ResultVoUtil.success(selectthree);
    }
    @PostMapping("/save")
    public ResultVo save(@RequestBody IxDetails ixDetails){
        int insert = detailsService.insert(ixDetails);
        return ResultVoUtil.success(insert);
    }
    @PutMapping("/updata")
    public ResultVo updata(@RequestBody IxDetails ixDetails){
        int i = detailsService.updateByPrimaryKeySelective(ixDetails);
        return ResultVoUtil.success(i);
    }
    @DeleteMapping("/delete/{id}")
    public ResultVo delete(@PathVariable("id")String id){
         detailsService.deleteByPrimaryKey(id);
         return ResultVoUtil.success();
    }
}
