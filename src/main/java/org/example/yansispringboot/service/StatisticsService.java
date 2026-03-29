package org.example.yansispringboot.service;

// 统计服务接口
public interface StatisticsService {

    int getCountGoods();

    int getTodayInGoods();

    int getTodayOutGoods();

    int getInventoryWarning();
}
