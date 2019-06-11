package com.itheima.service;

import com.github.pagehelper.PageInfo;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Product;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-15 21:26
 */
public interface ProductService {
    /**
     * 查询所有
     */
    List<Product> findAll();

    /**
     * 保存
     *
     * @return
     */
    void save(Product product);

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Product findById(Integer id);

    /**
     * 更新数据
     *
     * @param product
     */
    void update(Product product);

    /**
     * 删除单条
     *
     * @param id
     */
    void delOne(Integer id);

    /**
     * 删除多个
     *
     * @param ids
     */
    void delMany(Integer[] ids);

    /**
     * 分页
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageBean<Product> findByPage(Integer pageNum, Integer pageSize);

    /**
     * 分页助手
     *
     * @param pageNum
     * @param pageSize
     * @return
     */
    PageInfo<Product> findByPageHelper(Integer pageNum, Integer pageSize);
}
