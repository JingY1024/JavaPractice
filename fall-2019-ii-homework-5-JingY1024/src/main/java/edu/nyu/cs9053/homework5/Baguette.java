package edu.nyu.cs9053.homework5;

import java.security.PublicKey;
import java.util.concurrent.atomic.AtomicReference;

public class Baguette implements Recipe, RecipeReadyCallback {
    // could have used RecipeReadyCallback anonymously

    private static final int VOLUME_CUBIC_INCHES = 2000;

    private final AtomicReference<Double> remainingSecondsUntilDone;

    private final Oven oven;

    private int ovenTemperature;

    public Baguette(Oven oven,  int ovenTemperature) {
        this.oven = oven;
        this.remainingSecondsUntilDone = new AtomicReference<Double>(1200d);
        this.ovenTemperature = ovenTemperature;
    }

    @Override
    public void initializeFromOven(Oven oven) {
        // check oven for null
    }

    @Override
    public int getVolumeCubicInches() {
        return VOLUME_CUBIC_INCHES;
    }

    @Override
    public Double getRemainingSecondsUntilDone() {
        return remainingSecondsUntilDone.get();
    }

    @Override
    public void adjust(Time unit, int amount, int ovenTemperature) {
        if (unit == Time.Seconds) {
            remainingSecondsUntilDone.set(remainingSecondsUntilDone.get() - amount);
        }
        else {
            remainingSecondsUntilDone.set(remainingSecondsUntilDone.get() - amount * 60);
        }
        this.ovenTemperature = ovenTemperature;
    }

    @Override
    public boolean isRecipeDone() {
        return (remainingSecondsUntilDone.get() <= 0);
    }

    @Override
    public void recipeReadyToCook(Recipe recipe) {
        // this method puts the recipe in oven to cook using an anonymous inner class for Timer
    }
}
