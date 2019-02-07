public class SortingAlgorithm {

    static public int[] InsertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        return arr;
    }

    static public int[] SelectionSort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int min_idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[min_idx]) {
                    min_idx = j;
                }
            }

            int temp = arr[min_idx];
            arr[min_idx] = arr[i];
            arr[i] = temp;
        }

        return arr;
    }

    // tree sum
    // tree sum fast

    private static void MergeSort_merge(int[] a, int lo, int mid, int hi) {
        int[] aux = a.clone();

        // merge back to a[]
        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            if      (i > mid)              a[k] = aux[j++];  // this copying is unneccessary
            else if (j > hi)               a[k] = aux[i++];
            else if (aux[j] < aux[i])      a[k] = aux[j++];
            else                           a[k] = aux[i++];
        }

    }

    static public int[] MergeSortBottomUp(int[] arr) {

        int N = arr.length;

        for (int sz = 1; sz < N; sz = sz + sz) {
            for(int lo = 0; lo < N-sz; lo += sz+sz){
                int mid = lo + sz - 1;
                int hi = Math.min(lo + sz + sz - 1, N - 1);
                MergeSort_merge(arr, lo, mid, hi);
            }
        }

        return arr;
    }


    static public int QuickSortInnerPartition(int[] arr, int partitionStartLocation, int partitionEndLocation){
        int startCursor = partitionStartLocation; // 1 get added in the loop before it is accessed
        int endCursor = partitionEndLocation+1; // 1 get subtracted in the loop before it is accessed

        while (true) {
            while (arr[++startCursor]<arr[partitionStartLocation]){
                if (startCursor == partitionEndLocation) {
                    break;
                }
            }
            while (arr[partitionStartLocation] < arr[--endCursor]) {
                if (endCursor == partitionStartLocation){
                    break;
                }
            }

            if(startCursor >= endCursor){
                break;
            }
            Helpers.swap(arr, startCursor, endCursor);
        }
        Helpers.swap(arr, partitionStartLocation, endCursor);

        return endCursor;
    }

    static public void QuickSortInner(int[] arr, int partitionStartLocation, int partitionEndLocation){
        if(partitionStartLocation >= partitionEndLocation){
            return;
        }
        int pivitpoint = QuickSortInnerPartition(arr, partitionStartLocation, partitionEndLocation);
        QuickSortInner(arr, partitionStartLocation, pivitpoint-1);
        QuickSortInner(arr, pivitpoint+1, partitionEndLocation);
    }

    static public int[] QuickSort(int[] arr) {
        Helpers.RandomizeArray(arr);
        QuickSortInner(arr, 0, arr.length - 1);
        return arr;
    }

    public static void main(String[] args) {
        int[] randomIntegers = Helpers.randomIntegers(100, -100, 105);

        Helpers.printArr(randomIntegers);

        Helpers.printArr(InsertionSort(randomIntegers.clone()));

        Helpers.printArr(SelectionSort(randomIntegers.clone()));

        Helpers.printArr(MergeSortBottomUp(randomIntegers.clone()));

        Helpers.printArr(QuickSort(randomIntegers.clone()));


    }

}


