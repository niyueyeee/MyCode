package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-02 21:05
 */
@Repository("accountService")
public class AccountServiceImpl implements AccountService {
    @Autowired
    @Qualifier("accountDao")
    private AccountDao accountDao;

    @Override
    public void saveAccount(Account account) {
        try {
            accountDao.saveAccount(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateAccountById(Account account) {
        try {
            accountDao.updateAccountById(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delteAccountById(int id) {
        try {
            accountDao.delteAccountById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account queryAccountById(int id) {
        Account account = null;
        try {
            account = accountDao.queryAccountById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return account;
    }

    @Override
    public List<Account> queryAccountList() {
        List<Account> list = null;
        try {
            list = accountDao.queryAccountList();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
