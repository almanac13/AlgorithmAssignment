public class TestPoint {
    public static void main(String[] args) {
        Point[] points = {
                new Point(2.1, 3.5),
                new Point(1.2, 1.0),
                new Point(4.0, 2.0),
                new Point(6.5, 3.0),
                new Point(5.0, 1.2)
        };

        Metrics metrics = new Metrics();
        metrics.algoName = "ClosestPair";
        metrics.n = points.length;
        metrics.trial = 1;
        metrics.mode = "random";

        double minDist = ClosestPair.findClosest(points, metrics);
        System.out.println("Closest distance = " + minDist);
        System.out.println("Time = " + metrics.getTimeMillis() + " ms");
        System.out.println("Depth = " + metrics.maxDepth);
        System.out.println("Comparisons = " + metrics.comparisons);
        System.out.println("Allocations = " + metrics.allocations);
    }
}
