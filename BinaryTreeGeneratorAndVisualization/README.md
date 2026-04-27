### Steps to Create a Random Tree

**1. Import the necessary classes :**
```java
    import generator.TreeGenerator;
    import model.TreeNode;
```

**2. Generate the tree :**
```java
    TreeGenerator tree = new TreeGenerator();
    TreeNode root = tree.generate();
```
**3. Automatic Cleanup :**
After the program finishes executing and you close the visualizer window, the terminal will prompt you (y/n) asking if you want to clean up the workspace. If you type y, the cleanup.sh script will automatically run and delete all generated .class files to keep your directory clean.