package org.example;

import org.example.core.GildedItem;
import org.example.core.QualityRule;
import org.example.core.QualityRules;
import org.example.dataproviders.QualityRuleDataProviders;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class QualityRuleTests {
    
    @Test(dataProvider = "UpdateQualityVariations", dataProviderClass =  QualityRuleDataProviders.class)
    public void testQualityRuleVariations(String scenario, GildedItem gildedItem, QualityRule qualityRule, int expectedQuality) {
        QualityRules.applyQualityRule(qualityRule, gildedItem);
        Assert.assertEquals(gildedItem.getQuality(), expectedQuality, scenario);
    }

    @Test(dataProvider = "QualityRuleApplicabilityVariations", dataProviderClass = QualityRuleDataProviders.class)
    public void testQualityRuleApplicabilityVariations(String scenario, List<QualityRule> qualityRules, int sellIn, int expectedQualityRuleIndex) {
        QualityRule actualQualityRule = QualityRules.getMostApplicableQuallityRule(qualityRules, sellIn);
        Assert.assertEquals(actualQualityRule, qualityRules.get(expectedQualityRuleIndex), scenario);
    }

}
