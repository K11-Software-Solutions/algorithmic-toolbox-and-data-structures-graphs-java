package k11TechLab.algorithmic_toolbox.sorting.countingsort;

public class CountingSortMemoryOptimized {

    static ArrayList<Integer> counting_sort(ArrayList<Integer> arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(Integer a : arr) {
            if( map.containsKey(a) ) {
                map.put( a, map.get(a) + 1 );
            } else {
                map.put(a, 1);
            }
        }
        arr.clear();

        Set<Map.Entry<Integer, Integer> > entries
                = map.entrySet();

        for (Map.Entry<Integer, Integer> entry : entries) {
            //System.out.println(entry.getKey() + "->"
            //                   + entry.getValue());
            int count = entry.getValue();
            for( int i=0; i < count; ++i ) {
                arr.add(entry.getKey());
            }
        }

        return arr;
    }
}
