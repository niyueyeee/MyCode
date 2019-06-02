package com.itheima.test;

import org.springframework.beans.factory.InitializingBean;

/**
 * @author NiYueYeee
 * @create 2019-06-02 14:44
 */
public class MyBean implements InitializingBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("我被创建好了 然后开始干活了....");
    }
}
