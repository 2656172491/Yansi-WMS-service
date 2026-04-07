package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yansispringboot.pojo.Inventory;


// 库存数据访问层
@Mapper
public interface InventoryMapper {

    /**
     * 根据物资ID和仓库ID查询库存信息
     * @param goodsId 物资id
     * @param warehouseId 仓库id
     * @return 库存信息
     */
    @Select("select * from inventory " +
            "where goods_id = #{goodsId} and warehouse_id = #{warehouseId}")
    Inventory getByIdInventory(long goodsId, long warehouseId);
}
