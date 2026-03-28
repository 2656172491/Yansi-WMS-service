package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.yansispringboot.pojo.Inventory;

import java.util.List;

// 库存数据访问层
@Mapper
public interface InventoryMapper {

    Inventory selectById(@Param("id") Long id);

    Inventory selectByGoodsAndWarehouse(@Param("goodsId") Long goodsId,
                                        @Param("warehouseId") Long warehouseId);

    List<Inventory> selectPage(@Param("offset") int offset,
                               @Param("pageSize") int pageSize,
                               @Param("goodsId") Long goodsId,
                               @Param("warehouseId") Long warehouseId);

    long countByCondition(@Param("goodsId") Long goodsId,
                          @Param("warehouseId") Long warehouseId);

    // 查询低于最小库存预警的库存记录
    List<Inventory> selectWarningPage(@Param("offset") int offset,
                                      @Param("pageSize") int pageSize);

    long countWarning();

    int insert(Inventory inventory);

    int update(Inventory inventory);

    int deleteById(@Param("id") Long id);
}
