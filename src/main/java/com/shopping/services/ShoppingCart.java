package com.shopping.services;

import com.shopping.models.Inventory;

import javax.money.MonetaryAmount;
import java.util.List;
import java.util.Optional;

public interface ShoppingCart {

    void addToCart(String name, Integer quantity) throws Exception;

    Optional<MonetaryAmount> displayTotal();

    List<Inventory> getInventories();

    void removeItem(String name, Integer quantity) throws Exception;

}
