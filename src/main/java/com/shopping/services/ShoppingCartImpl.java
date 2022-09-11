package com.shopping.services;

import com.shopping.decorator.ItemActionDecorator;
import com.shopping.factory.ItemFactory;
import com.shopping.factory.ItemFactoryImpl;
import com.shopping.models.Inventory;

import javax.money.MonetaryAmount;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class ShoppingCartImpl implements ShoppingCart {
    private Map<String, Inventory> cart;
    private ItemFactory itemFactory;
    private PerformAction itemActionDecorator;

    public ShoppingCartImpl() {
        this.cart = new HashMap<>();
        this.itemFactory = new ItemFactoryImpl();
    }

    @Override
    public void addToCart(String name, Integer quantity) throws Exception {
        Inventory inventory;
        if (cart.containsKey(name)) {
            inventory = cart.get(name);
        } else {
            inventory = new Inventory();
            inventory.setItem(itemFactory.getItem(name));
        }
        PerformAction addItemAction = new AddItemAction();
        itemActionDecorator = new ItemActionDecorator(addItemAction);
        cart.putIfAbsent(name, itemActionDecorator.perform(inventory));
    }

    @Override
    public Optional<MonetaryAmount> displayTotal() {
        return cart.values().stream().map(Inventory::getDiscountPrice)
                .reduce(MonetaryAmount::add);
    }

    @Override
    public List<Inventory> getInventories() {
        return (List<Inventory>) cart.values();
    }

    @Override
    public void removeItem(String name, Integer quantity) throws Exception {
        {
            Inventory inventory;
            if (cart.containsKey(name)) {
                inventory = cart.get(name);
            } else {
                inventory = new Inventory();
                inventory.setItem(itemFactory.getItem(name));
            }
            PerformAction removeItemAction = new RemoveItemAction();
            itemActionDecorator = new ItemActionDecorator(removeItemAction);
            itemActionDecorator.perform(inventory);
        }
    }
}
