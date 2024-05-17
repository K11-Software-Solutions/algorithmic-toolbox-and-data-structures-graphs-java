package k11TechLab.algorithmic_toolbox.sorting.selectionsort;

public class SelectionSortIterative {


    /*
    Asymptotic complexity in terms of `n` =  size of the input array:
    * Time: O(n^2).
    * Auxiliary space: O(1).
    * Total space: O(n).
    */

    static ArrayList<Integer> selection_sort(ArrayList<Integer> arr) {
        int n = arr.size();

        // Each iteration will fill arr.get(i) with its appropriate value.
        for (int i = 0; i < n - 1; i++) {

            // Finding the index of the smallest element in arr.get(i ... n-1).
            int min_element_index = i;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(j) < arr.get(min_element_index)) {
                    min_element_index = j;
                }
            }

            // Swap elements
            int temp = arr.get(i);
            arr.set(i, arr.get(min_element_index));
            arr.set(min_element_index, temp);
        }
        return arr;
    }
}
