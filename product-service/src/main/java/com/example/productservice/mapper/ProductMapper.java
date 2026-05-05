package com.example.productservice.mapper;

import com.example.productservice.dto.ProductDto;
import com.example.productservice.dto.ProductImageDto;
import com.example.productservice.model.Product;
import com.example.productservice.model.ProductImage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "productImageList", ignore = true)
    Product toEntity(ProductDto productDto);

    ProductDto toDto(Product product);

    @Mapping(target = "product", ignore = true)
    ProductImage toImageEntity(ProductImageDto productImageDto);

    ProductImageDto toImageDto(ProductImage productImage);
}
