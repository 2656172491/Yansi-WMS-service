package org.example.yansispringboot.controller;

import org.example.yansispringboot.common.Result;
import org.example.yansispringboot.pojo.Category;
import org.example.yansispringboot.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

// 物资分类控制器，处理与物资分类相关的请求，如获取分类列表、创建分类等
@RestController
@RequestMapping("/category")
public class CategoriesController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public Result<List<Category>> getAllCategories() {
        List<Category> categories = categoryService.getAllCategories();
        return Result.success(categories);
    }
}
