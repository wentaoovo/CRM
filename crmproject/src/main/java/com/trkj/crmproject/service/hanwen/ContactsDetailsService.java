package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxContactsDetails;
import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.vo.Indexes.ContactsSearchVo;

import java.util.List;

public interface ContactsDetailsService {
    PageInfo<IxContactsDetails> selectAll(ContactsSearchVo contactsSearchVo);
    List<String> selectByOne();
    int insert(IxContactsDetails record);
    int updateByPrimaryKeySelective(IxContactsDetails record);
    IxContactsDetails selectByPrimaryKey(String id);
    int deleteByPrimaryKey(String id);
    List<String> selectYomer();

}
