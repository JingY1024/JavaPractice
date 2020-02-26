package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Tarn extends FreshWater {
    private final int tarnParameter;

    public Tarn(String name, double volume, double isSalty, int tarnParameter) {
        super(name, volume, isSalty);
        this.tarnParameter = tarnParameter;
    }

    public int getTarnParameter() {
        return tarnParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a tarn with parameter %d and degree of salt %.2f", tarnParameter, super.getIsSalty());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Tarn other = (Tarn) otherObject;
        return tarnParameter == other.tarnParameter && getName().equals(other.getName()) && getVolume() == other.getVolume() && getIsSalty() == other.getIsSalty();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(tarnParameter) + 13 * Double.hashCode(getVolume()) + 17 * Double.hashCode(getIsSalty());
    }
}
