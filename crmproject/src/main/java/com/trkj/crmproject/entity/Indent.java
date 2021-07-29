package com.trkj.crmproject.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author MarkerHub
 * @since 2021-07-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Indent implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 订单号ID
     */
    private String id;

    /**
     * 主题
     */
    private String theme;

    /**
     * 分类
     */
    private String classify;

    /**
     * 对应客户ID
     */
    private String customerId;

    /**
     * 对应客户名称
     */
    private String customerName;

    /**
     * 对应机会ID
     */
    private String chanceId;

    /**
     * 对应机会名称
     */
    private String chanceName;

    /**
     * 总金额
     */
    private BigDecimal totalMoney;

    /**
     * 订单日期
     */
    private LocalDate indentDate;

    /**
     * 最晚发货日期
     */
    private LocalDate latestDeliveryDate;

    /**
     * 客户签约人ID
     */
    private String contactsId;

    /**
     * 客户签约人姓名
     */
    private String contactsName;

    /**
     * 备注
     */
    private String remark;

    /**
     * 发货金额
     */
    private BigDecimal outMoney;

    /**
     * 回款金额
     */
    private BigDecimal returnedMoney;

    /**
     * 总成本
     */
    private BigDecimal cost;

    /**
     * 总折扣
     */
    private BigDecimal discount;

    /**
     * 毛利
     */
    private BigDecimal grossMargin;

    /**
     * 预估毛利
     */
    private BigDecimal forgrossMargin;

    /**
     * 开发票金额
     */
    private BigDecimal invoiceValue;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 订单所有者ID
     */
    private String possessorId;

    /**
     * 订单所有者
     */
    private String possessor;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 收件人姓名
     */
    private String addressee;

    /**
     * 收件人电话
     */
    private String addresseeTelephone;

    /**
     * 收件人移动电话
     */
    private String addresseePhone;

    /**
     * 省区
     */
    private String province;

    /**
     * 城市
     */
    private String city;

    /**
     * 地址类型
     */
    private String addressType;

    /**
     * 收货人地址
     */
    private String addresseeSite;

    /**
     * 邮编
     */
    private String postcode;

    /**
     * 增加人
     */
    @TableField("AddName")
    private String AddName;

    /**
     * 增加时间
     */
    @TableField("AddTime")
    private LocalDateTime AddTime;

    /**
     * 修改人
     */
    @TableField("UpdateName")
    private String UpdateName;

    /**
     * 最后修改时间
     */
    @TableField("UpdateTime")
    private LocalDateTime UpdateTime;

    /**
     * 删除人
     */
    @TableField("DeleteName")
    private String DeleteName;

    /**
     * 删除时间
     */
    @TableField("DeleteTime")
    private LocalDateTime DeleteTime;

    /**
     * 时效性
     */
    @TableField("TimeLiness")
    private Integer TimeLiness;


}
