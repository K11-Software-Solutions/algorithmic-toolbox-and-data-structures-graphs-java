package k11TechLab.algorithmic_toolbox.assignments.sorting2;

/*
Attend Meetings
Given a list of meeting intervals where each interval consists of a start and an end time, check if a person can attend all the given meetings such that only one meeting can be attended at a time.

Example One
{
"intervals": [
[1, 5],
[5, 8],
[10, 15]
]
}
Output:

1
As the above intervals are non-overlapping intervals, it means a person can attend all these meetings.

Example Two
{
"intervals": [
[1, 5],
[4, 8]
]
}
Output:

0
Time 4 - 5 is overlapping in the first and second intervals.

Notes
A new meeting can start at the same time the previous one ended.
Constraints:

1 <= number of intervals <= 105
0 <= start time < end time <= 109
 */
public class AttendMeetings {

    //Brute Force Method
    /*
     * Asymptotic complexity in terms of the length of `intervals` `n`:
     * Time: O(n^2).
     * Auxiliary space: O(1).
     * Total space: O(n).
     */

    static Integer can_attend_all_meetings(ArrayList<ArrayList<Integer>> intervals) {

        for (int i = 0; i < intervals.size(); i++) {
            for (int j = i + 1; j < intervals.size(); j++) {
                // If overlap found, return 0.
                if (!(intervals.get(i).get(1) <= intervals.get(j).get(0)
                        || intervals.get(j).get(1) <= intervals.get(i).get(0))) {
                    return 0;
                }
            }
        }
        return 1;
    }


    //optimal_solution
    /*
    Since the meeting will be attended starting from the one with the smallest start time
    and moving ahead in the sorted order of the start times of the listed meetings,
    it will be beneficial to sort all the given intervals based on their starting times.

    1. Apply primary sort on the intervals by the start time and secondary sort by the end time.
    2. Compare only the adjacent intervals to check if overlapping is present or not.
    3. If the end time of some interval is found greater than the start time of the next interval,
       it means these two intervals are overlapping.

    Note: As the intervals are sorted, we can say if all the adjacent intervals are non-overlapping,
    intervals not adjacent are also non-overlapping.
     * Asymptotic complexity in terms of the length of `intervals` `n`:
     * Time: O(n * log(n)).
     * Auxiliary space: O(1).
     * Total space: O(n).
     */

    static Integer can_attend_all_meetings(ArrayList<ArrayList<Integer>> intervals) {
        // Sorting in ascending order of start time of an interval.
        // If start time is same for two intervals then sort in ascending order of end
        // time of intervals.
        Collections.sort(intervals, (a, b) -> {
            if (a.get(0) - b.get(0) == 0)
                return a.get(1) - b.get(1);
            return a.get(0) - b.get(0);
        });

        for (int i = 0; i < intervals.size() - 1; i++) {
            int end_time_current_interval = intervals.get(i).get(1);
            int start_time_next_interval = intervals.get(i + 1).get(0);

            // If overlap found, return 0.
            if (end_time_current_interval > start_time_next_interval)
                return 0;
        }
        return 1;
    }

}
