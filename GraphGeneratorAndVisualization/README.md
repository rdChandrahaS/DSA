### Steps to Create a Graph

**1. Import the necessary classes:**
```java
import generator.GraphGenerator;
import model.Pair; // (Only needed if generating weighted graphs)
import java.util.List;
```

**2. 2. Generate the graph:**
```java
//You can generate manual or random graphs (both weighted and unweighted). The visualizer will launch automatically.

GraphGenerator gen = new GraphGenerator();

// Example 1: Generate a random undirected weighted graph with 6 vertices
List<List<Pair>> randomGraph = gen.getRandomWeightedGraph(6, false);

// Example 2: Generate a manual directed unweighted graph with 4 vertices and 3 edges
List<List<Integer>> manualGraph = gen.getManualUnweightedGraph(4, 3, true, br);
```

**3. Automatic Workspace Cleanup :**
To keep your directory clean of compiled files, use the built-in cleaner utility. Simply call it at the very end of your program, and it will automatically run the cleanup.sh script to delete all .class files without needing any y/n prompts!

```java
import utility.WorkspaceCleaner;

// Call this at the end of your main method
WorkspaceCleaner.clean();
```