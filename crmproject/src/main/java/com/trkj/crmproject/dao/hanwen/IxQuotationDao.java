package com.trkj.crmproject.dao.hanwen;

import com.trkj.crmproject.entity.hanwen.IxQuotation;
import com.trkj.crmproject.vo.Indexes.QuatationSearchVo;

import java.util.List;

public interface IxQuotationDao {
    int deleteByPrimaryKey(String id);

    int insert(IxQuotation record);

    int insertSelective(IxQuotation record);

    IxQuotation selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IxQuotation record);

    int updateByPrimaryKey(IxQuotation record);

    List<IxQuotation> selectAll(QuatationSearchVo QuatationSearchVo);

    List<String> selecttwo();

    List<String> selectthree();

    List<String> selectfive();

}