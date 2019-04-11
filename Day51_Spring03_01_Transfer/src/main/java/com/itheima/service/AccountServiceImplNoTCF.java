package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import com.itheima.utils.TranscationManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author niyueyeee
 * @create 2019-04-03 19:50
 */
@Repository("accountServiceImplNoTCF")
public class AccountServiceImplNoTCF implements AccountService {
    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;
    @Autowired
    @Qualifier("transcationManager")
    private TranscationManager transcationManager;

    @Override
    public void transfer(String fromName, String toName, Float money)
            throws Exception {


        Account fromAccount = accountDao.queryAccountByName(fromName);
        Account toAccount = accountDao.queryAccountByName(toName);
        // 完成计算 汇款人-money  收款人+money
        fromAccount.setMoney(fromAccount.getMoney() - money);
        toAccount.setMoney(toAccount.getMoney() + money);
        // 将数据进行更新
        accountDao.updateAccount(toAccount);
        System.out.println(1/0);
        accountDao.updateAccount(fromAccount);
    }
}
