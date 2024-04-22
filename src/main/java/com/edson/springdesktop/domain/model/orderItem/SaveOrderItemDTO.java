package com.edson.springdesktop.domain.model.orderItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;

 
public record SaveOrderItemDTO(
        @NotNull(message = "O ID do produto não pode ser nulo") Long productId,
        @NotBlank(message = "O CFOP não pode estar em branco") String CFOP,
         @PositiveOrZero(message = "A quantidade deve ser um número positivo ou zero")
        @NotNull(message = "A quantidade não pode ser nula") BigDecimal quantity
)  {}
