package com.trkj.crmproject.service.hanwen;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.hanwen.IxDetails;
import com.trkj.crmproject.vo.Indexes.DetailsSearchVo;

import java.util.List;

public interface DetailsService {
    PageInfo<IxDetails> selectAll(DetailsSearchVo detailsSearchVo);
    List<String> selecttwo();
    List<String> selectthree();
    int insert(IxDetails record);
    int updateByPrimaryKeySelective(IxDetails record);
    int deleteByPrimaryKey(String id);
}
