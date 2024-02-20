package dev.ganeshpc.productservice.dtos.product;

import dev.ganeshpc.productservice.models.Category;
import dev.ganeshpc.productservice.models.Product;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {

    private Long id;

    private String title;

    private String description;

    private String image;

    private String category;

    private Double price;

    public GenericProductDto toProduct() {
        GenericProductDto product = new GenericProductDto();

        product.setId(id);
        product.setTitle(title);
        product.setDescription(description);
        product.setImage(image);
        product.setCategory(new Category(category));
        product.setPrice(price);

        return product;
    }

    public static FakeStoreProductDto fromProduct(GenericProductDto product) {
        FakeStoreProductDto fakeStoreProductDto = new FakeStoreProductDto();

        fakeStoreProductDto.setId(product.getId());
        fakeStoreProductDto.setTitle(product.getTitle());
        fakeStoreProductDto.setDescription(product.getDescription());
        fakeStoreProductDto.setImage(product.getImage());
        fakeStoreProductDto.setCategory(product.getCategory().getName());
        fakeStoreProductDto.setPrice(product.getPrice());

        return fakeStoreProductDto;

    }
}
