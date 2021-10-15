package com.trkj.crmproject.dao.hanwen;

import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.vo.Indexes.CosmerSearch;

import java.util.List;

public interface IxCustomerDetailsDao {
    int deleteByPrimaryKey(String id);

    int insert(IxCustomerDetails record);

    int insertSelective(IxCustomerDetails record);

    IxCustomerDetails selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IxCustomerDetails record);

    int updateByPrimaryKey(IxCustomerDetails record);

    List<IxCustomerDetails> selectByAll(CosmerSearch cosmerSearch);

    List<IxCustomerDetails> selectByTomer();
}