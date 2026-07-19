package com.ecommerce.ECommerceBackend.Service;

import com.ecommerce.ECommerceBackend.Payload.Product.ProductDTO;
import com.ecommerce.ECommerceBackend.Payload.Product.ProductResponse;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ProductService {
    ProductDTO addProduct(ProductDTO productDTO, Long categoryId);

    ProductResponse getAllProducts(Integer pageNumber, Integer pageSize, String sortBy, String sortByOrder);

    ProductResponse searchProductsBycategory(Long categoryId, Integer pageSize, Integer pageNumber, String sortByOrder, String sortBy);

    ProductResponse searchProductsByKeyWord(String keyword, Integer pageSize, Integer pageNumber, String sortByOrder, String sortBy);

    ProductDTO updateProduct(ProductDTO product, Long productId);

    ProductDTO deleteProduct(Long productId);

    ProductDTO updateProductImage(Long productId, MultipartFile image) throws IOException;
}
