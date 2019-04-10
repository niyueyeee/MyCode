package com.itheima.proxy;
/*
   婚介  百合网
 */
public class FindWifeProxy implements FindWife{

    // 定义一个 有找媳妇需求的人
    private FindWife findWife;

    // 在 创建代理对象的时候 得有委托人

    public FindWifeProxy(FindWife findWife){
        this.findWife = findWife;
    }

    @Override
    public void findWife(String message) {
        System.out.println("我们这里是百合网，交会员费，提供优质服务，按照您的条件找！");
        findWife.findWife(message);
        System.out.println("祝您幸福~~");
        System.out.println("又把信息卖给了婚纱摄影~~");
    }
}
