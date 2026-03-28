package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.yansispringboot.pojo.Warehouse;

import java.util.List;

// 仓库数据访问层
@Mapper
public interface WarehouseMapper {

    Warehouse selectById(@Param("id") Long id);

    List<Warehouse> selectAll();

    List<Warehouse> selectPage(@Param("offset") int offset,
                               @Param("pageSize") int pageSize,
                               @Param("name") String name);

    long countByCondition(@Param("name") String name);

    int insert(Warehouse warehouse);

    int update(Warehouse warehouse);

    int deleteById(@Param("id") Long id);
}
