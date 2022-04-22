package com.company.shop;

public interface Transaction {
    public boolean pay(int money, int service, MyUser myUser);
}
