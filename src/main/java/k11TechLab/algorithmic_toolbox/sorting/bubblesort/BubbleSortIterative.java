package k11TechLab.algorithmic_toolbox.sorting.bubblesort;

public class BubbleSortIterative {

     /*
    Asymptotic complexity in terms of size of `arr` `n`:
    * Time: O(n^2).
    * Auxiliary space: O(1).
    * Total space: O(n).
    */

    static ArrayList<Integer> bubble_sort(ArrayList<Integer> arr) {
        int n = arr.size();
        boolean isSwapped;

        // Each iteration will fill arr.get(n - i - 1) with its appropriate value.
        for (int i = 0; i < n - 1; i++) {
            isSwapped = true;
            for (int j = 0; j < n - i - 1; j++) {

                if (arr.get(j) > arr.get(j + 1)) {
                    // Swap elements
                    int temp = arr.get(j);
                    arr.set(j, arr.get(j + 1));
                    arr.set(j + 1, temp);
                    isSwapped = false;
                }
            }

            // Early stopping in case when no swap took place.
            if (isSwapped) {
                break;
            }
        }
        return arr;
    }
}
