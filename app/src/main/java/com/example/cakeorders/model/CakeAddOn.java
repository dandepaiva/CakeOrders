package com.example.cakeorders.model;

/**
 * Class of Cake Add Ons
 * can be used for batters and toppings
 */
public class CakeAddOn {
    String id;      // id of this addOn (50## if topping; 10## if batter)
    String type;    // type of this addOn

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
