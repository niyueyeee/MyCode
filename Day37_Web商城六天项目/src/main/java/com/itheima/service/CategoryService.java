package com.itheima.service;

import com.itheima.domain.Category;
import com.itheima.exception.CanNotDeleteException;

import java.util.List;

public interface CategoryService {

    // 查询所有的分类信息
    List<Category> findAllCategorys();

    //添加订单
    void addCategory(Category category);

    //删除订单
    void delByCid(String cid) throws CanNotDeleteException;

    //按名字查找分类信息
    Category fandCategoryByCid(String cid);

    //按名字修改分类信息
    public void editCategroy(Category category);
}
