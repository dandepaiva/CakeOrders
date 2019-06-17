package com.example.cakeorders.model;

import java.util.ArrayList;

/**
 * A class containing a list of batters
 */
public class Batters {
    ArrayList<CakeIngredients> batter; // list of all batters

    public Batters(ArrayList<CakeIngredients> batter) {
        this.batter = batter;
    }

    public ArrayList<CakeIngredients> getBatter() {
        return batter;
    }
}
