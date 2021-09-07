package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxIndexes;

import java.util.List;

public interface IxIndexesService {
    int insert(IxIndexes record);
    PageInfo<IxIndexes> selectByAll(int num,int size);
    int updateByPrimaryKey(IxIndexes record);
}
