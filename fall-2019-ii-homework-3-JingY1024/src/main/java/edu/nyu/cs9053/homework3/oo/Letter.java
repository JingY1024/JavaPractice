package edu.nyu.cs9053.homework3.oo;

import java.io.PrintStream;

public class Letter {

    private final char[][] asciiVerbose;
    private final PrintStream out;

    public Letter(char[][] asciiVerbose, PrintStream out) {
        this.asciiVerbose = asciiVerbose;
        this.out = out;
    }

    public void print() {
        for (int i = 0; i < 10; i++){
            out.println(asciiVerbose[i]);
        }
    }
}
