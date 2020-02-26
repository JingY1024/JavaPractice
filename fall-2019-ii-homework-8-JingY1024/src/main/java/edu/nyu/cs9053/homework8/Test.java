package edu.nyu.cs9053.homework8;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Test {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        TextingDictionary dictionary = new TextingDictionary();
        dictionary.insert("Brian");
        dictionary.insert("brain");
        dictionary.insert("braid");
        List<ValidTextKeyPress> prefix1 = new LinkedList<>();
        prefix1.add(ValidTextKeyPress.Two);
        prefix1.add(ValidTextKeyPress.Seven);
        List<String> result1 = dictionary.search(prefix1);
        List<ValidTextKeyPress> prefix2 = new LinkedList<>();
        prefix2.add(ValidTextKeyPress.Two);
        prefix2.add(ValidTextKeyPress.Seven);
        prefix2.add(ValidTextKeyPress.Two);
        List<String> result2 = dictionary.search(prefix2);
        List<ValidTextKeyPress> prefix3 = new LinkedList<>();
        prefix3.add(ValidTextKeyPress.Two);
        prefix3.add(ValidTextKeyPress.Eight);
        List<String> result3 = dictionary.search(prefix3);
        dictionary.insert("butte");
        List<String> result4 = dictionary.search(prefix3);
    }
}
