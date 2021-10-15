package com.trkj.crmproject.service.wentao;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.wentao.Indent;
import com.trkj.crmproject.vo.Indent.SearchListVo;

import java.util.Map;

public interface IndentService {
    boolean deleteTl(String id);

    Map insert(Indent record);

    Indent selectById(String id);

    PageInfo<Indent> selectAll(SearchListVo vo);

    Indent selectJoin(String id);

    boolean update(Indent record);
}
