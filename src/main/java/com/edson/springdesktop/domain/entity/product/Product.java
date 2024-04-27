package com.edson.springdesktop.domain.entity.product;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal; 

@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O codigo do produto não pode estar em branco")
    @Size(min = 1, max = 255, message = "O codigo do produto deve ter entre 1 e 255 caracteres")
    private String productCode;

    @NotBlank(message = "A descrição não pode estar em branco")
    @Size(min = 1, max = 255, message = "A descrição deve ter entre 1 e 255 caracteres")
    private String description;

    @NotBlank(message = "O ncm não pode estar em branco")
    @Size(min = 8, max = 8, message = "O ncm deve ter 8 caracteres")
    private String NCM;


    @NotBlank(message = "A unidade não pode estar em branco")
    @Size(min = 1, max = 50, message = "A unidade deve ter entre 1 e 50 caracteres")
    private String unit;


    @NotNull(message = "O preço não pode ser nulo")
    private BigDecimal unitPrice;


    public Product() {
    }
 
 

    public String getProductCode() {
        return productCode;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNCM() {
        return NCM;
    }

    public void setNCM(String NCM) {
        this.NCM = NCM;
    }


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }



    public Long getId() {
        return id;
    }



    public void setId(Long id) {
        this.id = id;
    }
}
