package com.ecommerce.ECommerceBackend.Repository;

import com.ecommerce.ECommerceBackend.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Long> {
}
