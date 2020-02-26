package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Spring extends FreshWater {
    private final int springParameter;

    public Spring(String name, double volume, double isSalty, int springParameter) {
        super(name, volume, isSalty);
        this.springParameter = springParameter;
    }

    public int getSpringParameter() {
        return springParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a spring with parameter %d and degree of salt %.2f", springParameter, super.getIsSalty());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Spring other = (Spring) otherObject;
        return springParameter == other.springParameter && getName().equals(other.getName()) && getVolume() == other.getVolume() && getIsSalty() == other.getIsSalty();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(springParameter) + 13 * Double.hashCode(getVolume()) + 17 * Double.hashCode(getIsSalty());
    }
}
