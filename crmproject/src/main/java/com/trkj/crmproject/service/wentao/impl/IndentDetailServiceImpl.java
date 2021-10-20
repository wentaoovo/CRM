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

    /**
     * 根据id删除订单详细
     */
    @Override
    public Boolean deleteById(String id) {
        List<IndentDetail> list = indentDetailDao.selectById(id);
        boolean bl= indentDetailDao.deleteById(id) >0 ? true : false;
        if (bl){
            getUp(list);
        }
        return bl;
    }
    /**
     * 批量新增订单详细
     */
    @Override
    public Boolean insert(List<IndentDetail> list) {
        for (int i=0;i<list.size();i++){
            list.get(i).setId(idWorker.nextId()+"");
            list.get(i).setAddtime(new Date());
            list.get(i).setUpdatetime(new Date());
            list.get(i).setTimeliness(0);
        };
       boolean bl= indentDetailDao.insert(list) > 0 ? true : false;
       if (bl){
           getUp(list);
       }
        return bl;
    }
    /**
     * 查询订单详细
     */
    @Override
    public List<IndentDetail> selectByPid(String indentId) {
        return indentDetailDao.selectByPid(indentId);
    }
    /**
     * 批量修改订单详细
     */
    @Override
    public Boolean updateById(List<IndentDetail> record) {
        List<IndentDetail> addList = record.stream().filter(e -> e.getId()==null).collect(Collectors.<IndentDetail>toList());
        List<IndentDetail> upList = record.stream().filter(e -> e.getId()!=null).collect(Collectors.<IndentDetail>toList());
        if (addList.size()>0){
          if (!this.insert(addList)){
              return false;
          }
        }
        boolean bl= indentDetailDao.updateById(record) >0 ? true : false;
        if (bl){
            getUp(record);
        }
        return bl;
    }

    /**
     * 修改订单表里的参数
     * @param list
     */
    public void getUp(List<IndentDetail> list){
        BigDecimal money = new BigDecimal(0);
        BigDecimal discount = new BigDecimal(0);
        BigDecimal cost = new BigDecimal(0);
        BigDecimal grossMargin = new BigDecimal(0);
        List<IndentDetail> detailList = indentDetailDao.selectByPid(list.get(0).getIndentId());
        Indent indent = indentDao.selectById(list.get(0).getIndentId());
        for (int i =0;i<detailList.size();i++){
            money = money.add(detailList.get(i).getMoney());
            discount = discount.add(detailList.get(i).getUnitPrice().multiply(BigDecimal.valueOf(detailList.get(i).getQuantity())));
            cost = cost.add(detailList.get(i).getCostPrice().multiply(BigDecimal.valueOf(detailList.get(i).getQuantity())));
        }
        if (discount.compareTo(BigDecimal.ZERO) == 0){
            discount = BigDecimal.ZERO;
        }else {
            discount = money.divide(discount,2,BigDecimal.ROUND_HALF_UP);
        }
        grossMargin = money.subtract(cost);
        indent.setTotalMoney(money);
        indent.setDiscount(discount);
        indent.setCost(cost);
        indent.setGrossMargin(grossMargin);
        indentDao.update(indent);
    }
}
