package com.trkj.crmproject.entity.wentao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * returned_money_plan
 * @author 
 */
@Data
public class ReturnedMoneyPlan implements Serializable {
    /**
     * 回款计划表ID
     */
    private String id;

    /**
     * 对应订单ID
     */
    private String indentId;

    /**
     * 对应订单标题
     */
    private String indentTheme;

    /**
     * 客户ID
     */
    private String customerId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 计划回款日期
     */
    private Date datePlan;

    /**
     * 期次
     */
    private Integer issue;

    /**
     * 金额
     */
    private BigDecimal money;

    /**
     * 是否回款
     */
    private Integer whether;

    /**
     * 所有者
     */
    private String possessor;

    /**
     * 负责人
     */
    private String principal;

    /**
     * 状态
     */
    private Integer state;

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

    private static final long serialVersionUID = 1L;
}