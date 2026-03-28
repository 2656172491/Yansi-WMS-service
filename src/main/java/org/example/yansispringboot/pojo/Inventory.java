package org.example.yansispringboot.pojo;

import lombok.Data;

import java.time.LocalDateTime;

// 库存表
@Data
public class Inventory {
    private long id;            // 库存ID
    private long goodsId;       // 物资ID
    private long warehouseId;   // 仓库ID
    private int quantity;       // 当前库存数量
    private LocalDateTime createTime;   // 创建时间
    private LocalDateTime updateTime;   // 更新时间
}
