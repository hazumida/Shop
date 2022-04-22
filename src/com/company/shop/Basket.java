package com.company.shop;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    private static Basket instance = null;
    private List<Product> listProducts = new ArrayList();

    private Basket() {}

    public static Basket getInstance() {
        if (instance == null) instance = new Basket();
        return instance;
    }

    public List getListProducts() {
        return listProducts;
    }

    public int buyProducts() {
        int sum = 0;
        for (int i = 0; i < listProducts.size(); i++) {
            sum = sum + listProducts.get(i).getPrice();
        }
        return sum;
    }

    public void addProduct(Product product) {
        listProducts.add(product);
    }
}
