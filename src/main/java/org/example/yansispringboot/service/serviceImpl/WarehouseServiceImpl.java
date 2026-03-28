package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.common.PageResult;
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
    public Warehouse getWarehouseById(Long id) {
        return warehouseMapper.selectById(id);
    }

    @Override
    public List<Warehouse> getAllWarehouses() {
        return warehouseMapper.selectAll();
    }

    @Override
    public PageResult<Warehouse> getWarehouses(int page, int pageSize, String name) {
        int offset = (page - 1) * pageSize;
        List<Warehouse> records = warehouseMapper.selectPage(offset, pageSize, name);
        long total = warehouseMapper.countByCondition(name);
        return new PageResult<>(total, records);
    }

    @Override
    public int addWarehouse(Warehouse warehouse) {
        return warehouseMapper.insert(warehouse);
    }

    @Override
    public int updateWarehouse(Warehouse warehouse) {
        return warehouseMapper.update(warehouse);
    }

    @Override
    public int deleteWarehouse(Long id) {
        return warehouseMapper.deleteById(id);
    }
}
