package com.itheima.log;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * @author niyueyeee
 * @create 2019-04-03 21:40
 */
public class LogUtil {
    /**
   业务方法执行之前 将其织入
         就相当于 在业务方法执行之前执行了
   */
    public void  beforeMethod(){
        System.out.println("方法前执行");
    }
    //类似于  finally
    public void  afterMethod(){
        System.out.println("方法结束执行");
    }

    public void  afterReturning(){
        System.out.println("方法正常执行，没有异常");
    }

    public void  afterThrowing(){
        System.out.println("方法执行异常，有异常了");
    }

    /**
     * 完成 环绕通知配置
     * 1：灵活度比较高 里面包含了四个方位
     * 2：可以控制 原有业务逻辑是否执行
     * <p>
     * ProceedingJoinPoint  正在执行的连接点
     * proceed()
     */
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
