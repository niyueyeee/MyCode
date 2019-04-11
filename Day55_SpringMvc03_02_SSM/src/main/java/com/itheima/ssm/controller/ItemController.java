package com.itheima.ssm.controller;

import com.itheima.ssm.mapper.ItemMapper;
import com.itheima.ssm.pojo.Item;
import com.itheima.ssm.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-11 10:47
 */
@Controller
@RequestMapping("item")
public class ItemController {
    @Autowired
    private ItemService itemService;

    @RequestMapping("queryList")
    public String queryList(Model model) throws Exception {
        List<Item> itemList = itemService.queryItemByList();
        model.addAttribute("itemList", itemList);
        return "itemList";
    }
}
