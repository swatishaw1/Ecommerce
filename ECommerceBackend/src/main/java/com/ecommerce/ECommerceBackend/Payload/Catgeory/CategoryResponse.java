package com.ecommerce.ECommerceBackend.Payload.Catgeory;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CategoryResponse {
    private List<CategoryDTO> content;
    private Integer pageNumber;
    private Integer pageSize;
    private Long totalElements;
    private Integer totalPages;
    private boolean lastPage;
    private String sortBy;
    private String sortOrder;
}
/*This is the Model Structure Where we get All the Categories*/