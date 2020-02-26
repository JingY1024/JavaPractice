package edu.nyu.cs9053.homework8;

public enum ValidTextKeyPress {

    Two("abcABC"),

    Three("defDEF"),

    Four("ghiGHI"),

    Five("jklJKL"),

    Six("mnoMNO"),

    Seven("pqrsPQRS"),

    Eight("tuvTUV"),

    Nine("wxyzWXYZ");

    private final String validText;

    // in enum the constructor is private, which means the enum only allows the outside caller use the constructor it
    // has defined (Two - Nine).
    ValidTextKeyPress(String validText) {
        this.validText = validText;
    }

    public String getText() {
        return this.validText;
    }
}
