package k11TechLab.algorithmic_toolbox.assignments.sorting2;

/*
Kth Largest In A Stream
Given an initial list along with another list of numbers to be appended with the initial list and an integer k, return an array consisting of the k-th largest element after adding each element from the first list to the second list.

Example
{
"k": 2,
"initial_stream": [4, 6],
"append_stream": [5, 2, 20]
}
Output:

[5, 5, 6]
Append	Stream	Sorted Stream	2nd largest
5	[4, 6, 5]	[4, 5, 6]	5
2	[4, 6, 5, 2]	[2, 4, 5, 6]	5
20	[4, 6, 5, 2, 20]	[2, 4, 5, 6, 20]	6
Notes
The stream can contain duplicates.
Constraints:

1 <= length of both lists <= 105
1 <= k <= length of initial list + 1
0 <= any value in the list <= 109
 */

public class KthLargestInAStream {

    //Brute Force Solution
    /*
     * Asymptotic complexity in terms of the size of `initial_stream` `n` and the size of `append_stream` `m`:
     * Time: O(m * (m + n) * log(n + m)).
     * Auxiliary space: O(m).
     * Total space: O(n + m).
     */

    static ArrayList<Integer> kth_largest(Integer k, ArrayList<Integer> initial_stream, ArrayList<Integer> append_stream) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < append_stream.size(); i++) {
            initial_stream.add(append_stream.get(i));

            Collections.sort(initial_stream);

            // kth element from the end will be the kth largest element.
            result.add(initial_stream.get(initial_stream.size() - k));
        }

        return result;
    }


    //Heap Solution
    /*
     * Asymptotic complexity in terms of `k`, the size of `initial_stream` `n` and the size of `append_stream` `m`:
     * Time: O(log(k) * (n + m)).
     * Auxiliary space: O(k).
     * Total space: O(n + m + k).
     */

    static ArrayList<Integer> kth_largest(Integer k, ArrayList<Integer> initial_stream, ArrayList<Integer> append_stream) {

        // Priority queue's internal implementation is the same as a binary heap.
        PriorityQueue<Integer> min_heap = new PriorityQueue<Integer>();

        for (int i = 0; i < initial_stream.size(); i++) {
            min_heap.add(initial_stream.get(i));

            // Make sure that the heap size does not exceed k.
            if (min_heap.size() > k)
                min_heap.poll(); // Remove the element smaller than the k largest elements.
        }

        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < append_stream.size(); i++) {
            min_heap.add(append_stream.get(i));

            // Make sure that the heap size does not exceed k.
            if (min_heap.size() > k)
                min_heap.poll(); // Remove the element smaller than the k largest elements.

            // Adding current k-th largest element.
            result.add(min_heap.peek());
        }

        return result;
    }


}
