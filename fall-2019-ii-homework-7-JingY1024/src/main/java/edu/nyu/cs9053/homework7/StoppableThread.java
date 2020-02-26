package edu.nyu.cs9053.homework7;

public class StoppableThread {

    private final Thread thread;

    public StoppableThread(final Runnable runnable) {
        Runnable wrapper = () -> {
            while (!Thread.currentThread().isInterrupted()) {
                System.out.print("Thread is running");
            }
        };
        this.thread = new Thread(wrapper);
    }

    public void start() {
        thread.start();
    }

    public void stop() {
        Thread.currentThread().interrupt();
    }
}
