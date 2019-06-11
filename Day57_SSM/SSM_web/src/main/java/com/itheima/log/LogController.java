package com.itheima.log;

import com.itheima.pojo.SysLog;
import com.itheima.service.LogService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * oop 面向对象编程， 面向一个点开发
 * 面向切面编程：aop， 面向多个点开发
 * <p>
 * aop 底层两个动态代理
 * jdk: 基于接口动态代理
 * cglib: 基于类的动态代理
 * 切面：切入点和增强对象
 * 切入点：对连接点的定义， 定义了哪些方法是连接点
 * 连接点：需要拦截的点，在spring，连接点只能是方法
 * 增强：对方法拦截后的加强的部分
 * 增强的类型
 * 前置增强： 在方法前执行
 * 后置增强： 在方法后执行， 出现异常后不执行
 * 异常增强：方法出现异常后执行
 * 最终增强：肯定会执行
 * 环绕增强：前置 + 后置 + 异常 + 最终
 * 织入：把增强织入到切入点
 * <p>
 * <p>
 * <p>
 * 作为日志切面类 -- 注解
 *
 * @author 黑马程序员
 * @Aspect ： 标记该类为切面类
 * @Component: 创建对象
 * @Company http://www.ithiema.com
 * @Version 1.0
 */
@Component
@Aspect
public class LogController {

    @Autowired
    LogService logService;


    @Autowired
    HttpServletRequest request;

    /**
     * 切入点
     */
    @Pointcut("execution(* com.itheima.controller.*.*(..))")
    public void pc() {
    }

    /**
     * 前置增强的织入
     */
    @Before("pc()")
    public void before(JoinPoint joinPoint) {
        //创建日志对象
        SysLog log = new SysLog();
        //给日志对象赋值
        // private String visitTime; -- 访问时间
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String date_str = sdf.format(date);
        log.setVisitTime(date_str);
        // private String username; -- 访问者
        //获取上下文对象
        SecurityContext context = SecurityContextHolder.getContext();
        //获取认证对象
        Authentication authentication = context.getAuthentication();
        //获取用户对象
        User user = (User) authentication.getPrincipal();
        //获取用户名
        String username = user.getUsername();
        log.setUsername(username);
        // private String ip; -- 访问者的ip
        String ip = request.getRemoteAddr();
        log.setIp(ip);
        // private String method; -- 访问的功能: 全类名.方法
        //获取目标对象-- 真实的对象
        Object target = joinPoint.getTarget();
        //获取全类名
        String className = target.getClass().getName();
        //获取方法
        String methodName = joinPoint.getSignature().getName();
        log.setMethod(className + "#" + methodName);
        //保存到数据库中
        logService.save(log);
    }

}
