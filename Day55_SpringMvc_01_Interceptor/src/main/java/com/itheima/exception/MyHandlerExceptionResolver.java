package com.itheima.exception;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author niyueyeee
 * @create 2019-04-11 10:23
 */
public class MyHandlerExceptionResolver implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        // e 程序中出现的异常
        //  ModelAndView  你可以对出现的异常进行 跳转操作
        if (e instanceof MyException) {
            // 是我的异常
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.addObject("message", e.getMessage());
            modelAndView.setViewName("exception");
            // 发短信
            // 发邮件
            // 记录到日志
            return modelAndView;
        }
        return null;
    }
}
