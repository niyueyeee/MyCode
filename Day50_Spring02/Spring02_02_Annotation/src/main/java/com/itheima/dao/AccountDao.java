package com.itheima.dao;

import com.itheima.pojo.Account;

import java.sql.SQLException;
import java.util.List;

public interface AccountDao {

    void saveAccount(Account account) throws SQLException;


}
