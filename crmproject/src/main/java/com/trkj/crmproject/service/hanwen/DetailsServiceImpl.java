package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.hanwen.IxDetailsDao;
import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.entity.hanwen.IxDetails;
import com.trkj.crmproject.util.IdWorker;
import com.trkj.crmproject.vo.Indexes.DetailsSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class DetailsServiceImpl implements DetailsService {
    @Autowired
    private IxDetailsDao ixDetailsDao;
    @Autowired
    private IdWorker idWorker;
    @Override
    public PageInfo<IxDetails> selectAll(DetailsSearchVo detailsSearchVo) {
        if (detailsSearchVo.getPageNum()==null){
            detailsSearchVo.setPageNum(1);
        }
        if (detailsSearchVo.getPageSize()==null){
            detailsSearchVo.setPageSize(10);
        }
        PageHelper.startPage(detailsSearchVo.getPageNum(),detailsSearchVo.getPageSize());
        return new PageInfo<IxDetails>(ixDetailsDao.selectAll(detailsSearchVo));
    }

    @Override
    public List<String> selecttwo() {
        List<String> selecttwo = ixDetailsDao.selecttwo();
        return selecttwo;
    }

    @Override
    public List<String> selectthree() {
        List<String> selectthree = ixDetailsDao.selectthree();
        return selectthree;
    }

    @Override
    public int insert(IxDetails record) {
        record.setId(idWorker.nextId()+"");
        record.getUpdateDate();
        record.setUpdateDate(new Date());
        return ixDetailsDao.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(IxDetails record) {
        return ixDetailsDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return ixDetailsDao.deleteByPrimaryKey(id);
    }
}
