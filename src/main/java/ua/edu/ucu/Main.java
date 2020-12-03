package ua.edu.ucu;

import ua.edu.ucu.tries.RWayTrie;
import ua.edu.ucu.tries.Tuple;

public class Main {
    public static void main(String[] args) {
        RWayTrie rw;

        rw = new RWayTrie();

        rw.get("");
        rw.delete("");

        rw.add(new Tuple("abc", 3));
        rw.add(new Tuple("abce", 4));
        rw.add(new Tuple("abcd", 4));
        rw.add(new Tuple("", 0));

        rw.get("");
        rw.get("abcd");

        rw.delete("abce");

        System.out.println(rw.words());

        System.out.println(rw.size());

    }
}
