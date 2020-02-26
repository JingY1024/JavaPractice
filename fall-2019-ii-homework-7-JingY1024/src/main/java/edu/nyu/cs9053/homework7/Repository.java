package edu.nyu.cs9053.homework7;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Repository<T> implements ArrayCreator {
    public static final int DEFAULT_SIZE = 10;
    private final AtomicInteger size;
    private final AtomicReference<T[]> arrayReference;
    private final ArrayCreator<T> arrayCreator;

    public Repository(ArrayCreator<T> arrayCreator) { this(arrayCreator, DEFAULT_SIZE); }

    // ArrayCreator is used for doubling the size of the repository when size reaches maximum.
    Repository(ArrayCreator<T> arrayCreator, int initNumber) {
        this.arrayCreator = arrayCreator;
        this.size = new AtomicInteger(0);
        this.arrayReference = new AtomicReference<>();
        this.arrayReference.set(arrayCreator.create(initNumber));
    }

    @Override
    public T[] create(int size) { // cast means using generic not correctly
        T[] result = (T[]) new Object[size];
        return result;
    }

    public boolean contains(T rat) {
        if (rat == null) {
            return false;
        }
        for (int i = 0; i < size.get(); i++) {
            if (arrayReference.get()[i].equals(rat)) {
                return true;
            }
        }
        return false;
    }

    public boolean add(T rat) {
        if (rat == null) {
            throw new NullPointerException();
            /*
            Notes for exception:
                for unchecked exception (runtime exception), not necessary to throw or try/catch,
                here we throw the exception and it would be better
                for checked exception (IO exception), must be thrown or use try/catch.
                Unchecked exception can be understood as exceptions created by programmers, which
                can be avoided when coding.
             */
        }
        if (this.contains(rat)) {
            return false;
        } else {
            int arrayLength = this.arrayReference.get().length;
            if (size.get() >= arrayLength) {
                T[] newRepository = arrayCreator.create(arrayLength * 2);
                java.lang.System.arraycopy(this.arrayReference.get(), 0, newRepository, 0, arrayLength);
                this.arrayReference.set(newRepository);
            }
            arrayReference.get()[size.get()] = rat;
            size.set(size.get() + 1);
            return true;
        }
    }

    public boolean remove(T rat) {
        if (!this.contains(rat) || rat == null) {
            return false;
        } else {
            int index = -1;
            for (int i = 0; i < size.get(); i++) {
                if (arrayReference.get()[i].equals(rat)) {
                    index = i;
                    break;
                }
            }
            for (int i = index; i < size.get() - 1; i++) {
                // does it work?
                arrayReference.get()[i] = arrayReference.get()[i + 1];
            }
            arrayReference.get()[size.get() - 1] = null;
            size.set(size.get() - 1);
            return true;
        }
    }

    public T get(int index) {
        if (index < 0 || index >= size.get()) {
            return null;
        } else {
            return arrayReference.get()[index];
        }
    }

    public int size() { return size.get(); }

}
