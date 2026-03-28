package org.example.yansispringboot.pojo;

import lombok.Data;

import java.time.LocalDateTime;

// 登录日志
@Data
public class LoginLog {
    private long id;            // 日志ID
    private String username;    // 用户名
    private int status;         // 登录状态（0：成功，1：失败）
    private String ip;          // IP地址
    private String message;     // 描述
    private LocalDateTime createTime;   // 登录时间
}
