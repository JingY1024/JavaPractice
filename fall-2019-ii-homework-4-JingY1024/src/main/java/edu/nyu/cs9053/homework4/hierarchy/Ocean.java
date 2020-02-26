package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Ocean extends SaltWater {
    private final int oceanParameter;

    public Ocean(String name, double volume, double isSalty, int oceanParameter) {
        super(name, volume, isSalty);
        this.oceanParameter = oceanParameter;
    }

    public int getOceanParameter() {
        return oceanParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a ocean with parameter %d and degree of salt %.2f", oceanParameter, super.getIsSalty());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Ocean other = (Ocean) otherObject;
        return oceanParameter == other.oceanParameter && getName().equals(other.getName()) && getVolume() == other.getVolume() && getIsSalty() == other.getIsSalty();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(oceanParameter) + 13 * Double.hashCode(getVolume()) + 17 * Double.hashCode(getIsSalty());
    }
}
