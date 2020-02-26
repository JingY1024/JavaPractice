package edu.nyu.cs9053.homework10;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * User: blangel
 */
public class ModernFortification extends AbstractFortification implements Fortification<ExecutorService> {
    private final ExecutorService executor;
    private final AtomicInteger running;
    private final BlockingQueue<Runnable> queue;

    public ModernFortification(final int concurrencyFactor) {
        super(concurrencyFactor);
        executor = Executors.newFixedThreadPool(concurrencyFactor);
        running = new AtomicInteger(0);
        queue = new LinkedBlockingQueue<>();
        new Thread(new Runnable() {
            public void run() {
                while (!Thread.currentThread().isInterrupted()) {
                    if (running.get() < getConcurrencyFactor()) {
                        synchronized (ModernFortification.class) {
                            if (!queue.isEmpty()) {
                                running.incrementAndGet();
                                executor.submit(queue.poll());
                            }
                        }
                    } else {
                        try {
                            Thread.sleep(100L);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }).start();
    }

    @Override
    public void handleAttack(AttackHandler handler) {
        if (running.get() < getConcurrencyFactor()) {
            running.incrementAndGet();
            executor.submit(new Runnable() {
                public void run() {
                    handler.soldiersReady();
                    running.decrementAndGet();
                }
            });
        } else {
            queue.offer(new Runnable() {
                public void run() {
                    handler.soldiersReady();
                    running.decrementAndGet();
                }
            });
        }
    }

    @Override
    public void surrender() {
        executor.shutdownNow();
    }
}
