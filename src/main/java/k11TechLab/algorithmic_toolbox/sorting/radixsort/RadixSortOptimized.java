package k11TechLab.algorithmic_toolbox.sorting.radixsort;

public class RadixSortOptimized {

    /*
     * Asymptotic complexity in terms of size of `arr` `n`:
     * Time: O(n).
     * Auxiliary space: O(n).
     * Total space: O(n).
     */

    public static void bucketSort(ArrayList<Integer> arr, int div) {

        // Create an array of empty buckets
        List<List<Integer>> buckets = new ArrayList<>(10);
        for (int i = 0; i < 10; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribute the elements into the buckets based on the specified digit
        for (int i = 0; i < arr.size(); i++) {
            int bucketIndex = (arr.get(i) / div) % 10;
            buckets.get(bucketIndex).add(arr.get(i));
        }

        // Merge the elements from all the buckets back into the original array
        int index = 0;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < buckets.get(i).size(); j++) {
                arr.set(index++, buckets.get(i).get(j));
            }
        }
    }

    public static ArrayList<Integer> radix_sort(ArrayList<Integer> arr) {
        int n = arr.size();

        int maxElement = arr.get(0);
        for (int i = 1; i < n; i++) {
            maxElement = Math.max(maxElement, arr.get(i));
        }

        int div = 1;
        // Perform bucket sort for each digit, starting from the least significant digit
        while (true) {
            bucketSort(arr, div);

            // If the current digit is the Most Significant Digit of 'maxElement',
            // it means that the complete array has been sorted.
            if ((maxElement / div) / 10 == 0) {
                break;
            }

            div *= 10;
        }

        return arr;
    }
}
