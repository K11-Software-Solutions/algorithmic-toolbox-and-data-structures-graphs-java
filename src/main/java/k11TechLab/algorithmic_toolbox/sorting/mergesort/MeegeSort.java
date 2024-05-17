package k11TechLab.algorithmic_toolbox.sorting.mergesort;

public class MeegeSort {
    static ArrayList<Integer> merge_sort(ArrayList<Integer> arr) {
        // Write your code here.
        helperMerger(arr, 0, arr.size()-1);
        return arr;
    }

    static void helperMerger(ArrayList<Integer> A, int start, int end){
        // LEAF
        if (start == end){
            return;
        }
        //MID
        int mid = (end-start)/2 +start; // Need to remember mid formula.
        helperMerger(A, start, mid);
        helperMerger(A, mid+1, end);

        merge(A,start, mid, end); // Easier to split the Merge into separate function
    }
    static void merge(ArrayList<Integer> A, int start, int mid, int end){
        ArrayList<Integer> aux = new ArrayList<>(end-start+1);
        int I=start;
        int J = mid+1;
        while (I <= mid && J <= end) {  //Forgot to add main for loop
            //Combine (assume return left, right)
            if(A.get(I) <= A.get(J)){
                aux.add(A.get(I));
                I++;
            } else {
                aux.add(A.get(J));
                J++;
            }
        }
        // GATHER:
        while(I <= mid){
            aux.add(A.get(I));
            I++;
        }
        while (J<= end){ // J<= end instead of A.size()
            aux.add(A.get(J));
            J++;
        }
        // COPY  // GOTCHA need to copy AUX to array so no return values in the helpers!!
        for(int i = start; i<=end; i++){  /// GOTCHA....Array A is subset so i = start and not 0
            A.set(i, aux.get(i-start )); //<< GOTCHA i-start since AUX starts at 0
        }

    }
}
