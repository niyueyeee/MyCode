package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


/**
 * @author niyueyeee
 * @create 2019-04-10 11:44
 */
@Controller
@RequestMapping("one")
public class OneController {
    @RequestMapping("strToDate")
    public ModelAndView strToDate(ModelAndView modelAndView, Date birthday) {
        // 处理数据 model  设置页面回显数据
        modelAndView.addObject("message", "完成最基本的测试！birthday：" + birthday);

        // 关联上 逻辑视图view 路径  找到跳转的页面
        modelAndView.setViewName("result");
        return modelAndView;
    }
}
