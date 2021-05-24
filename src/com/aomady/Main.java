package com.aomady;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        // Creating Items in the 1st location//


            Item necromant = new Item("necromant", "At the back in the Cave  you see the necromant.\nHe is sitting on the chair and looking to the fireplace.\n ", Moveable.STATIONARY, Updated.NOTUPDATED);
            Item bucket = new Item("bucket", "There is  a bucket on the floor. \n", Moveable.MOBILE, Updated.NOTUPDATED);
            Item cup = new Item("cup", "There is a cup on the table. \n", Moveable.MOBILE, Updated.NOTUPDATED);
            Item fireplace = new Item("fireplace", "The fireplace is near the wall. \n", Moveable.STATIONARY, Updated.NOTUPDATED);
            Item rope = new Item("rope", "You see a rope on the shelf. \n", Moveable.MOBILE, Updated.UPDATED);

            //Creating Items in the 2nd location//
            Item frog = new Item("frog", "There is  a frog near the whell. \n", Moveable.MOBILE, Updated.NOTUPDATED);

            Item well = new Item("well", "In the center is the well.", Moveable.STATIONARY, Updated.NOTUPDATED);

            //Creating Items in the 3rd location (UP - Tower)//
            Item spellbook = new Item("spellbook", "At the table near the center was the Spellbook, \n named 'The Great Book of beginning...'", Moveable.MOBILE, Updated.UPDATED);
            Item closet = new Item("closet", "Near the windows of room was the big closet with potions", Moveable.STATIONARY, Updated.NOTUPDATED);

            //Creating Items in the 4rth location (Down - dangeon)//
            //Item chain = new Item("chain", "At the neck of the Dragon there was the chain with the little metal box..", Moveable.STATIONARY, Updated.NOTUPDATED);
            Item elixir = new Item("elixir", "At the claws of the Dragon there was the elixir of Life..", Moveable.MOBILE, Updated.UPDATED);
            Item monument = new Item("monument", "In front of the dragon was monument..of the Man..", Moveable.STATIONARY, Updated.NOTUPDATED);
            Item dragon = new Item("dragon", "Dragon is sleeping, be carefully..He's strong enough to burnt you..\n lUnder his claws you noticed some source of life elixir", Moveable.STATIONARY, Updated.NOTUPDATED);
            //Creating items in player's inventory//
            Item bottle = new Item("bottle", "bottle of Protection potion \n", Moveable.MOBILE, Updated.NOTUPDATED);
            Item stick = new Item("stick", "the magic stick", Moveable.STATIONARY, Updated.NOTUPDATED);
            //Creating items(results of combo)//
            Item bucketWithRope = new Item("bucket", "bucket linked with rope. \n", Moveable.MOBILE, Updated.UPDATED);
            Item bucketWithWater = new Item("bucket", "bucket with water", Moveable.MOBILE, Updated.UPDATED);
            Item flowerInVase = new Item("rose", "rose put in vase", Moveable.MOBILE, Updated.NOTUPDATED);
            Item bottleEmpty = new Item("cup", "empty bottle", Moveable.MOBILE, Updated.NOTUPDATED);

            //combo result items//

            //Creating Combos//
            Combo emptyBottle = new Combo(bottle, cup, bottleEmpty, "You boiled Potion from bottle \n " +
                    "to cup and drunk all Potion..You get a protection aura of nature..and...bottle is empty", "bottle is empty..:(");

            Combo bucketRopeCombo = new Combo(rope, bucket, bucketWithRope, "You linked backet with rope", "backet is empty");
            Combo bucketRopeWellCombo = new Combo(bucketWithRope, well, bucketWithWater, "You fill up the backet with water", "backet with water2");
            Combo bucketWaterWizard = new Combo(bucketWithWater, necromant, bucketWithRope, "You washed Wizard with bucket of water and he has losted his power.", "hahaa");

            Combo stickMonument = new Combo(stick, monument, stick, "The description has appeared on a monument: \n 'Find the spell..sleep my dragon for ever'", "kadabra");
            Combo spellBookDragon = new Combo(spellbook, dragon, elixir, "The spell has enchanted the Dragon.He sleeps for ever. \n You took the magic elixir from under his claws", "karakal");
            Combo elixirFrog = new Combo(elixir, frog, elixir, "Elixir has affected on the frog..\n Instead of a frog there is a beautiful Princess Kel Elluna..You Win!", "Torrinko");

            //Creating HashMap 'mapItems' for mapping String names to real object of item//
            Map<String, Item> mapItems = new HashMap<>();
            mapItems.put("bucket", bucket);
            mapItems.put("well", well);
            mapItems.put("rope", rope);
            mapItems.put("cup", cup);
            mapItems.put("fireplace", fireplace);
            mapItems.put("bottle", bottle);
            mapItems.put("necromant", necromant);
            mapItems.put("frog", frog);
            mapItems.put("spellbook", spellbook);
            mapItems.put("closet", closet);
            mapItems.put("elixir", elixir);
            mapItems.put("monument", monument);
            mapItems.put("dragon", dragon);
            mapItems.put("stick", stick);

            //Creating HashMap for mapping the String (error description) to each pair of items in combo//
            Map<String, String> noCombo = new HashMap<>();
            noCombo.put("bucketnecromant", "bucket is empty");
            noCombo.put("bucketfrog", "You just need an elixir");
            noCombo.put("bucketwell", "it's too deep, you must use something else, maybe rope");
            noCombo.put("stickdragon", "The Dragon is waking up..He can burn you...go out..Read The Guide first...from Monument..");
            noCombo.put("stickelixir", "The Dragon is waking up...and look at you..go back..harry!..Read The Guide..from Monument");

            //Creating HashMap, which contains pairs of (HashMap(item,item): Combo(item,item)//
            Map<Map<Item, Item>, Combo> mapComboMap2 = new HashMap<>();
            //Creating HashMaps, which contains pairs Item:Item//
            Map<Item, Item> bucketWizard = new HashMap<>();
            bucketWizard.put(bucketWithWater, necromant);

            Map<Item, Item> bucketRopewell = new HashMap<>();
            bucketRopewell.put(bucketWithRope, well);

            Map<Item, Item> bucketrope = new HashMap<>();
            bucketrope.put(rope, bucket);

            Map<Item, Item> stickmonument = new HashMap<>();
            stickmonument.put(stick, monument);


            Map<Item, Item> bottleCup = new HashMap<>();
            bottleCup.put(bottle, cup);

            Map<Item, Item> spellbookDragon = new HashMap<>();
            spellbookDragon.put(spellbook, dragon);

            Map<Item, Item> elixirfrog = new HashMap<>();
            elixirfrog.put(elixir, frog);

            mapComboMap2.put(bucketRopewell, bucketRopeWellCombo);
            mapComboMap2.put(bucketrope, bucketRopeCombo);
            mapComboMap2.put(bucketWizard, bucketWaterWizard);
            mapComboMap2.put(bottleCup, emptyBottle);
            mapComboMap2.put(stickmonument, stickMonument);
            mapComboMap2.put(spellbookDragon, spellBookDragon);
            mapComboMap2.put(elixirfrog, elixirFrog);


            //Creating Inventories of location 1//
            //Creating List of items//
            List<Item> items1 = new ArrayList<>();        //location 1
            items1.add(necromant);
            items1.add(bucket);
            items1.add(cup);
            items1.add(rope);
            items1.add(fireplace);


            Inventory inventory1 = new Inventory(items1);  //location 1

            //Creating Inventories of location 2//
            List<Item> items2 = new ArrayList<>();
            items2.add(frog);
            items2.add(well);
            Inventory inventory2 = new Inventory(items2);

            //Creating location 3 -- UP (big Tower)//

            List<Item> items4 = new ArrayList<>();
            items4.add(spellbook);
            items4.add(closet);
            Inventory inventory4 = new Inventory(items4);

            //Creating location 4 -- Down (Dangeon)//
            List<Item> items5 = new ArrayList<>();
            //sitems5.add(chain);
            items5.add(monument);
            items5.add(dragon);
            Inventory inventory5 = new Inventory(items5);
            //Creating Inventory of player//
            List<Item> items3 = new ArrayList<>();
            items3.add(bottle);
            items3.add(stick);
            Inventory startPlayerInvent = new Inventory(items3);

            //Creating HashMap Directions for locations//
            Map<Direction, Location> locationMap1 = new HashMap<Direction, Location>();
            Map<Direction, Location> locationMap2 = new HashMap<Direction, Location>();
            Map<Direction, Location> locationMap3 = new HashMap<Direction, Location>();
            Map<Direction, Location> locationMap4 = new HashMap<Direction, Location>();

            //Creating locations//
            Location frontYard = new Location("yard", " You are in the front of Entry into Cave. \n There is a small garden with the well at the center.", inventory2, locationMap2);

            Location Cave = new Location("Cave", " You are in the black  Cave at the Dragon's Rock. \n" +
                    " On the EAST from you - the entry \n with  dried black horse skin as a door, \n near - stairs to UP - to big long Tower, \n and stairs to Down..what it would be..? \n", inventory1, locationMap1);
            Location tower = new Location("Tower", "You upstairs to the Big Tower..It's a big library. \n There are the Oldest books of ancient knowledge about Magic.", inventory4, locationMap3);
            Location dangeon = new Location("dangeon", "You downstairs into the deepest dangeon at this world, it's cold, and dark...\n There was a sleeping Dragon..Red Rock Dragon..", inventory5, locationMap4);
            locationMap1.put(Direction.EAST, frontYard);
            locationMap1.put(Direction.UP, tower);
            locationMap1.put(Direction.DOWN, dangeon);
            locationMap2.put(Direction.WEST, Cave);
            locationMap3.put(Direction.DOWN, Cave);
            locationMap4.put(Direction.UP, Cave);
            locationMap4.put(Direction.DOWN, dangeon);
            locationMap4.put(Direction.WEST, dangeon);
            locationMap4.put(Direction.EAST, dangeon);
            //Creating Player//
            Player player = new Player("player1", Cave, startPlayerInvent, mapComboMap2, mapItems, noCombo);


        //Starting Game Process//
        System.out.println("    Once upon a time, There was a Most famous and Great Kingdom of Nortumbria.\n People lived through the Magic animals and Wizards aside in the peace. \n" +
                " However, there was a most powerfull  Dark Necromant, named - Dark Rohan, \n people scare of him. He lives at the Dragon's Rock, near the Big Volcano.\n    The Lord of Kingdom, The Great Kel Talas asked you " +
                " to help him. \n You must to discover his daughter, Kel Elluna. Maybe, She is still alive..\n Necromant  has enchanted her into animal. " +
                " No one knows what kind of animal..\n    You are a Wizard's student, Kailo Reno..the beginner at the Light Magic of life.\n Please, find her, a Hero! " +
                        "And try defeat the Necromant! All is in your hands! Good luck!");
        System.out.println();
        System.out.println("---------------Loading location-----------------");
        System.out.println("  Look around....");
        System.out.println(player.lookAround());
        System.out.println();
        System.out.println("--------- Your skills ------");
        System.out.println("'look around' - look around yourself ");
        System.out.println("'take item' - taking item (example: take bucket)");
        System.out.println("'go direction' - going to direction(example: go east; go up)");
        System.out.println("'use item1 on item2' - using item1 on item2 - get result item. (example: use bucket on well)");
        System.out.println("-----------------------------");
        System.out.printf("You have items: \n");
        System.out.printf(bottle.getName() +" : " + bottle.getDescription());
        System.out.println(stick.getName() +" : " + stick.getDescription());
        System.out.println();

        Scanner scanner = new Scanner(System.in);

        String s;
        int n = 0;
        System.out.println("Please, enter action: ");
        do {
            s = scanner.nextLine();

            //System.out.println(s);
            String[] line = s.split("\\s");

            String line1 = line[0];
            switch (line1) {
                case ("exit"):
                    System.out.println("exit now...");
                    n = 1;
                    break;

                case (""):
                    System.out.println("enter  command....");
                    break;
                case ("look"):

                    if (line[1].equals("around")) {
                    //System.out.println("you enter look");
                        System.out.println(player.lookAround());
                    }
                    else {
                    System.out.println("Try again..it's mistake");
                    }
                    break;
                case ("inventory"):
                    player.inventory();
                    break;


                case ("take"):

                    if (line.length > 1) {
                        player.take(line[1]);

                    } else {
                        System.out.println("What take?? try 'lookaround' ");
                    }
                    break;


                case ("use"):
                    //System.out.println(line[3]);
                    if(line.length != 4){
                        System.out.println("What?..");
                        break;
                    }
                    else if(line[2].equals("on")) {
                        //System.out.println(line[3]);
                        player.use(line[1], line[3]);
                    }
                    else{
                        player.use(line[1], line[2]);
                    }
                    break;



                case ("go"):
                    if (line[1].equals("east")) {
                        //System.out.println("you go east");
                        System.out.println(player.go("east"));
                    } else if (line[1].equals("west")) {
                        //System.out.println("you go west");
                        System.out.println(player.go("west"));
                    }
                    else if (line[1].equals("up")) {
                        //System.out.println("you go up");
                        System.out.println(player.go("up"));
                    }
                    else if (line[1].equals("down")) {
                        //System.out.println("you go down");
                        System.out.println(player.go("down"));
                    }
                    else {
                        System.out.println("I can't do this... use  'go word' - one space delimeter ");
                    }
                    break;
                default:
                    System.out.println("What do you mean? There is no that action");
                    break;

            }

        }
        while (n != 1) ;
        System.out.println();
        System.out.println("GAMEOVER");
    }


}
