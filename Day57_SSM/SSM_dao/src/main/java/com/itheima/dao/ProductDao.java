package com.itheima.dao;

import com.itheima.pojo.Product;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-15 21:30
 */
@Repository
public interface ProductDao {
    /**
     * 查询所有
     */
    List<Product> findAll();

    /**
     * 保存
     *
     * @param product
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
     * 更新产品
     *
     * @param product
     */
    void update(Product product);

    /**
     * 根据id删除
     *
     * @param id
     */
    void delOne(Integer id);

    /**
     * 查询总条数
     *
     * @return
     */
    Integer findTotalCount();

    /**
     * 根据分页参数查询
     *
     * @param startIndex
     * @param pageSize
     * @return
     */
    List<Product> findByPage(Integer startIndex, Integer pageSize);
}
