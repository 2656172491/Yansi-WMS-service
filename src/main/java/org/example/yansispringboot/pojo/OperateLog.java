package org.example.yansispringboot.pojo;

import lombok.Data;

import java.time.LocalDateTime;

// 操作日志
@Data
public class OperateLog {
    private long id;            // 日志ID
    private String username;    // 用户名
    private String type;        // 操作类型（如：入库、出库、修改库存等）
    private String module;      // 操作页面
    private String content;     // 操作内容描述
    private String ip;          // IP地址
    private LocalDateTime dateTime;   // 操作时间
}
