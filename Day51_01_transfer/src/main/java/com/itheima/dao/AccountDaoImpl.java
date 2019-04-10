package com.itheima.dao;

import com.itheima.pojo.Account;
import com.itheima.utils.ConnectionUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

/**
 * @author niyueyeee
 * @create 2019-04-03 19:45
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    @Qualifier("queryRunner")
    private QueryRunner queryRunner;

    @Autowired
    @Qualifier("connectionUtil")
    private ConnectionUtil connectionUtil;

    @Override
    public Account queryAccountByName(String name) throws Exception {
        String sql = "select * from account where name = ?";
        Object[] params = {name};
        return queryRunner.query(sql, new BeanHandler<>(Account.class), params);
    }

    @Override
    public void updateAccount(Account account) throws Exception {
        String sql = "update account set money=? where id = ?";
        Object[] params = {account.getMoney(), account.getId()};
        //保证一个线程连接对象是同一个
        queryRunner.update(connectionUtil.getConnection(),sql, params);
    }
}
