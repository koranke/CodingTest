package org.example.core;

import org.example.enums.ErrorType;
import org.example.enums.GildedItemType;

public class GildedItem extends Item {
    private GildedItemType gildedItemType;

    public GildedItem(GildedItemType gildedItemType, int sellIn, int quality) {
        super(gildedItemType.getItemName(), sellIn, quality);
        this.gildedItemType = gildedItemType;
    }

    public void decrementSellIn() throws Exception {
        if (getSellIn() == Integer.MIN_VALUE) {
            throw new Exception(ErrorType.MinValueError.getMessage());
        }
        this.setSellIn(getSellIn() - 1);
    }

    public void updateQuality() {
        if (isFixedQuality(this.gildedItemType)) {
            this.setQuality(this.gildedItemType.getMinQualityValue());
        } else {
            QualityRule qualityRule = QualityRules.getMostApplicableQuallityRule(this.gildedItemType.getQualityRules(), this.getSellIn());
            QualityRules.applyQualityRule(qualityRule, this);
        }
    }

    private boolean isFixedQuality(GildedItemType gildedItemType) {
            return gildedItemType.getQualityRules() == null || gildedItemType.getQualityRules().size() == 0;
    }

    public GildedItemType getGildedItemType() {
        return gildedItemType;
    }

    public void setGildedItemType(GildedItemType gildedItemType) {
        this.gildedItemType = gildedItemType;
    }

    public void print() {
        System.out.printf("Item: %s - SellIn: %d - Quality: %d.\n", this.getName(), this.getSellIn(), this.getQuality());
    }
}
