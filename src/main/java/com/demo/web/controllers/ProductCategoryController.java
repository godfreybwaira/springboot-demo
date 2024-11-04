package com.demo.web.controllers;

import com.demo.data.dto.ProductCategoryDto;
import com.demo.data.entities.ProductCategory;
import com.demo.services.ProductCategoryService;
import com.demo.web.interfaces.ProductCategoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductCategoryController implements ProductCategoryInterface {

    @Autowired
    private ProductCategoryService categoryService;

    @Override
    public ResponseEntity<List<ProductCategoryDto>> getAll() {
        List<ProductCategory> categories = categoryService.getAll();
        List<ProductCategoryDto> dtoList = new ArrayList<>();
        for (ProductCategory category : categories) {
            ProductCategoryDto dto = new ProductCategoryDto().getDto(category);
            dtoList.add(dto);
        }
        return ResponseEntity.ok(dtoList);
    }

    @Override
    public ResponseEntity<ProductCategoryDto> getById(Long id) {
        var category = categoryService.getById(id);
        if (category.isEmpty()) {
            return ResponseEntity.ofNullable(null);
        }
        ProductCategoryDto dto = new ProductCategoryDto().getDto(category.get());
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<ProductCategoryDto> create(ProductCategoryDto categoryDto) {
        ProductCategory category = categoryDto.getEntity();
        return ResponseEntity.status(200).body(this.save(category));
    }

    @Override
    public ResponseEntity<ProductCategoryDto> update(Long id, ProductCategoryDto categoryDto) {
        ProductCategory category = categoryDto.getEntity();
        category.setId(id);
        return ResponseEntity.ok(this.save(category));
    }

    @Override
    public ResponseEntity<ProductCategoryDto> delete(Long id) {
        if (categoryService.existsById(id)) {
            categoryService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

    private ProductCategoryDto save(ProductCategory category) {
        ProductCategory savedProduct = categoryService.save(category);
        return new ProductCategoryDto().getDto(savedProduct);
    }
}
