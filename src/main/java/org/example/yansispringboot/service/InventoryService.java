package org.example.yansispringboot.service;

import org.example.yansispringboot.pojo.Inventory;

import java.util.List;

// 库存服务接口
public interface InventoryService {

    List<Inventory> getInventoryByGoodId(Long goodId);
}
