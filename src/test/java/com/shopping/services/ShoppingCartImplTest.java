package com.shopping.services;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class ShoppingCartImplTest {

    Products products;

    @Mock
    ShoppingCart shoppingCart;

    @BeforeEach
    void setUp() {
        shoppingCart = new ShoppingCartImpl();
        products = new Products();
    }

    @Test
    void addToCartSucess() {
        assertDoesNotThrow(() -> shoppingCart.addToCart("A", 1));
    }

    @Test
    void addToCartThrowsException() {
        assertThrows(Exception.class, () -> shoppingCart.addToCart("E", 1));
    }

}