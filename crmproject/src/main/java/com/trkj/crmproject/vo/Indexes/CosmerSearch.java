package com.trkj.crmproject.vo.Indexes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CosmerSearch {
    private Integer pageNum;
    private Integer pageSize;
    private String keyword;
    private String type;
    private String lifeCycle;
    private String name;
}
