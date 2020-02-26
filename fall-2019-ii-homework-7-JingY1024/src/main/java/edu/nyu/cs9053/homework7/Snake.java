package edu.nyu.cs9053.homework7;


import java.util.Collection;

public class Snake extends AbstractReptile {
    private final String name;
    private final Boolean breathUnderWater;

    Snake(String name, Boolean breathUnderWater) {
        this.name = name;
        this.breathUnderWater = breathUnderWater;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public Boolean canBreathUnderWater() {
        return breathUnderWater;
    }

    @Override
    public Boolean isSlimy() {
        return true;
    }

    public String getSubSpecies() {
        return "Cobra";
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        Snake other = (Snake) otherObject;
        if (name == null || breathUnderWater == null) {
            throw new NullPointerException();
        }
        return getName().equals(other.getName()) && canBreathUnderWater().equals(other.canBreathUnderWater());
    }

    @Override
    public int hashCode() {
        if (name == null || breathUnderWater == null) {
            throw new NullPointerException();
        }
        return 7 * name.hashCode() + 11 * Boolean.hashCode(breathUnderWater);
    }

    public static <T extends Reptile> void copy(Collection<? extends T> sourceReptile, Collection<? super T> targetReptile) {
        if (sourceReptile == null || targetReptile == null) {
            throw new NullPointerException();
        }
        targetReptile.addAll(sourceReptile);
    }
}
