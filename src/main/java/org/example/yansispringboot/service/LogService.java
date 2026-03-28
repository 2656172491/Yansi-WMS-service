package org.example.yansispringboot.service;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.pojo.LoginLog;
import org.example.yansispringboot.pojo.OperateLog;

// 日志服务接口
public interface LogService {

    PageResult<LoginLog> getLoginLogs(int page, int pageSize, String username);

    int addLoginLog(LoginLog loginLog);

    PageResult<OperateLog> getOperateLogs(int page, int pageSize, String username);

    int addOperateLog(OperateLog operateLog);
}
