package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Gulf extends BodyOfWater {
    private final int gulfParameter;

    public Gulf(String name, double volume, int gulfParameter) {
        super(name, volume);
        this.gulfParameter = gulfParameter;
    }

    public int getGulfParameter() {
        return gulfParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a gulf with parameter %d", gulfParameter);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Gulf other = (Gulf) otherObject;
        return gulfParameter == other.gulfParameter && getName().equals(other.getName()) && getVolume() == other.getVolume();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(gulfParameter) + 13 * Double.hashCode(getVolume());
    }
}
