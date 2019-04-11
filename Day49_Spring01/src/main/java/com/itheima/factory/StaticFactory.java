package com.itheima.factory;

import com.itheima.pojo.Account;

public class StaticFactory {

    public static Account getAccount(){

        return new Account();
    }
}
