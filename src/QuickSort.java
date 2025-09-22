public class QuickSort {

    // Convenience wrapper: just call with array + metrics
    public static void quickSort(int[] arr, Metrics metrics) {
        metrics.start();
        quickSort(arr, 0, arr.length - 1, metrics);
        metrics.stop();
    }

    public static void quickSort(int[] arr, int low, int high, Metrics metrics) {
        metrics.enterRecursion();

        if (low < high) {
            int pi = partition(arr, low, high, metrics);

            quickSort(arr, low, pi - 1, metrics);
            quickSort(arr, pi + 1, high, metrics);
        }

        metrics.exitRecursion();
    }

    private static int partition(int[] arr, int low, int high, Metrics metrics) {
        int pivot = arr[high];
        int i = (low - 1);

        for (int j = low; j < high; j++) {
            metrics.compare();
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j, metrics);
            }
        }

        swap(arr, i + 1, high, metrics);
        return i + 1;
    }

    private static void swap(int[] arr, int i, int j, Metrics metrics) {
        metrics.allocate();
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
