package dev.ganeshpc.productservice.dtos.product;

import dev.ganeshpc.productservice.models.Product;
import dev.ganeshpc.productservice.models.Category;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestProductDto {
    private String title;

    private String description;

    private String image;

    private String category;

    private Double price;

    public GenericProductDto toGenericProductDto() {
        GenericProductDto product = new GenericProductDto(); 

        product.setTitle(title);
        product.setDescription(description);
        product.setImage(image);
        product.setCategory(new Category(category));
        product.setPrice(price);

        return product;
    }
}
