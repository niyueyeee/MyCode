package com.itheima.ssm.service;

import com.itheima.ssm.mapper.ItemMapper;
import com.itheima.ssm.pojo.Item;
import com.itheima.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-11 10:48
 */
@Service("itemService")
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> queryItemByList() throws Exception {
        return itemMapper.queryItemByList();
    }
}
