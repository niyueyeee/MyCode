package com.itheima.proxy;

/*
   买房的中介！！代理
 */
public class BuyHouseProxy implements BuyHouse {

    // 定义一个 有买房需求的
    private BuyHouse buyHouse;

    // 在 创建代理对象的时候 得有委托人

    public BuyHouseProxy(BuyHouse buyHouse) {
        this.buyHouse = buyHouse;
    }

    @Override
    public void buyHouse() {
        // 代理人 帮助 委托人
        System.out.println("我是中介，帮您买房，先付款~~");
        buyHouse.buyHouse();
        System.out.println("将信息偷偷地买给装修的人...");
    }
}
