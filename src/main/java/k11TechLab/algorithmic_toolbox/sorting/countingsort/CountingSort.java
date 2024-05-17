package k11TechLab.algorithmic_toolbox.sorting.countingsort;

public class CountingSort {
    /*
     * Asymptotic complexity in terms of size of `arr` `n`, range `m`:
     * Time: O(n + m).
     * Auxiliary space: O(n).
     * Total space: O(n).
     */

    public static ArrayList<Integer> counting_sort(ArrayList<Integer> arr) {
        int n = arr.size();

        // Find the minimum and maximum elements in the array
        int minElement = arr.get(0), maxElement = arr.get(0);
        for (int i = 1; i < n; i++) {
            int currentElement = arr.get(i);
            minElement = Math.min(minElement, currentElement);
            maxElement = Math.max(maxElement, currentElement);
        }

        // Create a frequency map to count the occurrences of each element
        Map<Integer, Integer> frequency = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int currentElement = arr.get(i);
            frequency.put(currentElement, frequency.getOrDefault(currentElement, 0) + 1);
        }

        // Fill in the sorted array based on the frequencies
        int arrIndex = 0;
        for (int i = minElement; i <= maxElement; i++) {
            int currentFrequency = frequency.getOrDefault(i, 0);
            while (currentFrequency > 0) {
                arr.set(arrIndex++, i);
                currentFrequency--;
            }
        }

        return arr;
    }

}
