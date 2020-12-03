package ua.edu.ucu.autocomplete;

import ua.edu.ucu.tries.Trie;
import ua.edu.ucu.tries.Tuple;

import java.util.Iterator;
import java.util.LinkedList;

/**
 *
 * @author andrii
 */
public class PrefixMatches {

    private Trie trie;

    public PrefixMatches(Trie trie) {
        this.trie = trie;
    }

    public int load(String... strings) {
//        String[] wordsToPack = strings.split(" ");
        for (String word: strings) {
            if (word.length() > 2) {
                this.trie.add(new Tuple(word, word.length()));
            }
        }
        return 1;
    }

//    public int load(String[] strings) {
//        for (String st: strings) {
//            load(st);
//        }
//        return 1;
//    }

    public boolean contains(String word) {
        return this.trie.contains(word);
    }

    public boolean delete(String word) {
        return this.trie.delete(word);
    }

    public Iterable<String> wordsWithPrefix(String pref) {
        if (pref.length() >= 2) {
            return this.trie.wordsWithPrefix(pref);
        }
        return null;
    }

    public Iterable<String> wordsWithPrefix(String pref, int k) {
        Iterable<String> allPrefixes = wordsWithPrefix(pref);
        Iterator<String> iter = allPrefixes.iterator();

        LinkedList<String> result = new LinkedList<>();

        while (iter.hasNext()) {
            String el = iter.next();
            if (pref.length() + k - 1 >= el.length()) {
                result.add(el);
            }
        }
        return result;
    }

    public int size() {
        return this.trie.size();
    }
}