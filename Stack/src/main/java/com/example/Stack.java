package com.example;

import java.util.ArrayList;
import java.util.List;

public class Stack {

    private final List<Integer> elements = new ArrayList<>();

    public boolean isEmpty() {

        if (elements.size() == 0) {
            return true;
        } else {
            return false;
        }
        //System.out.println("c'est empty ou pas" + elements.isEmpty());
        //or return elements.isEmpty();
    }

    public void pushElement (int element) {
        elements.add(element);
    }

    public int getSize(){
        return elements.size();
    }

    public int getLastElement() {
        return elements.getLast();
    }

    public void popLastElement() {
        if (elements.isEmpty()) {
            throw new RuntimeException ("can't pop an empty list");
        }
        elements.removeLast();
    }
}
