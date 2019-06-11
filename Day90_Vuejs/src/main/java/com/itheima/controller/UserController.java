package com.itheima.controller;

import com.itheima.pojo.User;
import com.itheima.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-09 18:13
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Resource
    private UserService userService;

    public static void main(String[] args) {

    }
    @GetMapping("/findAll")
    public List<User> findAll() {
        return userService.finaAll();
    }

    @GetMapping("/findById/{id}")
    public User findById(@PathVariable("id") Integer id) {
        return userService.findById(id);
    }

    @PostMapping("/update")
    public void update(@RequestBody  User user) {
         userService.update(user);
    }
}
