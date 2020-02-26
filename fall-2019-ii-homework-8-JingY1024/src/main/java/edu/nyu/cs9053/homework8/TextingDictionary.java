package edu.nyu.cs9053.homework8;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class TextingDictionary {

    private final AtomicReference<ArrayList<String>> dictionaryReference;

    // notice the initialization of AtomicReference here.
    public TextingDictionary() {
        this.dictionaryReference = new AtomicReference<>(new ArrayList<String>());
    }

    private void inputTest(String word) {
        if (word == null || word.isEmpty()) {
            throw new IllegalArgumentException();
        }
        for (char element : word.toCharArray()) {
            if (!((element >= 'a' && element <= 'z') || (element >= 'A' && element <= 'Z'))) {
                throw new IllegalArgumentException();
            }
        }
    }

    // to populate into the dictionary of possible results
    public void insert(String word) {
        inputTest(word);
        dictionaryReference.get().add(word);
    }

    // deep copy method, seems work
    private static <T> List<T> deepCopy(List<T> src) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
        ObjectOutputStream out = new ObjectOutputStream(byteOut);
        out.writeObject(src);

        ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
        ObjectInputStream in = new ObjectInputStream(byteIn);
        @SuppressWarnings("unchecked")
        List<T> dest = (List<T>) in.readObject();
        return dest;
    }


    // given an ordered list of valid key-press values returns a list of words or empty if none found
    // can apply binary search here to improve the speed
    public List<String> search(List<ValidTextKeyPress> prefixes) throws IOException, ClassNotFoundException {
        if (prefixes == null) throw new NullPointerException();
        List<String> result = TextingDictionary.deepCopy(dictionaryReference.get());
        return searchHelper(result, prefixes, 0);
    }

    private List<String> searchHelper(List<String> result, List<ValidTextKeyPress> prefixes, int index) {
        if (index == prefixes.size()) {
            return result;
        }
        if (result.size() == 0) {
            return result;
        }
        Iterator<String> iter = result.iterator();
        while (iter.hasNext()) {
            String val = iter.next();
            boolean ifExist = false;
            for (char chr : prefixes.get(index).getText().toCharArray())
                if (val.charAt(index) == chr) {
                    ifExist = true;
                    break;
                }
            if (!ifExist) {
                iter.remove();
            }
        }
        return searchHelper(result, prefixes, index + 1);
    }

}
