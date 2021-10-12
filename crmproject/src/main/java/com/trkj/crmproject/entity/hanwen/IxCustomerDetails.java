package com.trkj.crmproject.entity.hanwen;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

/**
 * ix_customer_details
 * @author 
 */
@Data
public class IxCustomerDetails implements Serializable {
    /**
     * 明细id
     */
    private String id;


    /**
     * 客户名称
     */
    private String name;
    /**
     * 公司
     */
    private String company;

    /**
     * 种类
            
     */
    private String type;
    /**
     * 所有者

     */
    private String realName;

    /**
     * 生命周期
            
     */

    private String lifeCycle;

    /**
     * 首次签约
            
     */
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "GKT+8")
    private Date firstSigning;

    /**
     * 来源
            
     */
    private String source;

    /**
     * 信用级别
            
     */
    private String creditLevel;

    /**
     * 阶段
            
     */
    private String stage;

    /**
     * 关系等级
            
     */
    private String nexusLevel;

    /**
     * 结款方式
            
     */
    private String settlementMethod;

    /**
     * 价格策略
            
     */
    private String priceStrategy;

    /**
     * 行业
            
     */
    private String industry;

    /**
     * 人员规模
            
     */
    private String personnelSize;

    /**
     * 淘宝编号
            
     */
    private String taobaoNumber;

    /**
     * 京东编号
            
     */
    private String jingdongNumber;

    /**
     * 天猫编号
            
     */
    private String tianmaoNumber;

    /**
     * 易订货编号
            
     */
    private String yidinghuoNumber;

    /**
     * 公司简介
            
     */
    private String companyProfile;

    /**
     * 电话
            
     */
    private String telephone;

    /**
     * 手机
            
     */
    private String mobilePhone;

    /**
     * 网站
            
     */
    private String website;

    /**
     * 省
            
     */
    private String province;

    /**
     * 市
            
     */
    private String city;

    /**
     * 区
            
     */
    private String area;

    /**
     * 邮编
            
     */
    private String postcode;

    /**
     * 地址
            
     */
    private String address;

    /**
     * 备注
            
     */
    private String remarks;

    private static final long serialVersionUID = 1L;
}