package org.example.yansispringboot.pojo;

import lombok.Data;

@Data
public class Record {
    private long id;        // 记录ID
    private long goodsId;   // 物资ID
    private long warehouseId;   // 仓库ID
    private int type;       // 1: 入库, 2: 出库
    private int quantity;   // 数量
    private int beforeQuantity; // 操作前数量
    private int afterQuantity;  // 操作后数量
    private String operator;    // 操作人
    private String remark;      // 备注
    private String createTime;  // 创建时间
}
