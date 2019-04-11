package com.itheima.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author niyueyeee
 * @create 2019-04-11 10:17
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        Object username = request.getSession().getAttribute("username");
        if (username == null) {
            response.sendRedirect(request.getContextPath() + "/user/toLogin.action");
            return false;
        }
        return true;
    }
}
