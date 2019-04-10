package com.itheima.factory;

import com.itheima.utils.TranscationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author niyueyeee
 * @create 2019-04-03 21:10
 */
@Component("proxyFactory")
public class ProxyFactory {
    @Autowired
    @Qualifier("transcationManager")
    private TranscationManager transcationManager;

    public Object createProxy(Object o) {
        Object proxy = null;

        proxy = Proxy.newProxyInstance(o.getClass().getClassLoader(), o.getClass().getInterfaces()
                , new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        Object result = null;

                        try {
                            transcationManager.begin();
                            method.invoke(o, args);
                            transcationManager.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                            transcationManager.rollback();
                        } finally {
                            transcationManager.close();
                        }
                        return result;
                    }
                });
        return proxy;
    }
}
