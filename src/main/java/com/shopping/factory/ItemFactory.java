package com.shopping.factory;

import com.shopping.models.Item;

public interface ItemFactory {
    Item getItem(String name) throws Exception;
}
