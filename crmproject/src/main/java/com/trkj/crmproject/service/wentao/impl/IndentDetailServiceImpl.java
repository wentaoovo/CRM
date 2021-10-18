package com.trkj.crmproject.service.wentao.impl;

import com.trkj.crmproject.dao.wentao.IndentDao;
import com.trkj.crmproject.dao.wentao.IndentDetailDao;
import com.trkj.crmproject.entity.wentao.Indent;
import com.trkj.crmproject.entity.wentao.IndentDetail;
import com.trkj.crmproject.service.wentao.IndentDetailService;
import com.trkj.crmproject.util.IdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class IndentDetailServiceImpl implements IndentDetailService {
    @Resource
    private IdWorker idWorker;
    @Resource
    private IndentDetailDao indentDetailDao;
    @Resource
    private IndentDao indentDao;

    @Override
    public Boolean deleteById(String id) {
        return indentDetailDao.deleteById(id) >0 ? true : false;
    }

    @Override
    public Boolean insert(List<IndentDetail> list) {
        BigDecimal money = new BigDecimal(0);
        BigDecimal discount = new BigDecimal(0);
        BigDecimal cost = new BigDecimal(0);
        BigDecimal grossMargin = new BigDecimal(0);
        for (int i=0;i<list.size();i++){
            list.get(i).setId(idWorker.nextId()+"");
            list.get(i).setAddtime(new Date());
            list.get(i).setUpdatetime(new Date());
            list.get(i).setTimeliness(0);
            money = money.add(list.get(i).getMoney());
            discount = discount.add(list.get(i).getUnitPrice().multiply(BigDecimal.valueOf(list.get(i).getQuantity())));
            cost = cost.add(list.get(i).getCostPrice().multiply(BigDecimal.valueOf(list.get(i).getQuantity())));
        };
        discount = money.divide(discount,2,BigDecimal.ROUND_HALF_UP);
        grossMargin = money.subtract(cost);
       boolean bl= indentDetailDao.insert(list) > 0 ? true : false;
       if (bl){
           Indent indent = indentDao.selectById(list.get(0).getIndentId());
           System.out.println(">>>>>>>>>金额:"+money);
           System.out.println(">>>>>>>>>>折扣:"+discount);
           System.out.println(">>>>>>>>>>毛利:"+grossMargin);
           System.out.println(">>>>>>>>>>>成本"+cost);
           indent.setTotalMoney(indent.getTotalMoney().add(money));
           indent.setCost(indent.getCost().add(cost));
           indent.setGrossMargin(indent.getGrossMargin().add(grossMargin));

       }
        return bl;
    }

    @Override
    public List<IndentDetail> selectByPid(String indentId) {
        return indentDetailDao.selectByPid(indentId);
    }

    @Override
    public Boolean updateById(List<IndentDetail> record) {
        List<IndentDetail> addList = record.stream().filter(e -> e.getId()==null).collect(Collectors.<IndentDetail>toList());
        List<IndentDetail> upList = record.stream().filter(e -> e.getId()!=null).collect(Collectors.<IndentDetail>toList());
        if (addList.size()>0){
          if (!this.insert(addList)){
              return false;
          }
        }
        return indentDetailDao.updateById(record) >0 ? true : false;
    }
}
