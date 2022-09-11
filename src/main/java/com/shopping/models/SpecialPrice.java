package com.shopping.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.money.MonetaryAmount;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class SpecialPrice {
    private final MonetaryAmount price;
    private final Integer quantity;
}
