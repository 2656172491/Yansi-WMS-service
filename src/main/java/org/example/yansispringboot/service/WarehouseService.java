package org.example.yansispringboot.service;

import org.example.yansispringboot.pojo.Warehouse;

import java.util.List;

// 仓库服务接口
public interface WarehouseService {
    List<Warehouse> getWarehouses();

    Warehouse getWarehouseById(long id);

    void addWarehouses(Warehouse warehouse);

    void updateWarehouses(Warehouse warehouse);
}
