package com.shopping.services;

import com.shopping.models.Inventory;
import com.shopping.models.Item;

import java.util.Objects;

public class AddItemAction implements PerformAction {
    @Override
    public Inventory perform(Inventory inventory) {
        Objects.requireNonNull(inventory, "");
        Objects.requireNonNull(inventory.getItem(), "");

        Item item = inventory.getItem();
        inventory.setQuantity(inventory.getQuantity() + 1);
        inventory.setTotalItemPrice(item.getPrice().multiply(inventory.getQuantity()));
        return inventory;
    }
}
