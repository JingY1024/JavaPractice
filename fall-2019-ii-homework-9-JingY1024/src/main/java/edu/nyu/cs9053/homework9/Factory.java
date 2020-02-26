package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

/**
 * User: blangel
 */
public class Factory {

    private final static Semaphore BinarySemaphore = new Semaphore(1);

    public static Customer createCustomer() {
        return new MyCustomer(BinarySemaphore);
    }

    public static Barista createBarista() {
        return new MyBarista(BinarySemaphore);
    }
}
