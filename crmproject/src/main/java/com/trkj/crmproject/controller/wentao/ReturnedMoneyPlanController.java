package com.trkj.crmproject.controller.wentao;

import com.trkj.crmproject.entity.wentao.IndentDetail;
import com.trkj.crmproject.entity.wentao.ReturnedMoneyPlan;
import com.trkj.crmproject.service.wentao.ReturnedMoneyPlanService;
import com.trkj.crmproject.util.ResultVoUtil;
import com.trkj.crmproject.vo.ResultVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/plan")
public class ReturnedMoneyPlanController {
    @Resource
    private ReturnedMoneyPlanService planService;
    /**
     * 批量新增回款计划
     * @return
     */
    @PostMapping("/add")
    public ResultVo add(@RequestBody List<ReturnedMoneyPlan> plans){
        if (planService.insert(plans)){
            return ResultVoUtil.success();
        }
        return ResultVoUtil.error("新增回款计划失败");
    }

}
