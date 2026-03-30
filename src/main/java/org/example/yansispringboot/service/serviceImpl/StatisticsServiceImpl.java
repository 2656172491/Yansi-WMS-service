package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.mapper.StatisticsMapper;
import org.example.yansispringboot.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


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

    public Map<String, List<Object>> getInventoryTrends(String period) {
        List<Map<String, Object>> list;
        if (period.equals("week")) {
            list = statisticsMapper.getInventoryTrends(6);
        }else {
            list = statisticsMapper.getInventoryTrends(29);
        }

        // 2. 把查询结果转成 Map，方便按日期快速取值
        Map<String, Map<String, Object>> dataMap = new HashMap<>();
        for (Map<String, Object> item : list) {
            dataMap.put(String.valueOf(item.get("date")), item);
        }
        // 3. 准备最近 7 天日期
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd");
        List<String> dates = new ArrayList<>();
        List<Integer> inbound = new ArrayList<>();
        List<Integer> outbound = new ArrayList<>();

        LocalDate start;
        if (period.equals("week")) {
            start = LocalDate.now().minusDays(6);
            for (int i = 0; i < 7; i++) {
                LocalDate current = start.plusDays(i);
                String dateStr = current.format(formatter);
                dates.add(dateStr);

                Map<String, Object> item = dataMap.get(dateStr);
                if (item != null) {
                    inbound.add(((Number) item.getOrDefault("in_quantity", 0)).intValue());
                    outbound.add(((Number) item.getOrDefault("out_quantity", 0)).intValue());
                } else {
                    inbound.add(0);
                    outbound.add(0);
                }
            }
        }else {
            start = LocalDate.now().minusDays(29);
            for (int i = 0; i < 30; i++) {
                LocalDate current = start.plusDays(i);
                String dateStr = current.format(formatter);
                dates.add(dateStr);

                Map<String, Object> item = dataMap.get(dateStr);
                if (item != null) {
                    inbound.add(((Number) item.getOrDefault("in_quantity", 0)).intValue());
                    outbound.add(((Number) item.getOrDefault("out_quantity", 0)).intValue());
                } else {
                    inbound.add(0);
                    outbound.add(0);
                }
            }
        }

        Map<String, List<Object>> result = new HashMap<>();
        result.put("dates", new ArrayList<>(dates));
        result.put("inbound", new ArrayList<>(inbound));
        result.put("outbound", new ArrayList<>(outbound));
        return result;
    }
}
