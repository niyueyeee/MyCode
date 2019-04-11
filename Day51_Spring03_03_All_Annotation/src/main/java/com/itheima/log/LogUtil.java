package com.itheima.log;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @author niyueyeee
 * @create 2019-04-03 21:40
 */
@Component("logUtil")
@Aspect
public class LogUtil {
    @Pointcut("execution(* com..service.*.*(..))")
    public void pt(){}

    @Before("pt()")
    public void  beforeMethod(){
        System.out.println("方法前执行");
    }
    @After("pt()")
    public void  afterMethod(){
        System.out.println("方法结束执行");
    }
    @AfterReturning("pt()")
    public void  afterReturning(){
        System.out.println("方法正常执行，没有异常");
    }
    @AfterThrowing("pt()")
    public void  afterThrowing(){
        System.out.println("方法执行异常，有异常了");
    }
//    @Around("pt()")
    public Object aroundMethod(ProceedingJoinPoint proceedingJoinPoint ){
        Object result = null;

        try {
            //方法执行之前
            System.out.println("环绕通知，方法执行之前执行");
            result= proceedingJoinPoint.proceed();
            System.out.println("环绕通知，方法正常，没有异常，结束执行");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            // 方法异常 结束
            System.out.println("环绕通知，方法异常，有异常，结束执行");
        }finally {
            // 方法结束
            System.out.println("环绕通知！方法结束执行");
        }


        return  result;
    }
}
