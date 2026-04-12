package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.*;
import org.example.yansispringboot.pojo.Warehouse;

import java.util.List;

// 仓库数据访问层
@Mapper
public interface WarehouseMapper {

    @Select("SELECT * FROM warehouse WHERE is_deleted = 0")
    List<Warehouse> getWarehouses();

    @Select("SELECT * FROM warehouse WHERE id = #{id} AND is_deleted = 0")
    Warehouse getWarehouseById(long id);

    @Insert("insert into warehouse (name, code, address, contact, phone, status, create_time, update_time, is_deleted) " +
            "value (#{name}, #{code}, #{address}, #{contact}, #{phone}, #{status}, now(), now(), 0)")
    void addWarehouses(Warehouse warehouse);

    @Update("update warehouse set name = #{name}, code = #{code}, address = #{address}, contact = #{contact}, " +
            "phone = #{phone}, status = #{status}, is_deleted = #{isDelete}, update_time = now() where id = #{id}")
    void updateWarehouses(Warehouse warehouse);
}
