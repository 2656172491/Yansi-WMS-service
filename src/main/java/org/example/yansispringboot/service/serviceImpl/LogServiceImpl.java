package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.mapper.LoginLogMapper;
import org.example.yansispringboot.mapper.OperateLogMapper;
import org.example.yansispringboot.pojo.LoginLog;
import org.example.yansispringboot.pojo.OperateLog;
import org.example.yansispringboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// 日志服务实现类
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public void userLog(String username, int status, String ip, String message) {
        LoginLog loginLog = new LoginLog();
        loginLog.setUsername(username);
        loginLog.setStatus(status);
        loginLog.setIp(ip);
        loginLog.setMessage(message);
        loginLogMapper.add(loginLog);
    }

    @Override
    public void actionLog(String username, String type,String module, String content, String ip) {
        OperateLog operateLog = new OperateLog();
        operateLog.setUsername(username);
        operateLog.setType(type);
        operateLog.setModule(module);
        operateLog.setContent(content);
        operateLog.setIp(ip);
        operateLogMapper.addLog(operateLog);
    }
}
