package com.itheima.controller;

import com.mysql.cj.Session;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import sun.plugin.liveconnect.SecurityContextHelper;

import javax.servlet.http.HttpServletRequest;

/**
 * @author niyueyeee
 * @create 2019-04-18 20:19
 */
@Controller
@RequestMapping("test")
public class TestController {
    @RequestMapping("testShowUsername")
    public void testShowUsername(HttpServletRequest request) {
        SecurityContext context = SecurityContextHolder.getContext();
        Object principal = context.getAuthentication().getPrincipal();
        User user = (User) principal;
        System.out.println(user.getUsername());
    }
}
