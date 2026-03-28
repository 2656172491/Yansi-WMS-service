package org.example.yansispringboot.pojo;

import lombok.Data;

import java.time.LocalDateTime;

// 仓库表
@Data
public class Warehouse {
    private long id;            // 仓库ID
    private String name;        // 仓库名称
    private String code;        // 仓库编号
    private String address;     // 仓库地址
    private String contact;     // 联系人
    private String phone;       // 联系电话
    private int status;         // 状态（0：正常，1：停用）
    private LocalDateTime createdAt; // 创建时间
    private LocalDateTime updatedAt; // 更新时间
    private int isDelete;       // 是否删除（0：未删除，1：已删除）
}
