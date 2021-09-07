package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.hanwen.IxIndexesDao;
import com.trkj.crmproject.entity.hanwen.IxIndexes;
import com.trkj.crmproject.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IxIndexesServiceImpl implements IxIndexesService {
@Autowired
private IxIndexesDao indexesDao;
@Autowired
private IdWorker idWorker;
    @Override
    public int insert(IxIndexes record) {
        record.setId(idWorker.nextId()+"");
        return indexesDao.insert(record);
    }


    @Override
    public PageInfo<IxIndexes> selectByAll(int num,int size) {
        PageHelper.startPage(num,size);
        return new PageInfo<IxIndexes>(indexesDao.selectByAll(num, size));
    }

    @Override
    public int updateByPrimaryKey(IxIndexes record) {
        return indexesDao.updateByPrimaryKey(record);
    }
}
