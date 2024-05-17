package k11TechLab.algorithmic_toolbox.assignments.sorting2;


/*
2 Sum In A Sorted Array
Given an array sorted in non-decreasing order and a target number, find the indices of the two values from the array that sum up to the given target number.

Example
{
"numbers": [1, 2, 3, 5, 10],
"target": 7
}
Output:

[1, 3]
Sum of the elements at index 1 and 3 is 7.

Notes
In case when no answer exists, return an array of size two with both values equal to -1, i.e., [-1, -1].
In case when multiple answers exist, you may return any of them.
The order of the indices returned does not matter.
A single index cannot be used twice.
Constraints:

2 <= array size <= 105
-105 <= array elements <= 105
-105 <= target number <= 105
Array can contain duplicate elements.
 */
public class PairWithTargetSumInSortedArray {


    //Brute Force Solution
    /*
     * Asymptotic complexity in terms of the size of `numbers` ( = `n`):
     * Time: O(n^2).
     * Auxiliary space: O(1).
     * Total space: O(n).
     */

    static ArrayList<Integer> pair_sum_sorted_array(ArrayList<Integer> numbers, Integer target) {

        // A list to store the pair of indices that adds to target.
        ArrayList<Integer> result = new ArrayList<Integer>();

        for (int i = 0; i < numbers.size(); i++) {
            // For every element in numbers we find its complementary pair that sum to
            // target.

            for (int j = i + 1; j < numbers.size(); j++) {

                // If target pair indices found.
                if (numbers.get(i) + numbers.get(j) == target) {

                    // Add them to result list and return.
                    result.add(i);
                    result.add(j);
                    return result;
                }
            }
        }

        // If no such pair of indices exist, add -1, -1 to list.
        result.add(-1);
        result.add(-1);
        return result;
    }


    //Hashing Solution
    /*
     * Asymptotic complexity in terms of the size of `numbers` = `n`:
     * Time: O(n).
     * Auxiliary space: O(n).
     * Total space: O(n).
     */

    static ArrayList<Integer> pair_sum_sorted_array(ArrayList<Integer> numbers, Integer target) {
        // A list to store the pair of indices that adds to target.
        ArrayList<Integer> result = new ArrayList<Integer>();

        // This Map stores the array element as Key and its index as Value.
        HashMap<Integer, Integer> array_index = new HashMap<Integer, Integer>();

        for (int i = 0; i < numbers.size(); i++) {
            int current = numbers.get(i);
            int required = target - current; // complementary target pair

            if (array_index.containsKey(required)) {
                result.add(array_index.get(required)); // store index of required in result
                result.add(i);
                return result;
            }

            // Add every element to map after checking for required.
            // This ensures element does not math itself (indices to be unique).
            array_index.put(current, i);
        }

        // If no such pair of indices exist, add -1, -1 to list.
        result.add(-1);
        result.add(-1);
        return result;
    }


    //Two Pointer Solution
    /*
     * Asymptotic complexity in terms of the size of `numbers` = `n`:
     * Time: O(n).
     * Auxiliary space: O(1).
     * Total space: O(n).
     */

    static ArrayList<Integer> pair_sum_sorted_array(ArrayList<Integer> numbers, Integer target) {
        // A list to store the pair of indices that adds to target.
        ArrayList<Integer> result = new ArrayList<Integer>();

        int left = 0, right = numbers.size() - 1;

        while (left < right) {
            // Current sum is the sum of numbers at left and right indices.

            if (numbers.get(left) + numbers.get(right) == target) {
                result.add(left);
                result.add(right);
                return result;
            }
            // If the current sum is less than target, move left to (left + 1).
            // Element at (left + 1) is greater than the element at left, as the given array is sorted.
            else if (numbers.get(left) + numbers.get(right) < target) {
                left++;
            }
            // If the current sum is more than target, move right to (right - 1).
            // Element at (right - 1) is less than the element at right.
            else {
                right--;
            }
        }

        // If no such pair of indices exist, add -1, -1 to list.
        result.add(-1);
        result.add(-1);
        return result;
    }



}
