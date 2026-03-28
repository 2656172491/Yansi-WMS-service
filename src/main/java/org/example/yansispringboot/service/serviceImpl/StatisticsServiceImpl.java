package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.common.PageResult;
import org.example.yansispringboot.mapper.InventoryMapper;
import org.example.yansispringboot.mapper.StatisticsMapper;
import org.example.yansispringboot.pojo.Inventory;
import org.example.yansispringboot.service.StatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 统计服务实现类
@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private StatisticsMapper statisticsMapper;

    @Autowired
    private InventoryMapper inventoryMapper;

    @Override
    public Map<String, Object> getOverview() {
        Map<String, Object> overview = new HashMap<>();
        overview.put("totalGoods", statisticsMapper.countTotalGoods());
        overview.put("todayInbound", statisticsMapper.countTodayInbound());
        overview.put("todayOutbound", statisticsMapper.countTodayOutbound());
        overview.put("warningCount", statisticsMapper.countWarningInventory());
        return overview;
    }

    @Override
    public PageResult<Inventory> getWarningList(int page, int pageSize) {
        int offset = (page - 1) * pageSize;
        List<Inventory> records = inventoryMapper.selectWarningPage(offset, pageSize);
        long total = inventoryMapper.countWarning();
        return new PageResult<>(total, records);
    }
}
