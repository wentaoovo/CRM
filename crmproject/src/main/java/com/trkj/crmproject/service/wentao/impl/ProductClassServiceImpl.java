package com.trkj.crmproject.service.wentao.impl;

import com.trkj.crmproject.dao.wentao.ProductClassDao;
import com.trkj.crmproject.entity.wentao.ProductClass;
import com.trkj.crmproject.service.wentao.ProductClassService;
import com.trkj.crmproject.util.IdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ProductClassServiceImpl implements ProductClassService {
    @Resource
    private ProductClassDao productClassDao;
    @Autowired
    private IdWorker idWorker;
    @Override
    /**
     * 根据id删除产品类别
     */
    public boolean deleteById(String id) {
        return productClassDao.deleteById(id) > 0 ? true : false;
    }

    /**
     * 新增产品类别
     * @param record
     * @return
     */
    @Override
    public boolean insert(ProductClass record) {
        record.setId(idWorker.nextId()+"");
        record.setAddtime(new Date());
        record.setUpdatetime(new Date());
        record.setTimeliness(0);
        return productClassDao.insert(record) > 0 ? true : false;
    }

    /**
     * 根据id查询产品类别
     * @param id
     * @return
     */
    @Override
    public ProductClass selectById(String id) {
        return productClassDao.selectById(id);
    }

    /**
     * 查询全部产品类别
     * @return
     */
    @Override
    public List<ProductClass> selectAll() {
        return productClassDao.selectAll();
    }

    /**
     * 修改产品类别
     * @param record
     * @return
     */
    @Override
    public boolean update(ProductClass record) {
        record.setUpdatetime(new Date());
        return productClassDao.update(record) > 0 ? true : false;
    }
}
