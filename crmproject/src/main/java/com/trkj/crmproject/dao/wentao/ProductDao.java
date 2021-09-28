package com.trkj.crmproject.dao.wentao;

import com.trkj.crmproject.entity.wentao.Product;
import com.trkj.crmproject.vo.Indent.SearchListVo;

import java.util.List;

public interface ProductDao {
    int deleteById(String id);

    int insert(Product record);

    Product selectById(String id);

    List<Product> selectAll(SearchListVo vo);

    int update(Product record);
}