package com.demo.services;

import com.demo.data.entities.ProductCategory;
import com.demo.data.repositories.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductCategoryService {

    @Autowired
    private ProductCategoryRepository repository;

    public ProductCategory save(ProductCategory category) {
        return repository.save(category);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<ProductCategory> getById(Long id) {
        return repository.findById(id);
    }

    public List<ProductCategory> getAll() {
        return repository.findAll();
    }
}
