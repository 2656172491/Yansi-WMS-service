package org.example.yansispringboot.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.pojo.Inventory;
import org.example.yansispringboot.service.InventoryService;
import org.example.yansispringboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

        logService.actionLog(token,"查询","库存列表","查询物资:"+goodId,request.getRemoteAddr());
        List<Inventory> inventorys = inventoryService.getInventoryByGoodId(goodId);
        return Result.success(inventorys);
    }
}
