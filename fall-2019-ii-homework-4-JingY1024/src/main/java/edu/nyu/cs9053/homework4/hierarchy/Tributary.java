package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Tributary extends FreshWater {
    private final int tributaryParameter;
    private final int connectedWaterBodiesCount;

    public Tributary(String name, double volume, double isSalty, int tributaryParameter, int connectedWaterBodiesCount) {
        super(name, volume, isSalty);
        this.tributaryParameter = tributaryParameter;
        this.connectedWaterBodiesCount = connectedWaterBodiesCount;
    }

    public int getTributaryParameter() {
        return tributaryParameter;
    }

    public int getConnectedWaterBodiesCount() {
        return connectedWaterBodiesCount;
    }

    @Override
    public String getDescription() {
        return String.format("a tributary with parameter %d and degree of salt %.2f", tributaryParameter, super.getIsSalty());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Tributary other = (Tributary) otherObject;
        return connectedWaterBodiesCount == other.connectedWaterBodiesCount && tributaryParameter == other.tributaryParameter && getName().equals(other.getName()) && getVolume() == other.getVolume() && getIsSalty() == other.getIsSalty();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(connectedWaterBodiesCount) + 13 * Integer.hashCode(tributaryParameter) + 17 * Double.hashCode(getVolume()) + 19 * Double.hashCode(getIsSalty());
    }
}
