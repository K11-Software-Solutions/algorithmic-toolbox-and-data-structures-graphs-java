package k11TechLab.algorithmic_toolbox.assignments.sorting1;

/*
3 Sum
Given an integer array arr of size n, find all magic triplets in it.

Magic triplet is a group of three numbers whose sum is zero.

Note that magic triplets may or may not be made of consecutive numbers in arr.

Example
{
"arr": [10, 3, -4, 1, -6, 9]
}
Output:

["10,-4,-6", "3,-4,1"]
Notes
Function must return an array of strings. Each string (if any) in the array must represent a unique magic triplet and strictly follow this format: "1,2,-3" (no whitespace, one comma between numbers).
Order of the strings in the array is insignificant. Order of the integers in any string is also insignificant. For example, if ["1,2,-3", "1,-1,0"] is a correct answer, then ["0,1,-1", "1,-3,2"] is also a correct answer.
Triplets that only differ by order of numbers are considered duplicates, and duplicates must not be returned. For example, if "1,2,-3" is a part of an answer, then "1,-3,2", "-3,2,1" or any permutation of the same numbers may not appear in the same answer (though any one of them may appear instead of "1,2,-3").
Constraints:

1 <= n <= 2000
-1000 <= any element of arr <= 1000
arr may contain duplicate numbers
arr is not necessarily sorted
 */
public class TripletWithZeroSum {
    static ArrayList<String> find_zero_sum(ArrayList<Integer> arr) {
        Collections.sort(arr);

        ArrayList<String> result = new ArrayList<>();
        int[] nums = new int[arr.size()];

        for (int i = 0; i < arr.size(); i++) {
            nums[i] = arr.get(i);
        }

        for (int i = 0; i < nums.length - 1; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int target = -nums[i];
            int left = i + 1, right = arr.size() - 1;
            while (left < right) {
                if ((nums[left] + nums[right] > target)) {
                    right--;
                } else if (nums[left] + nums[right] < target) {
                    left++;
                } else {
                    String triplet = buildResultTriplet(nums[i], nums[left], nums[right]);
                    result.add(triplet);
                    left++; right--;
                    while (left < right && nums[left] == nums[left - 1]) left++;
                }
            }
        }

        return result;
    }

    static String buildResultTriplet(int i, int j, int k) {
        return new StringBuilder().append(i).append(",").append(j).append(",").append(k).toString();
    }

}
