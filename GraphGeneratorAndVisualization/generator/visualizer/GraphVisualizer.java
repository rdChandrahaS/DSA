package generator.visualizer;

import model.Pair;
import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class GraphVisualizer extends JPanel {
    private int V;
    private List<List<Integer>> unweightedGraph;
    private List<List<Pair>> weightedGraph;
    private boolean isDirected;
    private boolean isWeighted;
    
    private double scale = 1.0;
    private Map<Integer, Point> nodeLocations = new HashMap<>();

    public GraphVisualizer(List<List<Integer>> graph, boolean isDirected) {
        this.unweightedGraph = graph;
        this.V = graph.size();
        this.isDirected = isDirected;
        this.isWeighted = false;
        setup();
    }

    public GraphVisualizer(List<List<Pair>> graph, boolean isDirected, boolean isWeighted) {
        this.weightedGraph = graph;
        this.V = graph.size();
        this.isDirected = isDirected;
        this.isWeighted = true;
        setup();
    }

    private void setup() {
        int centerX = 400;
        int centerY = 350;
        int radius = 250;

        for (int i = 0; i < V; i++) {
            double angle = 2 * Math.PI * i / V;
            int x = (int) (centerX + radius * Math.cos(angle));
            int y = (int) (centerY + radius * Math.sin(angle));
            nodeLocations.put(i, new Point(x, y));
        }

        this.addMouseWheelListener(e -> {
            if (e.getWheelRotation() < 0) scale *= 1.1;
            else scale /= 1.1;
            revalidate();
            repaint();
        });
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int)(800 * scale), (int)(750 * scale));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.scale(scale, scale);

        g2.setColor(Color.GRAY);
        g2.setStroke(new BasicStroke(2));

        if (isWeighted) {
            for (int u = 0; u < V; u++) {
                for (Pair edge : weightedGraph.get(u)) drawEdge(g2, u, edge.v, edge.w);
            }
        } else {
            for (int u = 0; u < V; u++) {
                for (int v : unweightedGraph.get(u)) drawEdge(g2, u, v, null);
            }
        }

        int nodeRadius = 20;
        for (int i = 0; i < V; i++) {
            Point p = nodeLocations.get(i);
            g2.setColor(new Color(255, 182, 193)); 
            g2.fillOval(p.x - nodeRadius, p.y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
            g2.setColor(Color.BLACK);
            g2.drawOval(p.x - nodeRadius, p.y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
            g2.setFont(new Font("Arial", Font.BOLD, 14));
            g2.drawString(String.valueOf(i), p.x - 5, p.y + 5);
        }
    }

    private void drawEdge(Graphics2D g2, int u, int v, Integer weight) {
        Point p1 = nodeLocations.get(u);
        Point p2 = nodeLocations.get(v);

        // 1. Calculate the angle between the two nodes
        double angle = Math.atan2(p2.y - p1.y, p2.x - p1.x);
        int radius = 20; // Must match nodeRadius

        // 2. Shorten the line so it stops at the edge of the circle (doesn't go inside)
        int startX = (int) (p1.x + radius * Math.cos(angle));
        int startY = (int) (p1.y + radius * Math.sin(angle));
        int endX = (int) (p2.x - radius * Math.cos(angle));
        int endY = (int) (p2.y - radius * Math.sin(angle));

        g2.drawLine(startX, startY, endX, endY);

        // 3. Draw Arrow if directed
        if (isDirected) {
            int arrowSize = 10;
            double arrowAngle = Math.PI / 6; // 30 degrees

            // Calculate back-points of the triangle arrowhead
            int x1 = (int) (endX - arrowSize * Math.cos(angle - arrowAngle));
            int y1 = (int) (endY - arrowSize * Math.sin(angle - arrowAngle));
            int x2 = (int) (endX - arrowSize * Math.cos(angle + arrowAngle));
            int y2 = (int) (endY - arrowSize * Math.sin(angle + arrowAngle));

            g2.fillPolygon(new int[]{endX, x1, x2}, new int[]{endY, y1, y2}, 3);
        }

        // 4. Draw Weights offset to the side
        if (weight != null) {
            int midX = (startX + endX) / 2;
            int midY = (startY + endY) / 2;

            // Offset perpendicularly from the line so it sits "beside" the path
            int offsetX = (int) (-15 * Math.sin(angle));
            int offsetY = (int) (15 * Math.cos(angle));

            g2.setColor(Color.RED);
            g2.fillOval(midX + offsetX - 10, midY + offsetY - 10, 20, 20); 
            g2.setColor(Color.WHITE);
            g2.setFont(new Font("Arial", Font.BOLD, 12));
            
            int textShift = String.valueOf(weight).length() > 1 ? 6 : 3;
            g2.drawString(String.valueOf(weight), midX + offsetX - textShift, midY + offsetY + 4);
            g2.setColor(Color.GRAY); 
        }
    }

    public static void showGraph(JPanel visualizerPanel, String title) {
        JFrame frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        visualizerPanel.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(visualizerPanel);
        frame.add(scrollPane);
        frame.pack();
        frame.setSize(850, 800);
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}