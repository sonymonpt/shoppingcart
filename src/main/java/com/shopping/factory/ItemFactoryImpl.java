package com.shopping.factory;

import com.shopping.models.Item;
import com.shopping.services.Products;

public class ItemFactoryImpl implements ItemFactory {
    @Override
    public Item getItem(String name) throws Exception {
        return Products.getProducts().stream()
                .filter(n -> n.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(Exception::new);

    }
}
