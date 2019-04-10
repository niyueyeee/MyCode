package com.itheima.service;

import com.itheima.domain.Category;
import com.itheima.domain.PageBean;
import com.itheima.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductService {
    //查询最新商品
    List<Product> findNews();

    //查询最热商品
    List<Product> findHots();

    //根据id查询指定商品信息
    Product pinfo(String pid);

    // 获取 根据cid封装的PageBean对象
    PageBean<Product> getPageBeanByCid(String cid, int pageNumber, int pageSize);

    //查询商品信息
    PageBean<Product> getPageBeanBy(int pageNumber, int pageSize);

    //添加商品
    void saveProduct(Product product);
}
