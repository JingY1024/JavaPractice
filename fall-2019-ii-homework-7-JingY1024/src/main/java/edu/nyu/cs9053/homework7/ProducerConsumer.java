package edu.nyu.cs9053.homework7;

import java.util.concurrent.Semaphore;

public class ProducerConsumer {

    private int index;

    private final int size;

    private final Object[] work;

    private final Semaphore binarySemaphore;

    public ProducerConsumer(int size, Semaphore binarySemaphore) {
        this.binarySemaphore = binarySemaphore;
        this.size = size;
        this.work = new Object[size];
        this.index = 0;
    }

    public void add(Object work) {
        if (work == null) {
            throw new IllegalArgumentException();
        }
        // release must be executed after acquire successfully
        try {
            binarySemaphore.acquire();
            try {
                if (index < size) {
                    index++;
                }
            } finally {
                binarySemaphore.release();
            }
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(ie);
        }
    }

    public Object remove() {
        // release must be executed after acquire successfully
        try {
            binarySemaphore.acquire();
            try {
                if (index > 0) {
                    index--;
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
