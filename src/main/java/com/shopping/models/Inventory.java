package com.shopping.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.javamoney.moneta.Money;

import javax.money.MonetaryAmount;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Inventory {
    private Item item;
    private Integer quantity = 0;
    private MonetaryAmount totalItemPrice = Money.of(0, "GBP");
    private MonetaryAmount discountPrice = Money.of(0, "GBP");

}
