package com.trkj.crmproject.dao.hanwen;

import com.trkj.crmproject.entity.hanwen.IxOfferDetails;

public interface IxOfferDetailsDao {
    int deleteByPrimaryKey(String id);

    int insert(IxOfferDetails record);

    int insertSelective(IxOfferDetails record);

    IxOfferDetails selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IxOfferDetails record);

    int updateByPrimaryKey(IxOfferDetails record);
}