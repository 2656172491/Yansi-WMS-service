package org.example.yansispringboot.pojo;

import lombok.Data;

import java.time.LocalDateTime;

// 物资表
@Data
public class Goods {
    private long id;            // 物资ID
    private String name;        // 物资名称
    private String code;        // 物资编码
    private long categoryId;    // 分类ID
    private String specification;   // 规格
    private String unit;        // 单位
    private double price;       // 单价
    private int minStock;       // 最小库存预警
    private int maxStock;       // 最大库存预警
    private int status;         // 状态：1-正常，0-停用
    private LocalDateTime createTime;   // 创建时间
    private LocalDateTime updateTime;   // 更新时间
    private int isDeleted;      // 是否删除：0-未删除，1-已删除
}
