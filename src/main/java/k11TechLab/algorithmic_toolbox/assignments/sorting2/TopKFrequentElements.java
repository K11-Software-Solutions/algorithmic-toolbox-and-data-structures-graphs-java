package k11TechLab.algorithmic_toolbox.assignments.sorting2;


public class TopKFrequentElements {

    /*A brute force that you might think of is to first store the (number, frequency)
    pairs for all the distinct elements in an array, sort the array based on the frequency
    and then return the largest k elements of this sorted array.
    This approach takes an O(n * log(n)) time in the worst case.
    We can do better than this.
    */

   //quick_select_solution

    /*
    sort all the unique elements present in the array based on their frequencies.
    So, any two elements will be compared based on their frequencies and not on their values.

    We will first store the frequencies of all the distinct elements present in the array
    in a hashmap and using this hashmap, we will build an array of unique elements present in the array.

     * Asymptotic complexity in terms of size of `arr` `n` and `k`:
     * Time: O(n^2).
     * Auxiliary space: O(n).
     * Total space: O(n + k).
     */

    static int partition(ArrayList<Integer> unique, Integer low, Integer high, HashMap<Integer, Integer> frequency) {
        int random_pivot_index = (int) (Math.random() % (high - low + 1) + low);
        int pivot_freq = frequency.get(unique.get(random_pivot_index));

        Collections.swap(unique, random_pivot_index, high);
        int i = low;

        // This loop places the elements whose frequency is less than or equal to the frequency of
        // the pivot element at the beginning of the subarray [low, high].
        for (int j = low; j <= high - 1; j++) {
            if (frequency.get(unique.get(j)) <= pivot_freq) {
                Collections.swap(unique, i, j);
                i++;
            }
        }
        Collections.swap(unique, i, high);
        return i;
    }

    static void quick_select(ArrayList<Integer> unique, Integer k, HashMap<Integer, Integer> frequency) {
        int low = 0, high = unique.size() - 1;

        while (low <= high) {
            int pivot = partition(unique, low, high, frequency);

            if (pivot == unique.size() - k) {
                return;
            } else if (pivot > unique.size() - k) {
                high = pivot - 1;
            } else {
                low = pivot + 1;
            }
        }
    }

    static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, int k) {
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr.size(); i++) {
            frequency.put(arr.get(i), frequency.getOrDefault(arr.get(i), 0) + 1);
        }

        ArrayList<Integer> unique = new ArrayList<Integer>();
        for (Integer key : frequency.keySet()) {
            unique.add(key);
        }

        // Partially sorting the array based on their occurrence frequency such that
        // the last k indices contain the Top k most frequent elements.
        quick_select(unique, k, frequency);

        ArrayList<Integer> res = new ArrayList<>();
        for (int i = unique.size() - k; i < unique.size(); i++) {
            res.add(unique.get(i));
        }
        return res;
    }

    // Heap Solution
    /*
     * Asymptotic complexity in terms of size of `arr` `n` and `k`:
     * Time: O(n * log(k)).
     * Auxiliary space: O(n + k).
     * Total space: O(n + k).
     */

    // Data structure to encapsulate elements of arr and their frequency together.
    static class pair implements Comparable<pair> {
        int element, frequency;

        public pair(int element, int frequency) {
            this.element = element;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(pair o) {
            // TODO Auto-generated method stub
            return this.frequency - o.frequency;
        }
    }

    static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        if (k == arr.size()) {
            return arr;
        }

        // Calculate and store frequency of all elements.
        HashMap<Integer, Integer> frequency = new HashMap<>();
        for (int i : arr) {
            frequency.put(i, frequency.getOrDefault(i, 0) + 1);
        }

        // Creating a min-heap of size k.
        PriorityQueue<pair> pq = new PriorityQueue<>();
        for (int element : frequency.keySet()) {
            int freq_of_element = frequency.get(element);
            pq.add(new pair(element, freq_of_element));

            // Keeping top k elements in priority queue.
            // Popping lower (extra) elements.
            if (pq.size() > k) {
                pq.poll();
            }
        }

        ArrayList<Integer> result = new ArrayList<>(k);

        for (int i = 0; i < k; i++) {
            result.add(pq.peek().element);
            pq.poll();
        }
        return result;
    }


    //counting_sort_solution
    /*
     * Asymptotic complexity in terms of size of `arr` `n` and `k`:
     * Time: O(n).
     * Auxiliary space: O(n).
     * Total space: O(n + k).
     */

    static ArrayList<Integer> find_top_k_frequent_elements(ArrayList<Integer> arr, Integer k) {
        HashMap<Integer, Integer> frequency = new HashMap<Integer, Integer>();
        ArrayList<ArrayList<Integer>> numbers = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer, Boolean> taken = new HashMap<Integer, Boolean>();

        for (int i = 0; i < arr.size() + 1; i++) {
            numbers.add(new ArrayList<Integer>());
        }

        // Store the frequency of every element.
        for (int i = 0; i < arr.size(); i++) {
            frequency.put(arr.get(i), frequency.getOrDefault(arr.get(i), 0) + 1);
        }

        // Store every element at the index equal to its frequency in 'numbers'.
        for (int i = 0; i < arr.size(); i++) {
            if (taken.getOrDefault(arr.get(i), false)) {
                continue;
            } else {
                taken.put(arr.get(i), true);
                numbers.get(frequency.get(arr.get(i))).add(arr.get(i));
            }
        }

        ArrayList<Integer> result = new ArrayList<Integer>();

        // Build 'result' by taking elements with top frequency from 'numbers'.
        for (int i = arr.size(); i >= 1; i--) {
            while (numbers.get(i).size() > 0 && k > 0) {
                k--;
                result.add(numbers.get(i).get(numbers.get(i).size() - 1));
                numbers.get(i).remove(numbers.get(i).size() - 1);
            }
            if (k == 0) {
                break;
            }
        }

        return result;
    }



}
