package edu.nyu.cs9053.homework7;

import java.util.Objects;

public class bambooRat implements Animal{
    private final String name;

    bambooRat(String name){
        this.name = name;
    }

    @Override
    public String getName(){
        return name;
    }

    @Override
    public boolean equals(Object otherObject) {
        if (this == otherObject) return true;
        if (otherObject == null) return false;
        if (getClass() != otherObject.getClass()) return false;
        bambooRat other = (bambooRat) otherObject;
        if (name == null) {
            throw new NullPointerException();
        }
        return getName().equals(other.getName()) ;
    }

    @Override
    public int hashCode() {
        if (name == null) {
            throw new NullPointerException();
        }
        return 7 * Objects.hashCode(name);
    }
}
