package org.example.yansispringboot.service;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.pojo.Inventory;

// 库存服务接口
public interface InventoryService {

    Inventory getInventoryById(Long id);

    PageResult<Inventory> getInventory(int page, int pageSize, Long goodsId, Long warehouseId);

    PageResult<Inventory> getWarningInventory(int page, int pageSize);

    int addInventory(Inventory inventory);

    int updateInventory(Inventory inventory);

    int deleteInventory(Long id);
}
