package com.company;

import com.company.shop.*;

import java.util.List;
import java.util.Scanner;

public class Messages {
    public static Scanner scanner = new Scanner(System.in);

    public static void mainMenu(Shop shop, MyUser myUser) {
        while (true) {
            System.out.println("\nВыберите что хотите сделать:");
            System.out.println("1. Посмотреть товары");
            System.out.println("2. Зайти в игровую зону");
            System.out.println("3. Узнать балланс");
            System.out.println("4. Посмотреть корзину");
            System.out.println("5. Поставить оценку");
            System.out.println("6. Выход");

            String choiceType = scanner.nextLine();
            String line;

            switch (choiceType) {
                case "1":
                    menuProduct(shop, myUser);
                    break;
                case  "2":
                    menuGameZone(shop, myUser);
                    break;
                case  "3":
                    System.out.println("На Вашем счету = " + myUser.getMoney() + " руб.");
                    System.out.println("Если хотите пополнить баланс введите число, если нет, то нажмите символ");
                    line = scanner.nextLine();
                    try {
                        int money = Integer.parseInt(line);
                        if (money < 0) {
                            System.out.println("Извините, но снять со счета не имеется возможным, попробуйте позднее");
                        } else {
                            myUser.addMoney(money);
                        }
                    } catch (NumberFormatException err) {
                        //System.err.println("Неправильный формат строки!");
                    }
                    break;
                case  "4":
                    menuBasket(shop, myUser);
                    break;
                case  "5":
                    User user = (User) myUser;
                    int i = 0;
                    for (Product product : user.getMyRating().getListRating()) {
                        i++;
                        System.out.println(i + ") " + product.toString());
                    }
                    if (user.getMyRating().getListRating().size() != 0) {
                        System.out.println("Выберите, какому товару будете ставить рейтинг");
                        System.out.println("Если ввести 0 то выйдите");

                        line = scanner.nextLine();
                        try {
                            int choose = Integer.parseInt(line);
                            if (choose == 0) {
                                break;
                            }

                            System.out.println("Поставьте оценку");
                            line = scanner.nextLine();
                            int rating = Integer.parseInt(line);

                            if (choose > 0 && choose <= user.getMyRating().getListRating().size()) {
                                user.getMyRating().addRating(choose, rating);
                            }
                        } catch (NumberFormatException err) {
                            System.err.println("Неправильный ввод!");
                        }
                    } else {
                        System.out.println("Ничего не было куплено");
                    }
                    break;
                case  "6":
                    User user1 = (User) myUser;
                    user1.getBasket().getListProducts().clear();
                    return;
                default:
                    System.out.println("\nНе корректный ввод, повторите снова");
            }
        }
    }

    public static void menuProduct(Shop shop, MyUser myUser) {
        String line;
        System.out.println("Выберите какой товар хотите приобрести:");
        shop.getProducts().printAll();
        System.out.println("Нажмите 0, чтобы выйти");
        while (true) {
            line = scanner.nextLine();
            try {
                int choose = Integer.parseInt(line);
                if (choose == 0) {
                    break;
                }
                if (choose > 0 && choose <= shop.getProducts().getListProducts().size()) {
                    User user = (User) myUser;
                    user.getBasket().addProduct(shop.getProducts().getProduct(choose));
                }
            } catch (NumberFormatException err) {
                System.err.println("Неправильный ввод!");
            }
        }
    }

    public static void menuGameZone(Shop shop, MyUser myUser) {
        while (true) {
            System.out.println("Выберите что хотите сделать:");
            System.out.println("1. Смотреть vr фильмы");
            System.out.println("2. Сделать фото");
            System.out.println("3. Сыграть в игровой автомат");
            System.out.println("Нажмите на любой символ, чтобы вернуться");
            Transaction transaction = new TransactionImpl();
            String choiceType = scanner.nextLine();

            switch (choiceType) {
                case "1":
                    GameZoneMail gameZoneMail1 = new VR();
                    gameZoneMail1.mail();
                    if (transaction.pay(myUser.getMoney(), 950, myUser)) {
                        shop.getGameZoneVR().status();
                    }
                    break;
                case "2":
                    GameZoneMail gameZoneMail2 = new Photo();
                    gameZoneMail2.mail();
                    if (transaction.pay(myUser.getMoney(), 500, myUser)) {
                        shop.getGameZonePhoto().status();
                    }
                    break;
                case "3":
                    GameZoneMail gameZoneMail3 = new PC_Gaming();
                    gameZoneMail3.mail();
                    if (transaction.pay(myUser.getMoney(), 370, myUser)) {
                        shop.getGameZonePCGaming().status();
                    }
                    break;
                default:
                    return;
            }
        }
    }

    public static void menuBasket(Shop shop, MyUser myUser) {
        User user = (User) myUser;
        Transaction transaction = new TransactionImpl();
        String line;
        List<Product> list = user.getBasket().getListProducts();
        if (list.size() == 0) {
            System.out.println("Корзина пуста");
        } else {

            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).toString());
            }

            System.out.println("Нажмите 0, чтобы оплатить товар");
            System.out.println("Нажмите на любой символ, чтобы вернуться");

            line = scanner.nextLine();
            try {
                int choose = Integer.parseInt(line);
                if (transaction.pay(myUser.getMoney(),user.getBasket().buyProducts(), myUser)) {
                    for (int i = 0; i < list.size(); i++) {
                        user.getMyRating().add(list.get(i));
                    }
                    user.getBasket().getListProducts().clear();
                }
            } catch (NumberFormatException err) {
                //System.err.println("Неправильный формат строки!");
            }
        }
    }
}
