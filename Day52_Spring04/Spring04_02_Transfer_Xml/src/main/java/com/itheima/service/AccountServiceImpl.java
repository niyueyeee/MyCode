package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 * @author niyueyeee
 * @create 2019-04-06 19:50
 */
@Service("accountService")
public class AccountServiceImpl implements AccountService {

    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;


    @Override
    public void transfer(String fromName, String toName, Float money) throws Exception {
        // 根据账户名查询账户信息
        Account fromAccount = accountDao.queryAccountByName(fromName);
        Account toAccount = accountDao.queryAccountByName(toName);

        // 更新钱数
        fromAccount.setMoney(fromAccount.getMoney() - money);
        toAccount.setMoney(toAccount.getMoney() + money);

        // 更新到数据库
        accountDao.updateAccountById(fromAccount);
//        System.out.println(1/0);
        accountDao.updateAccountById(toAccount);
    }
}
