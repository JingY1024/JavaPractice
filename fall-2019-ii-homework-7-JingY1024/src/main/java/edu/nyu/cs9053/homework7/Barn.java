package edu.nyu.cs9053.homework7;

public class Barn<T extends Animal> extends Repository<T> {
    Barn(ArrayCreator<T> arrayCreator, int size) {
        super(arrayCreator, size);
    }
}
