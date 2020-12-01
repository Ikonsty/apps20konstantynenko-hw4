package ua.edu.ucu.tries;

public final class Tuple {
    public final String term;
    public final int weight;

    public Tuple(String term, int weight) {
        this.term = term;
        this.weight = weight;
    }

    public String getWord() {
        return term;
    }

    public int getValue() {
        return weight;
    }
}