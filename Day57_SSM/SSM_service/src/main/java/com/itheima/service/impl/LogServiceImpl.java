package com.itheima.service.impl;

import com.itheima.dao.LogDao;
import com.itheima.pojo.SysLog;
import com.itheima.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author niyueyeee
 * @create 2019-04-20 11:40
 */
@Service
public class LogServiceImpl implements LogService {
    @Autowired
    LogDao logDao;

    @Override
    public void save(SysLog log) {
        logDao.save(log);
    }
}
