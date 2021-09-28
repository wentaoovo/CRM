package com.trkj.crmproject.vo.Product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductSearchVo {
    private Integer pageNum;
    private Integer pageSize;
    private String keyword;
}
