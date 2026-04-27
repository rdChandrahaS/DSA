package utility;

public class WorkspaceCleaner {

    /**
     * Automatically runs the cleanup.sh script to remove all compiled .class files.
     */
    public static void clean() {
        System.out.println("\n[System] Auto-running cleanup.sh...");
        try {
            ProcessBuilder pb = new ProcessBuilder("bash", "cleanup.sh");
            pb.inheritIO(); 
            Process process = pb.start();
            int exitCode = process.waitFor();
            
            if (exitCode == 0) {
                System.out.println("[System] Workspace cleaned successfully.");
            } else {
                System.err.println("[System] Cleanup script failed with exit code: " + exitCode);
            }
        } catch (Exception e) {
            System.err.println("[System] Cleanup process encountered an error.");
            e.printStackTrace();
        }
    }
}