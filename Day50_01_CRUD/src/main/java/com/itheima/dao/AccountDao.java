package com.itheima.dao;

import com.itheima.pojo.Account;

import java.sql.SQLException;
import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-02 20:40
 */
public interface AccountDao {
    void saveAccount(Account account) throws SQLException;

    void updateAccountById(Account account) throws SQLException;

    void delteAccountById(int id) throws SQLException;

    Account queryAccountById(int id) throws SQLException;

    List<Account> queryAccountList() throws SQLException;
}
