package edu.nyu.cs9053.homework4.hierarchy;

import java.util.Objects;

public class Stream extends FreshWater {
    private final int streamParameter;

    public Stream(String name, double volume, double isSalty, int streamParameter) {
        super(name, volume, isSalty);
        this.streamParameter = streamParameter;
    }

    public int getStreamParameter() {
        return streamParameter;
    }

    @Override
    public String getDescription() {
        return String.format("a stream with parameter %d and degree of salt %.2f", streamParameter, super.getIsSalty());
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Stream other = (Stream) otherObject;
        return streamParameter == other.streamParameter && getName().equals(other.getName()) && getVolume() == other.getVolume() && getIsSalty() == other.getIsSalty();
    }

    @Override
    public int hashCode() {
        return 7 * Objects.hashCode(getName()) + 11 * Integer.hashCode(streamParameter) + 13 * Double.hashCode(getVolume()) + 17 * Double.hashCode(getIsSalty());
    }
}
