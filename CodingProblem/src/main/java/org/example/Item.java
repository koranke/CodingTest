package org.example;

public class Item
{
    private String name;
    private int sellIn;
    private int quality;

    public Item(String name, int sellIn, int quality)
    {
        setName(name);
        setSellIn(sellIn);
        setQuality(quality);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getSellIn() { return sellIn; }
    public void setSellIn(int sellIn) { this.sellIn = sellIn; }

    public int getQuality() { return quality; }
    public void setQuality(int quality) { this.quality = quality; }
}