package k11TechLab.algorithmic_toolbox.assignments.sorting1;

/*
3 Sum Smaller
Given a list of numbers, count the number of triplets having a sum less than a given target.

Example One
{
"target": 4,
"numbers": [5, 0, -1, 3, 2]
}
Output:

2
{numbers[1], numbers[2], numbers[3]} and {numbers[1], numbers[2], numbers[4]} are the triplets having sum less than 4.

Example Two
{
"target": 7,
"numbers": [2, 2, 2, 1]
}
Output:

4
{numbers[0], numbers[1], numbers[2]}, {numbers[0], numbers[1], numbers[3]}, {numbers[0], numbers[2], numbers[3]} and {numbers[1], numbers[2], numbers[3]} are the triplets having sum less than 7.

Notes
The original array's indexes identify a triplet. Therefore, any two triplets will differ if they are denoted by a different triplet of indexes, even if the values present at those indexes are the same. Please observe Example Two for more details on this.

Constraints:

3 <= size of the input list <= 103
-105 <= any element of the input list <= 105
-109 <= target number <= 109
 */
public class TripletsWithLessThanTargetSum {
    static Integer count_triplets(Integer target, ArrayList<Integer> numbers) {
        // Write your code here.
        Collections.sort(numbers);
        int count = 0;
        int n = numbers.size();
        int[] nums = new int[n];
        for(int i=0; i<n; i++)
            nums[i] = numbers.get(i);

        for(int i=0;i<n; i++) {
            int left = i+1;
            int right = n - 1;
            while(right >= left) {
                if(nums[i]+nums[left]+nums[right] <target)
                {
                    count = count + right - left; //If this condition true then all between left and right sum will be less than target
                    left++;
                }  else  {
                    right--;
                }
            }
        }
        return count;
    }

}
