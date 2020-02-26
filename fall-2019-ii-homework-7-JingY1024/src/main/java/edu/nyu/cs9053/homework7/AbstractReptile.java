package edu.nyu.cs9053.homework7;

public abstract class AbstractReptile implements Reptile {
    protected String name;
    protected Boolean breathUnderWater;

    abstract String getSubSpecies();
}
