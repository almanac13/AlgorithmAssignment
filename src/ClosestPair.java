import java.util.Arrays;
import java.util.Comparator;

public class ClosestPair {

    public static double findClosest(Point[] points, Metrics metrics) {
        metrics.start();
        Point[] sortedByX = points.clone();
        Arrays.sort(sortedByX, Comparator.comparingDouble(p -> p.x));
        Point[] aux = new Point[points.length];
        double minDist = closestRecursive(sortedByX, aux, 0, points.length - 1, metrics);
        metrics.stop();
        return minDist;
    }

    private static double closestRecursive(Point[] pts, Point[] aux, int left, int right, Metrics metrics) {
        metrics.enterRecursion();

        if (right - left <= 3) {
            double min = Double.POSITIVE_INFINITY;
            for (int i = left; i <= right; i++) {
                for (int j = i + 1; j <= right; j++) {
                    metrics.compare();
                    min = Math.min(min, dist(pts[i], pts[j]));
                }
            }
            Arrays.sort(pts, left, right + 1, Comparator.comparingDouble(p -> p.y));
            metrics.exitRecursion();
            return min;
        }

        int mid = (left + right) / 2;
        Point midPoint = pts[mid];

        double dLeft = closestRecursive(pts, aux, left, mid, metrics);
        double dRight = closestRecursive(pts, aux, mid + 1, right, metrics);
        double d = Math.min(dLeft, dRight);

        mergeByY(pts, aux, left, mid, right);

        // strip check
        int stripSize = 0;
        for (int i = left; i <= right; i++) {
            if (Math.abs(pts[i].x - midPoint.x) < d) {
                aux[stripSize++] = pts[i];
            }
        }

        for (int i = 0; i < stripSize; i++) {
            for (int j = i + 1; j < stripSize && (aux[j].y - aux[i].y) < d; j++) {
                metrics.compare();
                d = Math.min(d, dist(aux[i], aux[j]));
            }
        }

        metrics.exitRecursion();
        return d;
    }

    private static void mergeByY(Point[] pts, Point[] aux, int left, int mid, int right) {
        int i = left, j = mid + 1, k = left;
        while (i <= mid && j <= right) {
            if (pts[i].y <= pts[j].y) aux[k++] = pts[i++];
            else aux[k++] = pts[j++];
        }
        while (i <= mid) aux[k++] = pts[i++];
        while (j <= right) aux[k++] = pts[j++];
        for (i = left; i <= right; i++) pts[i] = aux[i];
    }

    private static double dist(Point a, Point b) {
        double dx = a.x - b.x;
        double dy = a.y - b.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}
