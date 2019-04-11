package com.itheima.ssm.service;

import com.itheima.ssm.pojo.Item;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-11 10:48
 */
public interface ItemService {
    List<Item> queryItemByList() throws Exception;
}
