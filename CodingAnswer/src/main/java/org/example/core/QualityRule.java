package org.example.core;

public class QualityRule {
    private int adjustment;
    private boolean absoluteValue;
    private int effectiveDayStart;
 
    public QualityRule(int adjustment, Integer effectiveDayStart) {
        this.adjustment = adjustment;
        this.effectiveDayStart = effectiveDayStart;
        this.setAbsoluteValue(false);
    }
    public QualityRule(int adjustment, boolean absoluteValue, Integer effectiveDayStart) {
        this.adjustment = adjustment;
        this.effectiveDayStart = effectiveDayStart;
        this.setAbsoluteValue(absoluteValue);
    }
    public int getAdjustment() {
        return adjustment;
    }
    public void setAdjustment(int adjustment) {
        this.adjustment = adjustment;
    }
    public boolean isAbsoluteValue() {
        return absoluteValue;
    }
    public void setAbsoluteValue(boolean absoluteValue) {
        this.absoluteValue = absoluteValue;
    }
    public Integer getEffectiveDayStart() {
        return effectiveDayStart;
    }
    public void setEffectiveDayStart(Integer effectiveDayStart) {
        this.effectiveDayStart = effectiveDayStart;
    }
}
