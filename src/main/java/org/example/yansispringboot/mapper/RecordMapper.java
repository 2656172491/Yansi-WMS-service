package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yansispringboot.pojo.Record;

import java.util.List;


// 出入库记录数据访问层
@Mapper
public interface RecordMapper {

    @Insert("INSERT INTO record (goods_id, warehouse_id, quantity, before_quantity, after_quantity, type, operator_name, remark, create_time) " +
            "VALUES (#{goodsId}, #{warehouseId}, #{quantity}, #{beforeQuantity}, #{afterQuantity}, #{type}, #{remark}, #{operator}, NOW())")
    void insertRecord(Record record);

    @Select("SELECT * FROM record WHERE type = #{type} ORDER BY create_time DESC")
    List<Record> getAllRecords(Integer type);
}
