package com.trkj.crmproject.service.wentao.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.trkj.crmproject.dao.wentao.ProductDao;
import com.trkj.crmproject.entity.wentao.Product;
import com.trkj.crmproject.service.wentao.ProductService;
import com.trkj.crmproject.util.IdWorker;
import com.trkj.crmproject.vo.Indent.SearchListVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Resource
    private ProductDao productDao;
    @Resource
    private IdWorker idWorker;

    /**
     * 根据id删除产品
     * @param id
     * @return
     */
    @Override
    public boolean deleteById(String id) {
        return productDao.deleteById(id) > 0 ? true : false;
    }

    /**
     * 新增产品
     * @param
     * @return
     */
    @Override
    public boolean insert(Product product) {
        product.setId(idWorker.nextId()+"");
        product.setAddtime(new Date());
        product.setUpdatetime(new Date());
        product.setTimeliness(0);
        return productDao.insert(product) > 0 ? true : false;
    }

    /**
     * 根据id查询产品
     * @param id
     * @return
     */
    @Override
    public Product selectById(String id) {
        return productDao.selectById(id);
    }

    /**
     * 查询所以在售产品
     * @return
     */
    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    /**
     * 分页加条件查询产品列表
     * @param vo
     * @return
     */
    @Override
    public PageInfo<Product> selectAll(SearchListVo vo) {
        if (vo.getPageNum()==null){
            vo.setPageNum(1);
        }
        if (vo.getPageSize()==null){
            vo.setPageSize(10);
        }
        PageHelper.startPage(vo.getPageNum(),vo.getPageSize());
        return new PageInfo<Product>(productDao.selectAll(vo));
    }

    /**
     * 修改产品
     * @param record
     * @return
     */
    @Override
    public boolean update(Product record) {
        record.setUpdatetime(new Date());
        return productDao.update(record) > 0 ? true : false;
    }
}
