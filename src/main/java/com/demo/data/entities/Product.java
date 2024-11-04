package com.demo.data.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "products", indexes = {
        @Index(columnList = "category_id,product_code", unique = true)
})
public class Product {

    @Id
    @GeneratedValue
    @Column(name = "product_id", nullable = false, unique = true, updatable = false)
    private Long id;

    @Column(name = "product_name", nullable = false, unique = true, length = 100)
    private String productName;

    @Column(name = "product_code", nullable = false, unique = true, updatable = false, length = 30)
    private String productCode;

    @Column
    private String description;

    @Column(updatable = false, nullable = false)
    private final LocalDateTime createdAt = LocalDateTime.now();

    @JsonBackReference
    @JoinColumn(name = "category_id", nullable = false)
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private ProductCategory productCategory;
}
