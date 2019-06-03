package com.itheima.service;

/**
 * @author niyueyeee
 * @create 2019-04-06 19:50
 */
public interface AccountService {
    void transfer(String fromName, String toName, Float money) throws Exception;

}
