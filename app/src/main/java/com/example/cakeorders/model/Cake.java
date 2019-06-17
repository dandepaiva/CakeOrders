package com.example.cakeorders.model;

import java.util.ArrayList;

/**
 * Class of a cake to be made
 *
 */
public class Cake {
    private String id;          // id of this cake
    private String type;        // type of cake
    private String name;        // name of cake
    private float ppu;          // price per unit
    private Batters batters;    // possible batters
    private ArrayList<CakeIngredients> topping;   // possible toppings

    public Cake(String id, String type, String name, float ppu, Batters batters, ArrayList<CakeIngredients> topping) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.ppu = ppu;
        this.batters = batters;
        this.topping = topping;
    }

    public String getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public float getPpu() {
        return ppu;
    }

    public ArrayList<CakeIngredients> getBatters() {
        return batters.getBatter();
    }

    public ArrayList<CakeIngredients> getTopping() {
        return topping;
    }
}

