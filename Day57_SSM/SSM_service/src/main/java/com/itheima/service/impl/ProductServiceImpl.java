package com.itheima.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itheima.dao.ProductDao;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Product;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-15 21:28
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public void save(Product product) {
        productDao.save(product);
    }

    @Override
    public Product findById(Integer id) {
        return productDao.findById(id);
    }

    @Override
    public void update(Product product) {
        productDao.update(product);
    }

    @Override
    public void delOne(Integer id) {
        productDao.delOne(id);
    }

    @Override
    public void delMany(Integer[] ids) {
        for (Integer id : ids) {
            productDao.delOne(id);
        }
    }

    @Override
    public PageBean<Product> findByPage(Integer pageNum, Integer pageSize) {
        //创建PageBean
        PageBean<Product> pageBean = new PageBean<Product>();
        //给PageBean赋值
        //当前页 -- 页面传参
        pageBean.setPageNum(pageNum);
        //每页显示的条数 -- 页面传参
        pageBean.setPageSize(pageSize);
        //总条数 -- 数据库查询
        Integer TotalCount = productDao.findTotalCount();
        pageBean.setTotalCount(TotalCount);
        //总页数 -- 计算
        pageBean.setTotalPage((int) Math.ceil(TotalCount * 1.0 / pageSize));
        //当前页要展示的数据 -- 数据库查询
        Integer startIndex = (pageNum - 1) * pageSize;
        pageBean.setData(productDao.findByPage(startIndex, pageSize));
        //返回PageBean
        return pageBean;
    }

    @Override
    public PageInfo<Product> findByPageHelper(Integer pageNum, Integer pageSize) {
        //开始分页
        PageHelper.startPage(pageNum, pageSize);
        //查询所有
        List<Product> productList = productDao.findAll();
        //创建pageinfo
        PageInfo<Product> pageInfo = new PageInfo<Product>(productList, 5);
        return pageInfo;
    }

}
