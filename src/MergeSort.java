public class MergeSort {
    public static void sort(int[] arr, Metrics metrics) {
        metrics.start();
        mergeSort(arr, 0, arr.length - 1, metrics);
        metrics.stop();
    }

    private static void mergeSort(int[] arr, int l, int r, Metrics metrics) {
        metrics.enterRecursion();
        if(l < r) {
            int mid = (l+r)/2;
            mergeSort(arr, l, mid, metrics);
            mergeSort(arr, mid+1, r, metrics);
            merge(arr, l, mid, r, metrics);
        }
        metrics.exitRecursion();
    }

    private static void merge(int[] arr, int l, int m, int r, Metrics metrics) {
        int n1 = m - l + 1;
        int n2 = r - m;
        metrics.allocate(); metrics.allocate();
        int[] L = new int[n1]; int[] R = new int[n2];

        for(int i=0;i<n1;i++) L[i]=arr[l+i];
        for(int j=0;j<n2;j++) R[j]=arr[m+1+j];

        int i=0,j=0,k=l;
        while(i<n1 && j<n2){
            metrics.compare();
            if(L[i]<=R[j]) arr[k++]=L[i++];
            else arr[k++]=R[j++];
        }
        while(i<n1) arr[k++]=L[i++];
        while(j<n2) arr[k++]=R[j++];
    }
}
