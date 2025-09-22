public class TestDeterministicSelect {
    public static void main(String[] args) {
        int[] arr = {12, 3, 5, 7, 4, 19, 26};
        int k = 3; // 3rd smallest

        Metrics m = new Metrics();
        m.algoName = "DeterministicSelect";
        m.n = arr.length;
        m.trial = 1;
        m.mode = "random";

        int kth = DeterministicSelect.select(arr, k, m);
        System.out.println(k + "rd smallest element = " + kth);
        System.out.println("Time = " + m.getTimeMillis() + " ms");
        System.out.println("Max Depth = " + m.maxDepth);
        System.out.println("Comparisons = " + m.comparisons);
        System.out.println("Allocations = " + m.allocations);
    }
}
