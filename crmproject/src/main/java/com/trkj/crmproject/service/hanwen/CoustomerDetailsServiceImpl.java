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

import java.util.List;
@Service
public class CoustomerDetailsServiceImpl implements CoustomerDetailsService {
    @Autowired
    private IxCustomerDetailsDao ixCustomerDetailsDao;
    @Autowired
    private IdWorker idWorker;

    @Override
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
    public int insert(IxCustomerDetails record) {
        record.setId(idWorker.nextId()+"");
        return ixCustomerDetailsDao.insert(record);
    }
}
