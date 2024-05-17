package k11TechLab.algorithmic_toolbox.assignments.sorting2;


/*
Intersection Of Three Sorted Arrays
Given three arrays sorted in the ascending order, return their intersection sorted array in the ascending order.

Example One
{
"arr1": [2, 5, 10],
"arr2": [2, 3, 4, 10],
"arr3": [2, 4, 10]
}
Output:

[2, 10]
Example Two
{
"arr1": [1, 2, 3],
"arr2": [],
"arr3": [2, 2]
}
Output:

[-1]
Example Three
{
"arr1": [1, 2, 2, 2, 9],
"arr2": [1, 1, 2, 2],
"arr3": [1, 1, 1, 2, 2, 2]
}
Output:

[1, 2, 2]
Notes
If the intersection is empty, return an array with one element -1.
Constraints:

0 <= length of each given array <= 105
0 <= any value in a given array <= 2 * 106
 */
public class IntersectionOfThreeSortedArray {

    //Brute Force Method

    /*
     * Asymptotic complexity in terms of size of `arr1` `L`, size of `arr2` `M` and size of `arr3` `N`:
     * Time: O(L * (M + N)).
     * Auxiliary space: O(1).
     * Total space: O(L + M + N).
     */

    static ArrayList<Integer> find_intersection(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> arr3) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int j, k;
        for (int i = 0; i < arr1.size(); i++) {
            int counts = 0;

            for (j = 0; j < arr2.size(); j++) {
                // First common element will be used and marked as -1.
                if (arr2.get(j) == arr1.get(i)) {
                    counts++;
                    // To stop when first occurrence is matched.
                    break;
                }
            }

            for (k = 0; k < arr3.size(); k++) {
                // First common element will be used and marked as -1.
                if (arr3.get(k) == arr1.get(i)) {
                    counts++;
                    // To stop when first occurrence is matched.
                    break;
                }
            }

            // Checking if both the arrays have A[i]
            if (counts == 2) {
                result.add(arr1.get(i));
                arr2.set(j, -1);
                arr3.set(k, -1);
            }
        }

        if (result.size() == 0)
            result.add(-1);

        return result;
    }


    //optimal_solution

    /*
    The idea is to use the merging technique of the Merge Sort algorithm.
    We simulate merging the three arrays into one.
    While doing so, we will always consider the elements of the three arrays in sorted order,
    thus we can check for equality of the three elements being considered
    and get the common elements.
     * Asymptotic complexity in terms of size of `arr1` `L`, size of `arr2` `M` and size of `arr3` `N`:
     * Time: O(L + M + N).
     * Auxiliary space: O(1).
     * Total space: O(L + M + N).
     */

    static ArrayList<Integer> find_intersection(ArrayList<Integer> arr1, ArrayList<Integer> arr2, ArrayList<Integer> arr3) {
        ArrayList<Integer> result = new ArrayList<Integer>();

        int i = 0, j = 0, k = 0;
        int L = arr1.size(), M = arr2.size(), N = arr3.size();

        while ((i < L) && (j < M) && (k < N)) {

            if ((arr1.get(i).equals(arr2.get(j))) && (arr2.get(j).equals(arr3.get(k)))) {
                result.add(arr1.get(i));
            }

            int mini = Math.min(arr1.get(i), arr2.get(j));
            mini = Math.min(mini, arr3.get(k));

            if (mini == arr1.get(i))
                i++;
            if (mini == arr2.get(j))
                j++;
            if (mini == arr3.get(k))
                k++;
        }

        if (result.size() == 0)
            result.add(-1);

        return result;
    }

}
