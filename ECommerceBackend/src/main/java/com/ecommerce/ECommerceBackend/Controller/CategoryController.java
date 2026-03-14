package com.ecommerce.ECommerceBackend.Controller;

import com.ecommerce.ECommerceBackend.Config.AppConstants;
import com.ecommerce.ECommerceBackend.Payload.Catgeory.CategoryDTO;
import com.ecommerce.ECommerceBackend.Payload.Catgeory.CategoryResponse;
import com.ecommerce.ECommerceBackend.Service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /*@GetMapping("/public/categories")*/
    @RequestMapping(value = "/public/categories",method = RequestMethod.GET)
    public ResponseEntity<CategoryResponse> getCategories(
            @RequestParam(name = "pageNumber", defaultValue = AppConstants.PAGE_NUMBER, required = false) Integer pageNumber,
            @RequestParam(name = "pageSize", defaultValue = AppConstants.PAGE_SIZE, required = false) Integer pageSize,
            @RequestParam(name = "sortBy", defaultValue = AppConstants.SORT_CATEGORIES_BY, required = false) String sortBy,
            @RequestParam(name = "sortOrder", defaultValue = AppConstants.SORT_DIR, required = false) String sortOrder){
        return new ResponseEntity<>(categoryService.getAllCategories(pageNumber,pageSize,sortBy,sortOrder), HttpStatus.OK);
    }

    @PostMapping("/public/categories")
    public ResponseEntity<CategoryDTO> addCategory(@Valid @RequestBody CategoryDTO categoryDTO){
        return new ResponseEntity<>(categoryService.createCategory(categoryDTO),HttpStatus.CREATED);
    }

    @DeleteMapping("/admin/categories/{categoryDTOId}")
    public  ResponseEntity<CategoryDTO> deleteCategory(@PathVariable("categoryDTOId") Long categoryDTOId){
        return new ResponseEntity<>(categoryService.deleteCategory(categoryDTOId), HttpStatus.OK);
    }

    @PutMapping("/public/categories/{categoryDTOId}")
    public ResponseEntity<CategoryDTO> updateCategory(@Valid @RequestBody CategoryDTO categoryDTO,@PathVariable Long categoryDTOId) {
        CategoryDTO savedCategoryDTO = categoryService.updateCategory(categoryDTO, categoryDTOId);
        return new ResponseEntity<>(savedCategoryDTO,HttpStatus.OK);
    }
}
