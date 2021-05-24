package com.aomady;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InventoryTest {

      @Test
    public void showTest(){
          Item necromant = new Item("necromant", "At the back in the Cave  you see the necromant.\nHe is sitting on the chair and looking to the fireplace.\n ", Moveable.STATIONARY, Updated.NOTUPDATED);
          Item bucket = new Item("bucket", "There is  a bucket on the floor. \n", Moveable.MOBILE, Updated.NOTUPDATED);
          Item cup = new Item("cup", "There is a cup on the table. \n", Moveable.MOBILE, Updated.NOTUPDATED);
          Item fireplace = new Item("fireplace", "The fireplace is near the wall. \n", Moveable.STATIONARY, Updated.NOTUPDATED);
          Item rope = new Item("rope", "You see a rope on the shelf. \n", Moveable.MOBILE, Updated.UPDATED);
          List<Item> items1 = new ArrayList<>();        //location 1
          items1.add(necromant);
          items1.add(bucket);
          items1.add(cup);
          items1.add(rope);
          items1.add(fireplace);
          Inventory inventory3 = new Inventory(items1);

          String expected = inventory3.show();

          String actual = necromant.getDescription()+bucket.getDescription()+cup.getDescription()+ rope.getDescription()+fireplace.getDescription();

          Assert.assertEquals(expected, actual);
      }

      @Test
    public void findTest(){
          Item necromant = new Item("necromant", "At the back in the Cave  you see the necromant.\nHe is sitting on the chair and looking to the fireplace.\n ", Moveable.STATIONARY, Updated.NOTUPDATED);
          Item bucket = new Item("bucket", "There is  a bucket on the floor. \n", Moveable.MOBILE, Updated.NOTUPDATED);
          Item cup = new Item("cup", "There is a cup on the table. \n", Moveable.MOBILE, Updated.NOTUPDATED);
          Item fireplace = new Item("fireplace", "The fireplace is near the wall. \n", Moveable.STATIONARY, Updated.NOTUPDATED);
          Item rope = new Item("rope", "You see a rope on the shelf. \n", Moveable.MOBILE, Updated.UPDATED);
          List<Item> items1 = new ArrayList<>();        //location 1
          items1.add(necromant);
          items1.add(bucket);
          items1.add(cup);
          items1.add(rope);
          items1.add(fireplace);

          Inventory inventory = new Inventory(items1);


          boolean result = inventory.find("necromant");

          Assert.assertTrue(result);
      }
}
