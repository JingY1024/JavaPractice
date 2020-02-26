package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Lake extends FreshWater {
    private final int lakeParameter;

    public Lake(String name, double volume, double isSalty, int lakeParameter) {
        super(name, volume, isSalty);
        this.lakeParameter = lakeParameter;
    }

    public int getLakeParameter() {
        return lakeParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a lake with parameter %d and degree of salt %.2f", lakeParameter, super.getIsSalty());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Lake other = (Lake) otherObject;
        return lakeParameter == other.lakeParameter && getName().equals(other.getName()) && getVolume() == other.getVolume() && getIsSalty() == other.getIsSalty();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(lakeParameter) + 13 * Double.hashCode(getVolume()) + 17 * Double.hashCode(getIsSalty());
    }
}
