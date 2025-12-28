package com.ecommerce.ECommerceBackend.Service;

import com.ecommerce.ECommerceBackend.Model.Category;
import com.ecommerce.ECommerceBackend.Payload.CategoryDTO;
import com.ecommerce.ECommerceBackend.Payload.CategoryResponse;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber,Integer pageSize,String sortBy,String sortOrder);
    CategoryDTO createCatgeory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long categoryDTOId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryDTOId);
}
