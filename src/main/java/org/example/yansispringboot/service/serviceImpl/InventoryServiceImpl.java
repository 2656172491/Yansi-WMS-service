package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.mapper.InventoryMapper;
import org.example.yansispringboot.mapper.RecordMapper;
import org.example.yansispringboot.mapper.UserMapper;
import org.example.yansispringboot.pojo.Inventory;
import org.example.yansispringboot.pojo.Record;
import org.example.yansispringboot.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 库存服务实现类
@Service
public class InventoryServiceImpl implements InventoryService {
    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RecordMapper recordMapper;

    @Override
    public List<Inventory> getInventoryByGoodId(Long goodId) {
        return inventoryMapper.getInventoryByGoodId(goodId);
    }

    @Override
    public void updateInventory(Integer id, Record record, String username) {
        // 获取商品id和仓库id
        long goodsId = record.getGoodsId();
        long warehouseId = record.getWarehouseId();
        // 根据商品id和仓库id获取当前库存数量
        Inventory inventory = inventoryMapper.getInventoryById(goodsId,warehouseId);
        // 获取当前库存数量，并根据操作类型更新库存数量
        int nowQuantity = inventory.getQuantity();
        // 设置操作前的库存数量
        record.setBeforeQuantity(nowQuantity);

        // 更新库存数量
        if (record.getType() == 1) {
            // 入库
            inventory.setQuantity(nowQuantity + record.getQuantity());
        } else if (record.getType() == 2) {
            // 出库
            inventory.setQuantity(nowQuantity - record.getQuantity());
        }
        // 更新库存信息
        inventoryMapper.updateInventory(goodsId, warehouseId, inventory.getQuantity());
        // 设置变更后数量
        record.setAfterQuantity(inventory.getQuantity());
        // 设置操作人信息
        record.setOperatorId(userMapper.getUserByName(username).getId());
        record.setOperatorName(username);
        recordMapper.insertRecord(record);
    }
}
