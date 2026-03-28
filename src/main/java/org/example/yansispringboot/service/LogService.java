package org.example.yansispringboot.service;

// 日志服务接口
public interface LogService {

    void userLog(String username, int i, String remoteAddr, String s);

    void actionLog(String username, String type, String module,String content, String remoteAddr);
}
