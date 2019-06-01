package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author niyueyeee
 * @create 2019-04-08 9:49
 */
@Controller
@RequestMapping("user")
public class JustSeeSee {
    @RequestMapping("paramsNoMatch")
    public ModelAndView paramsNoMatch(ModelAndView modelAndView, @RequestParam(value = "uid", defaultValue = "100") Integer id) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "-----> id=" + id);
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }

    /**
     * 解析请求头中信息
     * User-Agent
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping("sendRequestHeader")
    public ModelAndView sendRequestHeader(ModelAndView modelAndView, @RequestHeader("User-Agent") String userAgent) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "-----> userAgent=" + userAgent);
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }

    /**
     * 解析Cookie信息
     * JSESSIONID
     *
     * @param modelAndView
     * @return
     */
    @RequestMapping("sendCookie")
    public ModelAndView sendCookie(ModelAndView modelAndView, @CookieValue("JSESSIONID") String cookieValue) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "-----> JSESSIONID=" + cookieValue);
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }


}
