package com.trkj.crmproject.controller.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxIndexes;
import com.trkj.crmproject.entity.wentao.Indent;
import com.trkj.crmproject.service.hanwen.IxIndexesService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.Indexes.IndexesSearchVo;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/first")
public class IxIndexesController {
    @Autowired
   IxIndexesService ixIndexesService;
   @PostMapping("/save")
    public ResultVo save( @RequestBody IxIndexes ixIndexes){
       if(ixIndexes.getRealName()==null){
           ixIndexes.setRealName("xxw");
       }
       ixIndexesService.insert(ixIndexes);
           return ResultVoUtil.success();
   }
   @PostMapping("/select")
   public ResultVo select(@RequestBody IndexesSearchVo indexesSearchVo){
       PageInfo<IxIndexes> all = ixIndexesService.selectByAll(indexesSearchVo);
       return ResultVoUtil.success(all);
   }
   @PutMapping("/enit")
    public ResultVo update(@RequestBody IxIndexes ixIndexes){
        ixIndexesService.updateByPrimaryKey(ixIndexes);
       return ResultVoUtil.success();
   }
   @GetMapping("/byone/{id}")
    public ResultVo selectbyid(@PathVariable("id")String id){
       IxIndexes ixIndexes = ixIndexesService.selectById(id);
       return ResultVoUtil.success(ixIndexes);
   }
}
