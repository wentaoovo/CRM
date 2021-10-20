package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.hanwen.IxCustomerDetailsDao;
import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.entity.hanwen.IxIndexes;
import com.trkj.crmproject.util.IdWorker;
import com.trkj.crmproject.vo.Indexes.CosmerSearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CoustomerDetailsServiceImpl implements CoustomerDetailsService {
    @Autowired
    private IxCustomerDetailsDao ixCustomerDetailsDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    //分页查询
    public PageInfo<IxCustomerDetails> selectByAll(CosmerSearch cosmerSearch) {
        if (cosmerSearch.getPageNum()==null){
            cosmerSearch.setPageNum(1);
        }
        if (cosmerSearch.getPageSize()==null){
            cosmerSearch.setPageSize(10);
        }
        PageHelper.startPage(cosmerSearch.getPageNum(),cosmerSearch.getPageSize());
        return new PageInfo<IxCustomerDetails>(ixCustomerDetailsDao.selectByAll(cosmerSearch));
    }

    @Override
    //新增客户
    public int insert(IxCustomerDetails record) {
        //雪花算法自动生成id
        record.setId(idWorker.nextId()+"");
        return ixCustomerDetailsDao.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(IxCustomerDetails record) {
        return ixCustomerDetailsDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public IxCustomerDetails selectByPrimaryKey(String id) {
        return ixCustomerDetailsDao.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return ixCustomerDetailsDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> selectByTomer() {
        return ixCustomerDetailsDao.selectByTomer();
    }
}
