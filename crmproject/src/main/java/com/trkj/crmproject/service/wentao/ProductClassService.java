package com.trkj.crmproject.service.wentao;

import com.trkj.crmproject.entity.wentao.ProductClass;

import java.util.List;

public interface ProductClassService {
    boolean deleteById(String id);

    boolean insert(ProductClass record);

    ProductClass selectById(String id);

    List<ProductClass> selectAll();

    boolean update(ProductClass record);
}
