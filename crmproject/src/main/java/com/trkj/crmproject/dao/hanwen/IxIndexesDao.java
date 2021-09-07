package com.trkj.crmproject.dao.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxIndexes;

import java.util.List;

public interface IxIndexesDao {
    int deleteByPrimaryKey(String id);

    int insert(IxIndexes record);

    int insertSelective(IxIndexes record);

    List<IxIndexes> selectByAll(int num, int size);

    int updateByPrimaryKeySelective(IxIndexes record);

    int updateByPrimaryKey(IxIndexes record);

}