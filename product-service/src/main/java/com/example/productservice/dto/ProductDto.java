package com.example.productservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductDto {

    private String title;
    private String ebayUrl;
    private String category;
    private Integer quantity;
    private Double ebayPrice;
    private Double shippingCharge;
    private String description;
    private List<ProductImageDto> productImageList;
    private String amazonUrl;
    private Double amazonPrice;
    private Double shippingCost;
}
