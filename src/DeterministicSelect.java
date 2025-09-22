import java.util.Arrays;

public class DeterministicSelect {

    public static int select(int[] arr, int k, Metrics metrics) {
        metrics.start();
        int result = selectRecursive(arr, 0, arr.length - 1, k, metrics);
        metrics.stop();
        return result;
    }

    private static int selectRecursive(int[] arr, int left, int right, int k, Metrics metrics) {
        metrics.enterRecursion();

        if (left == right) {
            metrics.exitRecursion();
            return arr[left];
        }

        int pivotIndex = pivot(arr, left, right, metrics);
        pivotIndex = partition(arr, left, right, pivotIndex, metrics);

        int length = pivotIndex - left + 1;
        if (k == length) {
            metrics.exitRecursion();
            return arr[pivotIndex];
        } else if (k < length) {
            int res = selectRecursive(arr, left, pivotIndex - 1, k, metrics);
            metrics.exitRecursion();
            return res;
        } else {
            int res = selectRecursive(arr, pivotIndex + 1, right, k - length, metrics);
            metrics.exitRecursion();
            return res;
        }
    }

    private static int pivot(int[] arr, int left, int right, Metrics metrics) {
        if (right - left < 5) {
            Arrays.sort(arr, left, right + 1);
            return (left + right) / 2;
        }

        int subRight = left;
        for (int i = left; i <= right; i += 5) {
            int subEnd = Math.min(i + 4, right);
            Arrays.sort(arr, i, subEnd + 1);
            int median = (i + subEnd) / 2;
            swap(arr, median, subRight++, metrics);
        }

        return pivot(arr, left, subRight - 1, metrics);
    }

    private static int partition(int[] arr, int left, int right, int pivotIndex, Metrics metrics) {
        int pivotValue = arr[pivotIndex];
        swap(arr, pivotIndex, right, metrics);
        int storeIndex = left;

        for (int i = left; i < right; i++) {
            metrics.compare();
            if (arr[i] < pivotValue) {
                swap(arr, storeIndex, i, metrics);
                storeIndex++;
            }
        }
        swap(arr, right, storeIndex, metrics);
        return storeIndex;
    }

    private static void swap(int[] arr, int i, int j, Metrics metrics) {
        metrics.allocate();
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
}
