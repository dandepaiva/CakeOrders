package com.example.cakeorders.model;

/**
 * Class of Cake Add Ons
 * can be used for batters and toppings
 */
public class CakeAddOn {
    String id;
    String type;

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public CakeAddOn(String id, String type) {
        this.id = id;
        this.type = type;
    }
}
