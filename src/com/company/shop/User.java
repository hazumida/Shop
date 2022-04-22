package com.company.shop;

import java.util.Objects;

public class User implements MyUser{
    private String name;
    private int money;
    private String email;
    private Basket basket;
    private Rating myRating;

    public User(String name,String email) {
        this.name = name;
        this.email = email;
        this.money = 0;
        this.basket = Basket.getInstance();
        this.myRating = new Rating();
    }

    public User(String name) {
        this.name = name;
        this.email = null;
        this.money = 0;
        this.basket = Basket.getInstance();
        this.myRating = new Rating();
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || !object.getClass().equals(User.class)) return false;
        User user = (User) object;

        return this.name.equals(user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public void addMoney(int money) {
        this.money = this.money + money;
        System.out.println("Счет пополнен, сумма сейчас состовляет " + this.money +" руб.");
    }

    @Override
    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public int getMoney() {
        return money;
    }

    public String getString() {
        return name;
    }

    public Basket getBasket() {
        return basket;
    }

    public Rating getMyRating() {
        return myRating;
    }

}
