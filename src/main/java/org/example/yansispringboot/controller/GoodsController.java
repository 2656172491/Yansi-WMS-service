package org.example.yansispringboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.pojo.Goods;
import org.example.yansispringboot.service.GoodsService;
import org.example.yansispringboot.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;

// 物资控制器，处理与物资相关的请求，如获取物资列表、创建物资等
@RestController
@RequestMapping("/goods")
@Slf4j
public class GoodsController {
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private LogService logService;

    @GetMapping
    public Result<PageResult> getAllGoods(@RequestParam(defaultValue = "1") Integer pageNum,
                                          @RequestParam(defaultValue = "10") Integer pageSize,
                                          @RequestParam(required = false) String name,
                                          @RequestParam(required = false) String code,
                                          @RequestParam(required = false) String categoryId,
                                          @RequestParam(required = false) String status,
                                          HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JWT jwt = JWTUtil.parseToken(token);
        JWTPayload payload = jwt.getPayload();
        String username = (String) payload.getClaim("username");
        log.info("用户 {} 获取物资列表, 页码: {}, 每页数量: {}", username, pageNum, pageSize);

        // 记录日志
        logService.actionLog(token, "get", "物资列表", "获取物资列表", request.getRemoteAddr());

        PageResult result = goodsService.getAllGoods(pageNum, pageSize ,name, code, categoryId, status);

        return Result.success(result);
    }

    @GetMapping("/{id}")
    public Result<Goods> getGoodById(@PathVariable String id){
        Goods good = goodsService.getGoodById(id);
        return Result.success(good);
    }

    @DeleteMapping("/{id}")
    public Result<Void> deleteGoods(@PathVariable String id, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JWT jwt = JWTUtil.parseToken(token);
        JWTPayload payload = jwt.getPayload();
        String username = (String) payload.getClaim("username");
        log.info("用户 {} 删除物资, ids: {}", username, id);

        // 记录日志
        logService.actionLog(token, "delete", "物资列表", "删除物资", request.getRemoteAddr());

        goodsService.deleteGoods(id);
        return Result.success();
    }

    @PutMapping
    public Result<Void> updateGoods(@RequestBody Goods goods, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JWT jwt = JWTUtil.parseToken(token);
        JWTPayload payload = jwt.getPayload();
        String username = (String) payload.getClaim("username");
        log.info("用户 {} 更新物资, ids: {}", username, goods.getId());

        // 记录日志
        logService.actionLog(token, "update", "物资列表", "更新物资", request.getRemoteAddr());

        goodsService.updateGoods(goods);
        return Result.success();
    }

    @PostMapping
    public Result<Void> addGoods(@RequestBody Goods goods, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JWT jwt = JWTUtil.parseToken(token);
        JWTPayload payload = jwt.getPayload();
        String username = (String) payload.getClaim("username");
        log.info("用户 {} 创建物资, ids: {}", username, goods.getId());

        // 记录日志
        logService.actionLog(token, "set", "物资列表", "创建物资", request.getRemoteAddr());

        goodsService.addGoods(goods);
        return Result.success();
    }
}
