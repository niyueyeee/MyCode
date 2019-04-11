package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

/**
 * @author niyueyeee
 * @create 2019-04-10 14:30
 */
@Controller
@RequestMapping("ac")
@SessionAttributes(names = {"money"})
public class AnnotationController {
    @RequestMapping("updateUserById")
    public String updateUserById(User user) {

        System.out.println("需要修改的用户信息~~" + user);

        return "result";
    }

    @RequestMapping("setSessionValue")
    public String setSessionValue(Model model) {
        model.addAttribute("money", 100);
        model.addAttribute("message", "set");
        return "result";
    }

    @RequestMapping("getSessionValue")
    public String getSessionValue(ModelMap modelMap) {
        Object money = modelMap.get("money");
        modelMap.addAttribute("message", "get");
        return "result";
    }

    @RequestMapping("removeSessionValue")
    public String removeSessionValue(ModelMap modelMap, SessionStatus status) {
        status.setComplete();
        modelMap.addAttribute("message", "del");
        return "result";
    }

}
