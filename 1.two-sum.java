import java.util.HashMap;

/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] res = new int [2];
        HashMap <Integer, Integer> map = new HashMap<>();

        for (int i = 0 ; i <nums.length ;i ++){
            int complement = target - nums[i];

            if (map.containsKey(complement)){
                res[0] = map.get(complement);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);

        }
        return res;
    }
}
// @lc code=end

