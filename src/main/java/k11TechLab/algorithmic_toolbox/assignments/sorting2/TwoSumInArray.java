package k11TechLab.algorithmic_toolbox.assignments.sorting2;

/*
Given an array and a target number, find the indices of the two values from the array that sum up to the given target number.

Example One
{
"numbers": [5, 3, 10, 45, 1],
"target": 6
}
Output:

[0, 4]
Sum of the elements at index 0 and 4 is 6.

Example Two
{
"numbers": [4, 1, 5, 0, -1],
"target": 10
}
Output:

[-1, -1]
Notes
The function returns an array of size two where the two elements specify the input array indices whose values sum up to the given target number.
In case when no answer exists, return an array of size two with both values equal to -1, i.e., [-1, -1].
In case when multiple answers exist, you may return any of them.
The order of the returned indices does not matter.
A single index cannot be used twice.
Constraints:

2 <= array size <= 105
-105 <= array elements <= 105
-105 <= target number <= 105
Array can contain duplicate elements.
 */

public class TwoSumInArray {

    /*
     * Asymptotic complexity in terms of the size of `numbers` = `n`:
     * Time: O(n).
     * Auxiliary space: O(n).
     * Total space: O(n).
     */


    static ArrayList<Integer> two_sum(ArrayList<Integer> numbers, Integer target) {
        // Write your code here.

        Hashtable<Integer, Integer> traverseredElements = new Hashtable<>();

        for(int index = 0; index < numbers.size(); index++){

            if(traverseredElements.containsKey(target - numbers.get(index))) {
                return new ArrayList(
                        List.of(index, traverseredElements.get(target - numbers.get(index)))
                );
            } else {
                traverseredElements.put(numbers.get(index), index);
            }
        }


        return new ArrayList(List.of(-1, -1));
    }
}
