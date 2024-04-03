package org.example.dataproviders;

import java.util.ArrayList;
import java.util.List;
import org.testng.annotations.DataProvider;

public class GildedItemDataProviders {

    @DataProvider(name = "SellInVariations")
    public static Object[][] getSellInVariations() {
        List<Object[]> data = new ArrayList<>();

        data.add(new Object[]{Integer.MAX_VALUE, Integer.MAX_VALUE - 1});
        data.add(new Object[]{1, 0});
        data.add(new Object[]{0, -1});
        data.add(new Object[]{Integer.MIN_VALUE + 1, Integer.MIN_VALUE});

        return data.toArray(new Object[][]{});
    }

}
