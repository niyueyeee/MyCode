package com.itheima.dao;

import com.itheima.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

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
    public List<Account> queryAccountByList() throws Exception {
//        return jdbcTemplate.query("select * from account", new RowMapper<Account>() {
//            public Account mapRow(ResultSet resultSet, int i) throws SQLException {
//                Account account = new Account();
//                account.setId(resultSet.getInt("id"));
//                account.setName(resultSet.getString("name"));
//                account.setMoney(resultSet.getFloat("money"));
//                return account;
//            }
//        });
        return jdbcTemplate.query("select * from account", new BeanPropertyRowMapper<Account>(Account.class));
    }

    @Override
    public Account queryAccountById(Integer id) throws Exception {
        String sql = "select * from account where id = ?";
        Object[] params = {id};
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Account>(Account.class), params);

    }
}
