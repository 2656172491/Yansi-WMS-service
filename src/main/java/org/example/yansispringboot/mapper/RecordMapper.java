package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.yansispringboot.pojo.Record;

import java.util.List;

// 出入库记录数据访问层
@Mapper
public interface RecordMapper {

    Record selectById(@Param("id") Long id);

    List<Record> selectPage(@Param("offset") int offset,
                            @Param("pageSize") int pageSize,
                            @Param("goodsId") Long goodsId,
                            @Param("warehouseId") Long warehouseId,
                            @Param("type") Integer type);

    long countByCondition(@Param("goodsId") Long goodsId,
                          @Param("warehouseId") Long warehouseId,
                          @Param("type") Integer type);

    int insert(Record record);
}
