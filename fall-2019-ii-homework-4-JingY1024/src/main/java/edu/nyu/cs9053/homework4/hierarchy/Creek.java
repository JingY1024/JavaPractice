package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Creek extends FreshWater {
    private final int creekParameter;
    private final double flow;

    public Creek(String name, double volume, double isSalty, int creekParameter, double flow) {
        super(name, volume, isSalty);
        this.creekParameter = creekParameter;
        this.flow = flow;
    }

    public int getCreekParameter() {
        return creekParameter;
    }

    public double getFlow() {
        return flow;
    }

    @Override
    public String getDescription() {
        return String.format("a creek with parameter %d and degree of salt %.2f", creekParameter, super.getIsSalty());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Creek other = (Creek) otherObject;
        return flow == other.flow && creekParameter == other.creekParameter && getName().equals(other.getName()) && getVolume() == other.getVolume() && getIsSalty() == other.getIsSalty();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Double.hashCode(flow) + 13 * Integer.hashCode(creekParameter) + 17 * Double.hashCode(getVolume()) + 19 * Double.hashCode(getIsSalty());
    }
}
