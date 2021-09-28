package com.trkj.crmproject.service.wentao;

import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.entity.wentao.Product;
import com.trkj.crmproject.vo.Indent.SearchListVo;

import java.util.List;

public interface ProductService {
    boolean deleteById(String id);

    boolean insert(Product record);

    Product selectById(String id);

    PageInfo<Product> selectAll(SearchListVo vo);

    boolean update(Product record);
}
