package com.itheima.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/*
  代理公司！！
     作用 是不是产生代理对象

     必须有个方法  获取代理对象！
        给委托人找代理对象！！！！
 */
public class ProxyCompany {

    /**
     * 获取代理对象的方法
     * 返回值就是 代理对象
     * <p>
     * 传入的 的 委托人 对象
     * 返回的 是  根据委托人 的需求产生的代理对象！！
     */

    public static Object getProxy(Object obj) {
        Object proxy = null;

        //生产一个代理对象 使用JDK中的 Proxy.newProxyInstance()方法
        // ClassLoader loader, 类<?>[] interfaces, InvocationHandler h)
        /*
        ClassLoader loader 类加载器  委托人的类加载
        类<?>[] interfaces  委托人实现的接口！！！
           知道了委托人实现哪些接口 就知道他有什么需求需要什么代理！！

           InvocationHandler 它的实现类中 就是用来完成 具体功能增强的！！！！


         */
        proxy = Proxy.newProxyInstance(obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new InvocationHandler() {
                    /**
                     * invoke 功能 就是 用来进行所谓功能增强 也就真正去执行的操作！！
                     * @param proxy    代理对象
                     * @param method   就是被增强的方法
                     * @param args     被增强方法中的参数
                     * @return 就是增强方法的返回值
                     * @throws Throwable
                     */

                    @Override
                    public Object invoke(Object proxy,
                                         Method method,
                                         Object[] args)
                            throws Throwable {
                        Object result = null;
                        //通过method判断 是什么需求
                        if (method.getName().equalsIgnoreCase("buyHouse")) {
                            //对买房子进行功能增强
                            System.out.println("中介帮你找房无忧，需要支付服务费~找好房源！");
                            // 执行
                            result = method.invoke(obj, args);

                            System.out.println("买完之后，帮您推荐装修，还可以房子租出去！");
                        }


                        if (method.getName().equalsIgnoreCase("findWife")) {
                            //对买房子进行功能增强
                            System.out.println("中介帮你找媳妇无忧，需要支付服务费~找好媳妇！");
                            // 执行
                            result = method.invoke(obj, args);

                            System.out.println("介绍之后，帮你介绍婚纱摄影，介绍房源");
                        }

                        return result;
                    }
                });

        return proxy;
    }
}
