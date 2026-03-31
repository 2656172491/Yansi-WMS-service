package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yansispringboot.pojo.Inventory;


// 库存数据访问层
@Mapper
public interface InventoryMapper {

    @Select("select * from inventory where goods_id = #{goodsId} and warehouse_id = #{warehouseId}")
    Inventory getByIdInventory(long goodsId, long warehouseId);
}
