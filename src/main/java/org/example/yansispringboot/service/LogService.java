package org.example.yansispringboot.service;

import org.example.yansispringboot.pojo.LoginLog;
import org.example.yansispringboot.pojo.OperateLog;

import java.util.List;
import java.util.Map;

// 日志服务接口
public interface LogService {

    void userLog(String token, int status, String ip, String message, String userAgent);

    void actionLog(String token, String type, String module,String content, String remoteAddr);

    List<Map<String, String>> getRecentActivities();

    List<LoginLog> getLoginLogs();

    List<OperateLog> getOperateLogs();
}
