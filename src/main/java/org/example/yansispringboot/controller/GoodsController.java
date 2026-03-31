package org.example.yansispringboot.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.pojo.Record;
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
                                          HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        JWT jwt = JWTUtil.parseToken(token);
        JWTPayload payload = jwt.getPayload();
        String username = (String) payload.getClaim("username");
        log.info("用户 {} 获取物资列表, 页码: {}, 每页数量: {}", username, pageNum, pageSize);

        // 记录日志
        logService.actionLog(token, "get", "物资列表", "获取物资列表", request.getRemoteAddr());

        PageResult result = goodsService.getAllGoods(pageNum, pageSize);

        return Result.success(result);
    }

    @PutMapping("/{id}")
    public Result updateGoods(@PathVariable Integer id,
                              @RequestBody Record record,
                              HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JWT jwt = JWTUtil.parseToken(token);
        JWTPayload payload = jwt.getPayload();
        String username = (String) payload.getClaim("username");
        log.info("用户 {} 更新物资", username);
        log.info(String.valueOf(record));
        // 记录日志
        logService.actionLog(token, "set", "物资列表", "更新物资", request.getRemoteAddr());
        goodsService.updateGoods(id, record, username);
        return Result.success();
    }
}
