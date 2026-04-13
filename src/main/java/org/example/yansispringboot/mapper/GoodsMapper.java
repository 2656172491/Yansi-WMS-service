package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.*;
import org.example.yansispringboot.pojo.Goods;

import java.util.List;

// 物资数据访问层
@Mapper
public interface GoodsMapper {

    /**
     * 查询所有物资信息
     * @return 物资列表
     */
    List<Goods> getAllGoods(String name, String code, String categoryId, String status);

    @Select("SELECT * from goods where id = #{id}")
    Goods getGoodById(String id);

    @Delete("delete from goods where id=#{id};")
    void deleteGood(String id);

    @Update("update goods set name=#{name} ,code=#{code} ,category_id=#{categoryId} ,specification=#{specification} ," +
            "unit=#{unit} ,price=#{price} ,min_stock=#{minStock} ,max_stock=#{maxStock} ,status=#{status} ,update_time=#{updateTime} ,is_deleted=#{isDeleted} where id=#{id};")
    void updateGood(Goods goods);

    @Insert("insert into goods (name,code,category_id,specification,unit,price,min_stock,max_stock,status,create_time,update_time,is_deleted) " +
            "value (#{name},#{code},#{categoryId},#{specification},#{unit},#{price},#{minStock},#{maxStock},#{status},NOW(),NOW(),#{isDeleted})")
    void addGoods(Goods goods);
}
