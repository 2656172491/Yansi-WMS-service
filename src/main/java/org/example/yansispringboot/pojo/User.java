package org.example.yansispringboot.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

// 用户实体类
@Data
public class User {
    private long id;            // 用户ID
    private String username;        // 用户名
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) // 在序列化时忽略密码字段，避免泄露敏感信息
    private String password;    // 密码
    private String realName;    // 真实姓名
    private String employeeNo;    // 员工ID
    private String email;       // 电子邮箱
    private String avatar;      // 头像URL
    private String phone;       // 电话号码
    private String roleId;        // 角色
    private int status;         // 0：禁用，1：启用
    private LocalDateTime lastLoginTime;   // 上次登录时间
    private String lastLoginIp;     // 上次登录IP地址
    @JsonIgnore
    private LocalDateTime createTime;   // 创建时间
    @JsonIgnore
    private LocalDateTime updateTime;   // 更新时间
    @JsonIgnore
    private int isDeleted;      // 0：未删除，1：已删除
}
