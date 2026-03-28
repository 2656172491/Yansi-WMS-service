package org.example.yansispringboot.service.serviceImpl;

import org.example.yansispringboot.mapper.CategoryMapper;
import org.example.yansispringboot.pojo.Category;
import org.example.yansispringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 物资分类服务实现类
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    @Override
    public Category getCategoryById(Long id) {
        return categoryMapper.selectById(id);
    }

    @Override
    public List<Category> getCategories() {
        return categoryMapper.selectAll();
    }

    @Override
    public List<Category> getCategoriesByParentId(Long parentId) {
        return categoryMapper.selectByParentId(parentId);
    }

    @Override
    public int addCategory(Category category) {
        return categoryMapper.insert(category);
    }

    @Override
    public int updateCategory(Category category) {
        return categoryMapper.update(category);
    }

    @Override
    public int deleteCategory(Long id) {
        return categoryMapper.deleteById(id);
    }
}
