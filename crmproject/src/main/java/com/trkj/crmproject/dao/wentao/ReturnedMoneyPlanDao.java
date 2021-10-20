package com.trkj.crmproject.dao.wentao;

import com.trkj.crmproject.entity.wentao.ReturnedMoneyPlan;

import java.util.List;

public interface ReturnedMoneyPlanDao {
    int deleteByPrimaryKey(String id);

    int insert(List<ReturnedMoneyPlan> list);

    int insertSelective(ReturnedMoneyPlan record);

    ReturnedMoneyPlan selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(ReturnedMoneyPlan record);

    int updateByPrimaryKey(ReturnedMoneyPlan record);
}