public class Main {
    public static void main(String[] args) {
        int[] arr = {5,2,9,1,5,6};
        Metrics metrics = new Metrics();
        metrics.algoName = "MergeSort"; metrics.n=arr.length; metrics.trial=1; metrics.mode="random";

        MergeSort.sort(arr, metrics);
        System.out.println(java.util.Arrays.toString(arr));
        CsvWriter.append(metrics, "metrics.csv");
    }
}
