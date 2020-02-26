package edu.nyu.cs9053.homework3;

import edu.nyu.cs9053.homework3.metadata.Processor;

/**
 * User: blangel
 */
public class FixMe {

    private static final String DEFAULT_METADATA = "Frank";
    private final String name;
    private final String metadata;

    public FixMe(String name) {
        this(name, DEFAULT_METADATA);
    }

    public FixMe(String name, String metadata) {
        this.name = name;
        this.metadata = new Processor(true).processMetadata(metadata);
    }

    public FixMe changeName(String name) {
        return new FixMe(name, this.metadata);
    }

    public FixMe changeNameVerbose(String firstName, String lastName) {
        return new FixMe(nameCombiner(firstName, lastName), metadata);
    }

    private String nameCombiner(String firstName, String lastName) {
        return String.format("%s %s", firstName, lastName);
    }

    public String getName() {
        return name;
    }

}
