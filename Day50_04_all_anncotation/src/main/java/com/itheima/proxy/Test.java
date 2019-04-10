package com.itheima.proxy;

public class Test {

    public static void main(String[] args) {
        // 没有代理的时候
        // 委托人自己出面处理
        Customer customer = new Customer();

//        customer.buyHouse();
//      // 在买房 找代理
//        BuyHouseProxy buyHouseProxy = new BuyHouseProxy(customer);
//
//        buyHouseProxy.buyHouse();
//
//        // 找媳妇
//        FindWifeProxy findWifeProxy = new FindWifeProxy(customer);
//
//        findWifeProxy.findWife("是女的就行~~");
        BuyHouse proxy = (BuyHouse) ProxyCompany.getProxy(customer);

        proxy.buyHouse();

        FindWife fproxy = (FindWife) ProxyCompany.getProxy(customer);
        fproxy.findWife("随便");
    }

    @org.junit.Test
    public void ss() {
        System.out.println(CcCc.getObj(11));
    }
}
