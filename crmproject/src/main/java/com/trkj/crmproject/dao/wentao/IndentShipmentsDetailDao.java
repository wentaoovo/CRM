package com.trkj.crmproject.dao.wentao;

import com.trkj.crmproject.entity.wentao.IndentShipmentsDetail;

import java.util.List;

public interface IndentShipmentsDetailDao {
    int deleteByPrimaryKey(String id);

    int insert(List<IndentShipmentsDetail> list);

    int insertSelective(IndentShipmentsDetail record);

    IndentShipmentsDetail selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IndentShipmentsDetail record);

    int updateByPrimaryKey(IndentShipmentsDetail record);
}