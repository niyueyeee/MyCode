package com.itheima.service;

import com.itheima.pojo.Account;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-02 21:04
 */
public interface AccountService {
    void saveAccount(Account account);

    void updateAccountById(Account account);

    void delteAccountById(int id);

    Account queryAccountById(int id);

    List<Account> queryAccountList();
}
