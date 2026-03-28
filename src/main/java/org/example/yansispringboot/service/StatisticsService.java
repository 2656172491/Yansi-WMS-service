package org.example.yansispringboot.service;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.pojo.Inventory;

import java.util.Map;

// 统计服务接口
public interface StatisticsService {

    // 获取首页概览数据（物资总数、今日入库、今日出库、库存预警数）
    Map<String, Object> getOverview();

    // 获取库存预警列表
    PageResult<Inventory> getWarningList(int page, int pageSize);
}
