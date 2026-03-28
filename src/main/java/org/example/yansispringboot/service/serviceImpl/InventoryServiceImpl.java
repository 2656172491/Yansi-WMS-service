package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.common.PageResult;
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
    public Inventory getInventoryById(Long id) {
        return inventoryMapper.selectById(id);
    }

    @Override
    public PageResult<Inventory> getInventory(int page, int pageSize, Long goodsId, Long warehouseId) {
        int offset = (page - 1) * pageSize;
        List<Inventory> records = inventoryMapper.selectPage(offset, pageSize, goodsId, warehouseId);
        long total = inventoryMapper.countByCondition(goodsId, warehouseId);
        return new PageResult<>(total, records);
    }

    @Override
    public PageResult<Inventory> getWarningInventory(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<Inventory> records = inventoryMapper.selectWarningPage(offset, pageSize);
        long total = inventoryMapper.countWarning();
        return new PageResult<>(total, records);
    }

    @Override
    public int addInventory(Inventory inventory) {
        return inventoryMapper.insert(inventory);
    }

    @Override
    public int updateInventory(Inventory inventory) {
        return inventoryMapper.update(inventory);
    }

    @Override
    public int deleteInventory(Long id) {
        return inventoryMapper.deleteById(id);
    }
}
