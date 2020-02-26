package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Brook extends FreshWater {
    private final int brookParameter;

    public Brook(String name, double volume, double isSalty, int brookParameter) {
        super(name, volume, isSalty);
        this.brookParameter = brookParameter;
    }

    public int getBrookParameter() {
        return brookParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a brook with parameter %d and degree of salt %.2f", brookParameter, super.getIsSalty());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Brook other = (Brook) otherObject;
        return brookParameter == other.brookParameter && getName().equals(other.getName()) && getVolume() == other.getVolume() && getIsSalty() == other.getIsSalty();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(brookParameter) + 13 * Double.hashCode(getVolume()) + 17 * Double.hashCode(getIsSalty());
    }
}
