package edu.nyu.cs9053.homework9;

import java.util.concurrent.Semaphore;

public class MyBarista implements Barista {

    private final Semaphore binarySemaphore;

    public MyBarista(Semaphore binarySemaphore) {
        this.binarySemaphore = binarySemaphore;
    }

    @Override
    public OrderNumber handle(Queue from) {
        if (from == null) {
            throw new IllegalArgumentException();
        }
        // release must be executed after acquire successfully
        try {
            binarySemaphore.acquire();
            try {
                if (!from.isEmpty()) {
                    return from.getOrderNumber();
                }
                return null;
            } finally {
                binarySemaphore.release();
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
    }
}
