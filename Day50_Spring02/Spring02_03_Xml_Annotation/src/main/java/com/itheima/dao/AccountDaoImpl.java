package com.itheima.dao;

import com.itheima.pojo.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.List;

@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    @Qualifier("queryRunner")
    private QueryRunner queryRunner;

    @Override
    public void saveAccount(Account account) throws SQLException {
        String sql = "insert into account (name,money) values (?,?)";
        Object[] params = {account.getName(), account.getMoney()};
        queryRunner.update(sql, params);
    }

    @Override
    public void updateAccountById(Account account) throws SQLException {
        String sql = "update account set name=?,money=? where id=?";
        Object[] params = {account.getName(), account.getMoney(), account.getId()};
        queryRunner.update(sql, params);
    }

    @Override
    public void delteAccountById(Integer id) throws SQLException {
        String sql = "delete from account where id = ?";
        Object[] params = {id};
        queryRunner.update(sql, params);
    }

    @Override
    public Account queryAccountById(Integer id) throws SQLException {
        String sql = "select * from account where id = ?";
        Object[] params = {id};
        return queryRunner.query(sql, new BeanHandler<>(Account.class), params);
    }

    @Override
    public List<Account> queryAccountList() throws SQLException {
        String sql = "select * from account";
        return queryRunner.query(sql, new BeanListHandler<>(Account.class));
    }

}
