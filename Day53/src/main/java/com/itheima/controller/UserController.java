package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.pojo.UserVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * @author niyueyeee
 * @create 2019-04-07 21:57
 */
@Controller
@RequestMapping("user")
public class UserController {
    @RequestMapping("sendSimpleParams")
    public ModelAndView sendSimpleParams(ModelAndView modelAndView, HttpServletRequest request, HttpServletResponse response, HttpSession session) {

//        System.out.println(request);
//        System.out.println(response);
//        System.out.println(session);

        String name = request.getParameter("name");

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "----->name:" + name);
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }

    /*
        springmvc接收简单参数
            在SpringMVC的handler中 简化了 参数的接收
              你前端传什么 我就能接收什么

          要求  形参名与前端传递的参数名保持一致，这就体现了绑定的含义。

     */
    @RequestMapping("sendSimpleParamsByMVC")
    public ModelAndView sendSimpleParamsByMVC(ModelAndView modelAndView, String name, Integer id, boolean flag) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "----->name:" + name + "  id=" + id + "  flag=" + flag);
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }

    /**
     * 我希望 在 传递参数之后 将 参数中的数据 封装到 user对象
     * 要求：pojo对象中的属性名 和 参数名保持一致
     *
     * @param modelAndView
     * @param user
     * @return
     */
    @RequestMapping("sendPojo")
    public ModelAndView sendPojo(ModelAndView modelAndView, User user) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "----->user:" + user);
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }


    /**
     * 我希望 在 传递参数之后 将 参数中的数据 封装到 UserVo对象
     * vid
     * user
     * id
     * name
     */
    @RequestMapping("sendPojoPackage")
    public ModelAndView sendPojoPackage(ModelAndView modelAndView, UserVo userVo) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "----->userVo:" + userVo);
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }


    /**
     * 我希望 传递的用户列表 集合  封装到 UserVo对象
     */
    @RequestMapping("sendList")
    public ModelAndView sendList(ModelAndView modelAndView, UserVo userVo) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "----->userList:" + userVo.getUserList());
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }

    /**
     * 我希望 传递的用户双列 集合  封装到 UserVo对象userMap中
     */
    @RequestMapping("sendMap")
    public ModelAndView sendMap(ModelAndView modelAndView, UserVo userVo) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "----->userMap:" + userVo.getUserMap());
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }
}
