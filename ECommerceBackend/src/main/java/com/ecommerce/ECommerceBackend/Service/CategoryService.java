package com.ecommerce.ECommerceBackend.Service;

import com.ecommerce.ECommerceBackend.Model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getAllCategories();
    void createCatgeory(Category category);
    String deleteCategory(Long categoryId);

    Category updateCategory(Category category, Long categoryId);
}
