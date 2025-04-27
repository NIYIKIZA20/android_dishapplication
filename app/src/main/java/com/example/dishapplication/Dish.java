package com.example.dishapplication;

public class Dish {
    private String name;
    private int type; // for example, 1 = vegetarian, 2 = non-vegetarian
    private boolean isVegetarian;

    public Dish(String name, int type, boolean isVegetarian) {
        this.name = name;
        this.type = type;
        this.isVegetarian = isVegetarian;
    }

    public String getName() { return name; }
    public int getType() { return type; }
    public boolean isVegetarian() { return isVegetarian; }
}
