package com.trkj.crmproject.service.wentao.impl;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.wentao.IndentDao;
import com.trkj.crmproject.entity.wentao.Indent;
import com.trkj.crmproject.service.wentao.IndentService;
import com.trkj.crmproject.util.IdWorker;
import com.trkj.crmproject.vo.Indent.SearchListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class IndentServiceImpl implements IndentService {
    @Resource
    private IndentDao indentDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 根据id删除订单
     * @param id
     * @return
     */
    @Override
    public boolean deleteTl(String id) {
        int i = indentDao.deleteTl(id,new Date());
        if (i>0){
            return true;
        }
        return false;
    }

    /**
     * 新增订单
     * @param
     * @return
     */
    @Override
    public Map insert(Indent indent) {
        indent.setId(idWorker.nextId()+"");
        indent.setAddtime(new Date());
        indent.setIndentDate(new Date());
//        indent.setOutMoney(BigDecimal.valueOf(0));
//        indent.setReturnedMoney(BigDecimal.valueOf(0));
//        indent.setCost(BigDecimal.valueOf(0));
//        indent.setDiscount(BigDecimal.valueOf(0));
//        indent.setGrossMargin(BigDecimal.valueOf(0));
//        indent.setForgrossMargin(BigDecimal.valueOf(0));
//        indent.setInvoiceValue(BigDecimal.valueOf(0));
//        indent.setFreight(BigDecimal.valueOf(0));
        indent.setTimeliness(0);
        indent.setUpdatetime(new Date());
        indent.setState(0);
        int i = indentDao.insert(indent);
        Map map=new HashMap();
        if (i>0){
            map.put("boolean",true);
            map.put("id",indent.getId());
            return map;
        }
        map.put("boolean",false);
        return map;
    }

    /**
     * 根据id查询订单
     * @param id
     * @return
     */
    @Override
    public Indent selectById(String id) {
        return indentDao.selectById(id);
    }

    /**
     * 查询订单列表
     * @return
     */
    @Override
    public PageInfo<Indent> selectAll(SearchListVo vo) {
        if (vo.getPageNum()==null){
            vo.setPageNum(1);
        }
        if (vo.getPageSize()==null){
            vo.setPageSize(10);
        }
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        return new PageInfo<Indent>(indentDao.selectAll(vo));
    }

    /**
     * 订单,明细连接查询
     * @param id
     * @return
     */
    @Override
    public Indent selectJoin(String id) {
        return indentDao.selectJoin(id);
    }

    /**
     * 根据id修改订单
     * @param record
     * @return
     */
    @Override
    public boolean update(Indent record) {
        record.setUpdatetime(new Date());
        int i = indentDao.update(record);
        if (i>0){
            return true;
        }
        return false;
    }
}
