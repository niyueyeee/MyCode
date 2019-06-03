package com.itheima.dao;

import com.itheima.pojo.Account;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component("accountDao")
public class AccountDaoImpl implements AccountDao {


    @Override
    public void saveAccount(Account account) throws SQLException {
        System.out.println("账户信息保存成功");
    }


}
