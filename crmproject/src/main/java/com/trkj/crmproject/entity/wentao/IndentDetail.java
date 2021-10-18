package com.trkj.crmproject.entity.wentao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * indent_detail
 * @author 
 */
@Data
public class IndentDetail implements Serializable {
    /**
     * 明细ID
     */
    private String id;

    /**
     * 订单ID
     */
    private String indentId;

    /**
     * 产品ID
     */
    private String productId;

    /**
     * 产品名称
     */
    private String productName;

    /**
     * 单价
     */
    private BigDecimal unitPrice;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 产品数量
     */
    private Integer quantity;

    /**
     * 型号
     */
    private String model;

    /**
     * 折扣
     */
    private BigDecimal discount;

    /**
     * 备注
     */
    private String remark;

    /**
     * 增加人
     */
    private String addname;

    /**
     * 增加时间
     */
    private Date addtime;

    /**
     * 修改人
     */
    private String updatename;

    /**
     * 最后修改时间
     */
    private Date updatetime;

    /**
     * 删除人
     */
    private String deletename;

    /**
     * 删除时间
     */
    private Date deletetime;

    /**
     * 时效性
     */
    private Integer timeliness;
    /**
     * 成本价格
     */
    private BigDecimal costPrice;

    private static final long serialVersionUID = 1L;
}