package com.trkj.crmproject.dao.hanwen;

import com.trkj.crmproject.entity.hanwen.IxContactsDetails;

public interface IxContactsDetailsDao {
    int deleteByPrimaryKey(String id);

    int insert(IxContactsDetails record);

    int insertSelective(IxContactsDetails record);

    IxContactsDetails selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IxContactsDetails record);

    int updateByPrimaryKey(IxContactsDetails record);
}