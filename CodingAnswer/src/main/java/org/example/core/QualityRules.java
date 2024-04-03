package org.example.core;

import org.example.enums.GildedItemType;

import java.util.List;
import java.util.stream.Collectors;

public class QualityRules {
    
    public static QualityRule getMostApplicableQuallityRule(List<QualityRule> qualityRules, int sellIn) {
        //sort rules by effective day asc
        List<QualityRule> sortedItems = qualityRules.stream()
            .sorted((item1, item2) -> item1.getEffectiveDayStart().compareTo(item2.getEffectiveDayStart()))
            .toList();

        //get lowest effective day rule based on sellIn value
        QualityRule qualityRule = sortedItems.stream()
            .filter(item -> item.getEffectiveDayStart() >= sellIn)
            .findFirst().orElse(null);

        //if none found, use last rule (max effective day)
        if (qualityRule == null) {
            qualityRule = sortedItems.get(sortedItems.size() - 1);
        }
        return qualityRule;
    }

    public static void applyQualityRule(QualityRule qualityRule, GildedItem gildedItem) {
        if (qualityRuleIsApplicable(qualityRule, gildedItem.getSellIn())) {
            int adjustment = qualityRule.getAdjustment();
            GildedItemType gildedItemType = gildedItem.getGildedItemType();
            if (qualityRule.isAbsoluteValue()) {
                gildedItem.setQuality(adjustment);
            } else {
                gildedItem.setQuality(gildedItem.getQuality() + adjustment);

                //adjust quality if over max or under min
                if (adjustment > 0 && gildedItem.getQuality() > gildedItemType.getMaxQualityValue()) {
                    gildedItem.setQuality(gildedItemType.getMaxQualityValue());
                } else if (adjustment < 0 && gildedItem.getQuality() < gildedItemType.getMinQualityValue()) {
                    gildedItem.setQuality(gildedItemType.getMinQualityValue());
                }
            }
        }
    }

    private static boolean qualityRuleIsApplicable(QualityRule qualityRule, int sellIn) {
        return qualityRule.getEffectiveDayStart() >= sellIn;
    }

}
