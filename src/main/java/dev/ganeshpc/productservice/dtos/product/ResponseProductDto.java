package dev.ganeshpc.productservice.dtos.product;

import dev.ganeshpc.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ResponseProductDto {

    private Long id;

    private String title;

    private String description;

    private String image;

    private String category;

    private Double price;

    public static ResponseProductDto fromGenericProductDto(GenericProductDto product) {
        ResponseProductDto responseProductDto = new ResponseProductDto();
        
        responseProductDto.setId(product.getId());
        responseProductDto.setTitle(product.getTitle());
        responseProductDto.setDescription(product.getDescription());
        responseProductDto.setImage(product.getImage());
        responseProductDto.setCategory(product.getCategory().getName());
        responseProductDto.setPrice(product.getPrice());

        return responseProductDto;
    }
}
