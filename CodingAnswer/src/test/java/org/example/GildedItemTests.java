package org.example;

import org.example.core.GildedItem;
import org.example.dataproviders.GildedItemDataProviders;
import org.example.enums.GildedItemType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GildedItemTests {
    
    @Test(dataProvider = "SellInVariations", dataProviderClass = GildedItemDataProviders.class)
    public void testUpdateSellIn(int sellInValue, int expectedSellInValue) throws Exception {
        GildedItem gildedItem = new GildedItem(GildedItemType.ConjuredManaCake, sellInValue, 1);
        gildedItem.decrementSellIn();
        Assert.assertEquals(gildedItem.getSellIn(), expectedSellInValue);
    }

    @Test(expectedExceptions = Exception.class, expectedExceptionsMessageRegExp = "Unable to decrement sellIn.  Reached min value.")
    public void testUpdateSellInException() throws Exception {
        GildedItem gildedItem = new GildedItem(GildedItemType.ConjuredManaCake, Integer.MIN_VALUE, 1);
        gildedItem.decrementSellIn();
    }

    @Test
    public void testBasicUpdateQuality() throws Exception {
        GildedItem gildedItem = new GildedItem(GildedItemType.DexterityVest, 10, 1);
        gildedItem.updateQuality();
        Assert.assertEquals(gildedItem.getQuality(), 0);
    }

}
