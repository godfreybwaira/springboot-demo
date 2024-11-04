package com.demo.data.repositories;

import com.demo.data.entities.Product;
import com.demo.data.entities.ProductCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductCategoryRepository extends JpaRepository<ProductCategory,Long> {
}
