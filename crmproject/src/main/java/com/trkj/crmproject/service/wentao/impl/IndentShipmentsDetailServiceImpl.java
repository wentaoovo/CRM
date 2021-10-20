package com.trkj.crmproject.service.wentao.impl;

import com.trkj.crmproject.dao.wentao.IndentShipmentsDetailDao;
import com.trkj.crmproject.entity.wentao.IndentShipmentsDetail;
import com.trkj.crmproject.service.wentao.IndentShipmentsDetailService;
import com.trkj.crmproject.util.IdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class IndentShipmentsDetailServiceImpl implements IndentShipmentsDetailService {
    @Resource
    private IndentShipmentsDetailDao shipmentsDetailDao;
    @Resource
    private IdWorker idWorker;
    @Override
    public boolean insert(List<IndentShipmentsDetail> list,String pid) {
        list.forEach(e->{
            e.setId(idWorker.nextId()+"");
            e.setIndentShipmentsId(pid);
            e.setAddtime(new Date());
            e.setUpdatetime(new Date());
            e.setTimeliness(0);
        });
        return shipmentsDetailDao.insert(list) >0? true: false;
    }
}
