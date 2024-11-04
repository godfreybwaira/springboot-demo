package com.demo.services;

import com.demo.data.entities.Product;
import com.demo.data.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public Product save(Product product) {
        return repository.save(product);
    }

    public boolean existsById(Long id) {
        return repository.existsById(id);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public Optional<Product> getById(Long id) {
        return repository.findById(id);
    }

    public List<Product> getAll() {
        return repository.findAll();
    }
}
