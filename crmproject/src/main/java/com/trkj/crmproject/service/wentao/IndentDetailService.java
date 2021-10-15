package com.trkj.crmproject.service.wentao;

import com.trkj.crmproject.entity.wentao.IndentDetail;

import java.util.List;

public interface IndentDetailService {
    Boolean deleteById(String id);

    Boolean insert(List<IndentDetail> record);

    List<IndentDetail> selectByPid(String indentId);

    Boolean updateById(List<IndentDetail> record);
}
