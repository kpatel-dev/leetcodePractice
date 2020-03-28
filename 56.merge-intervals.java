import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=56 lang=java
 *
 * [56] Merge Intervals
 */

// @lc code=start
class Solution {
    public int[][] merge(int[][] intervals) {
        //sort the array in order
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);

        //create an array list to hold the result since we dont know the size of the resul
        ArrayList<int []> res = new ArrayList<>();

        //base case
        if (intervals.length ==0 || intervals == null){
            int [][] empty = new int[0][0];
            return empty;
        }

        //keep track of the previous interval
        int [] prev = intervals[0];

        for (int i = 1; i <intervals.length; i++){
            int [] curr = intervals[i];
            //if they are the same
            if (prev[1] >= curr [0]){
                if (prev[1]<curr[1]){
                    //if the intervals overlap, update the end of the previous interval
                    prev [1] = curr[1];
                }
                //if curr is a subset of prev, just ignore this interval
            }else{
                //add the previous interval to the list before updating to the next one
                res.add(prev);
                prev = curr;
            }
        }

        //add the last interval
        res.add(prev);

        //convert to an integer array
        return res.toArray(new int [res.size()][2]);
        
    }
}
// @lc code=end

