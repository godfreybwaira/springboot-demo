package com.demo.web.controllers;

import com.demo.data.dto.ProductDto;
import com.demo.data.entities.Product;
import com.demo.services.ProductService;
import com.demo.web.interfaces.ProductInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

public class ProductController implements ProductInterface {

    @Autowired
    private ProductService productService;

    @Override
    public ResponseEntity<List<ProductDto>> getAll() {
        List<Product> products = productService.getAll();
        List<ProductDto> dtoList = new ArrayList<>();
        for (Product product : products) {
            ProductDto dto = new ProductDto().getDto(product);
            dtoList.add(dto);
        }
        return ResponseEntity.ok(dtoList);
    }

    @Override
    public ResponseEntity<ProductDto> getById(Long id) {
        var product = productService.getById(id);
        if (product.isEmpty()) {
            return ResponseEntity.ofNullable(null);
        }
        ProductDto dto = new ProductDto().getDto(product.get());
        return ResponseEntity.ok(dto);
    }

    @Override
    public ResponseEntity<ProductDto> create(ProductDto productDto) {
        Product product = productDto.getEntity();
        return ResponseEntity.ok(this.save(product));

    }

    @Override
    public ResponseEntity<ProductDto> update(Long id, ProductDto productDto) {
        Product product = productDto.getEntity();
        product.setId(id);
        return ResponseEntity.ok(this.save(product));
    }

    @Override
    public ResponseEntity<ProductDto> delete(Long id) {
        if (productService.existsById(id)) {
            productService.delete(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.badRequest().build();
    }

    private ProductDto save(Product product) {
        Product savedProduct = productService.save(product);
        return new ProductDto().getDto(savedProduct);
    }
}
