package com.aomady;



import java.util.*;



public class Player {
    private  String name;
    private Location currentLocation;
    private Inventory currentInventory;
    private Map<Map<Item, Item>, Combo> mapComboMap2;
    private Map<String, Item> mapItems;
    Map<String, String> noCombo;

    public Player(String name, Location currentLocation, Inventory currentInventory, Map<Map<Item, Item>,
            Combo> mapComboMap2, Map<String, Item> mapItems, Map<String, String> noCombo) {
        this.name = name;
        this.currentLocation = currentLocation;
        this.currentInventory = currentInventory;
        this.mapComboMap2 = mapComboMap2;
        this.mapItems = mapItems;
        this.noCombo = noCombo;

    }

    public String getName() {
        return name;
    }

    public  Location getCurrentLocation() {
        return currentLocation;
    }

    public  Inventory getCurrentInventory() {
        return currentInventory;
    }

    public String lookAround() {

        return  this.currentLocation.getDescription()+this.currentLocation.getInventory().show();
        //System.out.println();
    }

    public String go(String s) {

        if (s.equals("east")) {
            //System.out.println(this.currentLocation.getLocationMap().get(Direction.EAST));
            this.currentLocation = this.currentLocation.getLocationMap().get(Direction.EAST);
            return this.lookAround();
        }
        //this.currentLocation = this.currentLocation.getLocationMap().get(direction);
        if (s.equals("west")) {
            //System.out.println(this.currentLocation.getLocationMap().get(Direction.WEST));
            this.currentLocation = this.currentLocation.getLocationMap().get(Direction.WEST);
            return this.lookAround();
        }
        if (s.equals("up")) {
            //System.out.println(this.currentLocation.getLocationMap().get(Direction.UP));
            this.currentLocation = this.currentLocation.getLocationMap().get(Direction.UP);
            return this.lookAround();
        }
        if (s.equals("down")) {
            //System.out.println(this.currentLocation.getLocationMap().get(Direction.DOWN));
            this.currentLocation = this.currentLocation.getLocationMap().get(Direction.DOWN);
            return this.lookAround();
        }
        else{
            return "chose direction";
        }
    }

    public void inventory() {
        System.out.printf("You have items: ");
        //this.getCurrentInventory().show();
        for (Item item : this.getCurrentInventory().getItemsList()) {
            System.out.printf(item.getName());
            System.out.printf(", ");
        }
        System.out.println();
    }

    public void take(String s) {
        //System.out.println("start taking..");

        if (this.currentLocation.getInventory().find(s)) {


            //System.out.println("There is this item");
            Item tempItem = this.mapItems.get(s);
            //System.out.printf("This item: %s \n", tempItem.getName());
            if (tempItem.getMoveable() == Moveable.MOBILE) {
                this.currentLocation.getInventory().getItemsList().remove(tempItem);
                this.currentInventory.add(tempItem);
                System.out.printf("%s moved into you bag\n", s);
            } else {
                System.out.println("You can't take it..");
                System.out.println("Maybe, skills or items would help..");
            }
        }


        else {
            System.out.println("no this item");
        }


    }


    public void use(String s1, String s2) {
        //System.out.printf("using %s and %s \n", s1, s2);
        //System.out.println("start using..");


        //System.out.println(this.currentInventory.find(s1));
       // System.out.println(this.currentInventory.find(s2) || this.currentLocation.getInventory().find(s2));
        if (this.currentInventory.find(s1)) {
            //System.out.printf("you have item: %s \n", s1);
            if (this.currentInventory.find(s2) || this.currentLocation.getInventory().find(s2)) {
                //System.out.printf("There is the subject %s \n", s2);
                Combo tempCombo = mapComboMap2.get(Map.of(mapItems.get(s1),mapItems.get(s2)));
                if(tempCombo != null){
                    this.currentInventory.add(tempCombo.getResult());
                    this.currentInventory.remove(tempCombo.getObject());

                    if(tempCombo.getSubject().getMoveable().equals(Moveable.MOBILE)){
                        this.currentLocation.getInventory().remove(tempCombo.getSubject());
                    }

                    this.currentInventory.remove(tempCombo.getSubject());
                    this.mapItems.put(tempCombo.getResult().getName(),tempCombo.getResult());
                    //this.mapItems.put(s1,tempCombo.getResult());
                    System.out.println(tempCombo.getMessage());


                }
                else

                    {
                        if(this.noCombo.get(s1+s2) != null){
                            System.out.println(this.noCombo.get(s1+s2));
                        }
                        else {

                            System.out.println("You can't use these items together..try something else.");
                        }
                    }

                } else {
                    System.out.printf("The subject %s doesn't exist on this location \n", s2);
                }
            } else {
                System.out.printf("you don't have this item: %s\n ", s1);
                System.out.println("look around, maybe change location and try take it");
            }
        }
    }



