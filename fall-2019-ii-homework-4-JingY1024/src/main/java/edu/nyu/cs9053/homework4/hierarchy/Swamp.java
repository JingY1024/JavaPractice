package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Swamp extends BodyOfWater {
    private final int swampParameter;

    public Swamp(String name, double volume, int swampParameter) {
        super(name, volume);
        this.swampParameter = swampParameter;
    }

    public int getSwampParameter() {
        return swampParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a swamp with parameter %d", swampParameter);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Swamp other = (Swamp) otherObject;
        return swampParameter == other.swampParameter && getName().equals(other.getName()) && getVolume() == other.getVolume();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(swampParameter) + 13 * Double.hashCode(getVolume());
    }
}
