package com.itheima.dao;

import com.itheima.pojo.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {

    void saveAccount(Account account) throws SQLException;

    void updateAccountById(Account account) throws SQLException;

    void delteAccountById(Integer id) throws SQLException;

    Account queryAccountById(Integer id) throws SQLException;

    List<Account> queryAccountList() throws SQLException;

}
