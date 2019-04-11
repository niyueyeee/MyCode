package com.itheima.proxy;
/*
   委托人
      实现什么接口
         代表 有什么需求！！！
 */
public class Customer implements BuyHouse,FindWife{

    @Override
    public void buyHouse() {
        System.out.println("看房源");
        System.out.println("谈价格");
        System.out.println("过户");
    }

    @Override
    public void findWife(String message) {
        System.out.println("找媳妇的要求："+message);
        System.out.println("只要暖被窝~~");
    }
}
