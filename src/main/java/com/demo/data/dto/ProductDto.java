package com.demo.data.dto;

import com.demo.data.entities.Product;
import lombok.Data;

@Data
public class ProductDto {

    private Long id;
    private String productCode;
    private String productName;
    private String description;
    private ProductCategoryDto category;

    public Product getEntity(){
        var product = new Product();
        product.setProductName(this.getProductName());
        product.setProductCode(this.getProductCode());
        product.setDescription(this.getDescription());
        return product;
    }

    public ProductDto getDto(Product product){
        this.setProductCode(product.getProductCode());
        this.setProductName(product.getProductName());
        this.setDescription(product.getDescription());
        this.setCategory(new ProductCategoryDto().getDto(product.getProductCategory()));
        this.setId(product.getId());
        return this;
    }
}
