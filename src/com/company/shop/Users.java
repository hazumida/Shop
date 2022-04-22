package com.company.shop;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Users {
    private Set<User> listUsers = new HashSet<>();

    public Users() {

    }

    public User myUser(String name) {
        User user = null;
        User deff;
        Iterator<User> iter = listUsers.iterator();
        while (iter.hasNext()) {
            deff = iter.next();
            if (deff.getString().equals(name)) {
                user = deff;
            }
        }
        return user;
    }

    public Set<User> getListUsers() {
        return listUsers;
    }
}
