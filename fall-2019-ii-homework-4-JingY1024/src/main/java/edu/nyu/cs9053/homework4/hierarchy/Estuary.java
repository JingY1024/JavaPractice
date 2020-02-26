package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Estuary extends SaltWater {
    private final int estuaryParameter;

    public Estuary(String name, double volume, double isSalty, int estuaryParameter) {
        super(name, volume, isSalty);
        this.estuaryParameter = estuaryParameter;
    }

    public int getEstuaryParameter() {
        return estuaryParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a estuary with parameter %d and degree of salt %.2f", estuaryParameter, super.getIsSalty());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Estuary other = (Estuary) otherObject;
        return estuaryParameter == other.estuaryParameter && getName().equals(other.getName()) && getVolume() == other.getVolume() && getIsSalty() == other.getIsSalty();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(estuaryParameter) + 13 * Double.hashCode(getVolume()) + 17 * Double.hashCode(getIsSalty());
    }
}
