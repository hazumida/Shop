package com.company.shop;

import java.util.HashSet;
import java.util.Set;

public class Rating {
    private Set<Product> listRating = new HashSet<>();
    private final int min = 1;
    private final int max = 5;

    public Set<Product> getListRating() {
        return listRating;
    }

    public void addRating(int number, int rating) {
        int i = 0;
        if (rating <= max && rating >= min) {
            for (Product product : listRating) {
                i++;
                if (number == i) {
                    product.setRating(rating);
                }
            }
        } else {
            System.out.println("Рейтинг не может быть таким, только от 1 до 5");
        }
    }

    public void add(Product product) {
        listRating.add(product);
    }
}
