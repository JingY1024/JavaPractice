package edu.nyu.cs9053.homework7;

public class bambooRatArrayCreator implements ArrayCreator<bambooRat> {
    @Override
    public bambooRat[] create(int size) {
        return new bambooRat[size];
    }
}
