package k11TechLab.algorithmic_toolbox.sorting.heapsort;

public class HeapSortIterative {

    /*
    Asymptotic complexity in terms of size of `arr` `n`:
    * Time: O(n * log(n)).
    * Auxiliary space: O(1).
    * Total space: O(n).
    */

    // This function will iteratively convert arr[rootIndex ... n - 1] into a Max-Heap.
    public static void heapify(List<Integer> arr, int rootIndex, int n) {
        int currentRootIndex = rootIndex;

        while (true) {
            int i = currentRootIndex;
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = 2 * i + 2;

            // Finding the index of the largest value among:
            // arr[currentRootIndex], arr[leftChildIndex], and arr[rightChildIndex].
            if (leftChildIndex < n && arr.get(leftChildIndex) > arr.get(i)) {
                i = leftChildIndex;
            }
            if (rightChildIndex < n && arr.get(rightChildIndex) > arr.get(i)) {
                i = rightChildIndex;
            }

            // The largest among the three considered values will now be the root of the Max-Heap
            // represented by arr[currentRootIndex ... n - 1].
            if (i != currentRootIndex) {
                Collections.swap(arr, i, currentRootIndex);
                currentRootIndex = i;
            } else {
                break;
            }
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
