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
    private String corrCustomers;
    private String realName;
    private String contacts;

    /**
     * 关键词
     */
    private String keyword;
}
