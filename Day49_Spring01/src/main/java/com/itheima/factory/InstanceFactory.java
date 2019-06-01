package com.itheima.factory;

import com.itheima.pojo.Account;

public class InstanceFactory {

    public Account getAccount() {

        return new Account();
    }
}
