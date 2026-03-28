package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.mapper.LoginLogMapper;
import org.example.yansispringboot.pojo.LoginLog;
import org.example.yansispringboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 日志服务实现类
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LoginLogMapper loginLogMapper;
    @Override
    public void log(String username, int status, String ip, String message) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUsername(username);
        loginLog.setStatus(status);
        loginLog.setIp(ip);
        loginLog.setMessage(message);
        loginLogMapper.log(loginLog);
    }
}
