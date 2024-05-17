package k11TechLab.algorithmic_toolbox.assignments.sorting1;

/*
Given some balls of three colors arranged in a line, rearrange them such that all the red balls go first, then green and then blue ones.

Do rearrange the balls in place. A solution that simply counts colors and overwrites the array is not the one we are looking for.

This is an important problem in search algorithms theory proposed by Dutch computer scientist Edsger Dijkstra. Dutch national flag has three colors (albeit different from ones used in this problem).

Example
{
"balls": ["G", "B", "G", "G", "R", "B", "R", "G"]
}
Output:

["R", "R", "G", "G", "G", "G", "B", "B"]
There are a total of 2 red, 4 green and 2 blue balls. In this order they appear in the correct output.

Notes
Constraints:

1 <= n <= 100000
Do this in ONE pass over the array, NOT TWO passes
Solution is only allowed to use constant extra memory
 */

public class DutchNationalFlag {
    static ArrayList<Character> dutch_flag_sort(ArrayList<Character> balls) {
        int red = 0;
        int blue = balls.size() - 1;
        int p = 0;
        while(p <= blue) {
            if(balls.get(p) == 'R') {
                Collections.swap(balls, p, red);
                red++;
            }
            if (balls.get(p) == 'B') {
                Collections.swap(balls, p, blue);
                blue--;
            } else {
                p++;
            }

        }
        return balls;
    }


}
