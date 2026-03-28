package org.example.yansispringboot.pojo;

import lombok.Data;

import java.time.LocalDateTime;

// 物资分类表
@Data
public class Category {
    private long id;        // 分类ID
    private String name;    // 分类名称
    private String code;    // 分类编码
    private long parentId;  // 父分类ID
    private int sort;       // 排序
    private LocalDateTime createTime;   // 创建时间
    private LocalDateTime updateTime;   // 更新时间
    private int isDeleted;  // 是否删除（0: 否, 1: 是）
}
