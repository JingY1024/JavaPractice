package edu.nyu.cs9053.homework5;

public class PotRoast implements Recipe, RecipeReadyCallback {

    private static final int VOLUME_CUBIC_INCHES = 10000;

    private Double remainingSecondsUntilDone;

    private Oven oven;

    private int ovenTemperature;

    @Override
    public void initializeFromOven(Oven oven) {
        this.oven = oven;
        ovenTemperature = oven.getSetTemperature();
        remainingSecondsUntilDone = (double) ovenTemperature / 5 * 60;
    }

    @Override
    public int getVolumeCubicInches() {
        return VOLUME_CUBIC_INCHES;
    }

    @Override
    public Double getRemainingSecondsUntilDone() {
        return remainingSecondsUntilDone;
    }

    @Override
    public void adjust(Time unit, int amount, int ovenTemperature) {
        if (unit == Time.Seconds) remainingSecondsUntilDone -= amount;
        else remainingSecondsUntilDone -= amount * 60;
        this.ovenTemperature = ovenTemperature;
    }

    @Override
    public boolean isRecipeDone() {
        return (remainingSecondsUntilDone <= 0);
    }

    @Override
    public void recipeReadyToCook(Recipe recipe) {

    }
}
