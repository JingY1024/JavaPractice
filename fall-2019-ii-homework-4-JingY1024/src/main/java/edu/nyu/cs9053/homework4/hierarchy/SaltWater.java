package edu.nyu.cs9053.homework4.hierarchy;

public abstract class SaltWater extends BodyOfWater {
    private final double isSalty;

    public SaltWater(String name, double volume, double isSalty) {
        super(name, volume);
        this.isSalty = isSalty;
    }

    public double getIsSalty() {
        return isSalty;
    }

    public abstract String getDescription();

}
