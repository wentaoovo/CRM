package com.trkj.crmproject.entity.hanwen;

import java.io.Serializable;
import lombok.Data;

/**
 * ix_contacts_details
 * @author 
 */
@Data
public class IxContactsDetails implements Serializable {
    /**
     * 联系人明细id
     */
    private String id;

    /**
     * 客户id
            
     */
    private String customerDetailsId;

    /**
     * 联系人id
            
     */
    private String contactsId;

    /**
     * 姓名
            
     */
    private String contactsName;

    /**
     * 移动电话
            
     */
    private String mobilePhone;

    /**
     * 对应客户
            
     */
    private String corrCustomer;

    /**
     * 联系人分类
            
     */
    private String contactCategory;

    /**
     * 负责业务
            
     */
    private String business;

    /**
     * 性别
            
     */
    private String sex;

    /**
     * 称谓
            
     */
    private String appellation;

    /**
     * 类型
            
     */
    private String genre;

    /**
     * 部门
            
     */
    private String department;

    /**
     * 职务
            
     */
    private String job;

    /**
     * 微信
            
     */
    private String wechat;

    /**
     * qq
     */
    private String qq;

    /**
     * 微信昵称
            
     */
    private String wechatName;

    /**
     * qq昵称
     */
    private String qqName;

    /**
     * 旺旺
            
     */
    private String wangwang;

    /**
     * 邮件地址
            
     */
    private String mailingAddress;

    /**
     * 工作电话
            
     */
    private String workPhone;

    /**
     * 家庭电话
     */
    private String homePhone;

    /**
     * 传真
            
     */
    private String fax;

    /**
     * 邮编
            
     */
    private String postcode;

    /**
     * 家庭住址
            
     */
    private String homeAddress;

    /**
     * 爱好
            
     */
    private String hobby;

    /**
     * 身份证
     */
    private String cardId;

    /**
     * 备注
            
     */
    private String remarks;

    /**
     * 习惯
            
     */
    private String habit;

    /**
     * 兴趣
            
     */
    private String interest;

    /**
     * 性格
            
     */
    private String characters;

    /**
     * 社交特点
            
     */
    private String socialCharacteristics;

    /**
     * 配偶情况
            
     */
    private String spouse;

    /**
     * 子女情况
            
     */
    private String children;

    /**
     * 年收入
            
     */
    private String annualIncome;

    /**
     * 消费习惯
            
     */
    private String consumptionHabits;

    private IxCustomerDetails name;

    private static final long serialVersionUID = 1L;
}