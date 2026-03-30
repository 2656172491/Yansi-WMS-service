package org.example.yansispringboot.controller;

import cn.hutool.jwt.JWT;
import cn.hutool.jwt.JWTPayload;
import cn.hutool.jwt.JWTUtil;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.service.LogService;
import org.example.yansispringboot.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 统计控制器，处理与统计相关的请求，如获取用户活动统计、系统性能统计等
@RestController
@RequestMapping("/statistics")
@Slf4j
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @Autowired
    private LogService logService;

    /**
     * 获取统计概览，包括物资总数、今日入库、今日出库、库存预警等信息
     * @param request HTTP请求对象，用于获取请求头中的token和记录日志
     * @return  一个包含统计数据的结果对象，成功时返回统计数据，失败时返回错误信息
     */
    @GetMapping("/overview")
    public Result<Map<String,Integer>> getOverview(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JWT jwt = JWTUtil.parseToken(token);
        JWTPayload payload = jwt.getPayload();
        String username = (String) payload.getClaim("username");
        log.info(token);
        log.info("用户 {} 请求获取统计概览", username);
        // 记录日志
        logService.actionLog(token, "get","首页", "统计概览",request.getRemoteAddr());

        Map<String,Integer> map = new HashMap<>();
        // 获取物资总数
        int getCountGoods = statisticsService.getCountGoods();
        int getTodayInGoods = statisticsService.getTodayInGoods();
        int getTodayOutGoods = statisticsService.getTodayOutGoods();
        int getInventoryWarning = statisticsService.getInventoryWarning();
        log.info("物资总数: {}, 今日入库: {}, 今日出库: {}, 库存预警: {}", getCountGoods, getTodayInGoods, getTodayOutGoods, getInventoryWarning);
        map.put("CountGoods", getCountGoods);
        map.put("TodayInGoods", getTodayInGoods);
        map.put("TodayOutGoods", getTodayOutGoods);
        map.put("InventoryWarning", getInventoryWarning);

        return Result.success(map);
    }

    /**
     * 获取用户最近的活动记录，操作等信息，展示在首页的最近动态模块
     * @param request HTTP请求对象，用于获取请求头中的token和记录日志
     * @return 一个包含用户最近活动记录的结果对象，成功时返回活动记录列表，失败时返回错误信息
     */
    @GetMapping("/activities")
    public Result<List<Map<String,String>>> getUserActivities(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JWT jwt = JWTUtil.parseToken(token);
        JWTPayload payload = jwt.getPayload();
        String username = (String) payload.getClaim("username");
        log.info(token);
        log.info("用户 {} 请求获取最近动态", username);
        // 记录日志
        logService.actionLog(token, "get","首页", "获取最近动态",request.getRemoteAddr());

        List<Map<String,String>> activities = logService.getRecentActivities();
        log.info("用户 {} 的最近活动: {}", username, activities);
        return Result.success(activities);
    }

    @GetMapping("/trends")
    public Result<Map<String,List<Object>>> getTrends(@RequestParam String period,HttpServletRequest request){
        String token = request.getHeader("Authorization");
        JWT jwt = JWTUtil.parseToken(token);
        JWTPayload payload = jwt.getPayload();
        String username = (String) payload.getClaim("username");
        log.info("用户 {} 请求获取库存趋势", username);
        // 记录日志
        logService.actionLog(token, "get", "工作台", "获取库存趋势", request.getRemoteAddr());
        Map<String, List<Object>> trends = statisticsService.getInventoryTrends(period);
        return Result.success(trends);
    }
}
