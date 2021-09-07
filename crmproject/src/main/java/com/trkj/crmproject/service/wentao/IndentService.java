package com.trkj.crmproject.service.wentao;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.wentao.Indent;
import com.trkj.crmproject.vo.Indent.SearchListVo;

public interface IndentService {
    boolean deleteTl(String id);

    boolean insert(Indent record);

    Indent selectById(String id);

    PageInfo<Indent> selectAll(SearchListVo vo);

    boolean update(Indent record);
}
