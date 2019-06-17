package com.example.cakeorders.model;

import java.util.ArrayList;

/**
 * A class representing a list of batters
 */
public class Batters {
    ArrayList<CakeAddOn> batter;

    public Batters(ArrayList<CakeAddOn> batter) {
        this.batter = batter;
    }

    public ArrayList<CakeAddOn> getBatter() {
        return batter;
    }
}
