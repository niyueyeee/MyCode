package com.itheima.dao;

import com.itheima.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @author niyueyeee
 * @create 2019-04-06 19:50
 */
@Repository("accountDao")
public class AccountDaoImpl implements AccountDao {
    @Autowired
    @Qualifier("jdbcTemplate")
    private JdbcTemplate jdbcTemplate;


    @Override
    public Account queryAccountByName(String name) throws Exception {
        String sql = "select * from account where name=?";
        Object[] params = {name};
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), params);

    }

    @Override
    public void updateAccountById(Account account) throws Exception {
        String sql = "update account set money=? where id=?";
        Object[] params = {account.getMoney(),account.getId()};

        jdbcTemplate.update(sql,params);
    }
}
