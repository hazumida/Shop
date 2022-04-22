package com.company.shop;

public class Shop {

    private Products products;
    private Users bookUsers;
    private GameZoneStatus photo;
    private GameZoneStatus vr;
    private GameZoneStatus pcGaming;

    public Shop() {
        this.products = new Products();
        this.bookUsers = new Users();
        this.photo = new Photo();
        this.vr = new VR();
        this.pcGaming = new PC_Gaming();
    }

    public Products getProducts() {
        return products;
    }

    public Users getBookUsers() {
        return bookUsers;
    }

    public GameZoneStatus getGameZonePhoto() {
        return this.photo;
    }

    public GameZoneStatus getGameZoneVR() {
        return this.vr;
    }

    public GameZoneStatus getGameZonePCGaming() {
        return this.pcGaming;
    }
}
