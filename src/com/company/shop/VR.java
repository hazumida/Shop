package com.company.shop;

public class VR implements GameZoneStatus, GameZoneMail{

    @Override
    public void status() {
        System.out.println("Вы хорошо провели время находясь в виртуальной реальности");
    }

    @Override
    public void mail() {
        System.out.println("Вы зашли в VR room");
    }
}
