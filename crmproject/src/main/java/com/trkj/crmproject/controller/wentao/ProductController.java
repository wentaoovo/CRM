package com.trkj.crmproject.controller.wentao;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.wentao.Product;
import com.trkj.crmproject.entity.wentao.ProductClass;
import com.trkj.crmproject.service.wentao.ProductClassService;
import com.trkj.crmproject.service.wentao.ProductService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.Indent.SearchListVo;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Resource
    private ProductService productService;

    /**
     * 新增产品
     */
    @PostMapping("/add")
    public ResultVo add(@RequestBody Product product){
        if (productService.insert(product)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("新增产品失败");
    }
    /**
     * 根据id删除产品
     * @return
     */
    @DeleteMapping("/delete/{id}")
    public ResultVo delete(@PathVariable("id") String id){
        if (productService.deleteById(id)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("删除产品失败");
    }

    /**
     * 根据id修改产品
     * @return
     */
    @PutMapping("/update/{id}")
    public ResultVo update(@PathVariable("id") String id, @RequestBody Product product){
        product.setId(id);
        if (productService.update(product)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("修改失败");
    }
    /**
     * 根据id查询产品
     * @return
     */
    @GetMapping("/find/{id}")
    public ResultVo find(@PathVariable("id") String id){
        Product product = productService.selectById(id);
        return ResultVoUtil.success(product);
    }
    /**
     * 查询全部产品
     * @return
     */
    @PostMapping("/findAll")
    public ResultVo findAll(@RequestBody SearchListVo vo){
        PageInfo<Product> all = productService.selectAll(vo);
        return ResultVoUtil.success(all);
    }
    /**
     * 查询所以在售产品
     * @return
     */
    @GetMapping("/findSale")
    public ResultVo findSale(){
        List<Product> all = productService.findAll();
        return ResultVoUtil.success(all);
    }
}
