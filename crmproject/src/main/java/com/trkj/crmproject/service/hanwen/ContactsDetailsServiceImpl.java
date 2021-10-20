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
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class ContactsDetailsServiceImpl implements ContactsDetailsService {
    @Autowired
    private IxContactsDetailsDao ixContactsDetailsDao;
    @Autowired
    private IdWorker idWorker;

    @Override
    //分页查询
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
    public List<Map> selectByOne() {
        List<Map> ixCustomerDetails = ixContactsDetailsDao.selectByOne();
        return ixCustomerDetails;
    }

    @Override
    //新增联系人
    public int insert(IxContactsDetails record) {
        //雪花算法自动生成id
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
