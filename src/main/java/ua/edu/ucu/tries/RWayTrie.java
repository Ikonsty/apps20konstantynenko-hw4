package ua.edu.ucu.tries;

//import ua.edu.ucu.queue.Queue;

import java.util.LinkedList;
import java.util.Queue;

public class RWayTrie implements Trie {
    private static final int R = 256;

    private Node root = new Node();
    private int size;

    private static class Node {
        private Object val;
        private Node[] next = new Node[R];
    }

    public RWayTrie() {

    }

    @Override
    public void add(Tuple t) {
        String word = t.getWord();
        int val = t.getValue();
        if (word == null) {
            throw new IllegalArgumentException("argument word is null");
        }
        else {
            root = add(root, word, val, 0);
        }
    }

    private Node add(Node x, String word, int val, int ln) {
        if (x == null) {
            x = new Node();
        }
        if (ln == word.length()) {
            if (x.val == null) {
                size++;
            }
            x.val = val;
            return x;
        }
        char c = word.charAt(ln);
        x.next[c] = add(x.next[c], word, val, ln + 1);
        return x;
    }

    public String get(String word) {
        if (word == null) {
            throw new IllegalArgumentException("Argument is null");
        }
        Node x = get(root, word, 0);
        if (x == null) {
            return null;
        }
        return (String) x.val;
    }

    private Node get(Node x, String word, int ln) {
        if (x == null) {
            return null;
        }
        if (ln == word.length()) {
            return x;
        }
        char c = word.charAt(ln);
        return get(x.next[c], word, ln + 1);
    }

    @Override
    public boolean contains(String word) {
        if (word == null) {
            throw  new IllegalArgumentException("argument is null");
        }
        return get(word) != null;
    }

    @Override
    public boolean delete(String word) {
        if (word == null) {
            throw new IllegalArgumentException("argument is null");
        }
        root = delete(root, word, 0);
        return root != null;
    }

    private Node delete(Node x, String word, int ln) {
        if (x == null) {
            return null;
        }
        if (ln == word.length()) {
            if (x.val != null) {
                size--;
            }
            x.val = null;
        }
        else {
            char c = word.charAt(ln);
            x.next[c] = delete(x.next[c], word, ln + 1);
        }

        if (x.val != null) {
            return x;
        }
        for (int c = 0; c < R; c++) {
            if (x.next[c] != null) {
                return x;
            }
        }
        return null;
    }

    @Override
    public Iterable<String> words() {
        return wordsWithPrefix("");
    }

    @Override
    public Iterable<String> wordsWithPrefix(String s) {
        Queue<String> result = new LinkedList<>();
        Node x = get(root, s, 0);
        collect(x, new StringBuilder(s), result);
        return result;
    }

    private void collect(Node x, StringBuilder s, Queue<String> result) {
        if (x == null) {
            return;
        }
        if (x.val != null) {
            result.offer(s.toString());
        }
        for (char c = 0; c < R; c++) {
            s.append(c);
            collect(x.next[c], s, result);
            s.deleteCharAt(s.length() - 1);
        }
    }

    @Override
    public int size() {
        return size;
    }

}
