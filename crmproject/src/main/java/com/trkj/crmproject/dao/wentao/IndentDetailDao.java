package com.trkj.crmproject.dao.wentao;

import com.trkj.crmproject.entity.wentao.IndentDetail;

import java.util.List;

public interface IndentDetailDao {
    int deleteById(String id);

    int insert(List<IndentDetail> list);

    List<IndentDetail> selectByPid(String indentId);

    List<IndentDetail> selectById(String id);

    int updateById(List<IndentDetail> list);
}