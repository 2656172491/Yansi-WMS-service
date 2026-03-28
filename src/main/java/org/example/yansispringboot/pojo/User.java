package org.example.yansispringboot.pojo;

import lombok.Data;

import java.time.LocalDateTime;

// 用户实体类
@Data
public class User {
    private long id;            // 用户ID
    private String name;        // 用户名
    private String password;    // 密码
    private String realName;    // 真实姓名
    private String phone;       // 电话号码
    private String role;        // 角色
    private int status;         // 0：禁用，1：启用
    private LocalDateTime createTime;   // 创建时间
    private LocalDateTime updateTime;   // 更新时间
    private int isDeleted;      // 0：未删除，1：已删除
}
