package org.example.yansispringboot.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.pojo.Inventory;
import org.example.yansispringboot.pojo.Record;
import org.example.yansispringboot.service.InventoryService;
import org.example.yansispringboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// 库存控制器，处理与库存相关的请求，如获取库存列表、更新库存等
@RestController
@RequestMapping("/inventory")
@Slf4j
public class InventoryController {
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private LogService logService;

    @GetMapping
    public Result<List<Inventory>> getInventoryById(@RequestParam Long goodId, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JWT parseJWT = JWTUtil.parseToken(token);
        JWTPayload payload = parseJWT.getPayload();
        String username = (String) payload.getClaim("username");
        log.info("用户:{}请求获取物资:{}信息",username,goodId);

        logService.actionLog(token,"get","库存列表","查询物资:"+goodId,request.getRemoteAddr());
        List<Inventory> inventorys = inventoryService.getInventoryByGoodId(goodId);
        return Result.success(inventorys);
    }

    @PutMapping("/{id}")
    public Result<Void> updateGoods(@PathVariable Integer id,
                                    @RequestBody Record record,
                                    HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JWT jwt = JWTUtil.parseToken(token);
        JWTPayload payload = jwt.getPayload();
        String username = (String) payload.getClaim("username");
        log.info("用户 {} 更新物资", username);
        log.info(String.valueOf(record));
        // 记录日志
        logService.actionLog(token, "set", "物资列表", "出入库物资", request.getRemoteAddr());
        inventoryService.updateInventory(id, record, username);
        return Result.success();
    }
}
