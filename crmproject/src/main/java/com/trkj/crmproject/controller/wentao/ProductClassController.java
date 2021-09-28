package com.trkj.crmproject.controller.wentao;

import com.trkj.crmproject.entity.wentao.ProductClass;
import com.trkj.crmproject.service.wentao.ProductClassService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/productclass")
public class ProductClassController {
    @Resource
    private ProductClassService productClassService;

    /**
     * 新增产品类别
     * @param productClass
     * @return
     */
    @PostMapping("/add")
    public ResultVo add(@RequestBody ProductClass productClass){
        if (productClassService.insert(productClass)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("新增产品类别失败");
    }
    /**
     * 根据id删除产品类别
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultVo add(@PathVariable("id") String id){
        if (productClassService.deleteById(id)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("删除产品类别失败");
    }

    /**
     * 根据id修改产品类别
     * @return
     */
    @PutMapping("/update/{id}")
    public ResultVo update(@PathVariable("id") String id, @RequestBody ProductClass productClass){
        productClass.setId(id);
        if (productClassService.update(productClass)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("修改失败");
    }
    /**
     * 根据id查询产品类别
     * @return
     */
    @GetMapping("find/{id}")
    public ResultVo find(@PathVariable("id") String id){
        ProductClass productClass = productClassService.selectById(id);
        return ResultVoUtil.success(productClass);
    }
    /**
     * 查询全部产品类别
     * @return
     */
    @GetMapping("findAll")
    public ResultVo findAll(){
        List<ProductClass> all = productClassService.selectAll();
        return ResultVoUtil.success(all);
    }
}
