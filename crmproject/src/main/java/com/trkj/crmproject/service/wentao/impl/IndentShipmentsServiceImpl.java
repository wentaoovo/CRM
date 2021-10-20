package com.trkj.crmproject.service.wentao.impl;

import com.trkj.crmproject.dao.wentao.IndentShipmentsDao;
import com.trkj.crmproject.entity.wentao.Indent;
import com.trkj.crmproject.entity.wentao.IndentShipments;
import com.trkj.crmproject.service.wentao.IndentService;
import com.trkj.crmproject.service.wentao.IndentShipmentsDetailService;
import com.trkj.crmproject.service.wentao.IndentShipmentsService;
import com.trkj.crmproject.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

@Service
public class IndentShipmentsServiceImpl implements IndentShipmentsService {
    @Resource
    private IdWorker idWorker;
    @Resource
    private IndentShipmentsDao shipmentsDao;
    @Resource
    private IndentService indentService;
    @Autowired
    private IndentShipmentsDetailService detailService;
    /**
     * 新增发货单
     */
    @Override
    public boolean insert(IndentShipments record) {
        record.setId(idWorker.nextId()+"");
        record.setAddtime(new Date());
        record.setUpdatetime(new Date());
        record.setState(0);
        record.setTimeliness(0);
        boolean bl= shipmentsDao.insert(record) >0 ? true : false;
        if (bl){
           bl= detailService.insert(record.getIndentDetail(), record.getId());
        }else{
            return false;
        }
        if (bl){
            Indent indent = indentService.selectById(record.getIndentId());
            indent.setOutMoney(indent.getTotalMoney());
            indent.setFreight(record.getFreight());
            indentService.update(indent);
        }
        return bl;
    }
    /**
     * 根据订单id查询发货单与明细
     */
    @Override
    public IndentShipments selectByIid(String id) {
        return shipmentsDao.selectByIid(id);
    }
}
