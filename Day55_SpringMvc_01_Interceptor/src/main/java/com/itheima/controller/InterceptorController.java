package com.itheima.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author niyueyeee
 * @create 2019-04-10 21:40
 */
@Controller
@RequestMapping("ic")
public class InterceptorController {
    @RequestMapping("gotoResult")
    public String gotoResult(Model model) {
        model.addAttribute("message", "ok//");
        System.out.println("中文");
        return "result";
    }
}
