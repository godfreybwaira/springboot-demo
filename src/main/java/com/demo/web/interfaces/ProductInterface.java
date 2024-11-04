package com.demo.web.interfaces;

import com.demo.data.dto.ProductDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public interface ProductInterface {

    @GetMapping
    ResponseEntity<List<ProductDto>> getAll();

    @GetMapping("/{id}")
    ResponseEntity<ProductDto> getById(@PathVariable Long id);

    @PostMapping
    ResponseEntity<ProductDto> create(@RequestBody ProductDto productDto);

    @PutMapping("/{id}")
    ResponseEntity<ProductDto> update(@PathVariable Long id, @RequestBody ProductDto productDto);

    @DeleteMapping("/{id}")
    ResponseEntity<ProductDto> delete(@PathVariable Long id);
}
