package com.trkj.crmproject.dao.wentao;

import com.trkj.crmproject.entity.wentao.ProductClass;

import java.util.List;

public interface ProductClassDao {
    int deleteById(String id);

    int insert(ProductClass record);

    ProductClass selectById(String id);

    List<ProductClass> selectAll();

    int update(ProductClass record);
}