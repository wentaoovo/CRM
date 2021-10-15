package com.trkj.crmproject.dao.hanwen;

import com.trkj.crmproject.entity.hanwen.IxContactsDetails;
import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.vo.Indexes.ContactsSearchVo;


import java.util.List;

public interface IxContactsDetailsDao {
    int deleteByPrimaryKey(String id);

    int insert(IxContactsDetails record);

    int insertSelective(IxContactsDetails record);

    IxContactsDetails selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IxContactsDetails record);

    int updateByPrimaryKey(IxContactsDetails record);

    List<IxContactsDetails> selectAll(ContactsSearchVo contactsSearchVo);

    List<String> selectByOne();

    List<String> selectYomer();
}