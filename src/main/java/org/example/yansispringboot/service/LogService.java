package org.example.yansispringboot.service;

import java.util.List;
import java.util.Map;

// 日志服务接口
public interface LogService {

    void userLog(String token, int status, String ip, String message, String userAgent);

    void actionLog(String token, String type, String module,String content, String remoteAddr);

    List<Map<String, String>> getRecentActivities();
}
