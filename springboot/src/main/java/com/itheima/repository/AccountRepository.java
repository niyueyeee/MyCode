package com.itheima.repository;

import com.itheima.pojo.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author niyueyeee
 * @create 2019-04-08 13:09
 */

public interface AccountRepository extends JpaRepository<Account,Long>{

    @Override
    public List<Account> findAll();

}
