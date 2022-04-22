package com.company.shop;

public class PC_Gaming implements GameZoneStatus, GameZoneMail {

    @Override
    public void status() {
        System.out.println("Вы хорошо провели время играя в видеоигры");
    }

    @Override
    public void mail() {
        System.out.println("Вы зашли в gaming room");
    }
}
