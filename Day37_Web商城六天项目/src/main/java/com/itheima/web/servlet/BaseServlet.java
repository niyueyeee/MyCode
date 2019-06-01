package com.itheima.web.servlet;


import com.itheima.annotation.Auth;
import com.itheima.constant.Constant;
import com.itheima.domain.User;
import com.itheima.web.view.Result;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

public abstract class BaseServlet extends HttpServlet {
    /*
     如何 在一个servlet中判断是 不同的请求呢？
    */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");

        String method = request.getParameter("method");

        //  method的值  就是方法的名字    反射执行方法
        Class clazz = this.getClass();

        // 获取 方法  知道方法名
        try {
            Method m = clazz.getMethod(method, HttpServletRequest.class, HttpServletResponse.class);
            if (m.isAnnotationPresent(Auth.class)) {
                // 1:校验用户是否登陆
                // 从session获取 user对象 是null 说明没有登陆
                User user = (User) request.getSession().getAttribute("user");

                if (user == null) {
                    // 没有登陆
                    // 将响应数据 封装 result对象 转换成json返回
                    Result result = new Result(Constant.NO_LOGIN, "您还未登录，请先登录再来提交订单！");

                    response.getWriter().write(JSONObject.fromObject(result).toString());
                    return;
                }

            }
            //反射执行
            m.invoke(this, request, response);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        doGet(request, response);
    }

}
