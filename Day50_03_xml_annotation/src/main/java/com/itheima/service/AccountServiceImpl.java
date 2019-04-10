package com.itheima.service;

import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.sql.SQLException;
import java.util.List;

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

    @Override
    public void updateAccountById(Account account) {
        try {
            accountDao.updateAccountById(account);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delteAccountById(Integer id) {
        try {
            accountDao.delteAccountById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Account queryAccountById(Integer id) {
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
