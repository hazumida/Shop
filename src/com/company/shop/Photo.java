package com.company.shop;

public class Photo implements GameZoneStatus, GameZoneMail {

    @Override
    public void status() {
        System.out.println("Вы хорошо провели время делая фотографии на память");
    }

    @Override
    public void mail() {
        System.out.println("Вы зашли в кабинку для фотографий");
    }
}
