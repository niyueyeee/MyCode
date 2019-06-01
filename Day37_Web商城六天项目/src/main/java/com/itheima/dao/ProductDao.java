package com.itheima.dao;

/*
   操作数据库的接口
       这里只定义方法

         由具体的实现类实现
 */

import com.itheima.domain.Category;
import com.itheima.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    //查询最新商品
    List<Product> findNews() throws SQLException;

    //查询最热商品
    List<Product> findHots() throws SQLException;

    //根据id查询指定商品信息
    Product pinfo(String pid) throws SQLException;

    //根据cid查询  该分类下所有的商品信息
    long totalByCid(String cid) throws SQLException;

    //查询分类下所有商品  以分页形式展示
    List<Product> findProductsByCid(String cid, int pageNumber, int pageSize) throws SQLException;

    //查询所有商品
    List<Product> findProducts(int pageNumber, int pageSize) throws SQLException;

    //查询所有商品数量
    long ProductTotal() throws SQLException;

    //添加商品
    void saveProduct(Product product) throws SQLException;
}
