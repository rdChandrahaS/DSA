package generator.visualizer;

import model.TreeNode;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.util.HashMap;
import java.util.Map;

public class TreeVisualizer extends JPanel {
    private Map<TreeNode, Point> nodeLocations;
    private int nodeRadius = 15;
    
    private int xCounter = 1;
    public int maxX = 0;
    public int maxY = 0;

    // The current zoom level (1.0 = 100%)
    private double scale = 1.0;

    public TreeVisualizer(TreeNode root) {
        this.nodeLocations = new HashMap<>();
        calculatePositions(root, 0);
        
        // Add zoom listener
        this.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                if (e.getWheelRotation() < 0) {
                    scale *= 1.1; // Scroll up -> Zoom In
                } else {
                    scale /= 1.1; // Scroll down -> Zoom Out
                }
                // Refresh the panel and scrollbars with the new zoom
                revalidate();
                repaint();
            }
        });
    }

    private void calculatePositions(TreeNode node, int depth) {
        if (node == null) return;
        
        calculatePositions(node.left, depth + 1);
        
        int x = xCounter * 40;         
        int y = depth * 60 + 50;       
        nodeLocations.put(node, new Point(x, y));
        xCounter++;
        
        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
        
        calculatePositions(node.right, depth + 1);
    }

    @Override
    public Dimension getPreferredSize() {
        return new Dimension((int)((maxX + 50) * scale), (int)((maxY + 50) * scale));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Apply the zoom scaling before drawing anything
        g2.scale(scale, scale);

        // 1. Draw connections
        g2.setColor(Color.GRAY);
        for (TreeNode node : nodeLocations.keySet()) {
            Point p1 = nodeLocations.get(node);
            
            if (node.left != null) {
                Point p2 = nodeLocations.get(node.left);
                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
            if (node.right != null) {
                Point p2 = nodeLocations.get(node.right);
                g2.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }

        // 2. Draw nodes
        for (TreeNode node : nodeLocations.keySet()) {
            Point p = nodeLocations.get(node);
            
            g2.setColor(new Color(173, 216, 230)); 
            g2.fillOval(p.x - nodeRadius, p.y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
            
            g2.setColor(Color.DARK_GRAY);
            g2.drawOval(p.x - nodeRadius, p.y - nodeRadius, 2 * nodeRadius, 2 * nodeRadius);
            
            g2.setColor(Color.BLACK);
            g2.setFont(new Font("Arial", Font.BOLD, 12));
            
            int textShift = String.valueOf(node.val).length() > 1 ? 7 : 4;
            g2.drawString(String.valueOf(node.val), p.x - textShift, p.y + 5);
        }
    }

    public static void showTree(TreeNode root) {
        JFrame frame = new JFrame("Java Tree Visualizer (Use Mouse Wheel to Zoom)");
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
        
        TreeVisualizer panel = new TreeVisualizer(root);
        panel.setBackground(Color.WHITE);
        
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        frame.add(scrollPane);
        
        frame.pack();
        frame.setSize(Math.min(panel.maxX + 100, 1000), Math.min(panel.maxY + 100, 700));
        frame.setLocationRelativeTo(null); 
        frame.setVisible(true);
    }
}