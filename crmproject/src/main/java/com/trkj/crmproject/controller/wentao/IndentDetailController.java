package com.trkj.crmproject.controller.wentao;

import com.trkj.crmproject.entity.wentao.IndentDetail;
import com.trkj.crmproject.service.wentao.IndentDetailService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/indentdetail")
public class IndentDetailController {
    @Resource
    private IndentDetailService indentDetailService;
    /**
     * 批量新增订单详细
     * @param indentDetail
     * @return
     */
    @PostMapping("/add")
    public ResultVo add(@RequestBody List<IndentDetail> indentDetail){
        if (indentDetailService.insert(indentDetail)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("新增订单详细失败");
    }

    /**
     * 根据id删除订单详细
     * @param id
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultVo delete(@PathVariable("id") String id){
        if (indentDetailService.deleteById(id)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("删除订单详细失败");
    }

    /**
     * 批量修改订单详细
     * @param indentDetail
     * @return
     */
    @PutMapping("/update")
    public ResultVo update(@RequestBody List<IndentDetail> indentDetail){
        if (indentDetailService.updateById(indentDetail)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("修改订单详细失败");
    }

    /**
     * 查询订单详细
     * @param id
     * @return
     */
    @GetMapping("/find/{id}")
    public ResultVo find(@PathVariable("id") String id){
        List<IndentDetail> list = indentDetailService.selectByPid(id);
        return ResultVoUtil.success(list);
    }
}
