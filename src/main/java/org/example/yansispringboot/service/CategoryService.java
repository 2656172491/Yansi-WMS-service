package org.example.yansispringboot.service;

import org.example.yansispringboot.pojo.Category;

import java.util.List;

// 物资分类服务接口
public interface CategoryService {

    Category getCategoryById(Long id);

    List<Category> getCategories();

    List<Category> getCategoriesByParentId(Long parentId);

    int addCategory(Category category);

    int updateCategory(Category category);

    int deleteCategory(Long id);
}
