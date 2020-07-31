public class Solution {

    // Complete the countingValleys function below.
    static int countingValleys(int n, String s) {
        int updown = 0, res = 0;
        for(int i = 0; i < n ; i++)
        {
            if(s.charAt(i) == 'U')
                updown++;
            else
                updown--;
            if(updown == 0 && s.charAt(i) == 'U')
                res++;
        }
        return res;


    }
    // Very important
    // Remember whenever he reaches back to sea level from downward it is counted as valley...
    // As we know to reach to sea level from valley he needs have last element as U therefore s.charAt(i) =='U'
    // I have used
