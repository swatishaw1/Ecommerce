package com.ecommerce.ECommerceBackend.Service.Impli;

import com.ecommerce.ECommerceBackend.Exceptions.ApiException;
import com.ecommerce.ECommerceBackend.Exceptions.ResourceNotFoundException;
import com.ecommerce.ECommerceBackend.Model.Category;
import com.ecommerce.ECommerceBackend.Payload.CategoryDTO;
import com.ecommerce.ECommerceBackend.Payload.CategoryResponse;
import com.ecommerce.ECommerceBackend.Repository.CategoryRepository;
import com.ecommerce.ECommerceBackend.Service.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public CategoryResponse getAllCategories(Integer pageNumber,Integer pageSize,String sortBy,String sortOrder) {
        Sort sortByAndOrder = sortOrder.equalsIgnoreCase("asc")?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
        Pageable pageable = PageRequest.of(pageNumber,pageSize,sortByAndOrder);
        Page<Category> categoryPage = categoryRepository.findAll(pageable);
        List<Category> categories = categoryPage.getContent();
        if (categories.isEmpty()){
            throw new ApiException("No Category Added");
        }
        //Implementing category to category DTO
        List<CategoryDTO> categoryDTOS = categories.stream().map(category -> modelMapper.map(category,CategoryDTO.class)).toList();
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setContent(categoryDTOS);
        categoryResponse.setPageNumber(categoryPage.getNumber());
        categoryResponse.setPageSize(categoryPage.getSize());
        categoryResponse.setTotalElements(categoryPage.getTotalElements());
        categoryResponse.setTotalpages(categoryPage.getTotalPages());
        categoryResponse.setLastPage(categoryPage.isLast());
        return categoryResponse;
    }

    @Override
    public CategoryDTO createCatgeory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO,Category.class);
        Category categoryFromDb = categoryRepository.findByCategoryName(category.getCategoryName());
        if (categoryFromDb!=null){
            throw new ApiException("Category Name with: "+category.getCategoryName()+" already exists");
        }
        Category savedCategory = categoryRepository.save(category);
        return modelMapper.map(savedCategory,CategoryDTO.class);
    }

    @Override
    public CategoryDTO deleteCategory(Long categoryDTOId) {
        Category category = categoryRepository.findById(categoryDTOId)
                .orElseThrow(() -> new ResourceNotFoundException("Category","CategoryId",categoryDTOId));
        categoryRepository.delete(category);
        return modelMapper.map(category,CategoryDTO.class);
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Long categoryDTOId) {
        Category existingCategory = categoryRepository.findById(categoryDTOId)
                .orElseThrow(()-> new ResourceNotFoundException("Category","CategoryId",categoryDTOId));
        existingCategory.setCategoryName(categoryDTO.getCategoryName());
        existingCategory.setCategoryId(categoryDTOId);
        Category updatedCategory = categoryRepository.save(existingCategory);
        return modelMapper.map(updatedCategory,CategoryDTO.class);
    }
}