package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yansispringboot.pojo.Record;

import java.util.List;


// 出入库记录数据访问层
@Mapper
public interface RecordMapper {

    /**
     * 插入出入库记录
     * @param record 记录对象，包含物资ID、仓库ID、数量、操作类型、操作人等信息
     */
    @Insert("INSERT INTO record (goods_id, warehouse_id, type, quantity, before_quantity, after_quantity, operator_id, operator_name, remark, create_time) " +
            "value (#{goodsId}, #{warehouseId}, #{type}, #{quantity}, #{beforeQuantity}, #{afterQuantity}, #{operatorId}, #{operatorName}, #{remark}, NOW())")
    void insertRecord(Record record);

    /**
     * 根据操作类型查询出入库记录，按照创建时间降序排序
     * @param type 操作类型，1表示入库记录，2表示出库记录
     * @return 符合条件的出入库记录列表
     */
    @Select("SELECT * FROM record WHERE type = #{type} ORDER BY create_time DESC")
    List<Record> getAllRecords(Integer type);
}
