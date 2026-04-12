package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.mapper.WarehouseMapper;
import org.example.yansispringboot.pojo.Warehouse;
import org.example.yansispringboot.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 仓库服务实现类
@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public List<Warehouse> getWarehouses() {
        return warehouseMapper.getWarehouses();
    }

    @Override
    public Warehouse getWarehouseById(long id) {
        return warehouseMapper.getWarehouseById(id);
    }

    @Override
    public void addWarehouses(Warehouse warehouse) {
        warehouseMapper.addWarehouses(warehouse);
    }

    @Override
    public void updateWarehouses(Warehouse warehouse) {
        warehouseMapper.updateWarehouses(warehouse);
    }
}
