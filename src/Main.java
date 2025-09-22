public class Main {
    public static void main(String[] args) {
        int[] arr1 = {5, 2, 9, 1, 5, 6};
        int[] arr2 = arr1.clone();

        // Test MergeSort
        Metrics m1 = new Metrics();
        m1.algoName = "MergeSort";
        m1.start();
        MergeSort.sort(arr1, m1);
        m1.stop();
        System.out.println("MergeSort:");
        System.out.println("Sorted: " + java.util.Arrays.toString(arr1));
        System.out.println("Time = " + m1.getTimeMillis() + " ms");
        System.out.println("Depth = " + m1.maxDepth);
        System.out.println("Comparisons = " + m1.comparisons);
        System.out.println("Allocations = " + m1.allocations);
        System.out.println();

        // Test QuickSort
        Metrics m2 = new Metrics();
        m2.algoName = "QuickSort";
        m2.start();
        QuickSort.quickSort(arr2, 0, arr2.length - 1, m2);
        m2.stop();
        System.out.println("QuickSort:");
        System.out.println("Sorted: " + java.util.Arrays.toString(arr2));
        System.out.println("Time = " + m2.getTimeMillis() + " ms");
        System.out.println("Depth = " + m2.maxDepth);
        System.out.println("Comparisons = " + m2.comparisons);
        System.out.println("Allocations = " + m2.allocations);
    }
}
