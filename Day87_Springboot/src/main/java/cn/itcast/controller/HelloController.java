package cn.itcast.controller;

import cn.itcast.pojo.User;
import cn.itcast.service.UserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author NiYueYeee
 * @create 2019-06-04 19:51
 */
@Controller
@ConfigurationProperties(prefix = "weixin")
public class HelloController {
    private String account;

    private String username;

    private String miyao;

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getMiyao() {
        return miyao;
    }

    public void setMiyao(String miyao) {
        this.miyao = miyao;
    }

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private UserService userService;

    @RequestMapping("/hello")
    @ResponseBody
    public String hello() {
        return "nihao";
    }

    @RequestMapping("/user/{id}")
    @ResponseBody
    public User findById(@PathVariable(name = "id") int id) {
        return userService.findById(id);
    }

    @RequestMapping("/users")
    public String findAll(Model model) {
        //先查询数据库
        List<User> users = userService.findAll();
        //将数据放入model
        model.addAttribute("users", users);
        //返回一个view视图
        return "/user/list";
    }

    @RequestMapping("/redis/{id}")
    @ResponseBody
    public String redis(@PathVariable(name = "id") int id) throws JsonProcessingException {
        String user = redisTemplate.opsForValue().get("user");
        if (user == null) {
            System.out.println("触发查询数据库");
            User byId = userService.findById(id);
            ObjectMapper objectMapper = new ObjectMapper();
            String s = objectMapper.writeValueAsString(byId);
            redisTemplate.opsForValue().set("user", s);
        }
        return user;
    }

    @RequestMapping("/mybatis")
    public String mybatis(Model model) {
        //先查询数据库
        List<User> users = userService.findAll2();
        //将数据放入model
        model.addAttribute("users", users);
        //返回一个view视图
        return "/user/list";
    }

    @RequestMapping("/peizhi")
    @ResponseBody
    public String peizhi() {
        return account + ":::::" + miyao + ":::::::" + username;
    }
}
