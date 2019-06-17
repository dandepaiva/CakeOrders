package com.example.cakeorders.model;

/**
 * Class of Cake Ingredients
 * can be used for batters and toppings
 */
public class CakeIngredients {
    String id;      // id of this addOn (50## if topping; 10## if batter)
    String type;    // type of this addOn

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public CakeIngredients(String id, String type) {
        this.id = id;
        this.type = type;
    }
}
