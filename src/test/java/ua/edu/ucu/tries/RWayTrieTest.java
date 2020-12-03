package ua.edu.ucu.tries;

import static org.hamcrest.Matchers.containsInAnyOrder;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import ua.edu.ucu.tries.RWayTrie;

public class RWayTrieTest {

    private RWayTrie rw;

    @Before
    public void init() {
        rw = new RWayTrie();

        rw.get("");
        rw.delete("");

        rw.add(new Tuple("abc", 3));
        rw.add(new Tuple("abce", 4));
        rw.add(new Tuple("abcd", 4));
        rw.add(new Tuple("", 0));
    }

    @Test
    public void testWordsUse() {
        rw.get("");
        rw.get("abcd");

        rw.delete("abce");

        System.out.println(rw.words());

        System.out.println(rw.size());
    }

}
