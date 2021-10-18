package com.trkj.crmproject.entity.hanwen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * ix_offer_details
 * @author 
 */
@Data
public class IxOfferDetails implements Serializable {
    /**
     * 报价单明细ID
            
     */
    private String id;

    /**
     * 报价单id
            
     */
    private String quotationId;

    /**
     * 产品id
            
     */
    private String productId;

    /**
     * 员工id
            
     */
    private String employeeId;

    /**
     * 客户id
            
     */
    private String customerId;

    /**
     * 产品
            
     */
    private String product;

    /**
     * 数量
            
     */
    private String quantity;

    /**
     * 单价
            
     */
    private BigDecimal unitPrice;

    /**
     * 金额
            
     */
    private BigDecimal amountMoney;

    /**
     * 所有人
            
     */
    private String employeeName;

    /**
     * 创建时间
            
     */
    private Date creationTime;

    /**
     * 客户
            
     */
    private String customerName;

    /**
     * 报价单
            
     */
    private String quotationTheme;

    private static final long serialVersionUID = 1L;
}