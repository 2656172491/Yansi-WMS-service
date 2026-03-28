package org.example.yansispringboot.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.example.yansispringboot.pojo.Category;

import java.util.List;

// 物资分类数据访问层
@Mapper
public interface CategoryMapper {

    Category selectById(@Param("id") Long id);

    List<Category> selectAll();

    List<Category> selectByParentId(@Param("parentId") Long parentId);

    int insert(Category category);

    int update(Category category);

    int deleteById(@Param("id") Long id);
}
