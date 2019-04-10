package com.itheima.dao;

import com.itheima.pojo.Account;

public class AccountDaoImpl implements AccountDao {

    @Override
    public void saveAccount(Account account) {
        System.out.println("账户信息保存成功");
    }
}
