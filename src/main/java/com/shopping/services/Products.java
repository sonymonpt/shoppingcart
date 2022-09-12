package com.shopping.services;

import com.shopping.models.Item;
import com.shopping.models.SpecialPrice;
import org.javamoney.moneta.Money;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Products {
    private final static List<Item> products = new ArrayList<Item>();

    public Products() {
        this.initStoreItems();
    }

    public static List<Item> getProducts() {
        return products;
    }

    public void initStoreItems() {
        String[] productNames = {"A", "B", "C", "D"};
        Double[] productPrice = {.50d, .30d, .20d, .15d};
        Integer[] splPriceCont = {3, 2, 0, 0};
        Double[] splPrice = {1.30d, .40d, 0.0d, 0.0d};

        IntStream.range(0, 4).forEach(
                n -> {

                    SpecialPrice specialPrice = SpecialPrice.builder()
                            .quantity(splPriceCont[n])
                            .price(Money.of(splPrice[n], "GBP"))
                            .build();
                    Item item = Item.builder()
                            .name(productNames[n])
                            .price(Money.of(productPrice[n], "GBP"))
                            .specialPrice(specialPrice)
                            .build();
                    products.add(item);
                }
        );
    }
}
