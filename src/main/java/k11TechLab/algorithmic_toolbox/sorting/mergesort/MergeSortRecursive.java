package k11TechLab.algorithmic_toolbox.sorting.mergesort;

public class MergeSortRecursive {
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

    /*function to partition the array into subarrays and then merge them*/
    static void split(List<Integer> arr, int left, int right) {
        if(left < right) {
            int mid = (left + right) / 2;
            //sort first and second halves of the array
            split(arr, left, mid);
            split(arr, mid + 1, right);
            //merge the sorted halves
            merge(arr, left, mid, right);
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
