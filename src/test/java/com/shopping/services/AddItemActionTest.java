package com.shopping.services;

import com.shopping.models.Inventory;
import com.shopping.models.Item;
import com.shopping.models.SpecialPrice;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class AddItemActionTest {

    PerformAction addItemAction;

    Inventory inventory;

    @BeforeEach
    void setUp() {
        addItemAction = new AddItemAction();
        setupInventory();
    }

    @Test
    void verifyDiscountperformWhenAddItemAction() {
        inventory.setQuantity(3);
        inventory = addItemAction.perform(inventory);
        assertTrue(inventory.getTotalItemPrice().getNumber().doubleValue() == 120.0);
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