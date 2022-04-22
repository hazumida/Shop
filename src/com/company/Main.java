package com.company;

import com.company.shop.MyUser;
import com.company.shop.Product;
import com.company.shop.Shop;
import com.company.shop.User;

import static com.company.Messages.*;

public class Main {

    public static void main(String[] args) {

        Shop shop = new Shop();
        String name = "Алексей";

        System.out.println("Добро пожаловать в магазин компьютерных игр");
        System.out.println("Вы зашли в учетную запись, как " + name);

        shop.getProducts().getListProducts().add(new Product("Tomb Raider", 2009, 1648));
        shop.getProducts().getListProducts().add(new Product("Tomb Raider", 2009, 2080));
        shop.getProducts().getListProducts().add(new Product("Tomb Raider", 2018, 3088));
        shop.getProducts().getListProducts().add(new Product("Tomb Raider", 2018, 1000));
        shop.getProducts().getListProducts().add(new Product("Worms", 1998, 850));

        shop.getBookUsers().getListUsers().add(new User("Сергей"));
        shop.getBookUsers().getListUsers().add(new User("Алексей"));
        shop.getBookUsers().getListUsers().add(new User("Николай", "nick@mail.ru"));
        shop.getBookUsers().getListUsers().add(new User("Ирина"));
        shop.getBookUsers().getListUsers().add(new User("Екатерина"));

        MyUser myUser = shop.getBookUsers().myUser(name);
        myUser.addMoney(500);

        mainMenu(shop, myUser);

        System.out.println("Спасибо, что Вы выбрали наш магазин");
        System.out.println("Все некупленные товары были успешно возвращены на место");
    }
}
