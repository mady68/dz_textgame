package com.aomady;
import java.util.*;
public class Location {
    private String name;
    private String description;
    private Inventory inventory;
    private Map<Direction, Location> locationMap;


    public Location(String name, String description, Inventory inventory, Map<Direction, Location> locationMap) {
        this.name = name;
        this.description = description;
        this.inventory = inventory;
        this.locationMap = locationMap;
    }

    public String getDescription() {
        return description;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public Map<Direction, Location> getLocationMap() {
        return locationMap;
    }


    public Location findNext(String s) {
        return this.locationMap.get(s);
    }

    public void putOn(Item item){
        this.inventory.getItemsList().add(item);
    }
    public void pickUp(Item item){
        this.inventory.remove(item);
    }
}

enum Direction{
    UP,
    DOWN,
    WEST,
    EAST,
    NORTH,
    SOUTH;
}