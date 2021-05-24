package com.aomady;
import java.util.*;

public class Inventory {
    private  List<Item> itemsList;

    public Inventory(List<Item> items) {
        this.itemsList = items;
    }

    public List<Item> getItemsList() {
        return itemsList;
    }

    public void add(Item item) {
        itemsList.add(item);
    }

    public void remove(Item item) {
        itemsList.remove(item);
    }

    public String show() {
        String result = "";
        for (Item item : itemsList) {
             result = result+item.getDescription();
        }
        return result;
    }

    public boolean find(String name) {
        int yes = 0;
        Iterator<Item> iterator = itemsList.listIterator();

        while (iterator.hasNext()){
            if (iterator.next().getName().equals(name)) {
                yes = 1;
                break;
            }

        }
        if (yes == 1){
            return true;
        }
        else{
            return false;
        }
    }

}



