package com.itheima.service.impl;

import com.itheima.dao.CategoryDao;
import com.itheima.dao.ProductDao;
import com.itheima.domain.Category;
import com.itheima.exception.CanNotDeleteException;
import com.itheima.service.CategoryService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.JedisUtils;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    //通过 工具类结合配置文件 获取接口的子类对象
    private CategoryDao categoryDao = BeanFactory.newInstance(CategoryDao.class);
    private ProductDao productDao = BeanFactory.newInstance(ProductDao.class);

    //查询所有的分类信息
    @Override
    public List<Category> findAllCategorys() {
        List<Category> list = null;

        try {
            Jedis jedis = JedisUtils.getJedis();
            String categories = jedis.get("categories");
            if (categories == null) {
                list = categoryDao.findAllCategorys();
                String s = JSONArray.fromObject(list).toString();
                jedis.set("categories", s);
            } else {
                JSONArray jsonArray = JSONArray.fromObject(categories);
                list = JSONArray.toList(jsonArray, Category.class);
            }
            jedis.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return list;
    }

    //添加分类
    @Override
    public void addCategory(Category category) {

        try {
            categoryDao.addCategory(category);
            clearRedis();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //删除订单
    @Override
    public void delByCid(String cid) throws CanNotDeleteException {

        try {
            if (productDao.totalByCid(cid) > 0) {
                throw new CanNotDeleteException("该分类信息有数据，不能删除！！您操作有误！");
            } else {
                categoryDao.delByCid(cid);
                clearRedis();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //按名字查找分类信息
    @Override
    public Category fandCategoryByCid(String cid) {
        Category list = null;
        try {
            list = categoryDao.fandCategoryByCid(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    //按名字修改分类信息
    @Override
    public void editCategroy(Category category) {
        try {
            categoryDao.editCategroy(category);
            clearRedis();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //清空redis
    public void clearRedis() {
        Jedis jedis = JedisUtils.getJedis();
        jedis.del("categories");
        jedis.close();
    }
}
