package com.trkj.crmproject.entity.hanwen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * ix_indexes
 * @author 
 */
@Data
public class IxIndexes implements Serializable {
    /**
     * 索引id
     */
    private String id;

    /**
     * 采集内容
            
     */

    private String collectionContent;

    /**
     * 公司
     */
    private String company;

    /**
     * 对应客户
            
     */

    private String corrCustomers;

    /**
     * 成本
            
     */
    private BigDecimal cost;

    /**
     * 状态
            
     */
    private Integer state;

    /**
     * 所有者
            
     */
    private String realName;

    /**
     * 联系人
     */
    private String contacts;

    /**
     * 联系方式
            
     */
    private String contactsInformation;

    /**
     * 分类
            
     */
    private String classification;

    /**
     * 提交时间
            
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GKT+8")
    private Date subTime;

    private static final long serialVersionUID = 1L;
}