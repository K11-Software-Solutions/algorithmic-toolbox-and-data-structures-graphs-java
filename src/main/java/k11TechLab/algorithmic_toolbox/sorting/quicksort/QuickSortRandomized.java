package k11TechLab.algorithmic_toolbox.sorting.quicksort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;

public class QuickSortRandomized {

    public static int randomPartition(ArrayList<Integer> arr, int low, int high) {
        int randomIndex = low + new Random().nextInt(high - low + 1);
        Collections.swap(arr, randomIndex, high);

        int pivot = low;
        int pivotElement = arr.get(high);

        for (int i = low; i < high; i++) {
            if (arr.get(i) < pivotElement) {
                Collections.swap(arr, i, pivot);
                pivot++;
            }
        }
        Collections.swap(arr, pivot, high);
        return pivot;
    }

    public static ArrayList<Integer> quickSort(ArrayList<Integer> arr) {
        int n = arr.size();
        Stack<int[]> helper = new Stack<>();
        helper.push(new int[] {0, n - 1});

        while (!helper.empty()) {
            int[] range = helper.pop();
            int low = range[0];
            int high = range[1];

            if (low < high) {
                int pivot = randomPartition(arr, low, high);
                if (pivot - 1 > low) {
                    helper.push(new int[] {low, pivot - 1});
                }
                if (pivot + 1 < high) {
                    helper.push(new int[] {pivot + 1, high});
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(11);
        arr.add(13);
        arr.add(5);
        arr.add(6);
        arr.add(7);

        ArrayList<Integer> sortedArr = quickSort(arr);
        System.out.println("Sorted array is:");
        printArray(sortedArr);
    }

    public static void printArray(ArrayList<Integer> arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
