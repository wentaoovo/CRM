package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.hanwen.IxIndexesDao;
import com.trkj.crmproject.entity.hanwen.IxIndexes;
import com.trkj.crmproject.entity.wentao.Indent;
import com.trkj.crmproject.util.IdWorker;
import com.trkj.crmproject.vo.Indexes.IndexesSearchVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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
    public PageInfo<IxIndexes> selectByAll(IndexesSearchVo indexesSearchVo) {
        if (indexesSearchVo.getPageNum()==null){
            indexesSearchVo.setPageNum(1);
        }
        if (indexesSearchVo.getPageSize()==null){
            indexesSearchVo.setPageSize(10);
        }
        PageHelper.startPage(indexesSearchVo.getPageNum(),indexesSearchVo.getPageSize());
        return new PageInfo<IxIndexes>(indexesDao.selectByAll(indexesSearchVo));
    }

    @Override
    public int updateByPrimaryKey(IxIndexes record) {
        return indexesDao.updateByPrimaryKey(record);
    }

    @Override
    public IxIndexes selectById(String id) {
        return indexesDao.selectById(id);
    }


}
