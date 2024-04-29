package com.edson.springdesktop.domain.entity.product;

import java.math.BigDecimal;

public record ProductDTO(
        Long id,
        String productCode,
        String description,
        String ncm,
        String unit,
        BigDecimal unitPrice,
        Boolean active
) {

    // converte para Product
    public Product convertToProduct() {
        Product product = new Product();
        product.setProductCode(productCode);
        product.setDescription(description);
        product.setNcm(ncm);
        product.setUnit(unit);
        product.setUnitPrice(unitPrice);
        return product;
    }

    // converte para dto
    public static ProductDTO fromProduct(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getProductCode(),
                product.getDescription(),
                product.getNcm(),
                product.getUnit(),
                product.getUnitPrice(),
                product.getActive()
        );
    }
}

