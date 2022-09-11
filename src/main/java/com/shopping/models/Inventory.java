package com.shopping.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.money.MonetaryAmount;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    private Item item;
    private Integer quantity = 0;
    private MonetaryAmount totalItemPrice;
    private MonetaryAmount discountPrice;

}
