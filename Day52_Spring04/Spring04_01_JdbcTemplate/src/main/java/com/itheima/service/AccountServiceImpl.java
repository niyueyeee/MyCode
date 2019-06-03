package com.itheima.service;


import com.itheima.dao.AccountDao;
import com.itheima.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public Account queryAccountById(Integer id) throws Exception {
        return accountDao.queryAccountById(id);
    }

    @Override
    public List<Account> queryAccountByList() throws Exception {
        return accountDao.queryAccountByList();
    }
}
