package com.itheima.web.servlet;

import com.itheima.constant.Constant;
import com.itheima.domain.User;
import com.itheima.service.UserService;
import com.itheima.utils.BeanFactory;
import com.itheima.utils.UUIDUtils;
import com.itheima.web.view.Result;
import net.sf.json.JSONObject;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/user")
public class UserServlet extends BaseServlet {

    private UserService userService = BeanFactory.newInstance(UserService.class);
                                      //new UserServiceImpl()

    /**
     *  完成用户注册
     * @param request
     * @param response
     */
    public void register(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException,
                   IOException {
        //1:获取前端提交的数据
        Map<String, String[]> map = request.getParameterMap();

        // 2: 完成对象封装
        User user = new User();

        BeanUtils.populate(user,map);

        // 还有两个字段需要封装 uid  一个是 state字段
        String uid = UUIDUtils.getUUID();

        //设置到User中
        user.setUid(uid);

        // state  1 激活  0  未激活
        user.setState(Constant.JI_HUO);

        // 得到了一个user 交给service
        userService.register(user);

        // 给前端  返回数据

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.SUCCESS,"hi~~~注册成功");

        response.getWriter().write(JSONObject.fromObject(result).toString());


    }

    /**
     * 用户登陆操作
     * @param request
     * @param response
     * @throws InvocationTargetException
     * @throws IllegalAccessException
     * @throws IOException
     */
    public void login(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException,
                   IOException {

          //1:获取用户名和密码
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        //2:传递给 service
        User user = userService.login(username, password);

        if(user==null){
            Result result = new Result(Constant.FAILS,"用户名或密码错误");

            response.getWriter().write(JSONObject.fromObject(result).toString());

            return;
        }

        //用户不为空
        // 将用户信息 存储在session中
        request.getSession().setAttribute("user",user);

        // 将用户名 以cookie形式存储到跨域的浏览器上
        Cookie cookie = new Cookie("username", username);
        //设置
        cookie.setMaxAge(60*60*24);
        cookie.setPath(request.getContextPath());
        // 允许哪些 域名获取 cookie
        cookie.setDomain("itheima343.com");

        response.addCookie(cookie);

        // 给前端  返回数据

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.SUCCESS,"登陆成功");

        response.getWriter().write(JSONObject.fromObject(result).toString());


    }

   /*
     退出登陆
        关闭会话
        清除cookie
    */
    public void logout(HttpServletRequest request, HttpServletResponse response)
            throws InvocationTargetException, IllegalAccessException,
                   IOException {

        //销毁session
        request.getSession().invalidate();

        // 将用户名 以cookie形式存储到跨域的浏览器上
        Cookie cookie = new Cookie("username", null);
        //设置
        cookie.setMaxAge(0);
        cookie.setPath(request.getContextPath());
        // 允许哪些 域名获取 cookie
        cookie.setDomain("itheima343.com");

        response.addCookie(cookie);

        // 给前端  返回数据

        // 将响应数据 封装 result对象 转换成json返回
        Result result = new Result(Constant.LOGOUT,"退出登陆");

        response.getWriter().write(JSONObject.fromObject(result).toString());


    }
}
