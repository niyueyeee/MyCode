package com.itheima.web;

import com.itheima.dao.UserDao;
import com.itheima.pojo.User;
import com.itheima.service.UserService;
import com.itheima.utils.JedisUtils;
import org.apache.commons.beanutils.BeanUtils;
import redis.clients.jedis.Jedis;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;
import java.util.UUID;

/**
 * @author niyueyeee
 * @create 2019-03-11 20:11
 */
@WebServlet(urlPatterns = "/add")
public class add extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");


        Map<String, String[]> parameterMap = request.getParameterMap();
        System.out.println(parameterMap);
        System.out.println(request.getParameter("name"));
        User u = new User();
        try {
            BeanUtils.populate(u, parameterMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        u.setId(id);
        new UserService().save(u);
        System.out.println(JedisUtils.getJedis().get("s"));
    }
}
