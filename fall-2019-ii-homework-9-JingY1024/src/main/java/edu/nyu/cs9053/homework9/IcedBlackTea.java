package edu.nyu.cs9053.homework9;

public class IcedBlackTea implements CoffeeDrink {

    private final boolean isDecaf;
    private final boolean containsMilk;

    public IcedBlackTea(boolean isDecaf, boolean containsMilk) {
        this.isDecaf = isDecaf;
        this.containsMilk = containsMilk;
    }

    @Override
    public boolean isDecaf() {
        return isDecaf;
    }

    @Override
    public boolean containsMilk() {
        return containsMilk;
    }

}
