package com.aomady;



public class Item implements  Cloneable {
    private String name;
    private String description;
    private Moveable moveable;
    //private boolean property;
    private Updated updated;

    public Item(String name, String description, Moveable moveable, Updated updated){
        this.name = name;
        this.description = description;
        this.moveable = moveable;
        //this.property = false;
        this.updated = updated;
    }

    public String getName(){
        return name;
    }
    public String getDescription(){
        return description;
    }
    public Moveable getMoveable(){
        return moveable;
    }

    public Updated getUpdated(){
        return updated;
    }
    public void setUpdated(Updated updated){
        this.updated = updated;
    }

    /*//public void setProperty(){
        this.property = true;
    }*/
   /* //public void  printItem(){
        System.out.printf(" "+ this.description);
    }*/



}


enum Moveable{
    STATIONARY,
    MOBILE;
}

enum Updated{
    UPDATED,
    NOTUPDATED
}