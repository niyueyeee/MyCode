package com.itheima.service;

/**
 * @author niyueyeee
 * @create 2019-04-03 19:49
 */
public interface AccountService {
    void  transfer(String fromName,String toName,Float money)throws Exception;

}
