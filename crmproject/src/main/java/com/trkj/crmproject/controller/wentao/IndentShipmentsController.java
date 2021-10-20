package com.trkj.crmproject.controller.wentao;

import com.trkj.crmproject.entity.wentao.IndentShipments;
import com.trkj.crmproject.service.wentao.IndentShipmentsService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@RestController
@RequestMapping("/shipments")
public class IndentShipmentsController {
    @Resource
    private IndentShipmentsService shipmentsService;

    /**
     * 新增发货单
     * @param
     * @return
     */
    @PostMapping("/add")
    public ResultVo add(@Validated @RequestBody IndentShipments shipments){
        if (shipmentsService.insert(shipments)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("新增发货单失败");
    }
    /**
     * 根据订单id查询发货单与明细
     * @param
     * @return
     */
    @GetMapping("/find/{id}")
    public ResultVo find(@PathVariable("id") String id){
        IndentShipments shipments = shipmentsService.selectByIid(id);
        return ResultVoUtil.success(shipments);
    }
}
