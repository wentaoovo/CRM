package com.trkj.crmproject.entity.wentao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * indent_shipments
 * @author 
 */
@Data
public class IndentShipments implements Serializable {
    /**
     * 发货单ID
     */
    private String id;

    /**
     * 订单ID
     */
    private String indentId;

    /**
     * 客户名称
     */
    private String customerName;

    /**
     * 发货日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GMT+8")
    private Date shdate;

    /**
     * 发货方式
     */
    private String mode;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 打包件数
     */
    private Integer packets;

    /**
     * 重量
     */
    private String weight;

    /**
     * 物流公司
     */
    private String logisticsCompany;

    /**
     * 物流单号
     */
    private String trackingNumber;

    /**
     * 运费
     */
    private BigDecimal freight;

    /**
     * 备注
     */
    private String remark;

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

    private List<IndentShipmentsDetail> indentDetail;
    private static final long serialVersionUID = 1L;
}