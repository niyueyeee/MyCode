package com.itheima.dao;

/*
   操作数据库的接口
       这里只定义方法

         由具体的实现类实现
 */

import com.itheima.domain.Category;
import com.itheima.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

    // 查询所有的分类信息
    List<Category> findAllCategorys() throws SQLException;

    //添加订单
    void addCategory(Category category) throws SQLException;

    //删除订单
    void delByCid(String cid) throws SQLException;

    //按名字查找分类信息
    Category fandCategoryByCid(String cid) throws SQLException;

    //按名字修改分类信息
    public void editCategroy(Category category) throws SQLException;
}
