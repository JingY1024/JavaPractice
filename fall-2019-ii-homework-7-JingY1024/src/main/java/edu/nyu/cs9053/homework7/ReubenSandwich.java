package edu.nyu.cs9053.homework7;

public class ReubenSandwich {

    private final String pastrami;
    private final String bread;

    public ReubenSandwich(String pastrami, String bread) {
        this.pastrami = pastrami;
        this.bread = bread;
    }

    public String getSandwich() {
        return String.format("%s%s%s", bread, pastrami, bread);
    }
}
