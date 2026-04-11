package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.mapper.InventoryMapper;
import org.example.yansispringboot.pojo.Inventory;
import org.example.yansispringboot.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 库存服务实现类
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public List<Inventory> getInventoryByGoodId(Long goodId) {
        return inventoryMapper.getInventoryByGoodId(goodId);
    }
}
