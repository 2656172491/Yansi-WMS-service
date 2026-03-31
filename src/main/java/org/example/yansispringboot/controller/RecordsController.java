package org.example.yansispringboot.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.pojo.Record;
import org.example.yansispringboot.service.LogService;
import org.example.yansispringboot.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

// 出入库记录控制器，处理与记录相关的请求，如获取记录列表、创建记录等
@RestController
@RequestMapping("/records")
@Slf4j
public class RecordsController {
    @Autowired
    private RecordService recordService;

    @Autowired
    private LogService logService;

    @GetMapping
    public Result<PageResult<Record>> getAllRecords(@RequestParam(defaultValue = "1") Integer pageNum,
                                                    @RequestParam(defaultValue = "10") Integer pageSize,
                                                    @RequestParam Integer type,
                                                    HttpServletRequest request) {
        String token = request.getHeader("Authorization");
        JWT jwt = JWTUtil.parseToken(token);
        JWTPayload payload = jwt.getPayload();
        String username = (String) payload.getClaim("username");
        if (type == 1){
            log.info("用户 {} 获取入库记录列表, 页码: {}, 每页数量: {}", username, pageNum, pageSize);
            logService.actionLog(token, "get", "入库管理", "获取入库记录列表", request.getRemoteAddr());
        }else if (type == 2){
            log.info("用户 {} 获取出库记录列表, 页码: {}, 每页数量: {}", username, pageNum, pageSize);
            logService.actionLog(token, "get", "出库管理", "获取出库记录列表", request.getRemoteAddr());

        }
        PageResult<Record> records = recordService.getAllRecords(pageNum,pageSize,type);
        return Result.success(records);
    }

}
