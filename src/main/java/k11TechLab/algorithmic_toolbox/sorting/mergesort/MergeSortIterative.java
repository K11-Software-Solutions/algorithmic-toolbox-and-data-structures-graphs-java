package k11TechLab.algorithmic_toolbox.sorting.mergesort;

public class MergeSortIterative {

    /*
   Asymptotic complexity in terms of size of `arr` `n`:
   * Time: O(n * log(n)).
   * Auxiliary space: O(n).
   * Total space: O(n).
   */
    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        int n = arr.size();
        int left = 0, right = n - 1;
        split(arr, left, right);
        return arr;
    }

    static void split(List<Integer> arr, int l, int h) {
        // divide the array into blocks of size [1, 2, 4, 8, ..]
        for (int blocks = 1; blocks <= h - l; blocks = 2 * blocks) {
            // for blocks = 1, i = 0, 2, 4, 6, 8 and so on
            // for each block we split the array into sub arrays and merge them
            /* note that each of these subarrays will always be sorted as we are
             building the array from smaller subarrays to larger subarrays*/
            for (int i = l; i < h; i += 2 * blocks) {
                int left = i;
                int mid = Math.min(i + blocks - 1, h);
                int right = Math.min(i + 2 * blocks - 1, h);
                merge(arr, left, mid, right);
            }
        }
    }

    /*function to merge 2 sorted arrays*/
    static void merge(List<Integer> arr, int left, int mid, int right) {
        int[] l = new int[mid - left + 1];
        //copies the integers to array l from arr
        for(int i = 0; i < mid - left + 1; i++) {
            l[i] = arr.get(left + i);
        }
        int[] r = new int[right - mid];
        //copies the integers to array r from arr
        for(int i = 0; i < right - mid; i++) {
            r[i] = arr.get(mid + i + 1);
        }
        int i = 0, j = 0, k = left;
        //merges arrays l and r back to arr
        while(i < l.length && j < r.length) {
            if(l[i] <= r[j]) {
                arr.set(k, l[i]);
                i++;
            }
            else {
                arr.set(k, r[j]);
                j++;
            }
            k++;
        }
        //merges remaining elements of arrays l and r
        while(i < l.length) {
            arr.set(k++, l[i++]);
        }
        while(j < r.length) {
            arr.set(k++, r[j++]);
        }
    }
}
