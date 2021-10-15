package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxQuotation;
import com.trkj.crmproject.vo.Indexes.QuatationSearchVo;

import java.util.List;

public interface QuatationService {
    PageInfo<IxQuotation> selectAll(QuatationSearchVo QuatationSearchVo);
    List<String> selecttwo();
    List<String> selectthree();
    List<String> selectfive();
    int insert(IxQuotation record);
    int updateByPrimaryKeySelective(IxQuotation record);
    int deleteByPrimaryKey(String id);
    IxQuotation selectByPrimaryKey(String id);
}
