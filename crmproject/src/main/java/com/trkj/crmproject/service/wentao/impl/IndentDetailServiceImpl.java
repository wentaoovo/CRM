package com.trkj.crmproject.service.wentao.impl;

import com.trkj.crmproject.dao.wentao.IndentDetailDao;
import com.trkj.crmproject.entity.wentao.IndentDetail;
import com.trkj.crmproject.service.wentao.IndentDetailService;
import com.trkj.crmproject.util.IdWorker;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class IndentDetailServiceImpl implements IndentDetailService {
    @Resource
    private IdWorker idWorker;
    @Resource
    private IndentDetailDao indentDetailDao;
    @Override
    public Boolean deleteById(String id) {
        return indentDetailDao.deleteById(id) >0 ? true : false;
    }

    @Override
    public Boolean insert(IndentDetail record) {
        record.setId(idWorker.nextId()+"");
        record.setAddtime(new Date());
        record.setUpdatetime(new Date());
        record.setTimeliness(0);
        return indentDetailDao.insert(record) > 0 ? true : false;
    }

    @Override
    public List<IndentDetail> selectByPid(String indentId) {
        return indentDetailDao.selectByPid(indentId);
    }

    @Override
    public Boolean updateById(IndentDetail record) {
        return indentDetailDao.updateById(record) >0 ? true : false;
    }
}
