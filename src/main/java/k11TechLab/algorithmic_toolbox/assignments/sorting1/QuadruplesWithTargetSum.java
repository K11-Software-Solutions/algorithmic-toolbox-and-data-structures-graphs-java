package k11TechLab.algorithmic_toolbox.assignments.sorting1;

/*
4 Sum
Given a list of numbers, find all the unique quadruples that sum up to a given target value.

Example
{
"arr": [0, 0, 1, 3, 2, -1],
"target": 3
}
Output:

[
[-1, 0, 1, 3],
[0, 0, 1, 2]
]
Notes
Two quadruples are considered different if there exists a number whose frequencies differ in those two quadruples.
The quadruples can be returned in any order.
The order of numbers inside any quadruple does not matter.
Constraints:

1 <= size of the input list <= 300
-105 <= any element of the input list <= 105
-4 * 105 <= target value <= 4 * 105

 */

public class QuadruplesWithTargetSum {

static ArrayList<ArrayList<Integer>> four_sum(ArrayList<Integer> arr, Integer target) {


    Collections.sort(arr);
    ArrayList<ArrayList<Integer>> response = new ArrayList<>();

    for(int first = 0; first < arr.size() - 3; first++) {
        if (first == 0 || !arr.get(first).equals(arr.get(first - 1))) {
            for (int second = first + 1; second < arr.size() - 2; second++) {
                if (second == first + 1 || (!arr.get(second).equals(arr.get(second - 1)))) {
                    findThreeSum(first, second, arr, target, response);
                }
            }
        }
    }


    return response;
}


static void findThreeSum(int first, int second, ArrayList<Integer> arr, Integer target, ArrayList<ArrayList<Integer>> response) {
    int st = second + 1;
    int end = arr.size() - 1;

    while (st < end) {
        int sum = arr.get(first) + arr.get(second) + arr.get(st) + arr.get(end);
        if (sum < target) {
            st++;
        } else if (sum > target) {
            end--;
        } else {
            response.add(new ArrayList<>(Arrays.asList(arr.get(first) , arr.get(second) , arr.get(st) , arr.get(end))));
            st++;
            end--;
            while (st < end && arr.get(st).equals(arr.get(st-1))){
                st++;
            }
        }
    }
}

