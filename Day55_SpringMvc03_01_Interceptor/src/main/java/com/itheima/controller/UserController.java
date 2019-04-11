package com.itheima.controller;

import com.itheima.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author niyueyeee
 * @create 2019-04-11 10:21
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @RequestMapping("login")
    public String login(String username, String password, HttpServletRequest request)
            throws MyException {
        /*
          完成登陆操作
             1：判断用户名和密码   假设 admin admin
             2: 如果正确 登陆成功 把username存入session中
                跳转到 登陆成功欢迎页面  再去访问 /ic/gotoResult.action
             3：如果失败呢  ？  继续登陆  toLogin.action
         */
        if ("admin".equals(username) && "admin".equals(password)) {
            // username存入session中
            request.getSession().setAttribute("username", username);

            return "redirect:/ic/gotoResult.action";
        }

        /*
          如果lubenwei登陆 这就是一个非法用户
         */
        if ("lubenwei".equals(username)) {
            throw new MyException(username + "是一个非法用户,被封500年！！！");
        }

        return "redirect:toLogin.action";
    }
}
