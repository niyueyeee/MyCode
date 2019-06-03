package com.itheima.ssm.mapper;

import com.itheima.ssm.pojo.Item;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-11 10:47
 */
public interface ItemMapper {
    List<Item> queryItemByList() throws Exception;
}
