package com.itheima.controller;

import com.itheima.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author niyueyeee
 * @create 2019-04-10 20:26
 */
@Controller
@RequestMapping("user")
public class RestfulStyleController {
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public String queryByIdByRestful(@PathVariable("id") Integer id) {

        System.out.println("Restful风格获取id的值是:" + id);

        return "result";
    }

    @RequestMapping(value = "", method = RequestMethod.POST)
    public String saveUserByRestful(User user) {

        System.out.println("post请求做添加操作:" + user);

        return "result";
    }

    @RequestMapping(value = "", method = RequestMethod.PUT)
    public String updateUserByRestful(User user) {

        System.out.println("put请求做更新操作:" + user);

        return "result";
    }

    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public String delteByIdByRestful(@PathVariable("id") Integer id) {

        System.out.println("要删除数据的id是:" + id);

        return "result";
    }
}
