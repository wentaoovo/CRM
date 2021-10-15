package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.hanwen.IxQuotationDao;
import com.trkj.crmproject.entity.hanwen.IxContactsDetails;
import com.trkj.crmproject.entity.hanwen.IxQuotation;
import com.trkj.crmproject.util.IdWorker;
import com.trkj.crmproject.vo.Indexes.QuatationSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuatationServiceImpl implements QuatationService {
    @Autowired
    private IxQuotationDao ixQuotationDao;
    @Autowired
    private IdWorker idWorker;
    @Override
    public PageInfo<IxQuotation> selectAll(QuatationSearchVo QuatationSearchVo) {
        if (QuatationSearchVo.getPageNum()==null){
            QuatationSearchVo.setPageNum(1);
        }
        if (QuatationSearchVo.getPageSize()==null){
            QuatationSearchVo.setPageSize(10);
        }
        PageHelper.startPage(QuatationSearchVo.getPageNum(),QuatationSearchVo.getPageSize());
        return new PageInfo<IxQuotation>(ixQuotationDao.selectAll(QuatationSearchVo));
    }

    @Override
    public List<String> selecttwo() {
        List<String> selecttwo = ixQuotationDao.selecttwo();
        return selecttwo;
    }

    @Override
    public List<String> selectthree() {
        List<String> selectthree = ixQuotationDao.selectthree();
        return selectthree;
    }

    @Override
    public List<String> selectfive() {
        List<String> selectfive=ixQuotationDao.selectfive();
        return selectfive;
    }

    @Override
    public int insert(IxQuotation record) {
        record.setId(idWorker.nextId()+"");
        return ixQuotationDao.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(IxQuotation record) {
        return ixQuotationDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return ixQuotationDao.deleteByPrimaryKey(id);
    }
}
