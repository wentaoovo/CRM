package com.trkj.crmproject.vo.Indent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchListVo {
    /**
     * 页码
     */
    private Integer pageNum;
    /**
     * 页尺寸
     */
    private Integer pageSize;
    /**
     * 关键词
     */
    private String keyword;
    /**
     * 状态   0执行中,1结束,2意外中止
     */
    private Integer state;
    /**
     * 分类
     */
    private String classify;
}
