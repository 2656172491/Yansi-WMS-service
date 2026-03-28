package org.example.yansispringboot.service;

// 日志服务接口
public interface LogService {

    void log(String username, int i, String remoteAddr, String s);
}
