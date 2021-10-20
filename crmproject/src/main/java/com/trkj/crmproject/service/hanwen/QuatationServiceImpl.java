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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class QuatationServiceImpl implements QuatationService {
    @Autowired
    private IxQuotationDao ixQuotationDao;
    @Autowired
    private IdWorker idWorker;
    @Override
    //分页查询
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
    public List<Map> selecttwo(String id) {
        List<Map> selecttwo = ixQuotationDao.selecttwo(id);
        return selecttwo;
    }

    @Override
    public List<Map> selectthree() {
        List<Map> selectthree = ixQuotationDao.selectthree();
        return selectthree;
    }

    @Override
    public List<Map> selectfive(String id) {
        List<Map> selectfive=ixQuotationDao.selectfive(id);
        return selectfive;
    }

    @Override
    //新增报价
    public int insert(IxQuotation record) {
        //雪花算法自动生成id
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

    @Override
    public IxQuotation selectByPrimaryKey(String id) {
        return ixQuotationDao.selectByPrimaryKey(id);
    }
}
