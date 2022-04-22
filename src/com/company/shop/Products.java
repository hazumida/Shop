package com.company.shop;

import java.util.HashSet;
import java.util.Set;

public class Products {
    private Set<Product> listProducts = new HashSet<>();

    public Products() {

    }

    public void printAll() {
        int i = 0;
        for (Product product : listProducts) {
            i++;
            System.out.println(i + ") " + product.toString());
        }
    }

    public Set<Product> getListProducts() {
        return listProducts;
    }

    public Product getProduct(int number) {
        int i = 0;
        Product prod = null;
        for (Product product : listProducts) {
            i++;
            if (i == number) {
                prod = product;
                break;
            }
        }
        return prod;
    }
}
