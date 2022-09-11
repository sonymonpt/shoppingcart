package com.shopping.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


class ProductsTest {

    Products products;

    @BeforeEach
    void setUp() {
        products = new Products();
    }

    @Test
    void getProducts() {
        products.initStoreItems();
        assertFalse(Products.getProducts().isEmpty());
    }

}