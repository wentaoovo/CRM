package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.vo.Indexes.CosmerSearch;

import java.util.List;

public interface CoustomerDetailsService {
    PageInfo<IxCustomerDetails> selectByAll(CosmerSearch cosmerSearch);
    int insert(IxCustomerDetails record);
    int updateByPrimaryKeySelective(IxCustomerDetails record);
    IxCustomerDetails selectByPrimaryKey(String id);
    int deleteByPrimaryKey(String id);
}
