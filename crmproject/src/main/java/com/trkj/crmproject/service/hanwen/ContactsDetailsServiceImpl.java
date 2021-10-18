package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.hanwen.IxContactsDetailsDao;
import com.trkj.crmproject.entity.hanwen.IxContactsDetails;
import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.util.IdWorker;
import com.trkj.crmproject.vo.Indexes.ContactsSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ContactsDetailsServiceImpl implements ContactsDetailsService {
    @Autowired
    private IxContactsDetailsDao ixContactsDetailsDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    public PageInfo<IxContactsDetails> selectAll(ContactsSearchVo contactsSearchVo) {
        if (contactsSearchVo.getPageNum()==null){
            contactsSearchVo.setPageNum(1);
        }
        if (contactsSearchVo.getPageSize()==null){
            contactsSearchVo.setPageSize(10);
        }
        PageHelper.startPage(contactsSearchVo.getPageNum(),contactsSearchVo.getPageSize());
        return new PageInfo<IxContactsDetails>(ixContactsDetailsDao.selectAll(contactsSearchVo));
    }

    @Override
    public List<String> selectByOne() {
        List<String> ixCustomerDetails = ixContactsDetailsDao.selectByOne();
        return ixCustomerDetails;
    }

    @Override
    public int insert(IxContactsDetails record) {
        record.setId(idWorker.nextId()+"");
        return ixContactsDetailsDao.insert(record);
    }

    @Override
    public int updateByPrimaryKeySelective(IxContactsDetails record) {
        return ixContactsDetailsDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public IxContactsDetails selectByPrimaryKey(String id) {
        return ixContactsDetailsDao.selectByPrimaryKey(id);
    }

    @Override
    public int deleteByPrimaryKey(String id) {
        return ixContactsDetailsDao.deleteByPrimaryKey(id);
    }

    @Override
    public List<Map> selectYomer(String id) {
        return ixContactsDetailsDao.selectYomer(id);
    }
}
