package com.shopping.decorator;

import com.shopping.models.Inventory;
import com.shopping.models.Item;
import com.shopping.models.SpecialPrice;
import com.shopping.services.PerformAction;

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
        Integer discountedItemCount = inventory.getQuantity() / specialPrice.getQuantity();
        Integer otherItemCount = inventory.getQuantity() % specialPrice.getQuantity();
        inventory.setDiscountPrice(specialPrice.getPrice().multiply(discountedItemCount)
                .add(item.getPrice().multiply(otherItemCount)));

        return inventory;
    }
}
