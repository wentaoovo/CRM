package com.trkj.crmproject.entity.hanwen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * ix_details
 * @author 
 */
@Data
public class IxDetails implements Serializable {
    /**
     * 销售机会明细表
     */
    private String id;

    private String contactsDetailsId;

    private String customerDetailsId;

    /**
     * 机会主题
     */
    private String opportunityTheme;

    /**
     * 更新日期
            
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GKT+8")
    private Date updateDate;

    /**
     * 客户
            
     */
    private String customerName;

    /**
     * 状态
            
     */
    private Integer state;

    /**
     * 客户联系人
            
     */
    private String contactsName;

    /**
     * 销售类型
            
     */
    private String salesType;

    /**
     * 发现时间
            
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GKT+8")
    private Date findDate;

    /**
     * 来源
            
     */
    private String source;

    /**
     * 负责人
            
     */
    private String realName;

    /**
     * 提供人
     */
    private String provider;

    /**
     * 客户需求
            
     */
    private String customerDemand;

    /**
     * 预计签单时间
            
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GKT+8")
    private Date signingDate;

    /**
     * 可能性
            
     */
    private String possibility;

    /**
     * 预计金额
            
     */
    private BigDecimal estimatedAmount;

    /**
     * 阶段
            
     */
    private String stage;

    /**
     * 阶段备注
            
     */
    private String stageRemarks;

    /**
     * 阶段停留
            
     */
    private String stayPhase;

    private IxContactsDetails detailscontacts;

    private IxCustomerDetails name;

    private static final long serialVersionUID = 1L;
}