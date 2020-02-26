package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Sea extends SaltWater {
    private final int seaParameter;

    public Sea(String name, double volume, double isSalty, int seaParameter) {
        super(name, volume, isSalty);
        this.seaParameter = seaParameter;
    }

    public int getSeaParameter() {
        return seaParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a sea with parameter %d and degree of salt %.2f", seaParameter, super.getIsSalty());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Sea other = (Sea) otherObject;
        return seaParameter == other.seaParameter && getName().equals(other.getName()) && getVolume() == other.getVolume() && getIsSalty() == other.getIsSalty();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(seaParameter) + 13 * Double.hashCode(getVolume()) + 17 * Double.hashCode(getIsSalty());
    }
}
