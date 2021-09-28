package com.trkj.crmproject.entity.wentao;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * product_class
 * @author 
 */
@Data
public class ProductClass implements Serializable {
    /**
     * 产品分类表ID
     */
    private String id;

    /**
     * 父ID
     */
    private String pId;

    /**
     * 分类名称
     */
    private String name;

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