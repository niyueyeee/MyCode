package com.itheima.controller;

import com.itheima.pojo.Order;
import com.itheima.pojo.PageBean;
import com.itheima.pojo.Product;
import com.itheima.service.OrderService;
import com.itheima.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-16 21:30
 */
@Controller
@RequestMapping("/order")
//@Secured("ROLE_ADMIN")
public class OrderController {
    @Autowired
    OrderService orderService;

    /**
     * 查询所有
     *
     * @return
     */
    @RequestMapping("/findAll")
    public ModelAndView findAll() {
        ModelAndView modelAndView = new ModelAndView();
        List<Order> orderList = orderService.findAll();
        modelAndView.addObject("orderList", orderList);
        modelAndView.setViewName("order-list");
        return modelAndView;
    }


    @Autowired
    ProductService productService;

    /**
     * 查询订单分类
     *
     * @return
     */
    @RequestMapping("/saveUI")
    public ModelAndView updateUI() {
        ModelAndView modelAndView = new ModelAndView();
        List<Product> productList = productService.findAll();
        modelAndView.addObject("productList", productList);
        modelAndView.setViewName("order-add");
        return modelAndView;
    }

    /**
     * 保存订单
     *
     * @return
     */
    @RequestMapping("/save")
    public String save(Order order) {
        orderService.save(order);
        return "redirect:/order/findAll";
    }
}
