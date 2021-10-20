package com.trkj.crmproject.service.wentao.impl;

import com.trkj.crmproject.dao.wentao.ReturnedMoneyPlanDao;
import com.trkj.crmproject.entity.wentao.ReturnedMoneyPlan;
import com.trkj.crmproject.service.wentao.ReturnedMoneyPlanService;
import com.trkj.crmproject.util.IdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class ReturnedMoneyPlanServiceImpl implements ReturnedMoneyPlanService {
    @Resource
    private ReturnedMoneyPlanDao moneyPlanDao;
    @Resource
    private IdWorker idWorker;
    @Override
    public Boolean insert(List<ReturnedMoneyPlan> list) {
        for (int i =0;i<list.size();i++){
            if (i>0){
                list.get(i).setCustomerName(list.get(0).getCustomerName());
                list.get(i).setPossessor(list.get(0).getPossessor());
                list.get(i).setIndentId(list.get(0).getIndentId());
                list.get(i).setRemark(list.get(0).getRemark());
            }
            list.get(i).setId(idWorker.nextId()+"");
            list.get(i).setAddtime(new Date());
            list.get(i).setUpdatetime(new Date());
            list.get(i).setTimeliness(0);
        }
        System.out.println(list);
        return moneyPlanDao.insert(list) > 0? true: false;
    }
}
