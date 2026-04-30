package model;

public class Pair {
    /**
     * Definition for a weighted graph node (Edge representation).
     * <ul>
     * <li><b>v:</b> vertex</li>
     * <li><b>w:</b> Edge weight</li>
     * </ul>
     */
    public int v;
    public int w;

    public Pair(int destination, int weight) {
        this.v = destination;
        this.w = weight;
    }
}
