package generator.core;

import model.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GraphFactory {
    
    // --- RANDOM GENERATORS ---
    
    public List<List<Integer>> randomUnweighted(int V, boolean isDirected) {
        List<List<Integer>> graph = initUnweighted(V);
        Random rand = new Random();
        int E = rand.nextInt(V * (V - 1) / 2) + 1;

        for (int i = 0; i < E; i++) {
            int u = rand.nextInt(V);
            int v = rand.nextInt(V);
            if (u != v && !graph.get(u).contains(v)) {
                graph.get(u).add(v);
                if (!isDirected) graph.get(v).add(u);
            }
        }
        return graph;
    }

    public List<List<Pair>> randomWeighted(int V, boolean isDirected) {
        List<List<Pair>> graph = initWeighted(V);
        Random rand = new Random();
        int E = rand.nextInt(V * (V - 1) / 2) + 1;

        for (int i = 0; i < E; i++) {
            int u = rand.nextInt(V);
            int v = rand.nextInt(V);
            int w = rand.nextInt(100) + 1; // Weights from 1 to 100
            
            if (u != v && !containsEdge(graph, u, v)) {
                graph.get(u).add(new Pair(v, w));
                if (!isDirected) graph.get(v).add(new Pair(u, w));
            }
        }
        return graph;
    }

    // --- MANUAL GENERATORS ---
    
    public List<List<Integer>> manualUnweighted(int V, int E, boolean isDirected, BufferedReader br) throws IOException {
        List<List<Integer>> graph = initUnweighted(V);
        System.out.println("Enter " + E + " edges (format: u v):");
        for (int i = 0; i < E; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            graph.get(u).add(v);
            if (!isDirected) graph.get(v).add(u);
        }
        return graph;
    }

    public List<List<Pair>> manualWeighted(int V, int E, boolean isDirected, BufferedReader br) throws IOException {
        List<List<Pair>> graph = initWeighted(V);
        System.out.println("Enter " + E + " edges (format: u v weight):");
        for (int i = 0; i < E; i++) {
            String[] parts = br.readLine().trim().split("\\s+");
            int u = Integer.parseInt(parts[0]);
            int v = Integer.parseInt(parts[1]);
            int w = Integer.parseInt(parts[2]);
            graph.get(u).add(new Pair(v, w));
            if (!isDirected) graph.get(v).add(new Pair(u, w));
        }
        return graph;
    }

    // --- HELPERS ---
    
    private List<List<Integer>> initUnweighted(int V) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());
        return g;
    }

    private List<List<Pair>> initWeighted(int V) {
        List<List<Pair>> g = new ArrayList<>();
        for (int i = 0; i < V; i++) g.add(new ArrayList<>());
        return g;
    }
    
    private boolean containsEdge(List<List<Pair>> graph, int u, int v) {
        for (Pair p : graph.get(u)) if (p.v == v) return true;
        return false;
    }
}