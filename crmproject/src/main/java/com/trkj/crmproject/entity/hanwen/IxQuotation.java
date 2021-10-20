package com.trkj.crmproject.entity.hanwen;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * ix_quotation
 * @author 
 */
@Data
public class IxQuotation implements Serializable {
    /**
     * 报价id
            
     */
    private String id;

    /**
     * 机会id
            
     */
    private String salesId;

    /**
     * 客户id
            
     */
    private String customerId;

    /**
     * 联系人id
            
     */
    private String contactsId;
   /*
   *机会id
   *
   * */
    private String chanceId;
    /**
     * 员工id
            
     */
    private String employeeId;

    /**
     * 主题
            
     */
    private String quotationTheme;

    /**
     * 转成订单
            
     */
    private String orderConcert;

    /**
     * 客户
            
     */
    private String customerName;

    /**
     * 日期
            
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GKT+8")
    private Date timeNow;

    /**
     * 报价（总）
            
     */
    private BigDecimal totalQuotation;

    /**
     * 销售机会
            
     */
    private String chanceName;

    /**
     * 预估毛利
            
     */
    private BigDecimal grossProfit;

    /**
     * 明细
            
     */
    private String detailed;

    /**
     * 接收人
            
     */
    private String contactsName;

    /**
     * 报价人
            
     */
    private String employeeName;

    /**
     * 报价人联系方式
            
     */
    private String employeeContactWay;

    /**
     * 交付说明
            
     */
    private String deliverInstructions;

    /**
     * 付款说明
            
     */
    private String paymentInstructions;

    /**
     * 包装运货说明
            
     */
    private String packingInstructions;

    /**
     * 备注
            
     */
    private String remarks;

    private IxContactsDetails detailscontacts;

    private IxCustomerDetails name;

    private IxDetails sales;

    private static final long serialVersionUID = 1L;
}