package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author niyueyeee
 * @create 2019-04-10 14:40
 */
@Controller
@RequestMapping("json")
public class JsonToObjectController {
    @RequestMapping("sendJsonStr")
    public @ResponseBody
    User sendJsonStr(@RequestBody User user) {
        System.out.println("从前端获取到的数据是:" + user);
        user.setName("宋喆");
        user.setAddress("日本");
        // 后端给前端返回一个对象
        return user;
    }
}
