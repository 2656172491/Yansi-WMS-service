package org.example.yansispringboot.pojo;

import lombok.Data;

import java.time.LocalDateTime;

// 角色表
@Data
public class Role {
    private long id;            // id
    private String roleName;    // 角色名称
    private int level;          // 权限等级
    private LocalDateTime createTime;   // 创建时间
    private LocalDateTime updateTime;   // 更新时间
}
