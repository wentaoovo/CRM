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
import java.util.Map;

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
        Map map = indentService.insert(indent);
        if ((boolean) map.get("boolean")){
            return ResultVoUtil.success(map.get("id"));
        }
        return ResultVoUtil.error("新增订单失败");
    }

    /**
     * 删除订单
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultVo delete(@PathVariable("id") String id){
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
    @PostMapping("find")
    public ResultVo findAll( @RequestBody SearchListVo searchListVo){
        PageInfo<Indent> all = indentService.selectAll(searchListVo);
        return ResultVoUtil.success(all);
    }
    /**
     * 根据id查询订单和明细
     * @return
     */
    @GetMapping("findJoin/{id}")
    public ResultVo findJoin(@PathVariable("id") String id){
        Indent indent = indentService.selectJoin(id);
        return ResultVoUtil.success(indent);
    }
    /**
     * 根据id查询订单和明细2
     * @return
     */
    @GetMapping("findJoine/{id}")
    public ResultVo findJoine(@PathVariable("id") String id){
        Indent indent = indentService.selectJoine(id);
        return ResultVoUtil.success(indent);
    }
}
