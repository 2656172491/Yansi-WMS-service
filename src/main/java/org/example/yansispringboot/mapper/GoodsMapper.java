package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yansispringboot.pojo.Goods;

import java.util.List;

// 物资数据访问层
@Mapper
public interface GoodsMapper {

    /**
     * 查询所有物资信息
     * @return 物资列表
     */
    @Select("SELECT * FROM goods")
    List<Goods> getAllGoods();

}
