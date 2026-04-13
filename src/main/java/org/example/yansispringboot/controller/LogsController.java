package org.example.yansispringboot.controller;

import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.pojo.LoginLog;
import org.example.yansispringboot.pojo.OperateLog;
import org.example.yansispringboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 日志控制器，处理与日志相关的请求
@RestController
@RequestMapping("/logs")
public class LogsController {
    @Autowired
    private LogService logService;

    @GetMapping("/login")
    public Result<List<LoginLog>> getLoginLogs() {
        List<LoginLog> logs = logService.getLoginLogs();
        return Result.success(logs);
    }

    @GetMapping("/operate")
    public Result<List<OperateLog>> getOperateLogs() {
        List<OperateLog> logs = logService.getOperateLogs();
        System.out.println(logs);
        return Result.success(logs);
    }
}
