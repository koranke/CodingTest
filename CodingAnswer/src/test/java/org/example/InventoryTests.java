package org.example;

import java.util.ArrayList;
import java.util.List;

import org.example.core.GildedItem;
import org.example.core.Inventory;
import org.example.core.Item;
import org.example.dataproviders.InventoryDataProviders;
import org.example.enums.GildedItemType;
import org.testng.Assert;
import org.testng.annotations.Test;

/*
 * These tests verify that inventory items are properly configured
 */
public class InventoryTests {

    @Test(dataProvider = "DexterityVestVariations", dataProviderClass = InventoryDataProviders.class)
    public void testDexterityVestVariations(int sellBy, int startingQuality, int expectedQuality) throws Exception {
        runTest(GildedItemType.DexterityVest, sellBy, startingQuality, expectedQuality);
    }

    @Test(dataProvider = "ElixirMongooseVariations", dataProviderClass = InventoryDataProviders.class)
    public void testElixirMongooseVariations(int sellBy, int startingQuality, int expectedQuality) throws Exception {
        runTest(GildedItemType.ElixirMongoose, sellBy, startingQuality, expectedQuality);
    }

    @Test(dataProvider = "ConjuredManaCakeVariations", dataProviderClass = InventoryDataProviders.class)
    public void testConjuredManaCakeVariations(int sellBy, int startingQuality, int expectedQuality) throws Exception {
        runTest(GildedItemType.ConjuredManaCake, sellBy, startingQuality, expectedQuality);
    }

    @Test(dataProvider = "AgedBrieVariations", dataProviderClass = InventoryDataProviders.class)
    public void testAgedBrieVariations(int sellBy, int startingQuality, int expectedQuality) throws Exception {
        runTest(GildedItemType.AgedBrie, sellBy, startingQuality, expectedQuality);
    }

    @Test(dataProvider = "TAFKAL80ETCConcertVariations", dataProviderClass = InventoryDataProviders.class)
    public void testTAFKAL80ETCConcertVariations(int sellBy, int startingQuality, int expectedQuality) throws Exception {
        runTest(GildedItemType.TAFKAL80ETCConcert, sellBy, startingQuality, expectedQuality);
    }

    @Test(dataProvider = "SulfurasVariations", dataProviderClass = InventoryDataProviders.class)
    public void testSulfurasVariations(int sellBy, int startingQuality, int expectedQuality) throws Exception {
        runTest(GildedItemType.Sulfuras, sellBy, startingQuality, expectedQuality);
    }



    private void runTest(GildedItemType gildedItemType, int sellBy, int startingQuality, int expectedQuality) throws Exception {
        List<Item> items = new ArrayList<>();
        items.add(new GildedItem(gildedItemType, sellBy, startingQuality));

        Inventory.update(items);

        Assert.assertEquals(items.get(0).getQuality(), expectedQuality);
    }
}
