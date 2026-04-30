package algorithms;

import java.util.*;

/**
 * <h2>Disjoint Set Union (DSU)</h2>
 * <p>
 * Efficiently tracks partitioned elements into disjoint subsets.
 * </p>
 */
public class DisjointSet {
    private List<Integer> rank;
    private List<Integer> parent;
    private List<Integer> size;

    /**
     * <b>Constructor</b>
     * <hr>
     * <b>Array Version:</b>
     * 
     * <pre>
     * int[] rank;
     * int[] parent;
     * int[] size;
     * 
     * public DisjointSet(int n) {
     *     rank = new int[n];
     *     parent = new int[n];
     *     for (int i = 0; i <= n; i++) {
     *         parent[i] = i;
     *         size[i] = 1;
     *     }
     * }
     * </pre>
     */
    public DisjointSet(int n) {
        rank = new ArrayList<>();
        parent = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            rank.add(0);
            parent.add(i);
            size.add(1);
        }
    }

    /**
     * <b>findUltimateParent</b>
     * <hr>
     * <b>Array Version:</b>
     * 
     * <pre>
     * int findUPar(int node) {
     *     if (node == parent[node])
     *         return node;
     *     return parent[node] = findUPar(parent[node]);
     * }
     * </pre>
     * 
     * <b>How it works:</b>
     * <p>
     * Uses <b>Path Compression</b>. It recursively finds the root and,
     * during the backtracking phase, updates every node's parent to the root.
     * This flattens the tree height to nearly O(1).
     * </p>
     * @param node The element whose ultimate parent is to be found.
     * @return The representative element (root) of the set containing {@code node}
     */
    public int findUltimateParent(int node) {
        if (node == parent.get(node))
            return node;
        int ultimateParent = findUltimateParent(parent.get(node));
        parent.set(node, ultimateParent);
        return parent.get(node);
    }

    /**
     * <b>unionByRank</b>
     * <hr>
     * <b>Array Version:</b>
     * 
     * <pre>
     * void unionByRank(int u, int v) {
     *     int ulp_u = findUPar(u);
     *     int ulp_v = findUPar(v);
     *     if (ulp_u == ulp_v)
     *         return;
     *     if (rank[ulp_u] < rank[ulp_v]) {
     *         parent[ulp_u] = ulp_v;
     *     } else if (rank[ulp_v] < rank[ulp_u]) {
     *         parent[ulp_v] = ulp_u;
     *     } else {
     *         parent[ulp_v] = ulp_u;
     *         rank[ulp_u]++;
     *     }
     * }
     * </pre>
     * 
     * <b>How it works:</b>
     * <p>
     * 1. Find roots of both nodes.<br>
     * 2. Attach the tree with the <b>lower rank</b> under the root of the <b>higher
     * rank</b> tree.<br>
     * 3. If ranks are equal, attach one to the other and increment the rank of the
     * new root.
     * </p>
     * 
     * Unites the sets containing elements {@code u} and {@code v} based on their rank (height).
     * The tree with the smaller rank is attached under the root of the tree with the larger rank.
     * 
     * @param u The first element.
     * @param v The second element.
     * @return {@code true} if {@code u} and {@code v} were in different sets and have now 
     *         been joined; {@code false} if they were already in the same set.
     */
    public boolean unionByRank(int u, int v) {
        int ult_u = findUltimateParent(u);
        int ult_v = findUltimateParent(v);

        if (ult_u == ult_v)
            return false;

        if (rank.get(ult_u) < rank.get(ult_v)) {
            parent.set(ult_u, ult_v);
        } else if (rank.get(ult_v) < rank.get(ult_u)) {
            parent.set(ult_v, ult_u);
        } else {
            parent.set(ult_v, ult_u);
            rank.set(ult_u, rank.get(ult_u) + 1);
        }
        return true;
    }

    /**
     * <b>unionBySize</b>
     * <hr>
     * <b>Array Version:</b>
     * 
     * <pre>
     * void unionBySize(int u, int v) {
     *     int ulp_u = findUPar(u);
     *     int ulp_v = findUPar(v);
     * 
     *     if (ulp_u == ulp_v)
     *         return;
     * 
     *     if (size[ulp_u] < size[ulp_v]) {
     *         parent[ulp_u] = ulp_v;
     *         size[ulp_v] += size[ulp_u];
     *     } else {
     *         parent[ulp_v] = ulp_u;
     *         size[ulp_u] += size[ulp_v];
     *     }
     * }
     * </pre>
     * 
     * <b>How it works:</b>
     * <p>
     * 1. Find the roots (Ultimate Parents) of both nodes.<br>
     * 2. Compare the <b>size</b> (number of nodes) of both trees.<br>
     * 3. Attach the root of the <b>smaller tree</b> to the root of the <b>larger
     * tree</b>.<br>
     * 4. Update the size of the new root by adding the smaller tree's size to it.
     * </p>
     * Unites the sets containing elements {@code u} and {@code v} based on the number of nodes.
     * The smaller tree is merged into the larger tree to maintain a balanced structure.
     * 
     * @param u The first element.
     * @param v The second element.
     * @return {@code true} if the sets were successfully merged; 
     *         {@code false} if both elements already belong to the same set.
     */
    public boolean unionBySize(int u, int v) {
        int ult_u = findUltimateParent(u);
        int ult_v = findUltimateParent(v);

        if (ult_u == ult_v)
            return false;

        if (size.get(ult_u) < size.get(ult_v)) {
            parent.set(ult_u, ult_v);
            size.set(ult_v, size.get(ult_v) + size.get(ult_u));
        } else {
            parent.set(ult_v, ult_u);
            size.set(ult_u, size.get(ult_u) + size.get(ult_v));
        }
        return true;
    }

    public void union(int u,int v){
        int ult_u = findUltimateParent(u);
        int ult_v = findUltimateParent(v);

        if (ult_u == ult_v) return;

        if (size.get(ult_u) < size.get(ult_v)) {
            parent.set(ult_u, ult_v);
            size.set(ult_v, size.get(ult_v) + size.get(ult_u));
        } else {
            parent.set(ult_v, ult_u);
            size.set(ult_u, size.get(ult_u) + size.get(ult_v));
        }
    }
}