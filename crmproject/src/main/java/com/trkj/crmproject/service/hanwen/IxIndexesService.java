package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxIndexes;
import com.trkj.crmproject.vo.Indexes.IndexesSearchVo;

import java.util.List;

public interface IxIndexesService {
    int insert(IxIndexes record);
    PageInfo<IxIndexes> selectByAll(Integer pageNum ,Integer pageSize);
    int updateByPrimaryKey(IxIndexes record);
}
