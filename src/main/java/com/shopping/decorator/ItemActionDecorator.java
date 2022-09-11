package com.shopping.decorator;

import com.shopping.models.Inventory;
import com.shopping.models.Item;
import com.shopping.models.SpecialPrice;
import com.shopping.services.PerformAction;

import javax.money.MonetaryAmount;

public class ItemActionDecorator implements PerformAction {

    PerformAction performAction;

    public ItemActionDecorator(PerformAction performAction) {
        this.performAction = performAction;
    }


    @Override
    public Inventory perform(Inventory inventory) {

        performAction.perform(inventory);
        return applyDiscount(inventory);
    }

    private Inventory applyDiscount(Inventory inventory) {

        Item item = inventory.getItem();
        if (null == item.getSpecialPrice())
            return inventory;
        SpecialPrice specialPrice = item.getSpecialPrice();
        if (specialPrice.getQuantity() < 1)
            return inventory;

        Integer discountedItemCount = inventory.getQuantity() / specialPrice.getQuantity();
        Integer otherItemCount = inventory.getQuantity() % specialPrice.getQuantity();
        MonetaryAmount monetaryAmount = specialPrice.getPrice().multiply(discountedItemCount);
        MonetaryAmount monetaryAmount1 = item.getPrice().multiply(otherItemCount);
        inventory.setDiscountPrice(monetaryAmount.add(monetaryAmount1));
        return inventory;
    }
}
