package org.example.dataproviders;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;

public class InventoryDataProviders {
    
    @DataProvider(name = "DexterityVestVariations")
    public static Object[][] getDexterityVestVariations() {
        List<Object[]> data = new ArrayList<>();

        //parameters: current sellBy, current Quality, expectedQuality
        data.add(new Object[]{1, 10, 9});
        data.add(new Object[]{0, 10, 8});
        data.add(new Object[]{1, 0, 0});
        data.add(new Object[]{0, 1, 0});

        return data.toArray(new Object[][]{});
    }

    @DataProvider(name = "ElixirMongooseVariations")
    public static Object[][] getElixirMongooseVariations() {
        List<Object[]> data = new ArrayList<>();

        //parameters: current sellBy, current Quality, expectedQuality
        data.add(new Object[]{1, 10, 9});
        data.add(new Object[]{0, 10, 8});
        data.add(new Object[]{1, 0, 0});
        data.add(new Object[]{0, 1, 0});

        return data.toArray(new Object[][]{});
    }

    @DataProvider(name = "ConjuredManaCakeVariations")
    public static Object[][] getConjuredManaCakeVariations() {
        List<Object[]> data = new ArrayList<>();

        //parameters: current sellBy, current Quality, expectedQuality
        data.add(new Object[]{1, 10, 8});
        data.add(new Object[]{0, 10, 6});
        data.add(new Object[]{1, 0, 0});

        return data.toArray(new Object[][]{});
    }

    @DataProvider(name = "AgedBrieVariations")
    public static Object[][] getAgedBrieVariations() {
        List<Object[]> data = new ArrayList<>();

        //parameters: current sellBy, current Quality, expectedQuality
        data.add(new Object[]{1, 10, 11});
        data.add(new Object[]{0, 10, 11});
        data.add(new Object[]{1, 50, 50});

        return data.toArray(new Object[][]{});
    }

    @DataProvider(name = "TAFKAL80ETCConcertVariations")
    public static Object[][] getTAFKAL80ETCConcertVariations() {
        List<Object[]> data = new ArrayList<>();

        //parameters: current sellBy, current Quality, expectedQuality
        data.add(new Object[]{12, 10, 11});
        data.add(new Object[]{11, 10, 12});
        data.add(new Object[]{6, 10, 13});
        data.add(new Object[]{0, 10, 0});

        return data.toArray(new Object[][]{});
    }

    @DataProvider(name = "SulfurasVariations")
    public static Object[][] getSulfurasVariations() {
        List<Object[]> data = new ArrayList<>();

        //parameters: current sellBy, current Quality, expectedQuality
        data.add(new Object[]{1, 80, 80});
        data.add(new Object[]{0, 80, 80});

        return data.toArray(new Object[][]{});
    }
}
