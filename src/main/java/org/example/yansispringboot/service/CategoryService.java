package org.example.yansispringboot.service;

import org.example.yansispringboot.pojo.Category;

import java.util.List;

// 物资分类服务接口
public interface CategoryService {

    List<Category> getAllCategories();
}
