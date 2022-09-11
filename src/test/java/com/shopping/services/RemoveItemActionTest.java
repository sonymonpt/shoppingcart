package com.shopping.services;

import com.shopping.models.Inventory;
import com.shopping.models.Item;
import com.shopping.models.SpecialPrice;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RemoveItemActionTest {
    PerformAction removeItemAction;

    Inventory inventory;
    @BeforeEach
    void setUp() {
        removeItemAction = new RemoveItemAction();
        setupInventory();
    }
    @Test
    void verifyNoDiscountperformWhenAddItemAction() {
        inventory.setQuantity(3);
        inventory = removeItemAction.perform(inventory);
        assertTrue(inventory.getTotalItemPrice().getNumber().doubleValue() == 60.0);
    }

    private void setupInventory() {
        inventory = new Inventory();
        SpecialPrice specialPrice = SpecialPrice.builder()
                .quantity(3)
                .price(Money.of(40, "GBP"))
                .build();
        Item item = Item.builder()
                .name("A")
                .price(Money.of(30, "GBP"))
                .specialPrice(specialPrice)
                .build();
        inventory.setItem(item);
    }
}