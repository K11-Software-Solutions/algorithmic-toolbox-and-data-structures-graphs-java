package k11TechLab.algorithmic_toolbox.sorting.radixsort;

public class RadixSort {

    static ArrayList<Integer> radix_sort(ArrayList<Integer> arr)
    {
        List<List<Integer>> bucket = make_bucket(256);
        for (int c = 0; c < arr.size(); c++) {
            int val = arr.get(c);
            int dig = digit(val, 0);
            bucket.get(dig).add(val);
        }

        for (int d = 1; d < 4; d++) {
            List<List<Integer>> bucket1 = make_bucket(256);

            for (List<Integer> list: bucket) {
                for (Integer ii: list) {
                    int dig = digit(ii, d);
                    bucket1.get(dig).add(ii);
                }
            }

            bucket = bucket1;
        }

        ArrayList<Integer> res = new ArrayList<Integer>();

        for (List<Integer> list: bucket) {
            for (Integer ii: list) {
                res.add(ii);
            }
        }

        return res;
    }

    static List<List<Integer>> make_bucket(int size) {
        List<List<Integer>> bucket = new ArrayList<List<Integer>>(size);
        for (int c = 0; c < size; c++) {
            bucket.add(new ArrayList<Integer>());
        }
        return bucket;
    }

    static int digit(int value, int pos) {
        return (value >> (pos * 8)) & 0xFF;
    }
}
