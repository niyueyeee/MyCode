package com.itheima.service.impl;

import com.itheima.dao.CategoryDao;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Category;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;
import com.itheima.service.CategoryService;
import com.itheima.service.ProductService;
import com.itheima.utils.BeanFactory;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    //通过 工具类结合配置文件 获取接口的子类对象
    private ProductDao productDao = BeanFactory.newInstance(ProductDao.class);

    //c查询最新商品
    @Override
    public List<Product> findNews() {
        List<Product> list = null;

        try {
            list = productDao.findNews();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //查询最热商品
    @Override
    public List<Product> findHots() {
        List<Product> list = null;

        try {
            list = productDao.findHots();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    //根据id查询指定商品信息
    @Override
    public Product pinfo(String pid) {

        Product p = null;

        try {
            p = productDao.pinfo(pid);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return p;
    }

    //根据cid 完成 pagebean对象的封装
    @Override
    public PageBean<Product> getPageBeanByCid(String cid, int pageNumber, int pageSize) {
        PageBean<Product> pb = new PageBean<>();


        try {
            // 设置 页码
            pb.setPageNumber(pageNumber);
            pb.setPageSize(pageSize);
            int total = (int) productDao.totalByCid(cid);
            pb.setTotal(total);
            //设置 总页数
            pb.setTotalPage((int) Math.ceil((total * 1.0 / pageSize)));
                                  /*
                                    21 条数据  每页显示5 条  5页
                                    20 条数据               4页
                                    19                     4
                                    18                     4


                                   */
            //当前页数据
            List<Product> products = productDao
                    .findProductsByCid(cid, pageNumber, pageSize);

            pb.setData(products);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pb;
    }

    //查询商品信息
    @Override
    public PageBean<Product> getPageBeanBy(int pageNumber, int pageSize) {
        PageBean<Product> pb = new PageBean<>();


        try {
            // 设置 页码
            pb.setPageNumber(pageNumber);
            pb.setPageSize(pageSize);
            int total = (int) productDao.ProductTotal();
            pb.setTotal(total);
            //设置 总页数
            pb.setTotalPage((int) Math.ceil((total * 1.0 / pageSize)));
                                  /*
                                    21 条数据  每页显示5 条  5页
                                    20 条数据               4页
                                    19                     4
                                    18                     4


                                   */
            //当前页数据
            List<Product> products = productDao
                    .findProducts(pageNumber, pageSize);

            pb.setData(products);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pb;
    }

    //添加商品
    @Override
    public void saveProduct(Product product) {
        try {
            productDao.saveProduct(product);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
