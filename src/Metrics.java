public class Metrics {
    public long comparisons = 0;
    public long allocations = 0;
    public int maxDepth = 0;

    private int currentDepth = 0;
    private long startTime;
    private long endTime;

    public String algoName;
    public int n;
    public int trial;
    public String mode;

    public void start() { startTime = System.nanoTime(); }
    public void stop() { endTime = System.nanoTime(); }
    public long getTimeMillis() { return (endTime - startTime)/1_000_000; }

    public void enterRecursion() {
        currentDepth++;
        if(currentDepth > maxDepth) maxDepth = currentDepth;
    }
    public void exitRecursion() { currentDepth--; }

    public void compare() { comparisons++; }
    public void allocate() { allocations++; }

    public String toCsvRow() {
        return algoName + "," + n + "," + trial + "," + mode + "," +
                getTimeMillis() + "," + maxDepth + "," +
                comparisons + "," + allocations + "\n";
    }
}
