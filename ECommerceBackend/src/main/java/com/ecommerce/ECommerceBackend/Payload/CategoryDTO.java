package com.ecommerce.ECommerceBackend.Payload;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
/*Client to Server data transfer*/
public class CategoryDTO {
    private Long categoryId;
    private String categoryName;
}
