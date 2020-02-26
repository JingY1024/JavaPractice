package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Lagoon extends SaltWater {
    private final int lagoonParameter;

    public Lagoon(String name, double volume, double isSalty, int lagoonParameter) {
        super(name, volume, isSalty);
        this.lagoonParameter = lagoonParameter;
    }

    public int getLagoonParameter() {
        return lagoonParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a lagoon with parameter %d and degree of salt %.2f", lagoonParameter, super.getIsSalty());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Lagoon other = (Lagoon) otherObject;
        return lagoonParameter == other.lagoonParameter && getName().equals(other.getName()) && getVolume() == other.getVolume() && getIsSalty() == other.getIsSalty();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(lagoonParameter) + 13 * Double.hashCode(getVolume()) + 17 * Double.hashCode(getIsSalty());
    }
}
