package com.trkj.crmproject.dao.wentao;

import com.trkj.crmproject.entity.wentao.Indent;
import com.trkj.crmproject.vo.Indent.SearchListVo;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface IndentDao {
    int deleteTl(@Param("id") String id,@Param("deletetime") Date deletetime);

    int insert(Indent record);

    Indent selectById(String id);

    List<Indent> selectAll(SearchListVo searchListVo);

    int update(Indent record);
}