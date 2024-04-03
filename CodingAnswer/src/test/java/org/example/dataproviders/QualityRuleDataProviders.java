package org.example.dataproviders;

import java.util.ArrayList;
import java.util.List;

import org.example.core.GildedItem;
import org.example.core.QualityRule;
import org.example.enums.GildedItemType;
import org.testng.annotations.DataProvider;

public class QualityRuleDataProviders {

    @DataProvider(name = "UpdateQualityVariations")
    public static Object[][] getUpdateQualityVariations() {
        List<Object[]> data = new ArrayList<>();
        String scenario;
        GildedItem gildedItem;
        QualityRule qualityRule;
        int expectedQuality;

        //-----------------------------------
        scenario = "1. Decrement.";
        //-----------------------------------
        gildedItem = new GildedItem(GildedItemType.DexterityVest , 10, 10);
        qualityRule = new QualityRule(-1, 10);
        expectedQuality = 9;
        data.add(new Object[]{scenario, gildedItem, qualityRule, expectedQuality});

        //-----------------------------------
        scenario = "2. Decrement past min.";
        //-----------------------------------
        gildedItem = new GildedItem(GildedItemType.DexterityVest , 10, GildedItemType.DexterityVest.getMinQualityValue());
        qualityRule = new QualityRule(-1, 10);
        expectedQuality = GildedItemType.DexterityVest.getMinQualityValue();
        data.add(new Object[]{scenario, gildedItem, qualityRule, expectedQuality});

        //-----------------------------------
        scenario = "3. Accelerated decrement.";
        //-----------------------------------
        gildedItem = new GildedItem(GildedItemType.DexterityVest , 10, 10);
        qualityRule = new QualityRule(-2, 10);
        expectedQuality = 8;
        data.add(new Object[]{scenario, gildedItem, qualityRule, expectedQuality});

        //-----------------------------------
        scenario = "4. Increment.";
        //-----------------------------------
        gildedItem = new GildedItem(GildedItemType.DexterityVest , 10, 10);
        qualityRule = new QualityRule(1, 10);
        expectedQuality = 11;
        data.add(new Object[]{scenario, gildedItem, qualityRule, expectedQuality});

        //-----------------------------------
        scenario = "5. Increment past max.";
        //-----------------------------------
        gildedItem = new GildedItem(GildedItemType.DexterityVest , 10, GildedItemType.DexterityVest.getMaxQualityValue());
        qualityRule = new QualityRule(2, 10);
        expectedQuality = GildedItemType.DexterityVest.getMaxQualityValue();
        data.add(new Object[]{scenario, gildedItem, qualityRule, expectedQuality});

        //-----------------------------------
        scenario = "6. Absolute value.";
        //-----------------------------------
        gildedItem = new GildedItem(GildedItemType.DexterityVest , 10, 18);
        qualityRule = new QualityRule(200, true, 10);
        expectedQuality = 200;
        data.add(new Object[]{scenario, gildedItem, qualityRule, expectedQuality});

        return data.toArray(new Object[][]{});
    }

    
    @DataProvider(name = "QualityRuleApplicabilityVariations")
    public static Object[][] getQualityRuleApplicabilityVariations() {
        List<Object[]> data = new ArrayList<>();
        String scenario;
        int sellIn;
        int expectedQualityRuleIndex;

        List<QualityRule> qualityRules = List.of(
            new QualityRule(-1, Integer.MAX_VALUE),
            new QualityRule(-2, 10),
            new QualityRule(-3, 0)
        );

        //-----------------------------------
        scenario = "1. Highest applicable effective day.";
        //-----------------------------------
        sellIn = 11;
        expectedQualityRuleIndex = 0;
        data.add(new Object[]{scenario, qualityRules, sellIn, expectedQualityRuleIndex});

        //-----------------------------------
        scenario = "2. Middle applicable effective day.";
        //-----------------------------------
        sellIn = 10;
        expectedQualityRuleIndex = 1;
        data.add(new Object[]{scenario, qualityRules, sellIn, expectedQualityRuleIndex});

        //-----------------------------------
        scenario = "3. Lowest applicable effective day.";
        //-----------------------------------
        sellIn = 0;
        expectedQualityRuleIndex = 2;
        data.add(new Object[]{scenario, qualityRules, sellIn, expectedQualityRuleIndex});
        
        return data.toArray(new Object[][]{});
    }
 
}
