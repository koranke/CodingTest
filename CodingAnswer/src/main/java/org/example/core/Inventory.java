package org.example.core;

import org.example.enums.GildedItemType;

import java.util.ArrayList;
import java.util.List;

public class Inventory {

    public static List<Item> load() {
        List<Item> items = new ArrayList<>();
        items.add(new GildedItem(GildedItemType.DexterityVest, 10, 20));
        items.add(new GildedItem(GildedItemType.AgedBrie, 2, 0));
        items.add(new GildedItem(GildedItemType.ElixirMongoose, 5, 7));
        items.add(new GildedItem(GildedItemType.Sulfuras, 0, 80));
        items.add(new GildedItem(GildedItemType.TAFKAL80ETCConcert, 15, 20));
        items.add(new GildedItem(GildedItemType.ConjuredManaCake, 3, 6));
        return items;
    }

    public static void update(List<Item> items) throws Exception
    {
        for (Item item : items) {
            GildedItem gildedItem = (GildedItem) item;
            try {
                gildedItem.decrementSellIn();
            } catch (Exception e) {
                throw new Exception(e);
            }
            gildedItem.updateQuality();
        }
    }

    public static void print(String message, List<Item> items) {
        System.out.println(message);
        items.forEach(item -> {
            GildedItem gildedItem = (GildedItem) item;
            gildedItem.print();
        });
        System.out.println();
    }
}
