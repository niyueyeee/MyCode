package com.itheima.contriller;

import com.itheima.mapper.AccountMapper;
import com.itheima.pojo.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-08 10:38
 */
@RestController
public class MybatisQuickController {

    @Autowired
    private AccountMapper accountMapper;

    @RequestMapping("/query")
    public List<Account> queryUserList(){
        List<Account> accounts = accountMapper.queryAccountList();
        return accounts;
    }
}