package com.aomady;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayerTest {




    @Test
    public void lookAroundTest(){
//Creating Combos//
        Item necromant = new Item("necromant", "At the back in the Cave  you see the necromant.\nHe is sitting on the chair and looking to the fireplace.\n ", Moveable.STATIONARY, Updated.NOTUPDATED);
        Item bucket = new Item("bucket", "There is  a bucket on the floor. \n", Moveable.MOBILE, Updated.NOTUPDATED);
        Item rope = new Item("rope", "You see a rope on the shelf. \n", Moveable.MOBILE, Updated.UPDATED);
        Item bucketWithRope = new Item("bucket", "bucket linked with rope. \n", Moveable.MOBILE, Updated.UPDATED);
        Item frog = new Item("frog", "There is  a frog near the whell. \n", Moveable.MOBILE, Updated.NOTUPDATED);
        Item well = new Item("well", "In the center is the well.", Moveable.STATIONARY, Updated.NOTUPDATED);

        Item bottle = new Item("bottle", "bottle of Protection potion \n", Moveable.MOBILE, Updated.NOTUPDATED);
        Item stick = new Item("stick", "the magic stick", Moveable.STATIONARY, Updated.NOTUPDATED);


        Combo bucketRopeCombo = new Combo(rope, bucket, bucketWithRope, "You linked backet with rope", "backet is empty");

        //Creating HashMap 'mapItems' for mapping String names to real object of item//
        Map<String, Item> mapItems = new HashMap<>();
        mapItems.put("bucket", bucket);
        mapItems.put("rope", rope);
        mapItems.put("bottle", bottle);
        mapItems.put("stick", stick);
        mapItems.put("well", well);
        mapItems.put("frog", frog);

        // mapItems.put("chain", chain);


        //Creating HashMap for mapping the String (error description) to each pair of items in combo//
        Map<String, String> noCombo = new HashMap<>();
        noCombo.put("bucketnecromant", "bucket is empty");

        //Creating HashMap, which contains pairs of (HashMap(item,item): Combo(item,item)//
        Map<Map<Item, Item>, Combo> mapComboMap2 = new HashMap<>();
        Map<Item, Item> bucketrope = new HashMap<>();
        bucketrope.put(rope, bucket);
        mapComboMap2.put(bucketrope, bucketRopeCombo);

        List<Item> items1 = new ArrayList<>();        //location 1
        items1.add(necromant);
        items1.add(bucket);
        items1.add(rope);


        Inventory inventory1 = new Inventory(items1);
        List<Item> items2 = new ArrayList<>();
        items2.add(frog);
        items2.add(well);
        Inventory inventory2 = new Inventory(items2);

        List<Item> items3 = new ArrayList<>();
        items3.add(bottle);
        items3.add(stick);
        Inventory startPlayerInvent = new Inventory(items3);

        //Creating HashMap Directions for locations//
        Map<Direction, Location> locationMap1 = new HashMap<Direction, Location>();
        Map<Direction, Location> locationMap2 = new HashMap<Direction, Location>();
        //Creating locations//
        Location frontYard = new Location("yard", " You are in the front of Entry into Cave. \n There is a small garden with the well at the center.", inventory2, locationMap2);

        Location Cave = new Location("Cave", " You are in the black  Cave at the Dragon's Rock. \n" +
                " On the EAST from you - the entry \n with  dried black horse skin as a door, \n near - stairs to UP - to big long Tower, \n and stairs to Down..what it would be..? \n", inventory1, locationMap1);
        locationMap1.put(Direction.EAST, frontYard);
        locationMap2.put(Direction.WEST, Cave);

        Player player1 =  new Player("player1", Cave, startPlayerInvent, mapComboMap2, mapItems, noCombo);
        String result = player1.lookAround();


        String actual =  " You are in the black  Cave at the Dragon's Rock. \n" +
                " On the EAST from you - the entry \n with  dried black horse skin " +
                "as a door, \n near - stairs to UP - to big long Tower, \n and stairs to Down..what it would be..? \n"+
                "At the back in the Cave  you see the necromant.\nHe is sitting on the chair and looking to the fireplace.\n "+
                "There is  a bucket on the floor. \n"+
                "You see a rope on the shelf. \n";

                Assert.assertEquals(result, actual);

    }

    @Test
    public void goTest(){
        Item necromant = new Item("necromant", "At the back in the Cave  you see the necromant.\nHe is sitting on the chair and looking to the fireplace.\n ", Moveable.STATIONARY, Updated.NOTUPDATED);
        Item bucket = new Item("bucket", "There is  a bucket on the floor. \n", Moveable.MOBILE, Updated.NOTUPDATED);
        Item rope = new Item("rope", "You see a rope on the shelf. \n", Moveable.MOBILE, Updated.UPDATED);
        Item bucketWithRope = new Item("bucket", "bucket linked with rope. \n", Moveable.MOBILE, Updated.UPDATED);
        Item frog = new Item("frog", "There is  a frog near the whell. \n", Moveable.MOBILE, Updated.NOTUPDATED);
        Item well = new Item("well", "In the center is the well.", Moveable.STATIONARY, Updated.NOTUPDATED);

        Item bottle = new Item("bottle", "bottle of Protection potion \n", Moveable.MOBILE, Updated.NOTUPDATED);
        Item stick = new Item("stick", "the magic stick", Moveable.STATIONARY, Updated.NOTUPDATED);


        Combo bucketRopeCombo = new Combo(rope, bucket, bucketWithRope, "You linked backet with rope", "backet is empty");

        //Creating HashMap 'mapItems' for mapping String names to real object of item//
        Map<String, Item> mapItems = new HashMap<>();
        mapItems.put("bucket", bucket);
        mapItems.put("rope", rope);
        mapItems.put("bottle", bottle);
        mapItems.put("stick", stick);
        mapItems.put("well", well);
        mapItems.put("frog", frog);

        // mapItems.put("chain", chain);


        //Creating HashMap for mapping the String (error description) to each pair of items in combo//
        Map<String, String> noCombo = new HashMap<>();
        noCombo.put("bucketnecromant", "bucket is empty");

        //Creating HashMap, which contains pairs of (HashMap(item,item): Combo(item,item)//
        Map<Map<Item, Item>, Combo> mapComboMap2 = new HashMap<>();
        Map<Item, Item> bucketrope = new HashMap<>();
        bucketrope.put(rope, bucket);
        mapComboMap2.put(bucketrope, bucketRopeCombo);

        List<Item> items1 = new ArrayList<>();        //location 1
        items1.add(necromant);
        items1.add(bucket);
        items1.add(rope);


        Inventory inventory1 = new Inventory(items1);
        List<Item> items2 = new ArrayList<>();
        items2.add(frog);
        items2.add(well);
        Inventory inventory2 = new Inventory(items2);

        List<Item> items3 = new ArrayList<>();
        items3.add(bottle);
        items3.add(stick);
        Inventory startPlayerInvent = new Inventory(items3);

        //Creating HashMap Directions for locations//
        Map<Direction, Location> locationMap1 = new HashMap<Direction, Location>();
        Map<Direction, Location> locationMap2 = new HashMap<Direction, Location>();
        //Creating locations//
        Location frontYard = new Location("yard", " You are in the front of Entry into Cave. \n There is a small garden with the well at the center.", inventory2, locationMap2);

        Location Cave = new Location("Cave", " You are in the black  Cave at the Dragon's Rock. \n" +
                " On the EAST from you - the entry \n with  dried black horse skin as a door, \n near - stairs to UP - to big long Tower, \n and stairs to Down..what it would be..? \n", inventory1, locationMap1);
        locationMap1.put(Direction.EAST, frontYard);
        locationMap2.put(Direction.WEST, Cave);

        Player player1 =  new Player("player1", Cave, startPlayerInvent, mapComboMap2, mapItems, noCombo);

        player1.go("east");
        Location expected = player1.getCurrentLocation();
        Location actual = frontYard;

        Assert.assertEquals(expected, actual);

    }

    @Test
    public void takeTest(){
        Item necromant = new Item("necromant", "At the back in the Cave  you see the necromant.\nHe is sitting on the chair and looking to the fireplace.\n ", Moveable.STATIONARY, Updated.NOTUPDATED);
        Item bucket = new Item("bucket", "There is  a bucket on the floor. \n", Moveable.MOBILE, Updated.NOTUPDATED);
        Item rope = new Item("rope", "You see a rope on the shelf. \n", Moveable.MOBILE, Updated.UPDATED);
        Item bucketWithRope = new Item("bucket", "bucket linked with rope. \n", Moveable.MOBILE, Updated.UPDATED);
        Item frog = new Item("frog", "There is  a frog near the whell. \n", Moveable.MOBILE, Updated.NOTUPDATED);
        Item well = new Item("well", "In the center is the well.", Moveable.STATIONARY, Updated.NOTUPDATED);

        Item bottle = new Item("bottle", "bottle of Protection potion \n", Moveable.MOBILE, Updated.NOTUPDATED);
        Item stick = new Item("stick", "the magic stick", Moveable.STATIONARY, Updated.NOTUPDATED);


        Combo bucketRopeCombo = new Combo(rope, bucket, bucketWithRope, "You linked backet with rope", "backet is empty");

        //Creating HashMap 'mapItems' for mapping String names to real object of item//
        Map<String, Item> mapItems = new HashMap<>();
        mapItems.put("bucket", bucket);
        mapItems.put("rope", rope);
        mapItems.put("bottle", bottle);
        mapItems.put("stick", stick);
        mapItems.put("well", well);
        mapItems.put("frog", frog);

        // mapItems.put("chain", chain);


        //Creating HashMap for mapping the String (error description) to each pair of items in combo//
        Map<String, String> noCombo = new HashMap<>();
        noCombo.put("bucketnecromant", "bucket is empty");

        //Creating HashMap, which contains pairs of (HashMap(item,item): Combo(item,item)//
        Map<Map<Item, Item>, Combo> mapComboMap2 = new HashMap<>();
        Map<Item, Item> bucketrope = new HashMap<>();
        bucketrope.put(rope, bucket);
        mapComboMap2.put(bucketrope, bucketRopeCombo);

        List<Item> items1 = new ArrayList<>();        //location 1
        items1.add(necromant);
        items1.add(bucket);
        items1.add(rope);


        Inventory inventory1 = new Inventory(items1);
        List<Item> items2 = new ArrayList<>();
        items2.add(frog);
        items2.add(well);
        Inventory inventory2 = new Inventory(items2);

        List<Item> items3 = new ArrayList<>();
        items3.add(bottle);
        items3.add(stick);
        Inventory startPlayerInvent = new Inventory(items3);

        //Creating HashMap Directions for locations//
        Map<Direction, Location> locationMap1 = new HashMap<Direction, Location>();
        Map<Direction, Location> locationMap2 = new HashMap<Direction, Location>();
        //Creating locations//
        Location frontYard = new Location("yard", " You are in the front of Entry into Cave. \n There is a small garden with the well at the center.", inventory2, locationMap2);

        Location Cave = new Location("Cave", " You are in the black  Cave at the Dragon's Rock. \n" +
                " On the EAST from you - the entry \n with  dried black horse skin as a door, \n near - stairs to UP - to big long Tower, \n and stairs to Down..what it would be..? \n", inventory1, locationMap1);
        locationMap1.put(Direction.EAST, frontYard);
        locationMap2.put(Direction.WEST, Cave);

        Player player1 =  new Player("player1", Cave, startPlayerInvent, mapComboMap2, mapItems, noCombo);
        player1.take("bucket");

        List<Item> expected = player1.getCurrentInventory().getItemsList();
        List<Item> actual = new ArrayList<>();
        actual.add(bottle);
        actual.add(stick);
        actual.add(bucket);


        Assert.assertEquals(expected, actual);
    }

    @Test
    public void useTest(){
        Item necromant = new Item("necromant", "At the back in the Cave  you see the necromant.\nHe is sitting on the chair and looking to the fireplace.\n ", Moveable.STATIONARY, Updated.NOTUPDATED);
        Item bucket = new Item("bucket", "There is  a bucket on the floor. \n", Moveable.MOBILE, Updated.NOTUPDATED);
        Item rope = new Item("rope", "You see a rope on the shelf. \n", Moveable.MOBILE, Updated.UPDATED);
        Item bucketWithRope = new Item("bucket", "bucket linked with rope. \n", Moveable.MOBILE, Updated.UPDATED);
        Item frog = new Item("frog", "There is  a frog near the whell. \n", Moveable.MOBILE, Updated.NOTUPDATED);
        Item well = new Item("well", "In the center is the well.", Moveable.STATIONARY, Updated.NOTUPDATED);

        Item bottle = new Item("bottle", "bottle of Protection potion \n", Moveable.MOBILE, Updated.NOTUPDATED);
        Item stick = new Item("stick", "the magic stick", Moveable.STATIONARY, Updated.NOTUPDATED);


        Combo bucketRopeCombo = new Combo(rope, bucket, bucketWithRope, "You linked backet with rope", "backet is empty");

        //Creating HashMap 'mapItems' for mapping String names to real object of item//
        Map<String, Item> mapItems = new HashMap<>();
        mapItems.put("bucket", bucket);
        mapItems.put("rope", rope);
        mapItems.put("bottle", bottle);
        mapItems.put("stick", stick);
        mapItems.put("well", well);
        mapItems.put("frog", frog);

        // mapItems.put("chain", chain);


        //Creating HashMap for mapping the String (error description) to each pair of items in combo//
        Map<String, String> noCombo = new HashMap<>();
        noCombo.put("bucketnecromant", "bucket is empty");

        //Creating HashMap, which contains pairs of (HashMap(item,item): Combo(item,item)//
        Map<Map<Item, Item>, Combo> mapComboMap2 = new HashMap<>();
        Map<Item, Item> bucketrope = new HashMap<>();
        bucketrope.put(rope, bucket);
        mapComboMap2.put(bucketrope, bucketRopeCombo);

        List<Item> items1 = new ArrayList<>();        //location 1
        items1.add(necromant);
        items1.add(bucket);
        items1.add(rope);


        Inventory inventory1 = new Inventory(items1);
        List<Item> items2 = new ArrayList<>();
        items2.add(frog);
        items2.add(well);
        Inventory inventory2 = new Inventory(items2);

        List<Item> items3 = new ArrayList<>();
        items3.add(bottle);
        items3.add(stick);
        Inventory startPlayerInvent = new Inventory(items3);

        //Creating HashMap Directions for locations//
        Map<Direction, Location> locationMap1 = new HashMap<Direction, Location>();
        Map<Direction, Location> locationMap2 = new HashMap<Direction, Location>();
        //Creating locations//
        Location frontYard = new Location("yard", " You are in the front of Entry into Cave. \n There is a small garden with the well at the center.", inventory2, locationMap2);

        Location Cave = new Location("Cave", " You are in the black  Cave at the Dragon's Rock. \n" +
                " On the EAST from you - the entry \n with  dried black horse skin as a door, \n near - stairs to UP - to big long Tower, \n and stairs to Down..what it would be..? \n", inventory1, locationMap1);
        locationMap1.put(Direction.EAST, frontYard);
        locationMap2.put(Direction.WEST, Cave);

        Player player1 =  new Player("player1", Cave, startPlayerInvent, mapComboMap2, mapItems, noCombo);
        player1.take("bucket");
        player1.take("rope");
        player1.use("rope", "bucket");

        List<Item> expected = player1.getCurrentInventory().getItemsList();
        List<Item> actual = new ArrayList<>();
        actual.add(bottle);
        actual.add(stick);
        actual.add(bucketWithRope);

        Assert.assertEquals(expected, actual);
    }
}
