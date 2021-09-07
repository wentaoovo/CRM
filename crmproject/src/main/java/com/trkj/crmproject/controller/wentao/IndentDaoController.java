package com.trkj.crmproject.controller.wentao;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.wentao.Indent;
import com.trkj.crmproject.service.wentao.IndentService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.Indent.SearchListVo;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/indent")
public class IndentDaoController {
    @Resource
    private IndentService indentService;

    /**
     * 新增订单
     * @param indent
     * @return
     */
    @PostMapping("/add")
    public ResultVo add(@Validated @RequestBody Indent indent){
        if (indentService.insert(indent)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("新增订单失败");
    }

    /**
     * 删除订单
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultVo add(@PathVariable("id") String id){
        if (indentService.deleteTl(id)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("删除订单失败");
    }

    /**
     * 修改订单
     * @return
     */
    @PutMapping("/update/{id}")
    public ResultVo update(@PathVariable("id") String id,@Validated @RequestBody Indent indent){
        indent.setId(id);
        if (indentService.update(indent)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("修改订单失败");
    }
    /**
     * 根据id查询订单
     * @return
     */
    @GetMapping("find/{id}")
    public ResultVo find(@PathVariable("id") String id){
        Indent indent = indentService.selectById(id);
        return ResultVoUtil.success(indent);
    }
    /**
     * 查询订单列表
     * @return
     */
    @GetMapping("find")
    public ResultVo findAll( @RequestBody SearchListVo searchListVo){
        PageInfo<Indent> all = indentService.selectAll(searchListVo);
        return ResultVoUtil.success(all);
    }
}
