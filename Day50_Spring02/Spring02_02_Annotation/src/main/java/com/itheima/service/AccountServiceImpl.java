package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;

@Component("accountService")
public class AccountServiceImpl implements AccountService {

    @Resource(name = "accountDao")
    private AccountDao accountDao;

    @Override
    public void saveAccount(Account account) {
        try {
            accountDao.saveAccount(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
