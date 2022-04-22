package com.company.shop;

import java.util.Objects;

public class Product {
    private String name;
    private int year;
    private int price;
    private int rating;

    public Product(String name,int year, int price) {
        this.name = name;
        this.year = year;
        this.price = price;
        rating = 0;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !object.getClass().equals(Product.class)) return false;
        Product product = (Product) object;

        return (this.name.equals(product.name) && (this.year == product.year));
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, year);
    }

    @Override
    public String toString() {
        return "Имя = " + name + ", год выпуска = " + year + ", цена = " + price + ", рейтинг = " + rating;
    }

    public int getPrice() {
        return price;
    }

    public boolean setRating(int rating) {
        this.rating = rating;
        return true;
    }
}
