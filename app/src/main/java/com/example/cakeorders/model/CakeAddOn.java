package com.example.cakeorders.model;

/**
 * Class used for Batters and Toppings
 */
public class CakeAddOn {
    String id, type;

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
