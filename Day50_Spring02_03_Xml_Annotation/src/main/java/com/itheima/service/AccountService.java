package com.itheima.service;

import com.itheima.pojo.Account;

import java.util.List;

public interface AccountService {
    void saveAccount(Account account) ;

    void updateAccountById(Account account);

    void delteAccountById(Integer id);

    Account queryAccountById(Integer id);

    List<Account> queryAccountList();
}
