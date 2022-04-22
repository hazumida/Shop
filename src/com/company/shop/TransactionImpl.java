package com.company.shop;

public class TransactionImpl implements Transaction{

    @Override
    public boolean pay(int money, int service, MyUser myUser) {
       if (money - service > 0) {
           myUser.setMoney(money - service);
           System.out.println("Оплата прошла успешно");
           return true;
       } else {
           System.out.println("Не хватает денег");
           return false;
       }
    }
}
