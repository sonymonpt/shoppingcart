package com.shopping.models;


import lombok.*;

import javax.money.MonetaryAmount;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Item {
    private String name;
    private MonetaryAmount price;
    private SpecialPrice specialPrice;

}
