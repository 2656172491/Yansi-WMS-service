package org.example.yansispringboot.service;

import java.util.List;
import java.util.Map;

// 统计服务接口
public interface StatisticsService {

    int getCountGoods();

    int getTodayInGoods();

    int getTodayOutGoods();

    int getInventoryWarning();

    Map<String, List<Object>> getInventoryTrends(String period);

}
