package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.example.yansispringboot.pojo.Record;


// 出入库记录数据访问层
@Mapper
public interface RecordMapper {

    @Insert("INSERT INTO record (goods_id, warehouse_id, quantity, before_quantity, after_quantity, type, operator, remark, create_time) " +
            "VALUES (#{goodsId}, #{warehouseId}, #{quantity}, #{beforeQuantity}, #{afterQuantity}, #{type}, #{remark}, #{operator}, NOW())")
    void insertRecord(Record record);
}
