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

**3. Automatic Workspace Cleanup :**
To keep your directory clean of compiled files, use the built-in cleaner utility. Simply call it at the very end of your program, and it will automatically run the cleanup.sh script to delete all .class files without needing any y/n prompts!

```java
import utility.WorkspaceCleaner;

// Call this at the end of your main method
WorkspaceCleaner.clean();
```