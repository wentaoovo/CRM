package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.entity.hanwen.IxIndexes;
import com.trkj.crmproject.vo.Indexes.CosmerSearch;
import com.trkj.crmproject.vo.Indexes.IndexesSearchVo;

import java.util.List;

public interface IxIndexesService {
    int insert(IxIndexes record);
    PageInfo<IxIndexes> selectByAll(IndexesSearchVo indexesSearchVo);
    int updateByPrimaryKey(IxIndexes record);
    IxIndexes selectById(String id);
}
