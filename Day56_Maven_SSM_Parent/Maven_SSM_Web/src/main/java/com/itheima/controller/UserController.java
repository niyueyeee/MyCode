package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author niyueyeee
 * @create 2019-04-12 20:04
 */
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping("/findById")
    public ModelAndView findById(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        User user = userService.findById(id);
        modelAndView.addObject("user", user);
        modelAndView.setViewName("show");
        return modelAndView;
    }
}
