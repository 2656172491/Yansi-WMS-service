package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.example.yansispringboot.pojo.Category;

import java.util.List;

// 物资分类数据访问层
@Mapper
public interface CategoryMapper {

    @Select("select * from category")
    List<Category> getAllCategories();
}
