package dev.ganeshpc.productservice.dtos.product;

import dev.ganeshpc.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {

    private Long id;
        
    private String title;

    private String description;
    
    private String image;

    private Category category;

    private double price;
}
