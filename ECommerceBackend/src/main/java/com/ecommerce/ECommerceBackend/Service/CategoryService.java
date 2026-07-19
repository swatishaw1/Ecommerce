package com.ecommerce.ECommerceBackend.Service;

import com.ecommerce.ECommerceBackend.Payload.Catgeory.CategoryDTO;
import com.ecommerce.ECommerceBackend.Payload.Catgeory.CategoryResponse;

public interface CategoryService {
    CategoryResponse getAllCategories(Integer pageNumber,Integer pageSize,String sortBy,String sortOrder);
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO deleteCategory(Long categoryDTOId);

    CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryDTOId);
}
