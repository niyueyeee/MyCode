package com.itheima.service;


import com.itheima.pojo.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-03 19:50
 */
@Repository("accountService")
public class AccountServiceImpl implements AccountService {


    @Override
    public void saveAccount(Account account) {
        System.out.println("这里执行的是保存账户");
    }

    @Override
    public void updateAccountById(Account account) {
        System.out.println("这里执行的是修改用户");
    }

    @Override
    public void delteAccountById(Integer id) {
        System.out.println("这里执行的是删除用户");
    }

    @Override
    public Account queryAccountById(Integer id) {
        System.out.println("这里执行的是查询一个用户");
        return null;
    }

    @Override
    public List<Account> queryAccountList() {
        System.out.println("这里执行的是查询所有用户");
        return null;
    }
}
