package com.example.cakeorders.model;

import java.util.ArrayList;

public class Cake {
    private String id;
    private String type;
    private String name;
    private float ppu;
    private Batters batters;
    private ArrayList<CakeAddOn> topping;

    public Cake(String id, String type, String name, float ppu, Batters batters, ArrayList<CakeAddOn> topping) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.ppu = ppu;
        this.batters = batters;
        this.topping = topping;
    }

    //Constructor

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

    public ArrayList<CakeAddOn> getBatters() {
        return batters.getBatter();
    }

    public ArrayList<CakeAddOn> getTopping() {
        return topping;
    }

    class Batters {
        ArrayList<CakeAddOn> batter;

        public Batters(ArrayList<CakeAddOn> batter) {
            this.batter = batter;
        }

        public ArrayList<CakeAddOn> getBatter() {
            return batter;
        }
    }
}
