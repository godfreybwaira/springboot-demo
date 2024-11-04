package com.demo.data.dto;

import com.demo.data.entities.Product;
import com.demo.data.entities.ProductCategory;
import lombok.Data;

@Data
public class ProductCategoryDto {

    private Long id;
    private String name;
    private String description;

    public ProductCategory getEntity(){
        var category = new ProductCategory();
        category.setName(this.getName());
        category.setDescription(this.getDescription());
        return category;
    }

    public ProductCategoryDto getDto(ProductCategory category){
        this.setName(category.getName());
        this.setDescription(category.getDescription());
        this.setId(category.getId());
        return this;
    }
}
