package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.mapper.LoginLogMapper;
import org.example.yansispringboot.mapper.OperateLogMapper;
import org.example.yansispringboot.pojo.LoginLog;
import org.example.yansispringboot.pojo.OperateLog;
import org.example.yansispringboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 日志服务实现类
@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LoginLogMapper loginLogMapper;

    @Autowired
    private OperateLogMapper operateLogMapper;

    @Override
    public PageResult<LoginLog> getLoginLogs(int page, int pageSize, String username) {
        int offset = (page - 1) * pageSize;
        List<LoginLog> records = loginLogMapper.selectPage(offset, pageSize, username);
        long total = loginLogMapper.countByCondition(username);
        return new PageResult<>(total, records);
    }

    @Override
    public int addLoginLog(LoginLog loginLog) {
        return loginLogMapper.insert(loginLog);
    }

    @Override
    public PageResult<OperateLog> getOperateLogs(int page, int pageSize, String username) {
        int offset = (page - 1) * pageSize;
        List<OperateLog> records = operateLogMapper.selectPage(offset, pageSize, username);
        long total = operateLogMapper.countByCondition(username);
        return new PageResult<>(total, records);
    }

    @Override
    public int addOperateLog(OperateLog operateLog) {
        return operateLogMapper.insert(operateLog);
    }
}
