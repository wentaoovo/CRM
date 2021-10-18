package com.trkj.crmproject.dao.hanwen;

import com.trkj.crmproject.entity.hanwen.IxCustomerDetails;
import com.trkj.crmproject.entity.hanwen.IxDetails;
import com.trkj.crmproject.vo.Indexes.CosmerSearch;
import com.trkj.crmproject.vo.Indexes.DetailsSearchVo;

import java.util.List;
import java.util.Map;

public interface IxDetailsDao {
    int deleteByPrimaryKey(String id);

    int insert(IxDetails record);

    int insertSelective(IxDetails record);

    IxDetails selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(IxDetails record);

    int updateByPrimaryKey(IxDetails record);

    List<IxDetails> selectAll(DetailsSearchVo detailsSearchVo);

    List<String> selecttwo();

    List<String> selectthree();

    List<Map> selectDtmer();
}