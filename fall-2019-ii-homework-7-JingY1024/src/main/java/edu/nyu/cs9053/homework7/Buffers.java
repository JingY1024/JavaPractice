package edu.nyu.cs9053.homework7;

import java.nio.ByteBuffer;

public class Buffers {
    public void read(ByteBuffer buffer) {
        while (buffer.hasRemaining()) {
            System.out.printf("%d", buffer.get());
        }
    }

    public void move1(ByteBuffer buffer) {
        buffer.flip();
    }

    public void move2(ByteBuffer buffer) {
        buffer.clear();
    }
}
