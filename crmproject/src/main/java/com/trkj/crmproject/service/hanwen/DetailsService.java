package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxDetails;
import com.trkj.crmproject.vo.Indexes.DetailsSearchVo;

import java.util.List;
import java.util.Map;

public interface DetailsService {
    PageInfo<IxDetails> selectAll(DetailsSearchVo detailsSearchVo);
    List<Map> selecttwo(String id);
    List<Map> selectthree();
    int insert(IxDetails record);
    int updateByPrimaryKeySelective(IxDetails record);
    int deleteByPrimaryKey(String id);
    List<Map> selectDtmer();
}
