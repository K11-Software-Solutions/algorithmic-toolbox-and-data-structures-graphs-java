package k11TechLab.algorithmic_toolbox.assignments.sorting2;

/*
Kth Largest In An Array
Given an array of integers, find the k-th largest number in it.

Example One
{
"numbers": [5, 1, 10, 3, 2],
"k": 2
}
Output:

5
Example Two
{
"numbers": [4, 1, 2, 2, 3],
"k": 4
}
Output:

2
Notes
Constraints:

1 <= array size <= 3 * 105
-109 <= array elements <= 109
1 <= k <= array size
 */
public class KthLargestInArray {

    /*
    Since we need the k-th largest element in sorted order, one way is to sort the array
    and then return the k-th element from the end of the sorted array.
    This solution will have a time complexity of O(n * log(n)).
    We can do better than this.
     */

    /*
     * Asymptotic complexity in terms of the length of `numbers` `n`:
     * Time: O(n^2).
     * Auxiliary space: O(1).
     * Total space: O(n).
     */

    //quick_sort_solution
    static Integer kth_largest_in_an_array(ArrayList<Integer> numbers, Integer k) {
        int low = 0, high = numbers.size() - 1;

        while (low <= high) {
            int pivot = partition(numbers, low, high);

            // K-th largest element will be at the index (numbers.size() - k) in the sorted array.
            if (pivot == numbers.size() - k) {
                return numbers.get(pivot);
            } else if (pivot < numbers.size() - k) {
                low = pivot + 1;
            } else {
                high = pivot - 1;
            }
        }

        // This part will never be executed.
        return -1;
    }

    public static int partition(ArrayList<Integer> numbers, int low, int high) {
        Random rand = new Random();
        int random_index = rand.nextInt(high - low + 1) + low;

        // Moving a random element at the end and then partitioning around that random element.
        Collections.swap(numbers, random_index, high);

        int pivot_element = numbers.get(high), i = low;

        // This loop places the numbers which are less than or equal to the pivot
        // element at the beginning of the subarray [low, high].
        for (int j = low; j <= high - 1; j++) {
            if (numbers.get(j) <= pivot_element) {
                Collections.swap(numbers, i, j);
                i++;
            }
        }

        Collections.swap(numbers, i, high);
        return i;
    }

    //priority_queue_solution
    /*
     * Asymptotic complexity in terms of the length of `numbers` `n` and `k`:
     * Time: O(k + (n - k) * log(k)).
     * Auxiliary space: O(k).
     * Total space: O(n).
     */

    static Integer kth_largest_in_an_array(ArrayList<Integer> numbers, Integer k) {
        // Creating a min-heap.
        PriorityQueue<Integer> top_k = new PriorityQueue<Integer>();

        for (int i = 0; i < k; i++) {
            top_k.add(numbers.get(i));
        }

        for (int i = k; i < numbers.size(); i++) {
            if (numbers.get(i) > top_k.peek()) {
                top_k.poll();
                top_k.add(numbers.get(i));
            }
        }

        return top_k.peek();
    }

}
