package com.itheima.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

/**
 * @author niyueyeee
 * @create 2019-04-07 20:39
 */
@Controller
@RequestMapping("ok")
public class DefaultController {
    @RequestMapping("gotoResult")
    public ModelAndView gotoResult(ModelAndView modelAndView) {

        modelAndView.addObject("nowDate", new Date());
        modelAndView.setViewName("Result");
        return modelAndView;
    }

    @RequestMapping(value = {"gotoResultMultiUrl1", "gotoResultMultiUrl2"})
    public ModelAndView gotoResultMultiUrl(ModelAndView modelAndView) {
        System.out.println("-------------");
        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "----->gotoResultMultiUrl");
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }

    @RequestMapping(value = "gotoSameUrl", method = {RequestMethod.GET})
    public ModelAndView gotoResultDoGet(ModelAndView modelAndView) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "----->gotoResultDoGet");
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }

    @RequestMapping(value = "gotoSameUrl", method = {RequestMethod.POST})
    public ModelAndView gotoResultDoPost(ModelAndView modelAndView) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "----->gotoResultDoPost");
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }

    @RequestMapping(value = "login", params = {"state", "isAdmin=0", "type=user"})
    public ModelAndView sameUrlNoSameParmas1(ModelAndView modelAndView) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "----->user");
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }

    @RequestMapping(value = "login", params = {"state", "isAdmin=1", "type=admin"})
    public ModelAndView sameUrlNoSameParmas2(ModelAndView modelAndView) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "----->admin");
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }

    @RequestMapping(value = "login", params = {"state", "isAdmin=0", "type=vip"})
    public ModelAndView sameUrlNoSameParmas3(ModelAndView modelAndView) {

        Date nowDate = new Date();
        // 类似于 request.setAttribute  也就是将数据设置到渝中 数据就是模型数据
        modelAndView.addObject("nowDate", nowDate + "----->vip");
        // 跳转到结果页面   跳转的结果页面路径
        modelAndView.setViewName("Result");
        return modelAndView;
    }
}
