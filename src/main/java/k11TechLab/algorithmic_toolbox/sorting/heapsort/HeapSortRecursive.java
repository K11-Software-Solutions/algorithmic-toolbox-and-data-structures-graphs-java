package k11TechLab.algorithmic_toolbox.sorting.heapsort;

public class HeapSortRecursive {

    /*
    Asymptotic complexity in terms of size of `arr` `n`:
    * Time: O(n * log(n)).
    * Auxiliary space: O(log(n)).
    * Total space: O(n).
    */

    // This function will recursively convert arr[rootIndex ... n - 1] into a Max-Heap.
    public static void heapify(List<Integer> arr, int rootIndex, int n) {
        int largest = rootIndex;
        int leftChildIndex = 2 * rootIndex + 1;
        int rightChildIndex = 2 * rootIndex + 2;

        // Finding the index of the largest value among:
        // arr[rootIndex], arr[leftChildIndex], and arr[rightChildIndex]
        if (leftChildIndex < n && arr.get(leftChildIndex) > arr.get(largest)) {
            largest = leftChildIndex;
        }

        if (rightChildIndex < n && arr.get(rightChildIndex) > arr.get(largest)) {
            largest = rightChildIndex;
        }

        // The largest among the three considered values will now be the root of the Max-Heap
        // represented by arr[rootIndex ... n - 1].
        if (largest != rootIndex) {
            Collections.swap(arr, largest, rootIndex);
            heapify(arr, largest, n);
        }
    }

    public static ArrayList<Integer> heap_sort(ArrayList<Integer> arr) {
        int n = arr.size();

        // Building a Max-Heap in a bottom-up manner.
        // Heapifying only the indices in range [0, n/2 - 1) because only these indices will have at least one
        // child node in the Max-Heap.
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, i, n);
        }

        for (int i = n - 1; i > 0; i--) {
            Collections.swap(arr, 0, i);
            heapify(arr, 0, i);
        }

        return arr;
    }

}
