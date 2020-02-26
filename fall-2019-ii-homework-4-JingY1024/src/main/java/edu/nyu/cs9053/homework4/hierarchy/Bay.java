package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Bay extends BodyOfWater {

    private final int bayParameter;

    public Bay(String name, double volume, int bayParameter) {
        super(name, volume);
        this.bayParameter = bayParameter;
    }

    public int getBayParameter() {
        return bayParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a bay with parameter %d", bayParameter);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Bay other = (Bay) otherObject;
        return bayParameter == other.bayParameter && getName().equals(other.getName()) && getVolume() == other.getVolume();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(bayParameter) + 13 * Double.hashCode(getVolume());
    }

}
