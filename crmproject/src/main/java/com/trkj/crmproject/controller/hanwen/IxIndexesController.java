package com.trkj.crmproject.controller.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxIndexes;
import com.trkj.crmproject.service.hanwen.IxIndexesService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/first")
public class IxIndexesController {
    @Autowired
   IxIndexesService ixIndexesService;
   @PostMapping("/save")
    public ResultVo save(@RequestBody IxIndexes ixIndexes){
       int insert = ixIndexesService.insert(ixIndexes);
       return ResultVoUtil.success(insert);
   }
   @GetMapping("/select")
    public ResultVo select(@RequestParam(defaultValue = "1") int num,
                           @RequestParam(defaultValue ="10" ) int size){
      PageInfo<IxIndexes> byAll = ixIndexesService.selectByAll(num,size);
       return ResultVoUtil.success(byAll);
   }
   @PutMapping("/enit")
    public ResultVo update(@RequestBody IxIndexes ixIndexes){
       int update = ixIndexesService.updateByPrimaryKey(ixIndexes);
       return ResultVoUtil.success(update);
   }
}
