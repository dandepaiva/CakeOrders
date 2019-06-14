package com.example.cakeorders.cakeFactory;

import java.util.ArrayList;

public class CakeObject {
    String id, type, name;
    float ppu;
    Batters batters;
    ArrayList<CakeAddOn> topping;

    public CakeObject(String id, String type, String name, float ppu, Batters batters, ArrayList<CakeAddOn> topping) {
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

    class Batters{
        ArrayList<CakeAddOn> batter;

        public Batters(ArrayList<CakeAddOn> batter) {
            this.batter = batter;
        }
    }
}
