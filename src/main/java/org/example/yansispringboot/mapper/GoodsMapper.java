package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.yansispringboot.pojo.Goods;

import java.util.List;

// 物资数据访问层
@Mapper
public interface GoodsMapper {

    Goods selectById(@Param("id") Long id);

    List<Goods> selectPage(@Param("offset") int offset,
                           @Param("pageSize") int pageSize,
                           @Param("name") String name,
                           @Param("categoryId") Long categoryId);

    long countByCondition(@Param("name") String name,
                          @Param("categoryId") Long categoryId);

    int insert(Goods goods);

    int update(Goods goods);

    int deleteById(@Param("id") Long id);
}
