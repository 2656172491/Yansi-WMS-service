package org.example.yansispringboot.service;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.pojo.Warehouse;

import java.util.List;

// 仓库服务接口
public interface WarehouseService {

    Warehouse getWarehouseById(Long id);

    List<Warehouse> getAllWarehouses();

    PageResult<Warehouse> getWarehouses(int page, int pageSize, String name);

    int addWarehouse(Warehouse warehouse);

    int updateWarehouse(Warehouse warehouse);

    int deleteWarehouse(Long id);
}
