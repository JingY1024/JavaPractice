package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Puddle extends BodyOfWater {
    private final int puddleParameter;

    public Puddle(String name, double volume, int puddleParameter) {
        super(name, volume);
        this.puddleParameter = puddleParameter;
    }

    public int getPuddleParameter() {
        return puddleParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a puddle with parameter %d", puddleParameter);
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Puddle other = (Puddle) otherObject;
        return puddleParameter == other.puddleParameter && getName().equals(other.getName()) && getVolume() == other.getVolume();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(puddleParameter) + 13 * Double.hashCode(getVolume());
    }
}
