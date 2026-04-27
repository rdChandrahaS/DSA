package generator;

import generator.core.GraphFactory;
import generator.visualizer.GraphVisualizer;
import model.Pair;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.List;


/**
 * A utility class for generating and visually displaying various types of graphs.
 * <p>
 * <b>Workflow:</b>
 * <ol>
 * <li>Instantiate the {@code GraphGenerator}.</li>
 * <li>If requesting manual input, initialize a {@code BufferedReader} in your main class.</li>
 * <li>Call the desired generation method (Random/Manual, Weighted/Unweighted).</li>
 * </ol>
 * The generator will instantly launch an interactive Java Swing visualizer to display 
 * the graph and return the adjacency list representation for algorithmic processing.
 * <p>
 * <b>Usage Example:</b>
 * <pre>
 * GraphGenerator gen = new GraphGenerator();
 * * // Example: Generate a random undirected graph with 5 vertices
 * List&lt;List&lt;Integer&gt;&gt; myGraph = gen.getRandomUnweightedGraph(5, false);
 * </pre>
 */
public class GraphGenerator {
    
    private GraphFactory factory;

    public GraphGenerator() {
        this.factory = new GraphFactory();
    }

    /**
     * Generates an unweighted graph based on manual console input.
     * @param V          The total number of vertices in the graph.
     * @param E          The total number of edges to read from the input.
     * @param isDirected True if the graph should have directed edges, false otherwise.
     * @param br         The BufferedReader used to read the user's input.
     * @return           An adjacency list representation of the generated graph.
     * @throws IOException If an error occurs while reading from the BufferedReader.
     */
    public List<List<Integer>> getManualUnweightedGraph(int V, int E, boolean isDirected, BufferedReader br) throws IOException {
        System.out.println("Generating Manual Unweighted Graph...");
        
        List<List<Integer>> graph = factory.manualUnweighted(V, E, isDirected, br);
        GraphVisualizer.showGraph(new GraphVisualizer(graph, isDirected), "Manual Unweighted Graph");
        
        return graph;
    }

    /**
     * Generates a weighted graph based on manual console input.
     * @param V          The total number of vertices in the graph.
     * @param E          The total number of edges to read from the input.
     * @param isDirected True if the graph should have directed edges, false otherwise.
     * @param br         The BufferedReader used to read the user's input.
     * @return           An adjacency list representation of the generated weighted graph.
     * @throws IOException If an error occurs while reading from the BufferedReader.
     */
    public List<List<Pair>> getManualWeightedGraph(int V, int E, boolean isDirected, BufferedReader br) throws IOException {
        System.out.println("Generating Manual Weighted Graph...");
        
        List<List<Pair>> graph = factory.manualWeighted(V, E, isDirected, br);
        GraphVisualizer.showGraph(new GraphVisualizer(graph, isDirected, true), "Manual Weighted Graph");
        
        return graph;
    }

    /**
     * Generates an unweighted graph with random edges.
     * @param V          The total number of vertices in the graph.
     * @param isDirected True if the graph should have directed edges, false otherwise.
     * @return           An adjacency list representation of the generated random graph.
     */
    public List<List<Integer>> getRandomUnweightedGraph(int V, boolean isDirected) {
        System.out.println("Generating Random Unweighted Graph...");
        
        List<List<Integer>> graph = factory.randomUnweighted(V, isDirected);
        GraphVisualizer.showGraph(new GraphVisualizer(graph, isDirected), "Random Unweighted Graph");
        
        return graph;
    }

    /**
     * Generates a weighted graph with random edges and random weights.
     * @param V          The total number of vertices in the graph.
     * @param isDirected True if the graph should have directed edges, false otherwise.
     * @return           An adjacency list representation of the generated random weighted graph.
     */
    public List<List<Pair>> getRandomWeightedGraph(int V, boolean isDirected) {
        System.out.println("Generating Random Weighted Graph...");
        
        List<List<Pair>> graph = factory.randomWeighted(V, isDirected);
        GraphVisualizer.showGraph(new GraphVisualizer(graph, isDirected, true), "Random Weighted Graph");
        
        return graph;
    }
}