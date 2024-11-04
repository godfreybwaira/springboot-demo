package com.demo.web.interfaces;

import com.demo.data.dto.ProductCategoryDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product-categories")
public interface ProductCategoryInterface {

    @GetMapping
    ResponseEntity<List<ProductCategoryDto>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<ProductCategoryDto> getById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<ProductCategoryDto> create(@RequestBody ProductCategoryDto categoryDto);

    @PutMapping("/{id}")
    ResponseEntity<ProductCategoryDto> update(@PathVariable Long id, @RequestBody ProductCategoryDto categoryDto);

    @DeleteMapping("/{id}")
    ResponseEntity<ProductCategoryDto> delete(@PathVariable Long id);
}
