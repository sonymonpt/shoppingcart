package com.shopping.factory;

import com.shopping.services.Products;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ItemFactoryImplTest {

    Products products;
    ItemFactory itemFactory;

    @BeforeEach
    void setUp() {
        products = new Products();
        itemFactory = new ItemFactoryImpl();
    }

    @Test
    void getItem() throws Exception {
        assertTrue(itemFactory.getItem("D").getName().equalsIgnoreCase("D"));
    }

    @Test
    void getItemWhenException() throws Exception {
        assertThrows(Exception.class, () -> itemFactory.getItem("E"));
    }
}