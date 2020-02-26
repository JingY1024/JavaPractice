package edu.nyu.cs9053.homework7;


public interface Reptile {
    abstract String getName();

    abstract Boolean canBreathUnderWater();

    static String randomNameGenerator(Reptile reptile) {
        int key = reptile.hashCode() % 100;
        return key + "";
    }

    default Boolean isSlimy() {
        throw new UnsupportedOperationException();
    }
}
