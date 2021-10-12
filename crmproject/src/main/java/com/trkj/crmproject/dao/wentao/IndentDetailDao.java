package com.trkj.crmproject.dao.wentao;

import com.trkj.crmproject.entity.wentao.IndentDetail;

import java.util.List;

public interface IndentDetailDao {
    int deleteById(String id);

    int insert(IndentDetail record);

    List<IndentDetail> selectByPid(String indentId);

    int updateById(IndentDetail record);
}