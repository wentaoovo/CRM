package com.trkj.crmproject.entity.wentao;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * product
 * @author 
 */
@Data
public class Product implements Serializable {
    /**
     * 产品ID
     */
    private String id;

    /**
     * 分类ID
     */
    private String classId;

    /**
     * 产品名称
     */
    private String name;

    /**
     * 编码
     */
    private String coding;

    /**
     * 状态
     */
    private Integer state;

    /**
     * 单位
     */
    private String unit;

    /**
     * 价格
     */
    private BigDecimal price;

    /**
     * 成本价格
     */
    private BigDecimal costPrice;

    /**
     * 型号
     */
    private String model;

    /**
     * 重量
     */
    private String weight;

    /**
     * 产品图片
     */
    private String img;

    /**
     * 库存上限
     */
    private Integer upperLimit;

    /**
     * 库存下限
     */
    private Integer lowerLimit;

    /**
     * 库存
     */
    private Integer count;

    /**
     * 三包
     */
    private Integer warranty;

    /**
     * 明细概要
     */
    private String outline;

    /**
     * 折扣规范
     */
    private String discountNorm;

    /**
     * 产品说明
     */
    private String description;

    /**
     * 技术参考
     */
    private String technical;

    /**
     * 常见问题
     */
    private String faq;

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