package model;

/**
 * Store graph as :  parent/source -> List<Pair> or childs/destinations , weight
 * int v -> destination
 * int w -> weight
 */
public class Pair {
    public int v;
    public int w;

    public Pair(int destination, int weight) {
        this.v = destination;
        this.w = weight;
    }
}
