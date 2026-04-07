package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

// 统计数据访问层
@Mapper
public interface StatisticsMapper {

    /**
     * 获取物资总数
     * @return 物资总数
     */
    @Select("SELECT COUNT(*) FROM goods")
    int getCountGoods();

    /**
     * 获取今日入库数
     * @return 今日入库数
     */
    @Select("select count(*) from record " +
            "where type = 1 and DATE(create_time) = CURDATE()")
    int getTodayInGoods();

    /**
     * 获取今日出库数
     * @return 今日出库数
     */
    @Select("select count(*) from record " +
            "where type = 2 and DATE(create_time) = CURDATE()")
    int getTodayOutGoods();

    /**
     * 获取库存预警数
     * @return 库存预警数
     */
    @Select("select count(*) from inventory i join goods g on i.goods_id = g.id " +
            "where g.is_deleted = 0 and (i.quantity < g.min_stock or i.quantity > g.max_stock)")
    int getInventoryWarning();

    /**
     * 获取近7天或30天的库存变化趋势
     * @param day 天数，7或30
     * @return 包含日期、入库数量和出库数量的列表
     */
    @Select("SELECT DATE_FORMAT(create_time, '%m-%d') AS date, " +
            "SUM(CASE WHEN type = 1 THEN quantity ELSE 0 END) AS in_quantity, " +
            "SUM(CASE WHEN type = 2 THEN quantity ELSE 0 END) AS out_quantity " +
            "FROM record " +
            "WHERE create_time >= DATE_SUB(CURDATE(), INTERVAL #{day} DAY) " +
            "GROUP BY DATE_FORMAT(create_time, '%m-%d') " +
            "ORDER BY DATE_FORMAT(create_time, '%m-%d')")
    List<Map<String, Object>> getInventoryTrends(Integer day);
}
