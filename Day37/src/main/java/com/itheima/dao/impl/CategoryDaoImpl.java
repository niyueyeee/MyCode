package com.itheima.dao.impl;

import com.itheima.dao.CategoryDao;
import com.itheima.dao.UserDao;
import com.itheima.domain.Category;
import com.itheima.domain.User;
import com.itheima.utils.C3P0Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    private QueryRunner qr = new QueryRunner(C3P0Utils.getDataSource());

    //查询所有的分类信息
    @Override
    public List<Category> findAllCategorys() throws SQLException {

        String sql = "select *from category";

        return qr.query(sql, new BeanListHandler<>(Category.class));
    }

    //添加订单
    @Override
    public void addCategory(Category category) throws SQLException {
        String sql = "insert into category values(?,?)";
        Object[] params = {category.getCid(), category.getCname()};
        qr.update(sql, params);
    }

    //按名字查找分类信息
    @Override
    public Category fandCategoryByCid(String cid) throws SQLException {
        String sql = "SELECT * FROM category WHERE cid=?";
        return qr.query(sql, new BeanHandler<>(Category.class), cid);
    }

    //按名字修改分类信息
    @Override
    public void editCategroy(Category category)throws SQLException {
        String sql = "update category set cname=? where cid = ?";
        Object[] params = {category.getCname(),category.getCid()};
        qr.update(sql,params);;
    }

    //删除订单
    @Override
    public void delByCid(String cid) throws SQLException {
        String sql = "delete from category where cid = ?";
        qr.update(sql,cid);
    }
}
