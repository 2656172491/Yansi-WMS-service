package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.mapper.StatisticsMapper;
import org.example.yansispringboot.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


// 统计服务实现类
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private  StatisticsMapper statisticsMapper;

    @Override
    public int getCountGoods() {
        return statisticsMapper.getCountGoods();
    }

    @Override
    public int getTodayInGoods() {
        return statisticsMapper.getTodayInGoods();
    }

    @Override
    public int getTodayOutGoods() {
        return statisticsMapper.getTodayOutGoods();
    }

    @Override
    public int getInventoryWarning() {
        return statisticsMapper.getInventoryWarning();
    }
}
