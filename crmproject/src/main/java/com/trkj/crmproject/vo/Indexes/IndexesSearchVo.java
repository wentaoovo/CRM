package com.trkj.crmproject.vo.Indexes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IndexesSearchVo {
    private Integer pageNum;
    private Integer pageSize;
    private String search;
    private String corrCustomers;
}
