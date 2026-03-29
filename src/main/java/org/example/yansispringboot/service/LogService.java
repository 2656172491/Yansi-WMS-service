package org.example.yansispringboot.service;

import java.util.List;
import java.util.Map;

// 日志服务接口
public interface LogService {

    void userLog(String username, int i, String remoteAddr, String s);

    void actionLog(String username, String type, String module,String content, String remoteAddr);

    List<Map<String, String>> getRecentActivities();
}
