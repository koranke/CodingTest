package org.example.enums;

import org.example.core.QualityRule;

import java.util.List;

public enum GildedItemType {

    DexterityVest("+5 Dexterity Vest", 
        List.of(
            new QualityRule(-1, Integer.MAX_VALUE),
            new QualityRule(-2, -1)
            ),
        50,
        0
    ),
    ElixirMongoose("Elixir of the Mongoose", 
        List.of(
            new QualityRule(-1, Integer.MAX_VALUE),
            new QualityRule(-2, -1)
            ),
        50,
        0
    ),
    ConjuredManaCake("Conjured Mana Cake", 
        List.of(
            new QualityRule(-2, Integer.MAX_VALUE),
            new QualityRule(-4, -1)
            ),
        50,
        0
    ),
    AgedBrie("Aged Brie",
    List.of(
        new QualityRule(1, Integer.MAX_VALUE)
        ),
    50,
    0
    ),
    TAFKAL80ETCConcert("Backstage passes to a TAFKAL80ETC concert",
    List.of(
        new QualityRule(1, Integer.MAX_VALUE),
        new QualityRule(2, 10),
        new QualityRule(3, 5),
        new QualityRule(0, true, -1)
        ),
    50,
    0
    ),
    Sulfuras("Sulfuras, Hand of Ragnaros",
null,
    80,
    80
    )
    ;

    private final String itemName;
    private final List<QualityRule> qualityRules;
    private final int maxQualityValue;
    private final int minQualityValue;

    GildedItemType(String itemName, List<QualityRule> qualityRules, int maxQualityValue, int minQualityValue) {
        this.itemName = itemName;
        this.qualityRules = qualityRules;
        this.maxQualityValue = maxQualityValue;
        this.minQualityValue = minQualityValue;
    }

    public String getItemName() {
        return this.itemName;
    }

    public List<QualityRule> getQualityRules() {
        return qualityRules;
    }

    public int getMaxQualityValue() {
        return maxQualityValue;
    }

    public int getMinQualityValue() {
        return minQualityValue;
    }
}