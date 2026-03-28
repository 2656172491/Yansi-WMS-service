package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;

// 统计数据访问层
@Mapper
public interface StatisticsMapper {

    // 统计有效物资总数
    int countTotalGoods();

    // 统计今日入库数量（数量之和）
    int countTodayInbound();

    // 统计今日出库数量（数量之和）
    int countTodayOutbound();

    // 统计库存预警数量（低于最小库存的记录数）
    long countWarningInventory();
}
