package k11TechLab.algorithmic_toolbox.assignments.sorting2;

/*
Merge K Sorted Linked Lists
Given k linked lists where each one is sorted in the ascending order, merge all of them into a single sorted linked list.

Example
{
"lists": [
[1, 3, 5],
[3, 4],
[7]
]
}
Output:

[1, 3, 3, 4, 5, 7]
Notes
Constraints:

0 <= k <= 104
0 <= length of any given linked list <= 103
-109 <= node values <= 109
Sum of the lengths of all given lists won't exceed 105.
 */

public class MergeKSortedLinkedList {

    //Brute Force Solution
    /*
     * Asymptotic complexity in terms of total length of all given linked lists `n` and `k`:
     * Time: O(n * k).
     * Auxiliary space: O(1).
     * Total space: O(n + k).
     */

    static LinkedListNode merge_k_lists(ArrayList<LinkedListNode> lists) {
        LinkedListNode head = null;
        LinkedListNode tail = null;

        int min_index;
        while (true) {
            min_index = (int) (1e9 + 1);

            // Finding the list index with the minimum value of head node.
            for (int i = 0; i < lists.size(); i++) {
                if (lists.get(i) != null) {
                    if (min_index == 1e9 + 1 || lists.get(i).value < lists.get(min_index).value) {
                        min_index = i;
                    }
                }
            }
            if (min_index == 1e9 + 1) {
                break;
            }

            if (head == null) {
                head = lists.get(min_index);
                tail = lists.get(min_index);
            } else {
                tail.next = lists.get(min_index);
                tail = tail.next;
            }

            // Updating the node at min_index with its next node.
            lists.set(min_index, lists.get(min_index).next);
            tail.next = null;
        }
        return head;
    }


    //Divide And Conquer solution
    /*
     * Asymptotic complexity in terms of total length of all given linked lists `n` and `k`:
     * Time: O(n * log(k)).
     * Auxiliary space: O(1).
     * Total space: O(n + k).
     */

    static LinkedListNode merge_2_lists(LinkedListNode head1, LinkedListNode head2) {
        if (head1 == null) {
            return head2;
        }
        if (head2 == null) {
            return head1;
        }

        // Using a dummy node to merge two linked lists.
        // All the nodes, including the head will be
        // inserted after this dummy node.
        LinkedListNode dummy = new LinkedListNode(0);
        LinkedListNode tail = dummy;

        while (head1 != null || head2 != null) {
            if (head1 == null) {
                tail.next = head2;
                head2 = head2.next;
            } else if (head2 == null) {
                tail.next = head1;
                head1 = head1.next;
            } else {
                if (head1.value < head2.value) {
                    tail.next = head1;
                    head1 = head1.next;
                } else {
                    tail.next = head2;
                    head2 = head2.next;
                }
            }
            tail = tail.next;
        }

        // Head of the merged linked list is dummy.next.
        return dummy.next;
    }

    static LinkedListNode merge_k_lists(ArrayList<LinkedListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }

        int low, high, last = lists.size() - 1;

        // Continue until we are left with only a single linked list.
        while (last != 0) {
            low = 0;
            high = last;
            while (low < high) {
                lists.set(low, merge_2_lists(lists.get(low), lists.get(high)));
                low++;
                high--;
            }

            last = high;
        }
        return lists.get(0);
    }


    //Priority Queue Solution
    /*
     * Asymptotic complexity in terms of total length of all given linked lists `n` and `k`:
     * Time: O(n * log(k)).
     * Auxiliary space: O(1).
     * Total space: O(n + k).
     */

    static class pair implements Comparable<pair> {
        int value, index;

        public pair(int value, int index) {
            this.value = value;
            this.index = index;
        }

        @Override
        public int compareTo(pair o) {
            // TODO Auto-generated method stub
            return this.value - o.value;
        }
    }

    static LinkedListNode merge_k_lists(ArrayList<LinkedListNode> lists) {
        LinkedListNode head = null;
        LinkedListNode tail = null;

        PriorityQueue<pair> pq = new PriorityQueue<>();

        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                pq.add(new pair(lists.get(i).value, i));
            }
        }

        int min_index;
        while (pq.isEmpty() == false) {
            min_index = pq.peek().index;
            pq.poll();

            if (head == null) {
                head = lists.get(min_index);
                tail = lists.get(min_index);
            } else {
                tail.next = lists.get(min_index);
                tail = tail.next;
            }

            lists.set(min_index, lists.get(min_index).next);
            tail.next = null;

            if (lists.get(min_index) != null) {
                pq.add(new pair(lists.get(min_index).value, min_index));
            }
        }
        return head;
    }

}
