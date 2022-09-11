package com.shopping;

import com.shopping.services.Products;
import com.shopping.services.ShoppingCart;
import com.shopping.services.ShoppingCartImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Shop {
    public static void main(String args[])
            throws IOException {
        Products products = new Products();
        ShoppingCart shoppingCart = new ShoppingCartImpl();
        BufferedReader obj = new BufferedReader(new InputStreamReader(System.in));
        String str;
        System.out.println("Enter valid product with name A or B or C or D.");
        System.out.println("Enter 'stop' to quit.");
        System.out.println("Enter Item :");
        do {

            str = obj.readLine();
            try {
                shoppingCart.addToCart(str, 1);
                System.out.println("Total Cost :: " + shoppingCart.displayTotal().get());
                System.out.println("Enter 'stop' to quit.");

            } catch (Exception e) {
                System.out.println("Enter valid product with name A or B or C or D.");
                System.out.println("Enter 'stop' to quit.");
            }
        } while (!str.equals("stop"));
    }
}
