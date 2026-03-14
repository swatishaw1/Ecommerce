package com.ecommerce.ECommerceBackend.Repository;

import com.ecommerce.ECommerceBackend.Model.Category;
import com.ecommerce.ECommerceBackend.Model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findByCategoryOrderByPriceAsc(Category category, Pageable pageable);

    Page<Product> findByProductNameLikeIgnoreCase(String keyword, Pageable pageable);

    boolean existsByProductName(String productName);
}
