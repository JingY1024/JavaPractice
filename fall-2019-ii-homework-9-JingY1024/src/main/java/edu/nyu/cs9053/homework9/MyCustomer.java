package edu.nyu.cs9053.homework9;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class MyCustomer implements Customer {

    private final Semaphore binarySemaphore;
    private final Random random;

    public MyCustomer(Semaphore binarySemaphore) {
        this.binarySemaphore = binarySemaphore;
        this.random = new Random();
    }

    public OrderNumber order(Queue queue) {
        if (queue == null) {
            throw new IllegalArgumentException();
        }
        // release must be executed after acquire successfully
        try {
            binarySemaphore.acquire();
            try {
                if (!queue.full()) {
                    return queue.addOrder(randomCoffeeDrink());
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

    private CoffeeDrink randomCoffeeDrink() {
        List<CoffeeDrink> randomCoffeeDrink = new ArrayList<>(3);
        randomCoffeeDrink.add(new IcedBlackTea(true, true));
        randomCoffeeDrink.add(new IcedGreenTea(true, true));
        randomCoffeeDrink.add(new IcedMatchaGreenTeaLatte(true, true));
        return randomCoffeeDrink.get(random.nextInt(3));
    }
}
