package org.example.yansispringboot.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.pojo.Warehouse;
import org.example.yansispringboot.service.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

// 仓库控制器，处理与仓库相关的请求，如获取仓库列表、创建仓库等
@RestController
@RequestMapping("/warehouses")
@Slf4j
public class WarehousesController {
    @Autowired
    private WarehouseService warehouseService;

    @GetMapping
    private Result<List<Warehouse>> getWarehouses() {
        List<Warehouse> warehouses = warehouseService.getWarehouses();
        System.out.println(warehouses);
        return Result.success(warehouses);
    }

    @GetMapping("/{id}")
    public Result<Warehouse> getWarehousesById(@PathVariable long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id);
        if (warehouse != null) {
            return Result.success(warehouse);
        } else {
            return Result.error("仓库不存在");
        }
    }

    @PostMapping
    public Result<Void> addWarehouses(@RequestBody Warehouse warehouse) {
        warehouseService.addWarehouses(warehouse);
        return Result.success();
    }

    @PutMapping("/{id}")
    public Result<Void> updateWarehouses(@RequestBody Warehouse warehouse){
        warehouseService.updateWarehouses(warehouse);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteWarehouses(@PathVariable long id) {
        Warehouse warehouse = warehouseService.getWarehouseById(id);
        if (warehouse != null) {
            warehouse.setIsDelete(1); // 逻辑删除
            warehouseService.updateWarehouses(warehouse);
            return Result.success();
        } else {
            return Result.error("仓库不存在");
        }
    }

    @GetMapping("/stats")
    public Result<Map<String, Object>> getWarehouseStats() {
        List<Warehouse> warehouses = warehouseService.getWarehouses();
        int total = warehouses.size();
        int normal = (int) warehouses.stream().filter(w -> w.getStatus() == 1).count();
        int stopped = total - normal;

        Map<String, Object> stats = Map.of(
                "total", total,
                "normal", normal,
                "stopped", stopped
        );
        return Result.success(stats);
    }
}
