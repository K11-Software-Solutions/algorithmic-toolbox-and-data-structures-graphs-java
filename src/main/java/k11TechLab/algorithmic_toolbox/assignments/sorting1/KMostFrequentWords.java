package k11TechLab.algorithmic_toolbox.assignments.sorting1;

/*
K Most Frequent Words
Given a number and a list of words, return the given number of most frequent words.

Example
{
"k": 4,
"words": ["car", "bus", "taxi", "car", "driver", "candy", "race", "car", "driver", "fare", "taxi"]
}
Output:

["car", "driver", "taxi", "bus"]
Notes
Every word consists of only lowercase English letters.
Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.
Constraints:

1 <= number of words <= 105
1 <= size of each word <= 10
1 <= the given number <= the number of unique words
 */
public class KMostFrequentWords {

    static ArrayList<String> k_most_frequent(Integer k, ArrayList<String> words) {
        if(words == null)
            return null;

        Map<String, Integer> wordCount = new HashMap();
        int totalElement = 0;
        for(String word: words){
            totalElement++;
            if(wordCount.containsKey(word)){
                int count = wordCount.get(word);
                wordCount.put(word, count+1);
            }else{
                wordCount.put(word,1);
            }
        }

        PriorityQueue<Map.Entry<String, Integer>> heap = new PriorityQueue<>((entry1, entry2) -> {
            if (entry1.getValue() < entry2.getValue()) {
                return 1;
            } else if(entry1.getValue() > entry2.getValue()){
                return -1;
            } else {
                return entry1.getKey().compareTo(entry2.getKey());
            }
        });

        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            heap.offer(entry);
        }

        ArrayList<String> output = new ArrayList();
        for (int  i = 0; i < k; i++) {
            output.add(heap.poll().getKey());
        }
        // Write your code here.
        return output;
    }

}
