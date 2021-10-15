package com.trkj.crmproject.vo.Indexes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuatationSearchVo {
    private Integer pageNum;
    private Integer pageSize;
    private String keyword;
    private String orderConcert;
    private String quotationTheme;
}
