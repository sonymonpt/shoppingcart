package com.shopping.decorator;

import com.shopping.models.Inventory;
import com.shopping.models.Item;
import com.shopping.models.SpecialPrice;
import com.shopping.services.AddItemAction;
import com.shopping.services.PerformAction;
import com.shopping.services.RemoveItemAction;
import org.javamoney.moneta.Money;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemActionDecoratorTest {

    ItemActionDecorator itemActionDecorator;
    PerformAction addItemAction;
    PerformAction removeItemAction;
    Inventory inventory;

    @BeforeEach
    void setUp() {
        addItemAction = new AddItemAction();
        removeItemAction = new RemoveItemAction();
        setupInventory();
    }

    @Test
    void verifyDiscountperformWhenAddItemAction() {
        itemActionDecorator = new ItemActionDecorator(addItemAction);
        inventory.setQuantity(3);
        inventory = itemActionDecorator.perform(inventory);
        assertTrue(inventory.getDiscountPrice().getNumber().doubleValue() == 70.0);
        assertTrue(inventory.getTotalItemPrice().getNumber().doubleValue() == 120.0);
    }

    @Test
    void verifyNoDiscountperformWhenAddItemAction() {
        itemActionDecorator = new ItemActionDecorator(addItemAction);
        inventory.setQuantity(1);
        inventory = itemActionDecorator.perform(inventory);
        assertTrue(inventory.getDiscountPrice().getNumber().doubleValue() == 60.0);
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