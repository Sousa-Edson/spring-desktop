package com.edson.springdesktop.domain.model.orderItem;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import java.math.BigDecimal;
import java.util.UUID;

public record SaveOrderItemDTO(
        @NotNull(message = "O ID do produto não pode ser nulo") UUID productId,
        @NotBlank(message = "O CFOP não pode estar em branco") String CFOP,
        @Positive(message = "A quantidade deve ser um número positivo")
        @PositiveOrZero(message = "A quantidade deve ser um número positivo ou zero")
        @NotNull(message = "A quantidade não pode ser nula") BigDecimal quantity
) {}
